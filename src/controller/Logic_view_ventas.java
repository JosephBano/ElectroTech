package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.View_ventas;

public class Logic_view_ventas implements ActionListener {
	private View_ventas vv;

	public Logic_view_ventas(View_ventas vv) {
		super();
		// TODO Auto-generated constructor stub
		this.vv = vv;
		this.vv.btn_confirmar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 // TODO Auto-generated method stub
		if(e.getSource()==vv.btn_confirmar) {
			System.out.println("Venta confirmada");
		}
    } 
}
