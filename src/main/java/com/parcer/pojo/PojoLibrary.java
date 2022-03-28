package com.parcer.pojo;

public class PojoLibrary {
	String name;
	String empID;
	String email;
	int phone;
	public PojoLibrary() {

	}
	public PojoLibrary(String name, String empID, String email, int phone) {
		super();
		this.name = name;
		this.empID = empID;
		this.email = email;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpID() {
		return empID;
	}
	public void setEmpID(String empID) {
		this.empID = empID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
}
