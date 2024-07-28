package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Employees;
import Model.Product;
import Model.ProductDAO;
import Model.Provider;
import Model.ProviderDAO;
import View.view_inventario;

public class Logic_view_inventario implements ActionListener, Parametrizable{
	
	private view_inventario vi;
	
	private List<Provider> providers;
	
	public Logic_view_inventario(view_inventario vi_) {
		this.vi = vi_;
		this.vi.btnAgregar.addActionListener(this);
		this.vi.comboBoxProveedor.addActionListener(this);
		
		try {
			this.providers = prdao.listProviders();
			
			for(Provider e: providers) {
				this.vi.comboBoxProveedor.addItem(e.getFullname());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub 
		if(e.getSource() == vi.btnAgregar) {
			int index_provider = vi.comboBoxProveedor.getSelectedIndex();
			Provider provider = providers.get(index_provider);
			
			String name = vi.txtNombre.getText();
			String description = vi.txtDescripcion.getText();
			double price = Double.parseDouble(vi.txtPrecio.getText());
			int stock = (int) vi.spinnerCantidad.getValue();
			
			Product product = new Product(0, provider.getId(), name, description, price, stock);
			
			if(pdao.insertProduct(product)) {
				JOptionPane.showMessageDialog(vi, "Producto agregado correctamente!");
				resetFields();
			}
			else {
				JOptionPane.showMessageDialog(vi, "No se pudo agregar el producto");
			}
		}
	}
	
	private void resetFields() {
		vi.txtNombre.setText("");
		vi.txtDescripcion.setText("");
		vi.txtPrecio.setText("");
		vi.spinnerCantidad.setValue(0);
	}

}
