package com.kamboj.ankit.HibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmpAddrApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Emp emp1 = new Emp();
		emp1.setName("kim");
		emp1.setEmail("kim@gmail.com");

		Emp emp2 = new Emp();
		emp2.setName("julia");
		emp2.setEmail("julia@ymail.com");

		Addr adr = new Addr();
		adr.setAddressLine1("101 , dexter street");
		adr.setCity("newark");
		adr.setState("new jersey");
		adr.setCountry("USA");
		adr.setPincode(12345);

		emp1.setAddress(adr);
		emp2.setAddress(adr);

		session.persist(emp1);
		session.persist(emp2);

		tx.commit();
		session.close();
		factory.close();
		System.out.println("data updated successfully");
	}
}
