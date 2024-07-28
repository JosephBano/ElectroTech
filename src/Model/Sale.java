package Model;

import libreriaVersion3.Generic;

public class Sale {

	private Generic<Integer, Integer> dts;
	private Generic<Double,?> dts1;

	public Sale() {
		super();
		// TODO Auto-generated constructor stub
		dts = new Generic<>();
		dts1 = new Generic<>();
	}
	
	public Sale(int id, int id_client, int id_product, int amount, double total) {
		dts = new Generic<>(id, id_client, id_product, amount);
		dts1 = new Generic<>(total);
	}
	
	public int getId() {
		return dts.getAttribute1();
	}
	
	public void setId(int id) {
		dts.setAttribute1(id);
	}
	
	public int getClientId() {
		return dts.getAttribute2();
	}
	
	public void setClientId(int id) {
		dts.setAttribute2(id);
	}
	public int getProductId() {
		return dts.getAttribute3();
	}
	
	public void setProductId(int id) {
		dts.setAttribute3(id);
	}
	public int getAmount() {
		return dts.getAttribute4();
	}
	
	public void setAmount(int id) {
		dts.setAttribute4(id);
	}
	
	public double getTotal() {
		return dts1.getAttribute1();
	}
	
	public void setTotal(double id) {
		dts1.setAttribute1(id);
	}
}
