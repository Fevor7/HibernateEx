package by.it.loader;

import by.it.dao.SFPersonDao;
import by.it.dao.sfimpl.PersonDaoImpl;
import by.it.dao.util.SFUtil;
import by.it.pojos.Person;

public class SFLoader {

	public static void main(String[] args) {
		//Person person = new Person(null, 28, "ViktorWWa","Grinko");
		SFPersonDao<Person> personDao = new PersonDaoImpl();
		System.out.println(personDao.get(270));
		System.out.println(personDao.load(270));
		System.out.println(personDao.get(250));
		System.out.println(personDao.load(255));

		SFUtil.close();
	}
}
