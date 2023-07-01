package com.demo.test;
import java.util.Set;
import java.util.HashSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.demo.beans.Address;
import com.demo.beans.MyUser;

public class TestOneToMany {
public static void main(String[] args) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	/*Session sess=sf.openSession();
	Transaction tr=sess.beginTransaction();
	Address a1=new Address(101,"ssss","delhi");
	Address a2=new Address(102,"xyz","kanpur");
	Address a3=new Address(103,"hcde","agra");
	Set<Address> aset=new HashSet<>();
	aset.add(a1);
	aset.add(a2);
	aset.add(a3);
	MyUser u1=new MyUser(200,"def",aset);
	a1.setMu(u1);
	a2.setMu(u1);
	a3.setMu(u1);
	sess.save(a1);
	sess.save(a2);
	sess.save(a3);
	sess.save(u1);
	tr.commit();
	sess.close();
	sf.close();*/
	
	Session sess1=sf.openSession();
	Transaction tr1=sess1.beginTransaction();
	System.out.println("before");
	MyUser u1=sess1.get(MyUser.class, 200);
	System.out.println("after");
	System.out.println(u1.getAddset());
	System.out.println(u1);
	tr1.commit();
	sess1.close();
	sf.close();
}
}
