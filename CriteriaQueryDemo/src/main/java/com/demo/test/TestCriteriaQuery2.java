package com.demo.test;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;

import com.demo.beans.Product;

public class TestCriteriaQuery2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Criteria cr=sess.createCriteria(Product.class);
		List<Product> plist=cr.list();
		plist.forEach(System.out::println);
		Criterion cr1=Restrictions.gt("price", 200.0f);
		Criterion cr2=Restrictions.lt("qty", 34);
		Criteria cr3=sess.createCriteria(Product.class);
		LogicalExpression expr=Restrictions.or(cr1, cr2);
		cr3.add(expr);
		List<Product> plist1=cr3.list();
		plist1.forEach(System.out::println);
		
		System.out.println("USE JPQL");
		CriteriaBuilder cb=sess.getCriteriaBuilder();
		
		CriteriaQuery<Product> cr22=cb.createQuery(Product.class);
		Root<Product> root=cr22.from(Product.class);
		Query q=sess.createQuery(cr22.select(root));
		plist1=q.getResultList();
		plist1.forEach(System.out::println);
		tr.commit();
		sess.close();
		sf.close();
	}

}
