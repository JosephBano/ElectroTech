package model;

import libreríaVersion2.generic;

public class Employees {
	private generic<String,String> dt_e;
	private String number;
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
		dt_e=new generic<>();
	}
	String email;
	public Employees(String name,String email,String password,String role, String phone) {
		super();
		// TODO Auto-generated constructor stub
		dt_e=new generic<>(name,email,password,role);
		number = phone;
	}

	public String getName() {
		return dt_e.getAttribute1();
	}

	public void setName(String name) {
		 dt_e.setAttribute1(name);
	}

	public String getEmail() {
		return dt_e.getAttribute2();
	}

	public void setEmail(String email) {
		dt_e.setAttribute2(email);
	}

	public String getPassword() {
		return dt_e.getAttribute3();
	}

	public void setPassword(String password) {
		dt_e.setAttribute3(password);
	}
	
	public String getRole() {
		return dt_e.getAttribute4();
	}

	public void setRole(String role) {
		dt_e.setAttribute4(role);
	}
	
	public void setPhone(String phone) {
		number = phone;
	}
	
	public String getPhone() {
		return number;
	}

	public String infoEmployee() {
		return String.format("%s;%s;%s;%s;%s;", getName(),getEmail(),getPassword(),getRole(),number);
	}
	
}
