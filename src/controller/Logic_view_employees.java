package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private List<Employees> employees = new ArrayList<>();
	
	public Logic_view_employees(View_Employees ve) {
		super();
		this.ve = ve;
		this.ve.btn_show_password.addActionListener(this);
		this.ve.btn_change_role.addActionListener(this);
		this.ve.btn_save.addActionListener(this);
		this.ve.cmb_employees.addActionListener(this);
		this.ve.btnAddEmployer.addActionListener(this);
		loadNames();
		loadRoles();
		dataEmployee();
	}
	
	private List<Employees> dataEmployee() {
		file.setFile(new File(edao.mainPath, edao.information));
		try {
			String[] DataEmployees = file.readerFile().split("\n");

			for (String n : DataEmployees) {
				String[] info = n.split(";");
				Employees employee = new Employees();
				employee.setName(info[0]);
				employee.setEmail(info[1]);
				employee.setPassword(info[2]);
				employee.setRole(info[3]);
				employees.add(employee);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employees;
	}

	private void loadNames() {
		file.setFile(new File(edao.mainPath, edao.information));
		ArrayList<String> namesEmployees = new ArrayList<>();

		try {
			String[] DataEmployees = file.readerFile().split("\n");

			for (String n : DataEmployees) {
				String[] info = n.split(";");
				if (info.length > 0) {
					namesEmployees.add(info[0]);
				}
			}

			for (String name : namesEmployees) {
				ve.cmb_employees.addItem(name);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void loadRoles() {
		file.setFile(new File(edao.mainPath, edao.information));
		Set<String> roles = new HashSet<>();

		try {
			String[] DataEmployees = file.readerFile().split("\n");

			for (String n : DataEmployees) {
				String[] info = n.split(";");
				if (info.length > 3) {
					roles.add(info[3]);
				}
			}

			for (String role : roles) {
				ve.cmb_role.addItem(role);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ve.btn_show_password) {
			ve.lbl_password.setVisible(true);
			ve.txt_password.setVisible(true);
		} else if (e.getSource() == ve.btn_save) {
			// Implementar funcionalidad para guardar cambios
		} else if (e.getSource() == ve.btn_change_role) {
			// Implementar funcionalidad para cambiar rol
		} else if (e.getSource() == ve.cmb_employees) {
			for (Employees em : employees) {
				if (em.getName().equals(ve.cmb_employees.getSelectedItem())) {
					setData(em);
				}
			}
		} else if (e.getSource() == ve.btnAddEmployer) {
			// Implementar funcionalidad para agregar empleado	
			View_addEmployers vae = new View_addEmployers();
			vae.setVisible(true);
			
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
