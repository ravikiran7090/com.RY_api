package com.parcer.pojo;

public class PojoArrayLibrary2WithAnotherObject {
	public String name;
	public String empid;
	public String email;
	public int[] phone;
	public Object[] PojoLibrary;

	public PojoArrayLibrary2WithAnotherObject() {
		
	}
	public PojoArrayLibrary2WithAnotherObject(String name, String empid, String email, int[] phone,Object[] PojoLibrary) {
		this.name=name;
		this.empid=empid;
		this.email=email;
		this.phone=phone;
		this.PojoLibrary=PojoLibrary;
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
	public Object getPojoLibrary() {
		return PojoLibrary;
	}
	public void setPojoLibrary(Object[] pojoLibrary) {
		PojoLibrary = pojoLibrary;
	}
	
	

}
