package com.demo.beans;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="myuser12 ")
public class MyUser {
	@Id
	private int uid;
	private String uname;
	@OneToMany(mappedBy="mu")
	private Set<Address> addset;
	public MyUser() {
		super();
	}
	public MyUser(int uid, String uname, Set<Address> addset) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.addset = addset;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Set<Address> getAddset() {
		return addset;
	}
	public void setAddset(Set<Address> addset) {
		this.addset = addset;
	}
	@Override
	public String toString() {
		return "MyUser [uid=" + uid + ", uname=" + uname + ", addset=" + addset + "]";
	}
	
	
	

}
