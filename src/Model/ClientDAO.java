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
		return conn.setQuery(String.format("INSERT INTO electrotech.client (name, email, address, dni) VALUES ('%s', '%s', '%s', '%s');", 
					c.getName(), 
					c.getEmail(),
					c.getAddress(),
					c.getDNI()));
	}
	
	public List<Client> listClient() throws SQLException {
		List<Client> clients = new ArrayList<>();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.client;");
		
		while(res.next()) {
			clients.add(new Client(	res.getInt("id"),
									res.getString("name"),
									res.getString("email"),
									res.getString("address"),
									res.getString("dni")));
		}
		conn.closeConn();
		return clients;
	}
	
	public List<Client> searchClient(String dni) throws SQLException{
		List<Client> clients = new ArrayList<>();
		
		ResultSet res = conn.getQuery(String.format("SELECT * FROM electrotech.client WHERE dni='%s';", dni));
		
		while(res.next()) {
			clients.add(new Client(	res.getInt("id"),
									res.getString("name"),
									res.getString("email"),
									res.getString("address"),
									res.getString("dni")));
		}
		conn.closeConn();
		return clients;
	}


	public boolean updateClient(Client c) {
		return conn.setQuery(String.format("UPDATE electrotech.client SET name = '%s', email = '%s',  address = '%s', dni = '%s' WHERE (id = '%d');",
					c.getName(), 
					c.getEmail(),
					c.getAddress(),
					c.getDNI(),
					c.getID()));
	}
	
}
