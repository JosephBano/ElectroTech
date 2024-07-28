package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.Parametrizable;

public class SaleDAO implements Parametrizable{

	public SaleDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertSale(Sale sale) {
		return conn.setQuery(String.format("INSERT INTO electrotech.sale (id_client, id_product, amount, total, date) VALUES (%d, %d, %d, %.2f, '%s');",
				sale.getClientId(),
				sale.getProductId(),
				sale.getAmount(),
				sale.getTotal(),
				sale.getDate()));
	}
	
	public List<Sale> listSales() throws SQLException {
		List<Sale> employees = new ArrayList<>();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.sale;");
		
		while(res.next()) {
			employees.add(new Sale(	res.getInt("id"),
									res.getInt("id_client"),
									res.getInt("id_product"),
									res.getInt("amount"),
									res.getDouble("total"),
									res.getString("date")));
		}
		conn.closeConn();
		return employees;
	}
	
	public List<Sale> listSalesClient(int id_client) throws SQLException {
		List<Sale> employees = new ArrayList<>();
		
		ResultSet res = conn.getQuery(String.format("SELECT * FROM electrotech.sale WHERE id_client = %d;", id_client));
		
		while(res.next()) {
			employees.add(new Sale(	res.getInt("id"),
									res.getInt("id_client"),
									res.getInt("id_product"),
									res.getInt("amount"),
									res.getDouble("total"),
									res.getString("date")));
		}
		conn.closeConn();
		return employees;
	}

}
