package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import libreriaVersion3.*;

import Controller.Parametrizable;

public class EmployeesDAO implements Parametrizable{

	public EmployeesDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertEmployee(Employees e) {
		return conn.setQuery(String.format("INSERT INTO `electrotech`.`employee` (`name`, `email`, `psw`, `dni`, code, `date_join`) VALUES ('%s', '%s', '%s', '%s', %d, '%s');"
				,e.getName()
				,e.getEmail()
				,e.getPSW()
				,e.getDNI()
				,e.getCode()
				,e.getDate()));
	}
	
	public List<Employees> validateLogin(String email, String psw) throws SQLException {
		List<Employees> employees = new ArrayList<>();
		
		ResultSet res = conn.getQuery(String.format("SELECT * FROM electrotech.employee WHERE email='%s' AND psw='%s';",
				email,
				psw));
		
		while(res.next()) {
			employees.add(new Employees(res.getInt("id"),
										res.getString("name"),
										res.getString("email"),
										res.getString("psw"),
										res.getString("dni"),
										res.getInt("code"),
										res.getString("date_join")));
		}
		conn.closeConn();
		return employees;
	}
	
	public List<Employees> listEmployees() throws SQLException{
		List<Employees> employees = new ArrayList();
		
		ResultSet res = conn.getQuery("SELECT * FROM electrotech.employee WHERE code NOT IN(0, 1)");
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
	
	public boolean replaceRol(Employees e) {
        return conn.setQuery(String.format("UPDATE electrotech.employee SET code='%s' WHERE id = %d;",
                e.getCode(),
                e.getID()));
    }
	
	public boolean restartPSW(Employees e) {
        return conn.setQuery(String.format("UPDATE electrotech.employee SET psw='%s' WHERE id = %d;",
                e.getPSW(),
                e.getID()));
    }
	
	public boolean restartPSW2(String email) {
        return conn.setQuery(String.format("UPDATE electrotech.employee SET psw = dni WHERE email = %s;",
                email));
    }
}
