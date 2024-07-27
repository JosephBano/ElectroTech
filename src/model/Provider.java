package model;

import libreriaVersion3.Generic; 

public class Provider {

	private Generic<String, Long> dta;
	private Generic<Integer, String> dta1;
	
	public Provider(int id,String fullname, String email, long dni, int code, long phone, String socialReason) {
		dta = new Generic<>(fullname, email, dni, phone);
		dta1 = new 	Generic<>(id, code, socialReason);
	}
	
	public void setId(int id) {
        dta1.setAttribute1(id);
    }
	public void setFullname(String fullname) {
		dta.setAttribute1(fullname);
	}
	
	public void setEmail(String email) {
		dta.setAttribute2(email);
	}
	
	public void setDni(long dni) {
		dta.setAttribute3(dni);
	}
	
	public void setPhone(long phone) {
		dta.setAttribute4(phone);
	}
	
	public void setCode(int code) {
		dta1.setAttribute2(code);
	}
	
	public void setSocialReason(String socialReason) {
		dta1.setAttribute3(socialReason);
	}
	public int getId() {
        return dta1.getAttribute1();
	}
	
	public String getFullname() {
		return dta.getAttribute1();
	}
	
	public String getEmail() {
		return dta.getAttribute2();
	}
	
	public long getDni() {
		return dta.getAttribute3();
	}
	
	public long getPhone() {
		return dta.getAttribute4();
	}
	
	public int getCode() {
		return dta1.getAttribute2();
	}
	
	public String getSocialReason() {
		return dta1.getAttribute3();
	}
}
