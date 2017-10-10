package by.it;

import org.hibernate.Session;
import org.junit.Test;

import by.it.dao.util.SFUtil;
import by.it.pojos.Person;

public class UpdateTest {

	@Test
	public void updatePersonTest() {
		Person person = new Person(null, 28, "AA", "BB");
		Session session = SFUtil.getSession();
        session.beginTransaction();
        System.out.println(person);
        session.save(person);
        session.flush();
        System.out.println(person);
        //session.evict(person);
        System.out.println(person);
        person.setName("fevor777");
        if(session.isDirty()) {
        	session.flush();
        }
        System.out.println(person);
        person = session.get(Person.class, person.getId());
        session.clear();
        session.update(person);
        System.out.println(person);
        session.delete(person);
        session.getTransaction().commit();
        session.close();

	}
	
}
