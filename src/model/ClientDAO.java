package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreríaVersion2.FIles;

public class ClientDAO implements SettingsEmployee{

	private FIles file;
	
	public ClientDAO() {
		super();
		this.file = new FIles(mainPath);
		file.create(0);
	}
	
	public boolean writeClient(Client c) throws IOException {
		file.setFile(new File(mainPath,information));
		return file.writerFile(c.infoClient(), false);
	}
	
	public List<Client> listClient(String rol) throws IOException {
		List<Client> clients = new ArrayList<>();
		file.setFile(new File(mainPath,information));
		
		String [] data = file.readerFile().split("\n");
		for(String d:data) {
			
			if (d.trim().isEmpty()) {
	            continue;
			}
			
			String [] info = d.split(";");
			
			if(rol.equals(info[3])) {
				Client c = new Client(info[0],//fullname
									info[1],//email
									info[4],//adress
									info[5]);//detail contact
				clients.add(c);
			}
		}
		return clients;
	}
	
	public boolean updateClient(Client c, Client c_new) throws IOException {
	    String[] clients = file.readerFile().split("\n");
	    boolean flag = false;

	    for (int i = 0; i < clients.length; i++) {
	        if (clients[i].split(";")[0].equals(c.getName()) && clients[i].split(";")[3].equals("Cliente")) {
	            clients[i] = c_new.infoClient();
	            flag = true;
	        }
	    }

	    if (!flag) return false;

	    file.writerFile("", true);

	    for (int i = 0; i < clients.length; i++) {
	        System.out.println(clients[i]);
	        file.writerFile(clients[i], false);
	    }

	    return true;
	}
}
