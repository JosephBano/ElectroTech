package Controller;

import java.sql.SQLException;
import java.util.List;

import Model.Product;

public class Process_Low_Stock extends Thread implements Parametrizable{
	
	public Process_Low_Stock() {
	}
	
	public void run() {
		
		while(true) {
			try {
				try {
					List<Product> products = pdao.listLowStockProducts();
					
					if(!products.isEmpty()) {
						low_stock_products.clear();
						for(Product p: products) {
							low_stock_products.add(p);
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}