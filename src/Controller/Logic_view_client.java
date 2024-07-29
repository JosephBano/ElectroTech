package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Model.Client;
import Model.ClientDAO;
import View.View_Clientes;
import View.View_HistorySales;

public class Logic_view_client implements ActionListener, Parametrizable, DocumentListener{
	
	private View_Clientes vc;
	private Client client = new Client();
	private boolean flag = true;

	public Logic_view_client(View_Clientes vc_) {
		this.vc = vc_;
		this.vc.btn_Add.addActionListener(this);
		this.vc.btn_Update.addActionListener(this);
		this.vc.btn_validate.addActionListener(this);
		this.vc.btn_register.addActionListener(this);
		this.vc.btn_save.addActionListener(this);
		this.vc.txt_dni.getDocument().addDocumentListener(this);
		
		this.vc.btn_validate.setEnabled(false);
		this.vc.btn_Update.setEnabled(true);
		this.vc.btn_Add.setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vc.btn_Add) {
			flag = true;
			this.vc.btn_Update.setEnabled(true);
			this.vc.btn_Add.setEnabled(false);
			this.vc.btn_validate.setEnabled(false);
			this.vc.btn_register.setEnabled(false);
			this.vc.btn_save.setEnabled(true);
		}
		else if(e.getSource()==vc.btn_Update) {
			flag = false;
			this.vc.btn_save.setEnabled(false);
			this.vc.btn_Update.setEnabled(false);
			this.vc.btn_Add.setEnabled(true);
			this.vc.btn_validate.setEnabled(true);

		}
		else if(e.getSource()==vc.btn_register) {

			client_history.setID(client.getID());
			client_history.setName(client.getName());
			client_history.setEmail(client.getName());
			client_history.setDNI(client.getDNI());
			client_history.setAddress(client.getAddress());
			
			View_HistorySales vhs=new View_HistorySales();
	        vhs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vhs.setVisible(true);
		}
		else if(e.getSource()==vc.btn_validate) {
			try {
				String dni = vc.txt_dni.getText();
				List<Client> clients;
				clients = cdao.searchClient(dni);
				
				if(!clients.isEmpty()) {
					client = clients.get(0);
					
					vc.txt_Name.setText(client.getName());
					vc.txt_ContactDetails.setText(client.getEmail());
					vc.txt_Address.setText(client.getAddress());
					
					vc.btn_register.setEnabled(true);
					vc.btn_save.setEnabled(true);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==vc.btn_save) {
			//CREATE
			if(flag) {
				
				if(!validateFieldsInsert()) return;
				
				String name = vc.txt_Name.getText();
				String address = vc.txt_Address.getText();
				String detail = vc.txt_ContactDetails.getText();
				String dni = vc.txt_dni.getText();
					
				if(cdao.insertClient(new Client(0, name, detail, address, dni))) {
					JOptionPane.showMessageDialog(vc, "Cliente agregado con exito!");
					resetFields();	
				}else {
					JOptionPane.showMessageDialog(vc, "Campos Incorrectos");
				}
			}
			//UPDATE
			else {
				try {
					String dni = vc.txt_dni.getText();
					List<Client> clients;
					
					clients = cdao.searchClient(dni);
					if(!clients.isEmpty()) {
						client = clients.get(0);
						
						if(!validateFieldsUpdate()) return;
						
						String name = vc.txt_Name.getText();
						String address = vc.txt_Address.getText();
						String detail = vc.txt_ContactDetails.getText();
						
						client.setName(name);
						client.setEmail(detail);
						client.setAddress(address);
						
						if(cdao.updateClient(client)) {
							JOptionPane.showMessageDialog(vc, "Cliente update con exito!");
							resetFields();	
						}else {
							JOptionPane.showMessageDialog(vc, "Ha ocurrido un error");
						}
						
						
						vc.btn_Update.setEnabled(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	public boolean validateFieldsInsert() {
		boolean flagFields = true;
		if(!Parametrizable.validarRegex(ERNames4, vc.txt_Name.getText())) {
			vc.txt_Name.setBackground(Color.red);
			flagFields = false;
			vc.txt_Name.setText("");
		}
		else {
			vc.txt_Name.setBackground(Color.white);
		}
		if(!Parametrizable.validarRegex(ERAddress, vc.txt_Address.getText())) {
			vc.txt_Address.setBackground(Color.red);
			flagFields = false;
			vc.txt_Address.setText("");
		}
		else {
			vc.txt_Address.setBackground(Color.white);
		}
		if(!Parametrizable.validarRegex(EREmail, vc.txt_ContactDetails.getText())) {
			vc.txt_ContactDetails.setBackground(Color.red);
			flagFields = false;
			vc.txt_ContactDetails.setText("");
		}
		else {
			vc.txt_ContactDetails.setBackground(Color.white);
		}
		if(!Parametrizable.validarRegex(ERDNI, vc.txt_dni.getText())) {
			vc.txt_dni.setBackground(Color.red);
			flagFields = false;
			vc.txt_dni.setText("");
		}
		else {
			vc.txt_dni.setBackground(Color.white);
		}
		
		return flagFields;
	}
	
	public boolean validateFieldsUpdate() {
		boolean flagFields = true;
		if(!Parametrizable.validarRegex(ERNames4, vc.txt_Name.getText())) {
			vc.txt_Name.setBackground(Color.red);
			flagFields = false;
			vc.txt_Name.setText("");
		}
		else {
			vc.txt_Name.setBackground(Color.white);
		}
		if(!Parametrizable.validarRegex(ERAddress, vc.txt_Address.getText())) {
			vc.txt_Address.setBackground(Color.red);
			flagFields = false;
			vc.txt_Address.setText("");
		}
		else {
			vc.txt_Address.setBackground(Color.white);
		}
		if(!Parametrizable.validarRegex(EREmail, vc.txt_ContactDetails.getText())) {
			vc.txt_ContactDetails.setBackground(Color.red);
			flagFields = false;
			vc.txt_ContactDetails.setText("");
		}
		else {
			vc.txt_ContactDetails.setBackground(Color.white);
		}
		
		return flagFields;
	}
	
	public void resetFields() {
		vc.txt_dni.setText("");
		vc.txt_Name.setText("");
		vc.txt_Address.setText("");
		vc.txt_ContactDetails.setText("");
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(!flag) {
			vc.btn_save.setEnabled(false);
			vc.btn_register.setEnabled(false);
			vc.txt_Name.setText("");
			vc.txt_Address.setText("");
			vc.txt_ContactDetails.setText("");
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		if(!flag) {
			vc.btn_save.setEnabled(false);
			vc.btn_register.setEnabled(false);
			vc.txt_Name.setText("");
			vc.txt_Address.setText("");
			vc.txt_ContactDetails.setText("");
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

}
