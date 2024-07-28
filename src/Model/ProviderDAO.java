package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.Parametrizable;

public class ProviderDAO implements Parametrizable{


	
	public ProviderDAO() {
		super();
	}
	
	public boolean insertProvider(Provider p){
		return conn.setQuery(String.format("INSERT INTO electrotech.provider (names, email, dni, code, phone, social) VALUES ('%s', '%s', '%s', '%s', '%s', '%s');",
				p.getFullname(),
				p.getEmail(),
				p.getDni(),
				p.getCode(),
				p.getPhone(),
				p.getSocialReason()));
	}    
	
	public List<Provider> listProviders() throws SQLException {
		List<Provider> employees = new ArrayList<>();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.provider;");
		
		while(res.next()) {
			employees.add(new Provider(res.getInt("id"),
										res.getString("names"),
										res.getString("email"),
										res.getString("dni"),
										res.getString("code"),
										res.getString("phone"),
										res.getString("social")));
		}
		conn.closeConn();
		return employees;
	}
	
}
