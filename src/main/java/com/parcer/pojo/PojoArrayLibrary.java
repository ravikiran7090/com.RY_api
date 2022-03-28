package com.parcer.pojo;

public class PojoArrayLibrary {
	public String name;
	public String empid;
	public String email;
	public int[] phone;

	public PojoArrayLibrary() {
	}
	public PojoArrayLibrary(String name, String empid, String email, int[] phone) {
		this.name=name;
		this.empid=empid;
		this.email=email;
		this.phone=phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int[] getPhone() {
		return phone;
	}
	public void setPhone(int[] phone) {
		this.phone = phone;
	}
}
