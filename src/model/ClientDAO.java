package model;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import libreríaVersion2.FIles;
import view.View_Clientes;

public class ClientDAO implements SettingsEmployee{

	private FIles file;
	
	public ClientDAO() {
		super();
		this.file = new FIles(mainPath);
		file.create(0);
	}
	
	public boolean writeClient(Client c) throws IOException {
		file.setFile(new File(mainPath,cliente));
		return file.writerFile(c.infoClient(), false);
	}
	
	public List<Client> listClient(String rol) throws IOException {
		List<Client> clients = new ArrayList<>();
		file.setFile(new File(mainPath,cliente));
		
		String [] data = file.readerFile().split("\n");
		for(String d:data) {
			
			if (d.trim().isEmpty()) {
	            continue;
			}
			
			String [] info = d.split(";");
			System.out.println(d + "validator");
			//if(rol.equals(info[2])) {
				Client c = new Client(info[0],//fullname
									info[1],//adress
									info[2]);//detalles 
				clients.add(c);
			//}
		}
		return clients;
	}
	
	public boolean updateClient(Client c, Client c_new) throws IOException {
	    String[] clients = file.readerFile().split("\n");
	    boolean flag = false;

	    for (int i = 0; i < clients.length; i++) {
	        if (clients[i].split(";")[0].equals(c.getName())) {
	            clients[i] = c_new.infoClient();
	            flag = true;
	        }
	    }

	    if (!flag) return false;

	    file.writerFile("", true);

	    for (int i = 0; i < clients.length; i++) {
	        file.writerFile(clients[i], false);
	    }

	    return true; 
	}

		public boolean validateFields(View_Clientes vc) {

		boolean state = true;

		if(file.validateByER(vc.txt_Name.getText(), ERNamesCLient)) {
			
		}else {
			vc.txt_Name.setBackground(Color.RED);
			state = false;
		}
//		if(file.validateByER(vc.txt_ContactDetails.getText(), EREmailClient)){
//
//		}else {
//			vc.txt_ContactDetails.setBackground(Color.RED);
//			state = false;
//		}
		if(file.validateByER(vc.txt_Address.getText(), ERAddress)) {
			vc.txt_Address.setBackground(Color.WHITE);
		}else {
			vc.txt_Address.setBackground(Color.RED);
			state = false;
		}
		return state;
	}

}
