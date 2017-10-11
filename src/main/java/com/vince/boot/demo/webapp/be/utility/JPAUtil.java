package com.vince.boot.demo.webapp.be.utility;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAUtil {

		private static EntityManagerFactory factory;
		private static final String unitName = "partecipazioni-unit"; 
		
		public static EntityManager getEntityManager() {
			if (factory == null) {
				factory = Persistence.createEntityManagerFactory(unitName);
			}
			EntityManager em = factory.createEntityManager();
			return em;	
		}
		
		public static void closeEntityManager() {
			getEntityManager().close();
		}
		
		public static void recreateDatabase() {
			Map<String, Object> configOverrides = new HashMap<String, Object>();
			configOverrides.put("hibernate.hbm2ddl.auto", "create");

			EntityManagerFactory programmaticEmf = 
			    Persistence.createEntityManagerFactory(unitName, configOverrides);
			programmaticEmf.close();
		}
		
		public static EntityTransaction beginTransaction() {
			EntityManager em;
			em = JPAUtil.getEntityManager();
			EntityTransaction tx = em.getTransaction();			
			return tx;
		}
		
		public static void commitTransaction() {
			getEntityManager().getTransaction().commit();
		}
		
		public static void rollbackTransaction() {
			getEntityManager().getTransaction().rollback();
		}
		
		public static void main(String args[]) {
			recreateDatabase();
		}
}
