package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Employees;
import View.View_Clientes;
import View.View_Employees;
import View.View_Login;
import View.View_Proveedor;
import View.View_resetPsw;
import View.View_ventas;
import View.view_inventario;

public class Logic_view_login implements ActionListener, Parametrizable{
	
	private View_Login vm;
	private Employees employee=new Employees();
	
	public Logic_view_login(View_Login vm) {
		super();
		// TODO Auto-generated constructor stub
		this.vm=vm;
		this.vm.btn_join.addActionListener(this);
		this.vm.btn_key.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vm.btn_join) {
            if(validateUser()) {            	
            	redirectUser();
            }
		}
		if(e.getSource()==vm.btn_key) {
			View_resetPsw vhs=new View_resetPsw();
	        vhs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vhs.setVisible(true);
		}
	}
	
	private boolean validateUser() {	
		try {
			String email = vm.txt_email.getText();
			String psw = vm.psf_password.getText();
			List<Employees> employees = edao.validateLogin(email, psw);
			
			if(!employees.isEmpty()) {
				employee = employees.get(0);
				return true;
			}
			else {
				JOptionPane.showMessageDialog(vm,"Credenciales incorrectas!");
				vm.txt_email.setText("");
				vm.psf_password.setText("");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	private void redirectUser() {
		//Admin = 1
		//Inventario = 2
		//Registrar Cliente = 3
		//Registrar Proveedor = 4
		//Registrar Venta = 5
		if (employee.getCode()==1) {
        	vm.setVisible(false);
            View_Employees vg = new View_Employees();
            vg.setVisible(true);
        }else if(employee.getCode()==2) {
        	vm.setVisible(false);
            view_inventario vi = new view_inventario();
            vi.setVisible(true);
        } else if(employee.getCode()==3) {
        	vm.setVisible(false);
            View_Clientes ve = new View_Clientes();
            ve.setVisible(true);	
        }else if(employee.getCode()==4) {
        	vm.setVisible(false);
            View_Proveedor vp = new View_Proveedor();
            vp.setVisible(true);
		} else if (employee.getCode()==5) {
			vm.setVisible(false);
			View_ventas ve = new View_ventas();
			ve.setVisible(true);
		}
	}
}
