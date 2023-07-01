package com.demo.test;
import com.demo.beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAnnotations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		MyUser u1=new MyUser(12,"sainya","s@gmail.com");
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(u1);
		tr.commit();
		sess.close();
//		sf.close();
		/*Session sess1=sf.openSession();
		Transaction tr1=sess1.beginTransaction();
		System.out.println("before");
		sess1.get(MyUser.class,12);
		System.out.println("after");
		System.out.println("uid: "+u1.getUid());
		System.out.println("uname: "+u1.getUname());
		tr1.commit();
		sess1.close();
		sf.close();*/
		Session sess1=sf.openSession();
		Transaction tr1=sess1.beginTransaction();
		System.out.println("before");
		sess1.load(MyUser.class,12);
		System.out.println("after");
		System.out.println("uid: "+u1.getUid());
		System.out.println("uname: "+u1.getUname());
		tr1.commit();
		sess1.close();
		sf.close();
	}

}
