package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import model.Employees;
import model.Product;
import model.ProductDAO;
import model.ProviderDAO;
import view.view_inventario;

public class Logic_view_inventario implements ActionListener{
	
	private view_inventario vi;
	private ProviderDAO udao = new ProviderDAO();
	private ProductDAO pdao = new ProductDAO();
	private List<Employees> providers;
	
	public Logic_view_inventario(view_inventario vi_) {
		this.vi = vi_;
		this.vi.btnAgregar.addActionListener(this);
		this.vi.comboBoxProveedor.addActionListener(this);
		try {
			this.providers = udao.listProviders("Proveedor");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Employees e: providers) {
			System.out.println(e.getName()+1);
			this.vi.comboBoxProveedor.addItem(e.getName());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub 
		if(e.getSource() == vi.btnAgregar) {
			try {
				String name = vi.txtNombre.getText();
				String description = vi.txtDescripcion.getText();
				double precio = Double.parseDouble(vi.txtPrecio.getText());
				int stock = (Integer) vi.spinnerCantidad.getValue();
				long dni = udao.getDniByName((String) vi.comboBoxProveedor.getSelectedItem());
				
				pdao.writeProduct(new Product(name, description, precio, stock, dni));
				
				JOptionPane.showMessageDialog(vi, "Producto agregado correctamente!");
				resetFields();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
