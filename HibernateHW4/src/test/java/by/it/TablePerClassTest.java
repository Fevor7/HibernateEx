package by.it;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.entity.tableperclass.AircraftV2;
import by.it.entity.tableperclass.CarV2;
import by.it.entity.tableperclass.PassengerCarV2;
import by.it.entity.tableperclass.VehicleV2;
import by.it.util.EMUtil;

public class TablePerClassTest {

	@Test
	public void createAndReadTest() {
		VehicleV2  vehicle = new VehicleV2(null, 125);
		PassengerCarV2 passCar = new PassengerCarV2(null, 245, (byte)2, "BMW", "M4");
		CarV2 car = new CarV2(null, 250, (byte) 5);
		AircraftV2 aircraft = new AircraftV2(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(passCar);
		em.persist(car);
		em.persist(aircraft);
		em.persist(vehicle);
		em.flush();
		em.clear();
		PassengerCarV2 passCarDB = em.find(PassengerCarV2.class, passCar.getId());
		CarV2 carDB = em.find(CarV2.class, car.getId());
		AircraftV2 aircraftDB = em.find(AircraftV2.class, aircraft.getId());
		VehicleV2  vehicleDB = em.find(VehicleV2.class, vehicle.getId());
		em.getTransaction().commit();
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		Assert.assertEquals(vehicleDB, vehicle);
		System.out.println("-------------createAndRead------------");
	}
	
	@Test
	public void updateTest() {
		VehicleV2  vehicle = new VehicleV2(null, 125);
		PassengerCarV2 passCar = new PassengerCarV2(null, 245, (byte)2, "BMW", "M4");
		CarV2 car = new CarV2(null, 250, (byte) 5);
		AircraftV2 aircraft = new AircraftV2(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(passCar);
		em.persist(car);
		em.persist(aircraft);
		em.persist(vehicle);
		em.getTransaction().commit();
		em.getTransaction().begin();
		passCar.setMaxSpeed(254);
		car.setMaxSpeed(245);
		aircraft.setRangeFlight(10254);
		vehicle.setMaxSpeed(178);
		em.persist(aircraft);
		em.persist(car);
		em.persist(passCar);
		em.persist(vehicle);
		em.flush();
		em.clear();
		em.getTransaction().commit();
		PassengerCarV2 passCarDB = em.find(PassengerCarV2.class, passCar.getId());
		CarV2 carDB = em.find(CarV2.class, car.getId());
		AircraftV2 aircraftDB = em.find(AircraftV2.class, aircraft.getId());
		VehicleV2  vehicleDB = em.find(VehicleV2.class, vehicle.getId());
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		Assert.assertEquals(vehicleDB, vehicle);
		System.out.println("-------------updateTest------------");
	}
	
	@Test
	public void deleteTest() {
		VehicleV2  vehicle = new VehicleV2(null, 125);
		PassengerCarV2 passCar = new PassengerCarV2(null, 245, (byte)2, "BMW", "M4");
		CarV2 car = new CarV2(null, 250, (byte) 5);
		AircraftV2 aircraft = new AircraftV2(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(aircraft);
		em.persist(car);
		em.persist(passCar);
		em.persist(vehicle);
		em.flush();
		em.remove(aircraft);
		em.remove(car);
		em.remove(passCar);
		em.remove(vehicle);
		em.flush();
		em.clear();
		em.getTransaction().commit();
		PassengerCarV2 passCarDB = em.find(PassengerCarV2.class, passCar.getId());
		CarV2 carDB = em.find(CarV2.class, car.getId());
		AircraftV2 aircraftDB = em.find(AircraftV2.class, aircraft.getId());
		VehicleV2  vehicleDB = em.find(VehicleV2.class, vehicle.getId());
		Assert.assertNull(passCarDB);
		Assert.assertNull(carDB);
		Assert.assertNull(aircraftDB);
		Assert.assertNull(vehicleDB);
		System.out.println("-------------removeTest------------");
	}
	
	@AfterClass
	public static void CleanUp() {
		EMUtil.close();
	}
}
