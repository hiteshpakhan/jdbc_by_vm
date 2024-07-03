package com.model;

public class Student {
	private int sid;
	private String sname;
	private String lname;
	private double spercentage;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public double getSpercentage() {
		return spercentage;
	}
	public void setSpercentage(double spercentage) {
		this.spercentage = spercentage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", lname=" + lname + ", spercentage=" + spercentage + "]";
	}
	
}


//now that we have created the Student class that have properties that we required in our database now we want to do CRUD operations on this for this we will have to create the DAO class (DATA ACCESS OBJECT) this class has queries related to database 
// each user have dao class and all dao class is in dao package so we will create another package here