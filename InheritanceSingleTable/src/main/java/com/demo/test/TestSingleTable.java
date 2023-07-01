package com.demo.test;
import com.demo.beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestSingleTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Person p1=new Employee(1,"sainya","kanpur","HR","Manager");
		Person p2=new Student(2,"saket","pune","dac",90);
		sess.save(p1);
		sess.save(p2);
		tr.commit();
		sess.close();
		sf.close();
		
	}

}
