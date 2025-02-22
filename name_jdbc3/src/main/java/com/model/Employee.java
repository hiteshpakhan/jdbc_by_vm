package com.model;

public class Employee {
	private int eid;
	private String ename;
	private String edesignation;
	private String ecompany;
	private double esalary;
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", edesination=" + edesignation + ", ecompany=" + ecompany
				+ ", esalary=" + esalary + "]";
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEdesignation() {
		return edesignation;
	}
	public void setEdesignation(String edesination) {
		this.edesignation = edesination;
	}
	public String getEcompany() {
		return ecompany;
	}
	public void setEcompany(String ecompany) {
		this.ecompany = ecompany;
	}
	public double getEsalary() {
		return esalary;
	}
	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}
	
}
