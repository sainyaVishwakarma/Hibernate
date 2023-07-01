package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.Employee;
import com.demo.beans.Student;

public class TestTablePerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Employee p1=new Employee(1,"pranil","nashik","HR","Manager");
		Student p2=new Student(2,"saket","pune","dac",90);
		Student p3=new Student(3,"tarun","delhi","dbda",55);
		sess.save(p1);
		sess.save(p2);
		sess.save(p3);
		tr.commit();
		sess.close();
		sf.close();
	}

}
