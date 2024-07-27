package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.Parametrizable;

public class EmployeesDAO implements Parametrizable{

	public EmployeesDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertEmployee(Employees e) {
		return conn.setQuery(String.format("INSERT INTO `electrotech`.`employee` (`name`, `email`, `psw`, `dni`, code, `date_join`) VALUES ('%s', '%s', '%s', '%s', 0, '%s');"
				,e.getName()
				,e.getEmail()
				,e.getPSW()
				,e.getDNI()
				,e.getCode()
				,e.getDate()));
	}
	
	public List<Employees> listEmployees() throws SQLException{
		List<Employees> employees = new ArrayList();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.employee WHERE code = 0;");
		while(res.next()) {
			employees.add(new Employees(
					res.getInt(1),
					res.getString(2),
					res.getString(3),
					res.getString(4), 
					res.getString(5),
					res.getInt(6),
					res.getString(7)));
		}
		conn.closeConn();
		return employees;
	}
	
}
