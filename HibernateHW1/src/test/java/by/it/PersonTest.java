package by.it;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

import by.it.dao.PersonDao;
import by.it.dao.emimpl.PersonDaoImpl;
import by.it.dao.util.EMUtil;
import by.it.pojos.Person;

public class PersonTest {
	@Test
	public void saveTest() {
		Person person = new Person(null, 25, "Viktor", "Grinko");
		EntityManager em = EMUtil.getEntityManager("h2test");
		try {
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
		} catch (HibernateException e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		em = EMUtil.getEntityManager("h2test");
		em.getTransaction().begin();
		Person personDB = em.find(Person.class, person.getId());
		Assert.assertEquals(person, personDB);
		em.remove(personDB);
		em.getTransaction().commit();
	}

	@Test
	public void addTest() {
		Person person = new Person(null, 28, "AA", "BB");
		PersonDao<Person> pd = new PersonDaoImpl("h2test");
		Person personDB = pd.add(person);
		Person personFind = null;
		EntityManager em = EMUtil.getEntityManager("h2test");
		try {
			personFind = em.find(Person.class, personDB.getId());
		} catch (HibernateException e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}	
		Assert.assertEquals(personFind, personDB);
		pd.delete(personDB.getId());
	}
	
	@Test
	public void getTest() {
		Person person = new Person(null, 28, "AA", "BB");
		PersonDao<Person> pd = new PersonDaoImpl("h2test");
		Person personDB = pd.add(person);
		Person personFind = pd.get(personDB.getId());
		Assert.assertEquals(personFind, personDB);
		pd.delete(personDB.getId());
	}
	
	@Test
	public void updateTest() {
		Person person = new Person(null, 28, "AA", "BB");
		PersonDao<Person> pd = new PersonDaoImpl("h2test");
		Person personDB = pd.add(person);
		personDB.setName("Vasya");
		pd.update(personDB);
		Person personFind = pd.get(personDB.getId());
		Assert.assertEquals(personFind, personDB);
		pd.delete(personDB.getId());
	}

	@Test
	public void deleteTest() {
		Person person = new Person(null, 28, "AA", "BB");
		PersonDao<Person> pd = new PersonDaoImpl("h2test");
		Person personDB = pd.add(person);
		pd.delete(personDB.getId());
		Person personFind = pd.get(personDB.getId());
		Assert.assertNull(personFind);
	}

	@AfterClass
	public static void CleanUp() {
		EMUtil.close();
	}

}