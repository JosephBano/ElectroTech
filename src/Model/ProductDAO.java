package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.Parametrizable;

public class ProductDAO implements Parametrizable{

	
	public ProductDAO() {
		super();
		
	}
	
	public boolean insertProduct(Product p) {
		
		return conn.setQuery(String.format("INSERT INTO electrotech.product (id_provider, name, description, price, stock) VALUES(%d, '%s', '%s', %.2f, %d);",
				p.getProvider()
				,p.getName()
				,p.getDescription()
				,p.getPrice()
				,p.getStock()));
	}
	
	public List<Product> listProducts() throws SQLException{
		List<Product> products = new ArrayList();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.product;");
		while(res.next()) {
			products.add(new Product(
					res.getInt("id"),
					res.getInt("id_provider"),
					res.getString("name"),
					res.getString("description"), 
					res.getDouble("price"),
					res.getInt("stock")));
		}
		conn.closeConn();
		return products;
	}
	
	public List<Product> listLowStockProducts() throws SQLException{
		List<Product> products = new ArrayList();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.product WHERE stock <= 5;");
		while(res.next()) {
			products.add(new Product(
					res.getInt("id"),
					res.getInt("id_provider"),
					res.getString("name"),
					res.getString("description"), 
					res.getDouble("price"),
					res.getInt("stock")));
		}
		conn.closeConn();
		return products;
	}
	
	public boolean updateStockProduct(Product new_p) {
		return conn.setQuery(String.format("UPDATE electrotech.product SET stock=%d WHERE id = %d;",
				new_p.getStock(),
				new_p.getId()));
	}
}
