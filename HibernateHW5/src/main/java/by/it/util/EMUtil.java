package by.it.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMUtil {
	private static EntityManagerFactory emFactory;
	private static ThreadLocal<EntityManager> em = new ThreadLocal<EntityManager>();
	
	public static EntityManager getEntityManager(String name) {
		if (emFactory == null) {
			emFactory = Persistence.createEntityManagerFactory(name);
		}
		if (em.get() == null) {
			em.set(emFactory.createEntityManager());
		}
		return em.get();
	}

	public static EntityManager getEntityManager() {

		return getEntityManager("mysql");
	}

	public static void close() {
		emFactory.close();
	}
}
