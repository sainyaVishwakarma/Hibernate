package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	void closeSessionFactory();

	Boolean removeById(int pid);

	Product getById(int pid);

	List<Product> sortByNm();

	Boolean modifyById(int pid, String pname, String wname);

	List<Product> getAll();

}
