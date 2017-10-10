package by.it;

import javax.persistence.EntityManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.entity.composition.Address;
import by.it.entity.composition.Person;
import by.it.util.EMUtil;

public class AppTest {
	@Test
	public void componentTest() {
		Address address = new Address("Gogolya 5", "Minsk", 125121);
		Person person = new Person(null, 28, "Viktor", "Grinko", address);
		EntityManager em = EMUtil.getEntityManager("test");
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		em.clear();
		Person personDB = em.find(Person.class, person.getId());
		Assert.assertEquals(personDB.getAddress(), person.getAddress());
	}

	@AfterClass
	public static void cleanUp() {
		EMUtil.close();
	}
}
