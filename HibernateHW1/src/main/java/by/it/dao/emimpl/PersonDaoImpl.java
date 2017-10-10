package by.it.dao.emimpl;

import java.util.List;

import javax.persistence.TypedQuery;

import by.it.dao.PersonDao;
import by.it.pojos.Person;

public class PersonDaoImpl extends AbstractPersonDaoImpl implements PersonDao<Person> {

	public PersonDaoImpl() {
		super();
	}

	public PersonDaoImpl(String nameDB) {
		super(nameDB);

	}

	@Override
	public List<Person> getAll() {
		TypedQuery<Person> query = em.createNamedQuery("Person.getAll", Person.class);
		return query.getResultList();
	}
}
