package by.it.dao.emimpl;

import javax.persistence.EntityManager;

import by.it.dao.ModelDao;
import by.it.dao.util.EMUtil;
import by.it.pojos.Person;

abstract class AbstractPersonDaoImpl implements ModelDao<Person> {

	
	protected EntityManager em;

	public AbstractPersonDaoImpl() {
		em = EMUtil.getEntityManager();
	}

	public AbstractPersonDaoImpl(String nameDB) {
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

}
