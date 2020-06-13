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

public class QuestionAnswerApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		TypedQuery<Question> query = session.createQuery("from Question");
		List<Question> qlist = query.getResultList();

		Iterator<Question> itr = qlist.iterator();
		while (itr.hasNext()) {
			Question q = itr.next();
			String qname = q.getQname().toLowerCase();
			System.out.println("Question Name: " + q.getQname());
			if (qname.contains("what is java") && !qname.contains("?")) {
				q.setQname(qname + "?");
				session.persist(q);
				System.out.println("from update");
			}
			// Printing answers
			List<Answer> alist = q.getAnswers();
			Iterator<Answer> itr2 = alist.iterator();
			while (itr2.hasNext()) {
				Answer a = itr2.next();
				System.out.println("Answer Name: " + a.getAname() + " author " + a.getPostedBy());
			}
		}
		tx.commit();
		session.close();
		factory.close();
	}

}
