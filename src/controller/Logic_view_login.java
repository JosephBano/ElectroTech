package controller;

import view.View_Clientes;

import view.View_Employees;
import view.View_Gerente;
import view.view_inventario;
import view.View_Login;
import view.View_Proveedor;
import view.View_ventas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import libreriaVersion3.FileS;
import model.Employees;
import model.EmployeesDAO;

public class Logic_view_login implements ActionListener{
	
	private View_Login vm;
	private FileS files=new FileS("");
	private EmployeesDAO edao=new EmployeesDAO();
	private View_Employees ve;
	private view_inventario vi;
	private View_Proveedor vp;
	private Employees E=new Employees();
	private List<Employees> emp;
	
	public Logic_view_login(View_Login vm) {
		super();
		// TODO Auto-generated constructor stub
		this.vm=vm;
		this.vm.btn_join.addActionListener(this);
		try {
			emp=edao.readEmployee();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vm.btn_join) {
            correct(emp);
		}
	}
	
	private void correct(List<Employees> emp) {
		boolean found = false;
	    for (Employees em : emp) {
	        if (em.getEmail().equals(vm.txt_email.getText()) && em.getPassword().equals(vm.psf_password.getText())) {
	            found = true;
	            openWindow(em);
	            break; // Detener el bucle una vez que se encuentra una coincidencia
	        }
	    }
	    if (!found) {
	        // Mostrar mensaje: credenciales incorrectas
	    	JOptionPane.showMessageDialog(null,"Credenciales incorrectas");
	    }
	}
	private void openWindow(Employees em) {
		if (em.getRole().trim().equalsIgnoreCase("Admin")) { // Utilizar trim() y equalsIgnoreCase()
        	vm.setVisible(false);
            View_Gerente vg = new View_Gerente();
            vg.setVisible(true);
        }else if(em.getRole().trim().equalsIgnoreCase("Inventario")) {
        	vm.setVisible(false);
            view_inventario vi = new view_inventario();
            vi.setVisible(true);
        } else if(em.getRole().trim().equalsIgnoreCase("Cliente")) {
        	vm.setVisible(false);
            View_Clientes ve = new View_Clientes();
            ve.setVisible(true);	
        }else if(em.getRole().trim().equalsIgnoreCase("Proveedor")) {
        	vm.setVisible(false);
            View_Proveedor vp = new View_Proveedor();
            vp.setVisible(true);
		} else if (em.getRole().trim().equalsIgnoreCase("Ventas")) {
			vm.setVisible(false);
			View_ventas ve = new View_ventas();
			ve.setVisible(true);
		}
	}
}
