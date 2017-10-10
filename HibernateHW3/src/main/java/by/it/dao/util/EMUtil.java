package by.it.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	private static EntityManagerFactory emFactory;

	public static EntityManager getEntityManager(String name) {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory(name);
		}

		return emFactory.createEntityManager();
	}

	public static EntityManager getEntityManager() {

		return getEntityManager("mysql");
	}

	public static void close() {
		emFactory.close();
	}
}
