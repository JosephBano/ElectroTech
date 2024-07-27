package Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Employees;
import Model.EmployeesDAO;
import View.View_addEmployers;

public class Logic_view_addEmployers implements ActionListener{
	
	private View_addEmployers vae;
	private EmployeesDAO edao = new EmployeesDAO();
	private List<Employees> employees;
	
	public Logic_view_addEmployers(View_addEmployers vae_) {
		this.vae = vae_;
		this.vae.btnAgregar.addActionListener(this);
		this.vae.cmb_rol.addActionListener(this);
		
		this.vae.cmb_rol.addItem("Admin");
		this.vae.cmb_rol.addItem("Cliente");
		this.vae.cmb_rol.addItem("Inventario");
		this.vae.cmb_rol.addItem("Proveedor");
		
		try {
			employees = edao.readEmployee();
		} catch (IOException e) {
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
				String funcion = (String) vae.cmb_rol.getSelectedItem();
				String email = vae.txtCorreo.getText();
				String phone = vae.txtTelefono.getText();
				String psw = vae.txtClave.getText();
				boolean flag = true;
				
				for(Employees em: employees) {
					if(em.getEmail().equals(email)) {
						JOptionPane.showMessageDialog(vae, "Este correo electronico ya ha sido registrado!");
						flag = false;
					}
				}
				
				if(flag) {
					try {
						edao.writeEmployee(new Employees(name, email, psw, funcion, phone));
						JOptionPane.showMessageDialog(vae, "Empleado agregado correctamente!");
						resetFields();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			//}
		}
	}
	
	public void resetFields() {
		vae.txtNombre.setText("");
		vae.txtCorreo.setText("");
		vae.txtTelefono.setText("");
		vae.txtClave.setText("");
	}

}
