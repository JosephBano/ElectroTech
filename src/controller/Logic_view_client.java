package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Client;
import model.ClientDAO;
import view.View_Clientes;

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
			String name = vc.txt_Name.getText();
			//String email = vc.txt_Email.getText();
			String adress = vc.txt_Address.getText();
			String detail = vc.txt_ContactDetails.getText();
			
			try {
				cdao.writeClient(new Client(name,"client@client.com", adress, detail));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(vc, "Cliente agregado con exito!");
			resetFields();
		}
	}
	
	public void resetFields() {
		vc.txt_Name.setText("");
		vc.txt_Address.setText("");
		vc.txt_ContactDetails.setText("");
	}

}
