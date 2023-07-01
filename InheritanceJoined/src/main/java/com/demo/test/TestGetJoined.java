package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.Person;

public class TestGetJoined {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Person p=sess.get(Person.class, 1);
		System.out.println(p);
		tr.commit();
		sess.close();
		sf.close();
	}

}
