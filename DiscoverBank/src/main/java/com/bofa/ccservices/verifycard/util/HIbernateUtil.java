package com.bofa.ccservices.verifycard.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HIbernateUtil {

	private static final SessionFactory sessionFactory;
	static {
		try {			
			
			Configuration configuration = new Configuration().configure();
			
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
			applySettings(configuration.getProperties());
			
			sessionFactory = configuration.buildSessionFactory(builder.build());
			
			
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}
}
