package Model;

import libreriaVersion3.Generic;

public class Client {
	
	private Generic<Integer, String> dta;
    private Generic<String, ?> dta2;

    public Client() {
 		super();
 		// TODO Auto-generated constructor stub
 		this.dta = new Generic<>();
 		this.dta2 = new Generic<>();
 	}
    
    public Client(int id, String name, String email, String address) {
        this.dta = new Generic<>(id, null, name, address);
        this.dta2 = new Generic<>(email);
    }

    public void setID(int id) {
    	dta.setAttribute1(id);
    }
    
    public void setName(String name) {
        dta.setAttribute3(name);
    }

    public void setEmail(String email) {
        dta2.setAttribute1(email);
    }
    
    public void setAddress(String address) {
        dta.setAttribute4(address);
    }
    
    public int getID() {
    	return dta.getAttribute1();
    }

    public String getName() {
        return dta.getAttribute3();
    }

    public String getEmail() {
        return dta2.getAttribute1();
    }
    
    public String getAddress() {
        return dta.getAttribute4();
    }
    
}
