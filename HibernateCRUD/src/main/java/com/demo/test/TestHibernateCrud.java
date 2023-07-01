package com.demo.test;
import java.util.Scanner;
import java.util.List;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
public class TestHibernateCrud {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductService ps=new ProductServiceImpl();
		Scanner sc=new Scanner(System.in);
		int choice=0;
		do {
		System.out.println("1. Add new product\n 2. Delete by id\n 3. Display all\n 4. Display by id\n  5. sort by name\n 6. Modify by id\n  7. exit\n Enter choice: ");
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			ps.addNewProduct_warehouse();
			break;
		case 2:
			System.out.println("Enter pid");
			int pid=sc.nextInt();
			Boolean status=ps.deleteById(pid);
			if(status) {
				System.out.println("deleted successfully");
			}else {
				System.out.println("Not Found");
			}
			break;
		case 3:
			List<Product> plist=ps.displayAll();
			plist.forEach(System.out::println);
			break;
		case 4:
			System.out.println("Enter pid");
			 pid=sc.nextInt();
			 Product p=ps.displayById(pid);
			 if(p!=null) {
				 System.out.println(p);
			 }else {
				 System.out.println("not found");
			 }
			break;
		case 5:
			 plist=ps.sortByName();
			plist.forEach(System.out::println);
			break;
		case 6:
			System.out.println("Enter pid");
			 pid=sc.nextInt();
			 System.out.println("Enter pname");
			 String pname=sc.next();
			 System.out.println("Enter wname");
			 String wname=sc.next();
			  status=ps.UpdateById(pid,pname,wname);
				if(status) {
					System.out.println("modified successfully");
				}else {
					System.out.println("Not Found");
				}
			break;
		
		case 7:
			ps.closeSessionFactory();
			System.out.println("Thankyou for visiting!!");
			break;
		default:
				System.out.println("Wrong choice");
		}
		
		}while(choice!=7);
	}

}
