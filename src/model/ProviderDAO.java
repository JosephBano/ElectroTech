package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

import libreríaVersion2.FIles;
import view.View_Proveedor;

public class ProviderDAO implements SettingsEmployee{

	private FIles file;
	
	public ProviderDAO() {
		super();
		this.file = new FIles(mainPath);
		file.create(0);
	}
	
	public boolean writeProduct(Provider p) throws IOException{
		file.setFile(new File(mainPath,provider));
		return file.writerFile(p.infoProvider(), false);
	}
 	
	public List<Provider> listProviders(String rol) throws IOException{
		List<Provider> providers=new ArrayList<>();
		file.setFile(new File(mainPath,provider));
		
		String [] data=file.readerFile().split("\n");
		for(String d:data) {
			
			if (d.trim().isEmpty()) {
	            continue;
			}
			String [] info=d.split(";");
			
			//if(rol.equals(info[3])) {
				Provider e=new Provider(info[0],//nombre
										info[1],//correo
										Long.parseLong(info[2]),//dni
										Integer.parseInt(info[3]),//code
										Long.parseLong(info[4]),//telefono
										info[5]);//razon social
										//);
				providers.add(e);
				
			//}
		}
		return providers;
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

	public boolean validateFields(View_Proveedor vp) {

		boolean state = true;

		if(file.validateByER(vp.txt_Names.getText(), ERNamesProvider)) {
			
		}else {
			vp.txt_Names.setBackground(Color.RED);
			state = false;
		}
		if(file.validateByER(vp.txt_Email.getText(), EREmailProvider)){

		}else {
			vp.txt_Email.setBackground(Color.RED);
			state = false;
		}
		if(file.validateByER(vp.txt_RUC.getText(), ERRuc)){

		}else{
			vp.txt_RUC.setBackground(Color.RED);
			state = false;
		}if(file.validateByER(vp.txt_Phone.getText(), ERPhone)){

		}else{
			vp.txt_Phone.setBackground(Color.RED);
			state = false;
		}
		return state;
	}
	
}
