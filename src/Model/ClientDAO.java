package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.Parametrizable;

public class ClientDAO implements Parametrizable{

	public ClientDAO() {
		super();
	}
	
	public boolean insertClient(Client c) {
		return conn.setQuery(String.format("INSERT INTO electrotech.client (name, email, address) VALUES ('%s', '%s', '%s');", 
					c.getName(), 
					c.getEmail(),
					c.getAddress()));
	}
	
	public List<Client> listClient() throws SQLException {
		List<Client> clients = new ArrayList<>();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.client;");
		
		while(res.next()) {
			clients.add(new Client(	res.getInt("id"),
									res.getString("name"),
									res.getString("email"),
									res.getString("address")));
		}
		conn.closeConn();
		return clients;
	}


	public boolean updateClient(Client c) {
		return conn.setQuery(String.format("UPDATE electrotech.client SET name = '%s', email = '%s',  address = '%s' WHERE (id = '%d');",
					c.getName(), 
					c.getEmail(),
					c.getAddress(),
					c.getID()));
	}
	
}
