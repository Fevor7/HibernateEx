package by.it;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;

import by.it.dao.ModelDao;
import by.it.dao.sfimpl.PersonDaoImpl;
import by.it.dao.util.SFUtil;
import by.it.pojos.Person;

public class SFPersonTest {

	@Test
	public void addTest() {
		Person person = new Person(null, 28, "AA", "BB");
		ModelDao<Person> pd = new PersonDaoImpl();
		Person personDB = pd.add(person);
		System.out.println(personDB);
		Session session = SFUtil.getSession();
		session.beginTransaction();
		Person personFind = session.get(Person.class, personDB.getId());
		session.getTransaction().commit();	
		System.out.println(personFind);
		Assert.assertEquals(personFind, personDB);
		pd.delete(personDB.getId());
		
	}
	
	@Test
	public void getTest() {
		Person person = new Person(null, 28, "AA", "BB");
		ModelDao<Person> pd = new PersonDaoImpl();
		Person personDB = pd.add(person);
		Person personFind = pd.get(personDB.getId());
		Assert.assertEquals(personFind, personDB);
		pd.delete(personDB.getId());
		
	}
	
	@Test
	public void updateTest() {
		Person person = new Person(null, 28, "AA", "BB");
		ModelDao<Person> pd = new PersonDaoImpl();
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
		ModelDao<Person> pd = new PersonDaoImpl();
		Person personDB = pd.add(person);
		pd.delete(personDB.getId());
		Person personFind = pd.get(personDB.getId());
		Assert.assertNull(personFind);
		
	}

}
