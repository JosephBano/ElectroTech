package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import libreríaVersion2.FIles;
import model.Employees;
import model.EmployeesDAO;
import view.View_addEmployers;
import view.View_Employees;

public class Logic_view_employees implements ActionListener{
	private View_Employees ve;
	private FIles file = new FIles("");
	private EmployeesDAO edao = new EmployeesDAO();
	private Employees E = new Employees();
	private List<Employees> employees;
	
	public Logic_view_employees(View_Employees ve) {
		super();
		this.ve = ve;
		this.ve.btn_show_password.addActionListener(this);
		this.ve.btn_change_role.addActionListener(this);
		this.ve.cmb_employees.addActionListener(this);
		this.ve.btnAddEmployer.addActionListener(this);
		this.ve.cmb_role.addActionListener(this);
		this.ve.btn_resetpsw.addActionListener(this);
		
		ve.cmb_role.addItem("Admin");
		ve.cmb_role.addItem("Proveedor");
		ve.cmb_role.addItem("Cliente");
		ve.cmb_role.addItem("Ventas");
		
		try {
			employees = edao.readEmployee();
			
			for(Employees e: employees) {
				this.ve.cmb_employees.addItem(e.getName());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ve.btn_show_password) {
			for (Employees em : employees) {
				if (em.getName().equals(ve.cmb_employees.getSelectedItem())) {
					ve.txt_password.setText(em.getPassword());
				}
			}
			ve.lbl_password.setVisible(true);
			ve.txt_password.setVisible(true);
		} else if (e.getSource() == ve.btn_change_role) {
			// Implementar funcionalidad para cambiar rol
			
			try {
				String name = (String) ve.cmb_employees.getSelectedItem();
				String rol = (String) ve.cmb_role.getSelectedItem();
				
				for(Employees em: employees) {
					if(em.getName().equals(name)) {
							edao.replaceRol(em, new Employees(em.getName(), 
															em.getEmail(), 
															em.getPassword(), 
															rol, 
															em.getPhone()));
					}
				}
				JOptionPane.showMessageDialog(ve, "Se ha cambiado de rol correctamente!");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} else if (e.getSource() == ve.cmb_employees) {
			for (Employees em : employees) {
			if (em.getName().equals(ve.cmb_employees.getSelectedItem())) {
				setData(em);
				}
			}
			for (Employees em : employees) {
				if (em.getName().equals(ve.cmb_employees.getSelectedItem())) {
					ve.txt_password.setText(em.getPassword());
				}
			}
			
		} else if (e.getSource() == ve.btnAddEmployer) {
			// Implementar funcionalidad para agregar empleado	
			View_addEmployers vae = new View_addEmployers();
			vae.setVisible(true);
			
		}
		else if(e.getSource() == ve.btn_resetpsw) {
			try {
				String name = (String) ve.cmb_employees.getSelectedItem();
				String psw = "pws123";
				
				for(Employees em: employees) {
					if(em.getName().equals(name)) {
							edao.replaceRol(em, new Employees(em.getName(), 
															em.getEmail(), 
															psw, 
															em.getRole(), 
															em.getPhone()));
					}
				}
				
				ve.txt_password.setText(psw);
				
				JOptionPane.showMessageDialog(ve, "Se ha reseteado la contraseña correctamente!");
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void setData(Employees e) {
		for (int i = 0; i < ve.cmb_role.getItemCount(); i++) {
			if (e.getRole().equals(ve.cmb_role.getItemAt(i).toString())) {
				ve.cmb_role.setSelectedIndex(i);
				break;
			}
		}
	}
	
	
}
