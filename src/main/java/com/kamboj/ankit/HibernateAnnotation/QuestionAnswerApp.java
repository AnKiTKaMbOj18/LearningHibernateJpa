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

public class QuestionAnswerApp {

	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Answer ans1 = new Answer();
		ans1.setAname("Java is a programming language");
		ans1.setPostedBy("ankit");

		Answer ans2 = new Answer();
		ans2.setAname("Java is a platform independent language");
		ans2.setPostedBy("kalie");

		Answer ans3 = new Answer();
		ans3.setAname("Java is object oriented");
		ans3.setPostedBy("luke");

		Answer ans4 = new Answer();
		ans4.setAname("Java used JDK ,JRE , JVM to execute compile and run any program");
		ans4.setPostedBy("mark");

		List<Answer> list1 = new ArrayList<Answer>();
		list1.add(ans1);
		list1.add(ans2);

		List<Answer> list2 = new ArrayList<Answer>();
		list2.add(ans3);
		list2.add(ans4);

		Question ques1 = new Question();
		ques1.setQname("what is Java");
		ques1.setAnswers(list1);

		Question ques2 = new Question();
		ques2.setQname("Features of Java");
		ques2.setAnswers(list2);

		session.persist(ques1);
		session.persist(ques2);

		tx.commit();
		session.close();
		factory.close();
		System.out.println("Records saved successfully");
	}
}
