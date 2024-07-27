package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Provider;
import Model.ProviderDAO;
import View.View_Proveedor;

public class Logic_view_proveedor implements ActionListener{
	
	private View_Proveedor vp;
	private List<Provider> providers;
	private ProviderDAO pdao = new ProviderDAO();
	
	public Logic_view_proveedor(View_Proveedor vp_) {
		this.vp = vp_;
		this.vp.btn_save.addActionListener(this);
		this.vp.btn_close.addActionListener(this);
		
		try {
			providers = pdao.listProviders("Providers");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vp.btn_save) {

			if(pdao.validateFields(vp) == true){

				String fullname = vp.txt_Names.getText();
				String email = vp.txt_Email.getText();
				long dni = Long.parseLong(vp.txt_RUC.getText());
				int code = Integer.parseInt(vp.txt_Code.getText());
				long phone = Long.parseLong(vp.txt_Phone.getText());
				String socialReason = vp.txt_SocialReason.getText();
				
				try {
					pdao.writeProduct(new Provider(fullname, email, dni, code, phone, socialReason));
					JOptionPane.showMessageDialog(vp, "Proveedor agregado con exito!");
					resetFields();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
		} else if (e.getSource() == vp.btn_close) {
			vp.dispose();
		}
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
