package com.demo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{
	private static SessionFactory sf;
	static {
		sf=HibernateUtil.getMySessionFactory();
	}
	public void save(Product p) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		sess.save(p);
		tr.commit();
		sess.close();
	}
	public void closeSessionFactory() {
		// TODO Auto-generated method stub
		HibernateUtil.closeMySessionFactory();
	}
	public Boolean removeById(int pid) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		if(p!=null) {
			sess.delete(p);
			tr.commit();
			sess.close();
			return true;
		}
		tr.commit();
		sess.close();
		return false;
	}
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		tr.commit();
		sess.close();
		return p;
	}
	@Override
	public List<Product> sortByNm() {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Query q=sess.createQuery("from Product p order by p.pname");
		List<Product> plist=q.list();
		tr.commit();
		sess.close();
		return plist;
	}
	@Override
	public Boolean modifyById(int pid, String pname, String wname) {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Product p=sess.get(Product.class, pid);
		if(p!=null) {
		p.setPname(pname);
		p.getWhouse().setWname(wname);
		sess.update(p);
		tr.commit();
		sess.close();
		return true;
		}
		tr.commit();
		sess.close();
		return false;
	}
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		Session sess=sf.openSession();
		Transaction tr=sess.beginTransaction();
		Query q=sess.createQuery("from Product");
		List<Product> plist=q.list();
		tr.commit();
		sess.close();
		return plist;
	}
	
}
