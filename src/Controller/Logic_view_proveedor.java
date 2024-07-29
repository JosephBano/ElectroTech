package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Provider;
import Model.ProviderDAO;
import View.View_Proveedor;

public class Logic_view_proveedor implements ActionListener, Parametrizable{
	
	private View_Proveedor vp;
	
	public Logic_view_proveedor(View_Proveedor vp_) {
		this.vp = vp_;
		this.vp.btn_save.addActionListener(this);
		this.vp.btn_close.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vp.btn_save) {
			
			if(!validateFields()) return;

			String fullname = vp.txt_Names.getText();
			String email = vp.txt_Email.getText();
			String dni = vp.txt_RUC.getText();
			String code = vp.txt_Code.getText();
			String phone = vp.txt_Phone.getText();
			String socialReason = vp.txt_SocialReason.getText();
			
			Provider p = new Provider(0, fullname, email, dni, code, phone, socialReason);
			
			if(prdao.insertProvider(p)){
				JOptionPane.showConfirmDialog(vp, "El proveedor se ha registrado exitosamente!");
				resetFields();
			}
			else {
				JOptionPane.showConfirmDialog(vp, "Esta accion no se ha podido completar");
			}
			
		} else if (e.getSource() == vp.btn_close) {
			vp.dispose();
		}
	}
	
	public boolean validateFields() {
        boolean flagFields = true;

        // Validar nombre completo
        if(!Parametrizable.validarRegex(ERNames2, vp.txt_Names.getText())) {
            vp.txt_Names.setBackground(Color.red);
            flagFields = false;
            vp.txt_Names.setText("");
        } else {
            vp.txt_Names.setBackground(Color.white);
        }

        // Validar correo electrónico
        if(!Parametrizable.validarRegex(EREmail, vp.txt_Email.getText())) {
            vp.txt_Email.setBackground(Color.red);
            flagFields = false;
            vp.txt_Email.setText("");
        } else {
            vp.txt_Email.setBackground(Color.white);
        }

        // Validar RUC
        if(!Parametrizable.validarRegex(ERDNI, vp.txt_RUC.getText())) {
            vp.txt_RUC.setBackground(Color.red);
            flagFields = false;
            vp.txt_RUC.setText("");
        } else {
            vp.txt_RUC.setBackground(Color.white);
        }

        // Validar código
        if(!Parametrizable.validarRegex(ERCode, vp.txt_Code.getText())) {
            vp.txt_Code.setBackground(Color.red);
            flagFields = false;
            vp.txt_Code.setText("");
        } else {
            vp.txt_Code.setBackground(Color.white);
        }

        // Validar teléfono
        if(!Parametrizable.validarRegex(ERPhone, vp.txt_Phone.getText())) {
            vp.txt_Phone.setBackground(Color.red);
            flagFields = false;
            vp.txt_Phone.setText("");
        } else {
            vp.txt_Phone.setBackground(Color.white);
        }

        // Validar razón social
        if(!Parametrizable.validarRegex(ERSocialReason, vp.txt_SocialReason.getText())) {
            vp.txt_SocialReason.setBackground(Color.red);
            flagFields = false;
            vp.txt_SocialReason.setText("");
        } else {
            vp.txt_SocialReason.setBackground(Color.white);
        }

        return flagFields;
    }
	
	private void resetFields() {
		vp.txt_Names.setText("");
		vp.txt_Email.setText("");
		vp.txt_RUC.setText("");
		vp.txt_Code.setText("");
		vp.txt_Phone.setText("");
		vp.txt_SocialReason.setText("");
	}

}
