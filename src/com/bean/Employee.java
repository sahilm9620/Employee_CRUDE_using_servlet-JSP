package com.bean;

public class Employee {
	
	public Employee()
	{
		
	}
	public String fname,lname,city;
	public int salary,id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int id,String fname, String lname, String city, int salary) {
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.salary = salary;
	}
	

}
