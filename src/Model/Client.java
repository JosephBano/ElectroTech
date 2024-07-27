package Model;

import libreriaVersion3.Generic;

public class Client {

    private Generic<Integer, String> dta;

    public Client(int id, String name, String email) {
        this.dta = new Generic<>(id, null, name, email);
    }

    public void setID(int id) {
    	dta.setAttribute1(id);
    }
    
    public void setName(String name) {
        dta.setAttribute3(name);
    }

    public void setEmail(String address) {
        dta.setAttribute4(address);
    }
    
    public int getID() {
    	return dta.getAttribute1();
    }

    public String getName() {
        return dta.getAttribute3();
    }

    public String getEmail() {
        return dta.getAttribute4();
    }
    
}
