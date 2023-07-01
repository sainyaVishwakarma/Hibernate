package com.demo.service;

import com.demo.beans.Product;
import java.util.List;

public interface ProductService {

	void addNewProduct_warehouse();

	void closeSessionFactory();

	Boolean deleteById(int pid);

	Product displayById(int pid);

	List<Product> sortByName();

	Boolean UpdateById(int pid, String pname, String wname);


	List<Product> displayAll();

}
