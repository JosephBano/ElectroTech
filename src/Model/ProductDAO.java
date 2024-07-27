package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller.Parametrizable;

public class ProductDAO implements Parametrizable{

	
	public ProductDAO() {
		super();
		
	}
	
	public boolean insertProduct(Employees e) {
		return conn.setQuery(String.format("INSERT INTO `electrotech`.`employee` (`id_provider`, `name`, `description`, `price`, stock) VALUES ('%d', '%s', '%s', '%.2f','%d');"
				,e.getName()
				,e.getEmail()
				,e.getPSW()
				,e.getDNI()
				,e.getCode()
				,e.getDate()));
	}
}
