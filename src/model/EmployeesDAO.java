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
	public boolean writeEmployeeName(Employees e,String user) throws IOException {
		//Direccionar  al archivo
		file.setFile(new File(mainPath,(user+".txt")));
		return file.writerFile(e.infoEmployee()+"\n", true);
	}
	public List<Employees> readEmployee() throws IOException{
		//Almacenar los datos de cada persona encontrada
		List<Employees> employees=new ArrayList<>();
		file.setFile(new File(mainPath,information));
		//leer los datos del archivo
		String [] data=file.readerFile().split("\n");
		for(String d:data) {
			String [] info=d.split(";");
			Employees e=new Employees();
			e.setName(info[0]);
			e.setEmail(info[1]);
			e.setPassword(info[2]);
			e.setRole(info[3]);
			employees.add(e);
		}
		return employees;
	}
}
