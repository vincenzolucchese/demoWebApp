package com.vince.boot.demo.webapp.be.utility;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {

		private static SessionFactory factory;
		
		public static Configuration getInitializedConfiguration() {
			Configuration config =new Configuration();
			
			config.configure();
			return config;
		}
		
		public static Session getSession() {
			if (factory == null) {
				//Configuration config = HibernateUtil.getInitializedConfiguration("/hibernate_template.cfg.xml");
				//factory = config.buildSessionFactory();
				factory = new Configuration()
				.configure("/hibernate_template.cfg.xml")
				.buildSessionFactory();
			}
			Session hibernateSession = factory.getCurrentSession();
			hibernateSession.setFlushMode(FlushMode.COMMIT);
			return hibernateSession;
		}
		
		public static void closeSession() {
			getSession().close();
		}
		
		public static void recreateDatabase() {
			Configuration config;
			config = HibernateUtil.getInitializedConfiguration();
			new SchemaExport(config).create(true, true);
		}
		
		public static Session beginTransaction() {
			Session hibernateSession;
			hibernateSession = HibernateUtil.getSession();
			hibernateSession.beginTransaction();
			return hibernateSession;			
		}
		
		public static void commitTransaction() {
			getSession().getTransaction().commit();
		}
		
		public static void rollbackTransaction() {
			getSession().getTransaction().rollback();
		}
		
		public static void main(String args[]) {
			recreateDatabase();
		}
}
