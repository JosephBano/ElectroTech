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
		return conn.setQuery(String.format("INSERT INTO `electrotech`.`client` (`name`, `email`) VALUES ('%s', '%s');", 
					c.getName(), 
					c.getEmail()));
	}
	
	public List<Client> listClient() throws SQLException {
		List<Client> clients = new ArrayList<>();
		
		ResultSet res = conn.getQuery("SELEC * FROM electrotech.client;");
		
		while(res.next()) {
			clients.add(new Client(	res.getInt(1),
									res.getString(2),
									res.getString(3)));
		}
		conn.closeConn();
		return clients;
	}


	public boolean updateClient(Client c) {
		return conn.setQuery(String.format("UPDATE `electrotech`.`client` SET `name` = '%d', `email` = '%d' WHERE (`id` = '%d');",
					c.getName(), 
					c.getEmail(),
					c.getID()));
	}
}
