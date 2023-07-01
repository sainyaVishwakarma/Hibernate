package com.demo.service;

import java.util.List;
import java.util.Scanner;
import com.demo.beans.Product;
import com.demo.beans.Warehouse;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDao prodDao;

	public ProductServiceImpl() {
		super();
		this.prodDao = new ProductDaoImpl();
	}

	public void addNewProduct_warehouse() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter pid");
		int pid=sc.nextInt();
		System.out.println("Enter pname");
		String pname=sc.next();
		System.out.println("Enter wid");
		int wid=sc.nextInt();
		System.out.println("Enter wname");
		String wname=sc.next(); 
		System.out.println("Enter warehouse location");
		String wloc=sc.next();
		
		Warehouse w=new Warehouse(wid,wname,wloc);
		Product p=new Product(pid,pname,w);
		
		prodDao.save(p);
	}

	public void closeSessionFactory() {
		// TODO Auto-generated method stub
		prodDao.closeSessionFactory();
	}

	public Boolean deleteById(int pid) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("do you really want to delete? "+pid);
		String ans=sc.next();
		if(ans.equals("y")) {
		 prodDao.removeById(pid);
		 return true;
		}
		return false;
	}

	public Product displayById(int pid) {
		// TODO Auto-generated method stub
		return prodDao.getById(pid);
	}

	@Override
	public List<Product> sortByName() {
		// TODO Auto-generated method stub
		return prodDao.sortByNm();
	}

	@Override
	public Boolean UpdateById(int pid, String pname, String wname) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("do you really want to modify? "+pid);
		String ans=sc.next();
		if(ans.equals("y")) {
		 prodDao.modifyById(pid,pname,wname);
		 return true;
		}
		return false;
	}

	
	@Override
	public List<Product> displayAll() {
		// TODO Auto-generated method stub
		return prodDao.getAll();
	}
	
}
