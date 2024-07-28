package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import Model.Employees;
import Model.EmployeesDAO;
import View.View_Employees;
import View.View_addEmployers;
import libreriaVersion3.*;

public class Logic_view_employees implements ActionListener, Parametrizable{
	private View_Employees ve;
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
		
		for(String s: userRoll) {
			ve.cmb_role.addItem(s);
		}
		
		try {
			employees=edao.listEmployees();
			
			for(Employees e: employees) {
				ve.cmb_employees.addItem(e.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Employees em_aux = employees.get(ve.cmb_employees.getSelectedIndex());
		ve.cmb_role.setSelectedIndex(em_aux.getCode()-2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ve.btn_show_password) {
			for (Employees em : employees) {
				if (em.getName().equals(ve.cmb_employees.getSelectedItem())) {
					ve.txt_password.setText(em.getPSW());
				}
			}
			ve.lbl_password.setVisible(true);
			ve.txt_password.setVisible(true);
		} else if (e.getSource() == ve.btn_change_role) {
			// Implementar funcionalidad para cambiar rol
				int index_employee = ve.cmb_employees.getSelectedIndex();	
				int rol = ve.cmb_role.getSelectedIndex() + 2;
				
				Employees employee = employees.get(index_employee); 
				employee.setCode(rol);
				
				if(edao.replaceRol(employee)) {					
					JOptionPane.showMessageDialog(ve, "Se ha cambiado de rol correctamente!");
				}
				else {
					JOptionPane.showMessageDialog(ve, "No se ha sido posible esta accion");
				}
			
		} else if (e.getSource() == ve.cmb_employees) {
			for (Employees em : employees) {
				if (em.getName().equals(ve.cmb_employees.getSelectedItem())) {
					setData(em);
					}
				}
			for (Employees em : employees) {
				if (em.getName().equals(ve.cmb_employees.getSelectedItem())) {
					ve.txt_password.setText(em.getPSW());
				}
			}
			
		} else if (e.getSource() == ve.btnAddEmployer) {
			// Implementar funcionalidad para agregar empleado	
			View_addEmployers vae = new View_addEmployers();
			vae.setVisible(true);
			
		}
		else if(e.getSource() == ve.btn_resetpsw) {
			
			int index_employee = ve.cmb_employees.getSelectedIndex();	
			Employees employee = employees.get(index_employee); 
				
			employee.setPSW(employee.getDNI());				
			ve.txt_password.setText(employee.getPSW());
			
			edao.restartPSW(employee);
				
			JOptionPane.showMessageDialog(ve, "Se ha reseteado la contraseña correctamente!");
		}
	}

	private void setData(Employees e) {
		ve.cmb_role.setSelectedIndex(e.getCode()-2);
	}
}
