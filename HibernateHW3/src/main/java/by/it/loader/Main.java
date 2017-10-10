package by.it.loader;

import javax.persistence.EntityManager;

import by.it.dao.PersonDao;
import by.it.dao.impl.PersonDaoImpl;
import by.it.dao.util.EMUtil;
import by.it.pojo.Person;

public class Main {
	public static ThreadLocal<EntityManager> em = new  ThreadLocal<EntityManager>();
	
	public static void main(String[] args) {
		Person person = new Person(null, 28, "Viktor", "Grinko");
		Person person2 = new Person(null, 28, "Viktor", "Fevor");
		PersonDao<Person> pd = new PersonDaoImpl();
		System.out.println(person2);
		System.out.println(pd.add(person));
		person2 = pd.add(person2);
		System.out.println(pd.get(person2.getId()));
		pd.delete(person2.getId());
		person.setSurname("GrinkoVG");
		pd.update(person);
		System.out.println(pd.get(254));
		pd.getAll().forEach(System.out::println);
		EMUtil.close();

	}

}
