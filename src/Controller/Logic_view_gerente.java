package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import View.View_Clientes;
import View.View_Employees;
import View.View_Gerente;
import View.View_Proveedor;
import View.View_ventas;
import View.view_inventario;

public class Logic_view_gerente implements ActionListener{
	private View_Gerente vg;
	public Logic_view_gerente(View_Gerente vg) {
		super();
		// TODO Auto-generated constructor stub
		this.vg=vg;
		this.vg.btn_employees.addActionListener(this);
		this.vg.btn_ventas.addActionListener(this);
		this.vg.btn_proveedor.addActionListener(this);
		this.vg.btn_cliente.addActionListener(this);
		this.vg.btn_Inventario.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource()==vg.btn_employees) {
	        View_Employees ve=new View_Employees();
	        ve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        ve.setVisible(true);
	    } else if(e.getSource()==vg.btn_ventas) {
	        View_ventas vv=new View_ventas();
	        vv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vv.setVisible(true);
	    } else if(e.getSource()==vg.btn_proveedor) {
	        View_Proveedor vp=new View_Proveedor();
	        vp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vp.setVisible(true);
	    } else if(e.getSource()==vg.btn_cliente) {
	        View_Clientes vc=new View_Clientes();
	        vc.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vc.setVisible(true);
	    } else if (e.getSource() == vg.btn_Inventario) {
	        view_inventario vi = new view_inventario();
	        vi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vi.setVisible(true);
	    }
	}
}
