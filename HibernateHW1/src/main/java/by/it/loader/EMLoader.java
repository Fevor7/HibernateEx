package by.it.loader;

import by.it.dao.PersonDao;
import by.it.dao.emimpl.PersonDaoImpl;
import by.it.dao.util.EMUtil;
import by.it.pojos.Person;

public class EMLoader {
	
	public static void main(String[] args) throws Exception{
//		Person person = new Person(null, 28, "Viktor", "Grinko");
//		EntityManager em = HibernateUtil.getEntityManager();
//		em.getTransaction().begin();
//		em.persist(person);
//		em.getTransaction().commit();
//		HibernateUtil.close();

//		Person person = new Person(206, 28, "Viktor", "Grinko");
//		Person person2 = new Person(207, 28, "Viktor", "Fevor");
		
		Person person = new Person(null, 28, "Viktor", "Grinko");
		Person person2 = new Person(null, 28, "Viktor", "Fevor");
		PersonDao<Person> pd = new PersonDaoImpl();
		System.out.println(person2);
		System.out.println(pd.add(person));
		person2 = pd.add(person2);
		System.out.println(pd.get(person2.getId()));
		person.setSurname("GrinkoVG");
		pd.update(person);
		System.out.println(pd.get(25));
		pd.getAll().forEach(System.out::println);
		pd.delete(person.getId());
		pd.delete(person2.getId());
		EMUtil.close();
	}
}
