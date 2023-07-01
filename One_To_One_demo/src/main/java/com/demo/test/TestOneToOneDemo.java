package com.demo.test;
import com.demo.beans.Student;
import com.demo.beans.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneToOneDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		/*Address a1=new Address(8,"charbagh","lucknow");
		Student s1=new Student(12,"amisha",a1); 
		*/
		Address a2=new Address(10,"rajajipuram","lucknow");
		Student s2=new Student(15,"shweta",a2); 
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		/*sess.save(a1);
		sess.save(s1);*/
		sess.save(a2);
		sess.save(s2);
		tr.commit();
		sess.close();
		//sf.close();
		
		/*Session sess1=sf.openSession();
		Transaction tr1=sess1.beginTransaction();
		System.out.println("before");
		Student s2=sess1.get(Student.class,11);
		System.out.println("after");
		
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println(s2.getAddr());
		tr1.commit();
		sess1.close();
		sf.close();*/
		
		Session sess2=sf.openSession();
		Transaction tr2=sess2.beginTransaction();
		System.out.println("before");
		Student s3=sess2.load(Student.class,11);
		System.out.println("after");
		
		System.out.println(s3);
		System.out.println(s3.getSname());
		System.out.println(s3.getAddr());
		tr2.commit();
		sess2.close();
		sf.close();
	}

}
