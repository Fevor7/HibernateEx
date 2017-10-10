package by.it;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.entity.Address;
import by.it.entity.Person;
import by.it.util.EMUtil;

public class OneToOneTest implements Serializable{
	
	private static final long serialVersionUID = 9182382896281565408L;

	@Test
	public void createAndReadTest() {
		Address address = new Address(null, 25, 15, "Lenina", "Minsk", null);
		Person person = new Person(null, 25, "Fevor", "Grinko", address);
		address.setPerson(person);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		System.out.println("--------createAndReadTest-----------");
		em.persist(person);
		em.flush();
		em.clear();
		Person personDB =  em.find(Person.class, person.getPersonId());
		em.getTransaction().commit();
		Assert.assertEquals(personDB, person);
	}
	
	@Test
	public void updateTest() {
		Address address = new Address(null, 25, 15, "Lenina", "Minsk", null);
		Person person = new Person(null, 25, "Fevor", "Grinko", address);
		address.setPerson(person);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		System.out.println("--------update-----------");
		em.persist(person);
		em.getTransaction().commit();
		em.getTransaction().begin();
		person.setAge(23);
		person.getAddress().setCity("Gomel");
		em.persist(person);
		em.flush();
		em.clear();
		Person personDB =  em.find(Person.class, person.getPersonId());
		em.getTransaction().commit();
		Assert.assertEquals(personDB, person);
	}
	
	@Test
	public void deleteTest() {
		Address address = new Address(null, 25, 15, "Lenina", "Minsk", null);
		Person person = new Person(null, 25, "Fevor", "Grinko", address);
		address.setPerson(person);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		System.out.println("--------delete-----------");
		em.persist(person);
		em.flush();
		em.remove(person);
		em.getTransaction().commit();
		Person personDB =  em.find(Person.class, person.getPersonId());
		Assert.assertNull(personDB);
	}
	
	@AfterClass
	public static void CleanUp() {
		EMUtil.close();
	}
}
