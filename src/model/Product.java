package model;

import libreríaVersion2.generic;

public class Product {

	private generic<String, Double> dta;
	private generic<Integer, Long> dta1;
	
	public Product(String name, String description, double price, int stock, long dni) {
		this.dta = new generic<>(name, description, price);
		this.dta1 = new generic<>(stock, dni);
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
	public void setProvider(long dni) {
		dta1.setAttribute3(dni);
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
	
	public String infoProduct() {
		return String.format("%s;%s;%.2f;%d;%d;\n", getName(), getDescription(), getPrice(), getStock(), getProvider());
	}
}