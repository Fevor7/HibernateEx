package by.it.dao.sfimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import by.it.dao.SFPersonDao;
import by.it.dao.util.SFUtil;
import by.it.pojos.Person;

public class PersonDaoImpl extends AbstractPersonDaoImpl implements SFPersonDao<Person>{
	
	public Person load(Integer id) {
		Person person = null;
		Session session = SFUtil.getSession();
		try {
			person = session.load(Person.class, id);
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return person;
	}
	
}
