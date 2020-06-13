package com.kamboj.ankit.HibernateAnnotation;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class EmpAddrApp2 {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		TypedQuery<Emp> query = session.createQuery("from Emp e");
		List<Emp> list = query.getResultList();
		Iterator<Emp> itr = list.iterator();

		while (itr.hasNext()) {
			Emp e = itr.next();

			StringBuilder builder = new StringBuilder();
			builder.append(e.getId()).append(" : ").append(e.getName()).append(" : ").append(e.getEmail());

			System.out.println(builder.toString());

			Addr adr = e.getAddress();

			StringBuilder addressBuilder = new StringBuilder();
			addressBuilder.append(adr.getId()).append(" : ").append(adr.getAddressLine1()).append(" : ")
					.append(adr.getCity()).append(" : ").append(adr.getPincode()).append(" : ").append(adr.getState())
					.append(" : ").append(adr.getCountry());

			System.out.println(addressBuilder.toString());
		}

		tx.commit();
		session.close();
		factory.close();
		System.out.println("Fetch complete");
	}
}
