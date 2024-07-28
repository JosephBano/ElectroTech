package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import java.util.Date;

import javax.swing.JOptionPane;

import Model.Employees;
import Model.EmployeesDAO;
import View.View_addEmployers;

public class Logic_view_addEmployees implements ActionListener, Parametrizable{
	
	private View_addEmployers vae;
	private List<Employees> employees;
	
	public Logic_view_addEmployees(View_addEmployers vae_) {
		this.vae = vae_;
		this.vae.btnAgregar.addActionListener(this);
		this.vae.cmb_rol.addActionListener(this);
		
		for(String s: userRoll) {
			vae.cmb_rol.addItem(s);
		}
		
		try {
			employees=edao.listEmployees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vae.btnAgregar) {
			System.out.println("hola");
			//if(edao.validateFields(vae) == true) {
				String name = vae.txtNombre.getText();
				int code = vae.cmb_rol.getSelectedIndex() + 2;
				String email = vae.txtCorreo.getText();
				String dni = vae.txtDNI.getText();
				String psw = vae.txtClave.getText();
				boolean flag = true;
				
				for(Employees em: employees) {
					if(em.getEmail().equals(email)) {
						JOptionPane.showMessageDialog(vae, "Este correo electronico ya ha sido registrado!");
						flag = false;
					}
				}
				
				if(flag) {
					edao.insertEmployee(new Employees(0, name, email, psw, dni, code, new Date().toString()));
					JOptionPane.showMessageDialog(vae, "Empleado agregado correctamente!");
					resetFields();
				}
			//}
		}
	}
	
	public void resetFields() {
		vae.txtNombre.setText("");
		vae.txtCorreo.setText("");
		vae.txtDNI.setText("");
		vae.txtClave.setText("");
	}

}
