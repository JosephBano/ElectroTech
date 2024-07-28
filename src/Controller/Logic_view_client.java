package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Client;
import Model.ClientDAO;
import View.View_Clientes;

public class Logic_view_client implements ActionListener, Parametrizable{
	
	private View_Clientes vc;
	private Client client = new Client();

	public Logic_view_client(View_Clientes vc_) {
		this.vc = vc_;
		this.vc.btn_Add.addActionListener(this);
		this.vc.btn_Update.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vc.btn_Add) {

			String name = vc.txt_Name.getText();
			String address = vc.txt_Address.getText();
			String detail = vc.txt_ContactDetails.getText();
			client.setName(name);
			client.setEmail(detail);
			client.setAddress(address);
				
			if(cdao.insertClient(client)) {
				JOptionPane.showMessageDialog(vc, "Cliente agregado con exito!");
				resetFields();	
			}else {
				JOptionPane.showMessageDialog(vc, "Campos Incorrectos");
			}		
			
		}
		else if(e.getSource()==vc.btn_Update) {
			try {
				
				List<Client> clients = cdao.listClient();
				boolean flag = false;
				
				String name = vc.txt_Name.getText();
				String address = vc.txt_Address.getText();
				String detail = vc.txt_ContactDetails.getText();				
				
				for(Client c: clients) {
					System.out.println(c.getEmail() + detail);
					
					if(c.getEmail().equals(detail)) {
						if(cdao.updateClient(new Client(c.getID(), name, detail, address))){
							JOptionPane.showMessageDialog(vc, "El cliente se ha actualizado con exito");
							resetFields();
							flag = true;
						}else{
							JOptionPane.showMessageDialog(vc, "Campos Incorrectos");
						}
					}
					
				}
				if(flag == false) {
					JOptionPane.showMessageDialog(vc, "No se han encontrado las credenciales para actualizar!");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void resetFields() {
		vc.txt_Name.setText("");
		vc.txt_Address.setText("");
		vc.txt_ContactDetails.setText("");
	}

}
