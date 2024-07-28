package Model;

import Controller.Parametrizable;

public class SaleDAO implements Parametrizable{

	public SaleDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertSale(Sale sale) {
		return conn.setQuery(String.format("INSERT INTO electrotech.sale (id_client, id_product, amount, total) VALUES (%d, %d, %d, %.2f);",
				sale.getClientId(),
				sale.getProductId(),
				sale.getAmount(),
				sale.getTotal()));
	}

}
