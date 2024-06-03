package model;

import libreríaVersion2.generic;

public class Provider {

	private generic<String, Long> dta;
	private generic<Integer, String> dta1;
	
	public Provider(String fullname, String email, long dni, int code, long phone, String socialReason) {
		dta = new generic<>(fullname, email, dni, phone);
		dta1 = new generic<>(code, socialReason);
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
		dta1.setAttribute1(code);
	}
	
	public void setSocialReason(String socialReason) {
		dta1.setAttribute3(socialReason);
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
		return dta1.getAttribute1();
	}
	
	public String getSocialReason() {
		return dta1.getAttribute3();
	}
	
	public String infoProvider() {
		return String.format("%s;%s;%d;%d;%d;%s;\n", 
				getFullname(), 
				getEmail(), 
				getDni(), 
				getCode(), 
				getPhone(), 
				getSocialReason());
	}
}
