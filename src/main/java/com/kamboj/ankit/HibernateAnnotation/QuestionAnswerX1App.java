package com.kamboj.ankit.HibernateAnnotation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class QuestionAnswerX1App {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		QuestionX1 ques1 = new QuestionX1();
		ques1.setQname("What is Java");

		AnswerX1 ans1 = new AnswerX1();
		ans1.setAnswerName("Java is a programming language");
		ans1.setPostedBy("romy");

		AnswerX1 ans2 = new AnswerX1();
		ans2.setAnswerName("Java is a platform");
		ans2.setPostedBy("peter");

		List<AnswerX1> list1 = new ArrayList<AnswerX1>();
		list1.add(ans1);
		list1.add(ans2);

		ques1.setAnswers(list1);

		QuestionX1 ques2 = new QuestionX1();
		ques2.setQname("What is Hibernate and JPA");

		AnswerX1 ans3 = new AnswerX1();
		ans3.setAnswerName(
				"JPA is a Java application programming interface and Hibernate ORM is an object-relational mapping tool for the Java");
		ans3.setPostedBy("meery");

		AnswerX1 ans4 = new AnswerX1();
		ans4.setAnswerName(
				"JPA is a specification for relational data mgmnt and Hb provides framework for mapping an object oriented domain model to RDB");
		ans4.setPostedBy("quincy");

		List<AnswerX1> list2 = new ArrayList<AnswerX1>();
		list1.add(ans3);
		list1.add(ans4);

		ques2.setAnswers(list2);

		session.persist(ques1);
		session.persist(ques2);
		
		tx.commit();
		session.close();
		factory.close();
		System.out.println("Updated successfully");
	}
}
