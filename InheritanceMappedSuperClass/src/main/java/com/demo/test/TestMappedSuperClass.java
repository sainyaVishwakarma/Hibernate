package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;
import com.demo.beans.Person;
import com.demo.beans.Student;

public class TestMappedSuperClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Employee e=new Employee(1,"sainya","kanpur","HR","Manager");
		Student s=new Student(2,"saket","pune","dac",90);
		sess.save(e);
		sess.save(s);
		tr.commit();
		sess.close();
		sf.close();
		
	}

}
