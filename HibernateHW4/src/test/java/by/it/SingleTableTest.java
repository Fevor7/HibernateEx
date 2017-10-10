package by.it;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.entity.singletable.AircraftV3;
import by.it.entity.singletable.CarV3;
import by.it.entity.singletable.PassengerCarV3;
import by.it.entity.singletable.VehicleV3;
import by.it.util.EMUtil;

public class SingleTableTest {

	@Test
	public void createAndReadTest() {
		VehicleV3 vehicle = new VehicleV3(null, 125);
		PassengerCarV3 passCar = new PassengerCarV3(null, 245, (byte) 2, "BMW", "M4");
		CarV3 car = new CarV3(null, 250, (byte) 5);
		AircraftV3 aircraft = new AircraftV3(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(passCar);
		em.persist(car);
		em.persist(aircraft);
		em.persist(vehicle);
		em.flush();
		em.clear();
		PassengerCarV3 passCarDB = em.find(PassengerCarV3.class, passCar.getId());
		CarV3 carDB = em.find(CarV3.class, car.getId());
		AircraftV3 aircraftDB = em.find(AircraftV3.class, aircraft.getId());
		VehicleV3 vehicleDB = em.find(VehicleV3.class, vehicle.getId());
		em.getTransaction().commit();
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		Assert.assertEquals(vehicleDB, vehicle);
		System.out.println("-------------createAndRead------------");
	}

	@Test
	public void updateTest() {
		VehicleV3 vehicle = new VehicleV3(null, 125);
		PassengerCarV3 passCar = new PassengerCarV3(null, 245, (byte) 2, "BMW", "M4");
		CarV3 car = new CarV3(null, 250, (byte) 5);
		AircraftV3 aircraft = new AircraftV3(null, 980, 10500);
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
		PassengerCarV3 passCarDB = em.find(PassengerCarV3.class, passCar.getId());
		CarV3 carDB = em.find(CarV3.class, car.getId());
		AircraftV3 aircraftDB = em.find(AircraftV3.class, aircraft.getId());
		VehicleV3 vehicleDB = em.find(VehicleV3.class, vehicle.getId());
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		Assert.assertEquals(vehicleDB, vehicle);
		System.out.println("-------------updateTest------------");
	}

	@Test
	public void deleteTest() {
		VehicleV3 vehicle = new VehicleV3(null, 125);
		PassengerCarV3 passCar = new PassengerCarV3(null, 245, (byte) 2, "BMW", "M4");
		CarV3 car = new CarV3(null, 250, (byte) 5);
		AircraftV3 aircraft = new AircraftV3(null, 980, 10500);
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
		PassengerCarV3 passCarDB = em.find(PassengerCarV3.class, passCar.getId());
		CarV3 carDB = em.find(CarV3.class, car.getId());
		AircraftV3 aircraftDB = em.find(AircraftV3.class, aircraft.getId());
		VehicleV3 vehicleDB = em.find(VehicleV3.class, vehicle.getId());
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
