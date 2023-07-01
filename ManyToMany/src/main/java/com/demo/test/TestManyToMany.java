package com.demo.test;
import java.util.Set;
import java.util.HashSet;
import com.demo.beans.Employee;
import com.demo.beans.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class TestManyToMany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
	/*	Session sess=sf.openSession();
		Transaction t1=sess.beginTransaction();
		Project p1=new Project(101,"xyz",2,null);
		Project p2=new Project(102,"sss",1,null);
		Project p3=new Project(103,"fff",3,null);
		Set<Project> pset1=new HashSet<>();
		pset1.add(p1);
		pset1.add(p2);
		Set<Project> pset2=new HashSet<>();
		pset2.add(p1);
		pset2.add(p3);
		Employee e1=new Employee(11,"sainya",pset1);
		Employee e2=new Employee(12,"saket",pset1);
		Employee e3=new Employee(13,"tarun",pset2);
		Set<Employee> eset1=new HashSet<>();
		eset1.add(e1);
		Set<Employee> eset2=new HashSet<>();
		eset2.add(e3);
		p1.setEset(eset1);
		p2.setEset(eset2);
		sess.save(p1);
		sess.save(p2);
		sess.save(p3);
		sess.save(e1);
		sess.save(e2);
		sess.save(e3);
		t1.commit();
		sess.close();
		sf.close();*/
		Session sess1=sf.openSession();
		System.out.println("before");
		Employee e=sess1.load(Employee.class, 11);
		System.out.println("after");
		System.out.println(e);
		Transaction tr1=sess1.beginTransaction();
		tr1.commit();
		sess1.close();
		sf.close();
	}

}
