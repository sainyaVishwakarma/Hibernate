package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.Address;
import com.demo.beans.Student;

public class TestOneToOneTwoWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Address a1=new Address(11,"rajpur road","Dehradun",null);
		Student s1=new Student(121,"tarun",a1);
		a1.setS(s1);
		/*Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(a1);
		sess.save(s1);
		tr.commit();
		sess.close();
		sf.close();*/
		
		Session sess1 =sf.openSession();
		Transaction tr1=sess1.beginTransaction();
		System.out.println("before");
		Address a2=sess1.get(Address.class,11);
		System.out.println("after");
		System.out.println(a2);
		tr1.commit();
		sess1.close();
		sf.close();
		
	}

}
