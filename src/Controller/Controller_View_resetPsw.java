package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.View_resetPsw;

public class Controller_View_resetPsw implements Parametrizable, ActionListener{

	private View_resetPsw vrp;
	
	public Controller_View_resetPsw(View_resetPsw vrp_) {
		this.vrp = vrp_;
		this.vrp.btn_recuperar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vrp.btn_recuperar) {
			String email = vrp.txt_email.getText();
			if(edao.restartPSW2(email)) {
				JOptionPane.showConfirmDialog(vrp, "Se ha restablecido la contrasena con exito!");
			}
			else {
				JOptionPane.showConfirmDialog(vrp, "No se ha podido completar la operacion");
			}
		}
	}

}
