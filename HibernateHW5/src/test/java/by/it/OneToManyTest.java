package by.it;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Test;

import by.it.entity.Car;
import by.it.entity.Detail;
import by.it.util.EMUtil;

public class OneToManyTest {
	@Test
	public void createAndReadTest() {
		
		
		EntityManager em = EMUtil.getEntityManager();
		em.getTransaction().begin();
		Car car = new Car(null, 278, null);
		Set<Detail> list = new HashSet<Detail>();
		Detail detail = new Detail(null, "aaa1", car);
		Detail detail2 = new Detail(null, "aaa2", car);
		list.add(detail);
		list.add(detail2);
		car.setList(list);
		System.out.println(car);
		System.out.println("--------createAndReadTest-----------");
		em.persist(detail);
		em.persist(detail2);
		em.persist(car);
		em.getTransaction().commit();
		//Person personDB = em.find(Person.class, person.getPersonId());
		
		//Assert.assertEquals(personDB, person);
	}
}
