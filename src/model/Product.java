package model;

import libreriaVersion3.Generic;

public class Product {

	private Generic<String, Double> dta;
	private Generic<Integer, Integer> dta1;
	
	public Product(int id,int id_provider, String name, String description, double price, int stock) {
		this.dta = new Generic<>(name, description, price);
		this.dta1 = new Generic<>(stock, id_provider,id);
	}
	public void setId(int id) {
        dta1.setAttribute2(id);
    }
    public void setProvider(int id_provider) {
		dta1.setAttribute3(id_provider);
	}	
	public void setName(String name) {
		dta.setAttribute1(name);
	}	
	public void setDescription(String description) {
		dta.setAttribute2(description);
	}
	public void setPrice(double price) {
		dta.setAttribute3(price);
	}
	public void setStock(int stock) {
		dta1.setAttribute1(stock);
	}
	public String getName() {
		return dta.getAttribute1();
	}	
	public String getDescription() {
		return dta.getAttribute2();
	}	
	public double getPrice() {
		return dta.getAttribute3();
	}	
	public int getStock() {
		return dta1.getAttribute1();
	}
	public long getProvider() {
		return dta1.getAttribute3();
	}
	 public int getId() {
        return dta1.getAttribute2();
    }
}