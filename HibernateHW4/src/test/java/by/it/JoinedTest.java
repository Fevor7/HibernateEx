package by.it;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.entity.joined.AircraftV4;
import by.it.entity.joined.CarV4;
import by.it.entity.joined.PassengerCarV4;
import by.it.entity.joined.VehicleV4;
import by.it.util.EMUtil;

public class JoinedTest {
	@Test
	public void createAndReadTest() {
		VehicleV4 vehicle = new VehicleV4(null, 125);
		PassengerCarV4 passCar = new PassengerCarV4(null, 245, (byte) 2, "BMW", "M4");
		CarV4 car = new CarV4(null, 250, (byte) 5);
		AircraftV4 aircraft = new AircraftV4(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(passCar);
		em.persist(car);
		em.persist(aircraft);
		em.persist(vehicle);
		em.flush();
		em.clear();
		PassengerCarV4 passCarDB = em.find(PassengerCarV4.class, passCar.getId());
		CarV4 carDB = em.find(CarV4.class, car.getId());
		AircraftV4 aircraftDB = em.find(AircraftV4.class, aircraft.getId());
		VehicleV4 vehicleDB = em.find(VehicleV4.class, vehicle.getId());
		em.getTransaction().commit();
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		Assert.assertEquals(vehicleDB, vehicle);
		System.out.println("-------------createAndRead------------");
	}
	
	@Test
	public void updateTest() {
		VehicleV4 vehicle = new VehicleV4(null, 125);
		PassengerCarV4 passCar = new PassengerCarV4(null, 245, (byte) 2, "BMW", "M4");
		CarV4 car = new CarV4(null, 250, (byte) 5);
		AircraftV4 aircraft = new AircraftV4(null, 980, 10500);
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
		PassengerCarV4 passCarDB = em.find(PassengerCarV4.class, passCar.getId());
		CarV4 carDB = em.find(CarV4.class, car.getId());
		AircraftV4 aircraftDB = em.find(AircraftV4.class, aircraft.getId());
		VehicleV4 vehicleDB = em.find(VehicleV4.class, vehicle.getId());
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		Assert.assertEquals(vehicleDB, vehicle);
		System.out.println("-------------updateTest------------");
	}

	@Test
	public void deleteTest() {
		VehicleV4 vehicle = new VehicleV4(null, 125);
		PassengerCarV4 passCar = new PassengerCarV4(null, 245, (byte) 2, "BMW", "M4");
		CarV4 car = new CarV4(null, 250, (byte) 5);
		AircraftV4 aircraft = new AircraftV4(null, 980, 10500);
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
		PassengerCarV4 passCarDB = em.find(PassengerCarV4.class, passCar.getId());
		CarV4 carDB = em.find(CarV4.class, car.getId());
		AircraftV4 aircraftDB = em.find(AircraftV4.class, aircraft.getId());
		VehicleV4 vehicleDB = em.find(VehicleV4.class, vehicle.getId());
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
