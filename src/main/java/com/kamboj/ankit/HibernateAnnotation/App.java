package com.kamboj.ankit.HibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate annotation employee example 1
 *
 */

public class App {
	public static void main(String[] args) {

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp1 = new Employee();
		emp1.setId(101);
		emp1.setFirstName("bob");
		emp1.setLastName("marley");

		Employee emp2 = new Employee();
		emp2.setId(102);
		emp2.setFirstName("mark");
		emp2.setLastName("acosta");

		session.save(emp1);
		session.save(emp2);

		tx.commit();
		System.out.println("Employee data saved successfully");
		session.close();
		sessionFactory.close();
	}
}
