package by.it;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.dao.util.EMUtil;
import by.it.pojos.Person;

public class PersonTestH2 {
	@Test
	public void saveTest() {
		Person person = new Person(null, 25, "Viktor", "Grinko");
		EntityManager em = EMUtil.getEntityManager("h2test");
		em.getTransaction().begin();
		em.persist(person);
		em.flush();
		em.clear();
		Person personDB = em.find(Person.class, person.getId());
		Assert.assertEquals(person, personDB);
		em.remove(personDB);
		em.getTransaction().commit();
	}

	@Test
	public void deleteTest() {
		Person person = new Person(null, 25, "Viktor", "Grinko");
		EntityManager em = EMUtil.getEntityManager("h2test");
		em.getTransaction().begin();
		em.persist(person);
		em.remove(person);
		em.flush();
		Person personDB = em.find(Person.class, person.getId());
		Assert.assertNull(personDB);
		em.getTransaction().commit();
	}

	@Test
	public void updateTest() {
		Person person = new Person(null, 25, "Viktor", "Grinko");
		EntityManager em = EMUtil.getEntityManager("h2test");
		em.getTransaction().begin();
		em.persist(person);
		em.flush();
		person.setName("Fevor");
		Person personDB = em.find(Person.class, person.getId());
		Assert.assertEquals(personDB, person);
		em.flush();
		em.remove(person);
		em.getTransaction().commit();
	}

	@AfterClass
	public static void CleanUp() {
		EMUtil.close();
	}
}
