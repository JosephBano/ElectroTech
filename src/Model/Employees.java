package Model;

import libreriaVersion3.Generic;

public class Employees {
	
	private Generic<Integer,String> dt_e1;
	private Generic<String,String> dt_e;
	
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
		dt_e=new Generic<>();
	}
	String email;
	public Employees(int id, String name,String email,String psw, String dni, int code, String date_join) {
		super();
		// TODO Auto-generated constructor stub
		dt_e1=new Generic<>(id,code,name,email);
		dt_e=new Generic<>(psw,dni,null,date_join);
	}
	
	public int getID() {
		return dt_e1.getAttribute1();
	}	
	public void setID(int id) {
		dt_e1.setAttribute1(id);
	}
	
	public String getName() {
		return dt_e1.getAttribute3();
	}
	public void setName(String name) {
		dt_e1.setAttribute3(name);
	}
	
	public String getEmail() {
		return dt_e1.getAttribute4();
	}
	public void setEmail(String email) {
		dt_e1.setAttribute4(email);
	}
	
	public String getPSW() {
		return dt_e.getAttribute1();
	}
	public void setPSW(String psw) {
		dt_e.setAttribute1(psw);
	}
	
	public String getDNI() {
		return dt_e.getAttribute2();
	}
	public void setDNI(String id) {
		dt_e.setAttribute2(id);
	}
	
	public int getCode() {
		return dt_e1.getAttribute2();
	}
	public void setCode(int code) {
		dt_e1.setAttribute2(code);
	}
	
	public String getDate() {
		return dt_e.getAttribute4();
	}
	public void setDate(String date) {
		dt_e.setAttribute4(date);
	}
}
