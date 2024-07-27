package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Client;
import Model.ClientDAO;
import View.View_Clientes;

public class Logic_view_client implements ActionListener{
	
	private View_Clientes vc;
	private ClientDAO cdao = new ClientDAO();

	public Logic_view_client(View_Clientes vc_) {
		this.vc = vc_;
		this.vc.btn_Add.addActionListener(this);
		this.vc.btn_Update.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vc.btn_Add) {

			if(cdao.validateFields(vc) == true) {
				
				String name = vc.txt_Name.getText();
				//String email = vc.txt_Email.getText();
				String adress = vc.txt_Address.getText();
				String detail = vc.txt_ContactDetails.getText();
				try {
					cdao.writeClient(new Client(name,adress,detail));
					JOptionPane.showMessageDialog(vc, "Cliente agregado con exito!");
					resetFields();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else {
				JOptionPane.showMessageDialog(vc, "Campos Incorrectos");
			}		
			
		}
		else if(e.getSource()==vc.btn_Update) {
			try {
				List<Client> clients = cdao.listClient("Cliente");
				boolean flag = false;
				
				String name = vc.txt_Name.getText();
				//String email = vc.txt_Email.getText();
				String adress = vc.txt_Address.getText();
				String detail = vc.txt_ContactDetails.getText();
				
				for(Client c: clients) {
					if(c.getName().equals(name)) {
						if(cdao.validateFields(vc) == true) {

							cdao.updateClient(c, new Client(name, adress, detail));///////////////////////////
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
				
			} catch (IOException e1) {
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
