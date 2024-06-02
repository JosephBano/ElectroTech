package model;

import libreríaVersion2.generic;

public class Client {

    private generic<String, String> dta;

    public Client(String name, String email, String address, String detail) {
        this.dta = new generic<>(name, email, address, detail);
    }

    public void setName(String name) {
        dta.setAttribute1(name);
    }

    public void setEmail(String email) {
        dta.setAttribute2(email);
    }

    public void setAddress(String address) {
        dta.setAttribute3(address);
    }

    public void setDetail(String detail) {
        dta.setAttribute4(detail);
    }

    public String getName() {
        return dta.getAttribute1();
    }

    public String getEmail() {
        return dta.getAttribute2();
    }

    public String getAddress() {
        return dta.getAttribute3();
    }

    public String getDetail() {
        return dta.getAttribute4();
    }

    public String infoClient() {
        return String.format("%s;%s;client;Cliente;%s;%s;\n", getName(), getEmail(), getAddress(), getDetail());
    }
}
