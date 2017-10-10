package by.it.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import by.it.dao.PersonDao;
import by.it.dao.util.EMUtil;
import by.it.pojo.Person;

public class PersonDaoImpl implements PersonDao<Person> {
	
	private EntityManager em;

	public PersonDaoImpl() {
		em = EMUtil.getEntityManager();
	}

	public PersonDaoImpl(String nameDB) {
		em = EMUtil.getEntityManager(nameDB);

	}

	@Override
	public Person add(Person model) {
		em.getTransaction().begin();
		em.persist(model);
		em.getTransaction().commit();
		return model;
	}

	@Override
	public void delete(Integer id) {
		em.getTransaction().begin();
		em.remove(get(id));
		em.getTransaction().commit();
	}

	@Override
	public Person get(Integer id) {
		return em.find(Person.class, id);
	}

	@Override
	public void update(Person model) {
		em.getTransaction().begin();
		em.merge(model);
		em.getTransaction().commit();
	}

	@Override
	public List<Person> getAll() {
		TypedQuery<Person> query = em.createNamedQuery("Person.getAll", Person.class);
		return query.getResultList();
	}
}
