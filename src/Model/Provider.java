package Model;

import libreriaVersion3.Generic; 

public class Provider {

	private Generic<String, String> dta;
	private Generic<Integer, String> dta1;
	
	public Provider(int id,String fullname, String email, String dni, String code, String phone, String socialReason) {
		dta = new Generic<>(fullname, email, dni, phone);
		dta1 = new Generic<>(id);
		dta1.setAttribute3(code);
		dta1.setAttribute4(socialReason);
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
	
	public void setDni(String dni) {
		dta.setAttribute3(dni);
	}
	
	public void setPhone(String phone) {
		dta.setAttribute4(phone);
	}
	
	public void setCode(String code) {
		dta1.setAttribute3(code);
	}
	
	public void setSocialReason(String socialReason) {
		dta1.setAttribute4(socialReason);
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
	
	public String getDni() {
		return dta.getAttribute3();
	}
	
	public String getPhone() {
		return dta.getAttribute4();
	}
	
	public String getCode() {
		return dta1.getAttribute3();
	}
	
	public String getSocialReason() {
		return dta1.getAttribute4();
	}
}
