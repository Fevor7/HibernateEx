package by.it;

import javax.persistence.EntityManager;

import org.junit.Test;

import by.it.dao.util.EMUtil;
import by.it.pojo.Engineer;
import by.it.pojo.Person;
import by.it.pojo.Student;

public class FieldTest {
	
	@Test
	public void columnTest(){
		Person person = new Person(null, 28, "AA", "BB");
		Student student = new Student(null, 23, "CC", "DD");
		Engineer engineer = new Engineer(null, 30, "CsC", "DDf");
				
		EntityManager em = EMUtil.getEntityManager("h2test");
		em.getTransaction().begin();
		System.out.println(person);
		em.persist(person);
		em.persist(student);
		em.persist(engineer);

		em.flush();
		em.clear();
		System.out.println(person);
		System.out.println(student);
		System.out.println(engineer);
		
		Person personDB = em.find(Person.class, person.getId());
		System.out.println(personDB);
		em.getTransaction().commit();
		em.close();
	}
}
