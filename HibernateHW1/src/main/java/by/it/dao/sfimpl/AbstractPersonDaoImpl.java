package by.it.dao.sfimpl;

import org.hibernate.Session;

import by.it.dao.ModelDao;
import by.it.dao.util.SFUtil;
import by.it.pojos.Person;

abstract class AbstractPersonDaoImpl implements ModelDao<Person>{

	public Person get(Integer id) {
		Session session = SFUtil.getSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.getTransaction().commit();
        session.close();
		return person;
	}

	public Person add(Person person) {
		Session session = SFUtil.getSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
		return person;
	}

	public void delete(Integer id) {
		Session session = SFUtil.getSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.delete(person);
        session.getTransaction().commit();
        session.close();
	}

	public void update(Person person) {
		Session session = SFUtil.getSession();
        session.beginTransaction();
        session.update(person);
        session.getTransaction().commit();
        session.close();
	}

}
