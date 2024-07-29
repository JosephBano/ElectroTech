package Controller;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import java.util.Date;

import javax.swing.JOptionPane;

import Model.Employees;
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
			
			if(!validateFields()) return;	
			
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
		}
	}
	
	public boolean validateFields() {
        boolean flagFields = true;

        if(!Parametrizable.validarRegex(ERNames2, vae.txtNombre.getText())) {
            vae.txtNombre.setBackground(Color.red);
            flagFields = false;
            vae.txtNombre.setText("");
        } else {
            vae.txtNombre.setBackground(Color.white);
        }

        if(!Parametrizable.validarRegex(EREmail, vae.txtCorreo.getText())) {
            vae.txtCorreo.setBackground(Color.red);
            flagFields = false;
            vae.txtCorreo.setText("");
        } else {
            vae.txtCorreo.setBackground(Color.white);
        }

        if(!Parametrizable.validarRegex(ERDNI, vae.txtDNI.getText())) {
            vae.txtDNI.setBackground(Color.red);
            flagFields = false;
            vae.txtDNI.setText("");
        } else {
            vae.txtDNI.setBackground(Color.white);
        }

        if(!Parametrizable.validarRegex(ERPassword, vae.txtClave.getText())) {
            vae.txtClave.setBackground(Color.red);
            flagFields = false;
            vae.txtClave.setText("");
        } else {
            vae.txtClave.setBackground(Color.white);
        }

        return flagFields;
    }
	
	
	public void resetFields() {
		vae.txtNombre.setText("");
		vae.txtCorreo.setText("");
		vae.txtDNI.setText("");
		vae.txtClave.setText("");
	}

}
