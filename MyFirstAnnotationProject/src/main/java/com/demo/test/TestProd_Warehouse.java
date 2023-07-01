package com.demo.test;
import com.demo.beans.Product;
import com.demo.beans.Warehouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestProd_Warehouse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Warehouse w1=new Warehouse(102,"zzz","kanpur");
		Product p=new Product(12,"def",w1);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(p);
		tr.commit();
		sess.close();
		//sf.close();
		Session sess1=sf.openSession();
		Transaction tr1=sess1.beginTransaction();
		System.out.println("before");
		Product p1=sess1.get(Product.class,11);
		System.out.println("after");
		System.out.println(p1);    
		tr1.commit();
		sess1.close();
		sf.close();
	}

}
