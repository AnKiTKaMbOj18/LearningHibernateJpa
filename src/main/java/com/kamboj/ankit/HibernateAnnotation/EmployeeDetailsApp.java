package com.kamboj.ankit.HibernateAnnotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmployeeDetailsApp {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		EmployeeDetails emp = new EmployeeDetails();
		emp.setName("dimitry");

		RegularEmployeeDetails remp = new RegularEmployeeDetails();
		remp.setName("nuran");
		remp.setSalary(10000);
		remp.setBonus(5000);

		ContractEmployeeDetails cemp = new ContractEmployeeDetails();
		cemp.setName("james");
		cemp.setPay_per_hour(200);
		cemp.setContract_duration("15 hours");

		session.persist(emp);
		session.persist(remp);
		session.persist(cemp);

		tx.commit();
		session.close();
		factory.close();
		System.out.println("Success updated");
	}

}
