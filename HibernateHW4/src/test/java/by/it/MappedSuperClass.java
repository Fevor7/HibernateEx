package by.it;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.entity.mappedsuperclass.Aircraft;
import by.it.entity.mappedsuperclass.Car;
import by.it.entity.mappedsuperclass.PassengerCar;
import by.it.util.EMUtil;

public class MappedSuperClass {

	@Test
	public void createAndReadTest() {
		PassengerCar passCar = new PassengerCar(null, 245, (byte)2, "BMW", "M4");
		Car car = new Car(null, 250, (byte) 5);
		Aircraft aircraft = new Aircraft(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(passCar);
		em.persist(car);
		em.persist(aircraft);
		em.flush();
		em.clear();
		PassengerCar passCarDB = em.find(PassengerCar.class, passCar.getId());
		Car carDB = em.find(Car.class, car.getId());
		Aircraft aircraftDB = em.find(Aircraft.class, aircraft.getId());
		em.getTransaction().commit();
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		System.out.println("-------------createAndRead------------");
	}
	
	@Test
	public void updateTest() {
		PassengerCar passCar = new PassengerCar(null, 245, (byte)2, "BMW", "M4");
		Car car = new Car(null, 250, (byte) 5);
		Aircraft aircraft = new Aircraft(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(passCar);
		em.persist(car);
		em.persist(aircraft);
		em.getTransaction().commit();
		em.getTransaction().begin();
		passCar.setMaxSpeed(254);
		car.setMaxSpeed(245);
		aircraft.setRangeFlight(10254);
		em.persist(aircraft);
		em.persist(car);
		em.persist(passCar);
		em.flush();
		em.clear();
		em.getTransaction().commit();
		PassengerCar passCarDB = em.find(PassengerCar.class, passCar.getId());
		Car carDB = em.find(Car.class, car.getId());
		Aircraft aircraftDB = em.find(Aircraft.class, aircraft.getId());
		Assert.assertEquals(passCarDB, passCar);
		Assert.assertEquals(carDB, car);
		Assert.assertEquals(aircraftDB, aircraft);
		System.out.println("-------------updateTest------------");
	}
	
	@Test
	public void deleteTest() {
		PassengerCar passCar = new PassengerCar(null, 245, (byte)2, "BMW", "M4");
		Car car = new Car(null, 250, (byte) 5);
		Aircraft aircraft = new Aircraft(null, 980, 10500);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(aircraft);
		em.persist(car);
		em.persist(passCar);
		em.flush();
		em.remove(aircraft);
		em.remove(car);
		em.remove(passCar);
		em.flush();
		em.clear();
		em.getTransaction().commit();
		PassengerCar passCarDB = em.find(PassengerCar.class, passCar.getId());
		Car carDB = em.find(Car.class, car.getId());
		Aircraft aircraftDB = em.find(Aircraft.class, aircraft.getId());
		Assert.assertNull(passCarDB);
		Assert.assertNull(carDB);
		Assert.assertNull(aircraftDB);
		System.out.println("-------------removeTest------------");
	}


	@AfterClass
	public static void CleanUp() {
		EMUtil.close();
	}
}
