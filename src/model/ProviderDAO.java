package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreríaVersion2.FIles;

public class ProviderDAO implements SettingsEmployee{

	private FIles file;
	
	public ProviderDAO() {
		super();
		this.file = new FIles(mainPath);
		file.create(0);
	}
	
 	
	public List<Employees> listProviders(String rol) throws IOException{
		List<Employees> employees=new ArrayList<>();
		file.setFile(new File(mainPath,information));
		//leer los datos del archivo
		String [] data=file.readerFile().split("\n");
		for(String d:data) {
			String [] info=d.split(";");
			
			if(rol.equals(info[3])) {
				Employees e=new Employees();
				e.setName(info[0]);
				e.setEmail(info[1]);
				e.setPassword(info[2]);
				e.setRole(info[3]);
				employees.add(e);
				
			}
		}
		return employees;
	}
	
	public long getDniByName(String name) throws IOException {
		String [] providers = file.readerFile().split("\n");
		for(String p: providers) {
			if(p.split(";")[0].equals(name)) {
				return Long.parseLong(p.split(";")[4]);
			}
		}
		return 10000000;
	}
	
}
