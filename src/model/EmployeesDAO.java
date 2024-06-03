package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreríaVersion2.FIles;

public class EmployeesDAO implements SettingsEmployee{
	private FIles file;

	public EmployeesDAO() {
		super();
		// TODO Auto-generated constructor stub
		file=new FIles(mainPath);
		file.create(0);
	}
	
	public boolean writeEmployee(Employees e) throws IOException {
		file.setFile(new File(mainPath,information));
		return file.writerFile(e.infoEmployee()+"\n", false);
	}
	
	public List<Employees> readEmployee() throws IOException{
		//Almacenar los datos de cada persona encontrada
		List<Employees> employees=new ArrayList<>();
		file.setFile(new File(mainPath,information));
		//leer los datos del archivo
		String [] data=file.readerFile().split("\n");
		
		for(String d:data) {
			if (d.trim().isEmpty()) {
	            continue;
			}
			
			String [] info=d.split(";");
			
			Employees e=new Employees(info[0],
										info[1],
										info[2],
										info[3],
										info[4]);
			
			employees.add(e);
		}
		return employees;
	}
	
	public boolean replaceRol(Employees e, Employees e_new) throws IOException {
		file.setFile(new File(mainPath,information));
		String [] employees = file.readerFile().split("\n");
		boolean flag = false;
		
		for(int i = 0; i < employees.length; i++) {
			if (employees[i].trim().isEmpty()) {
	            continue;
			}
			if(employees[i].split(";")[1].equals(e.getEmail())) {
				employees[i] = e_new.infoEmployee();
				flag = true;
			}
		}
		
		if(!flag) return false;
		
		file.writerFile("", true);
		
		for (int i = 0; i < employees.length; i++) {
	        file.writerFile(employees[i], false);
	    }
		
		return true;
	}
}
