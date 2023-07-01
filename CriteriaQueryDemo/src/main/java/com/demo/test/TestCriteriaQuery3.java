package com.demo.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;

import com.demo.beans.Product;

public class TestCriteriaQuery3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Criteria cr=sess.createCriteria(Product.class);
		Criterion cr1=Restrictions.gt("price", 200.0f);
		Criterion cr2=Restrictions.lt("qty", 34);
		Criteria cr3=sess.createCriteria(Product.class);
		LogicalExpression expr=Restrictions.and(cr1,cr2);
		cr3.add(expr);
		List<Product> plist=cr3.list();
		plist.forEach(System.out::println);
		tr.commit();
		sess.close();
		sf.close();
	}

}
