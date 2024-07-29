package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Model.Product;
import Model.Provider;
import Model.Sale;
import View.View_EntrysInventory;
import View.view_inventario;

public class Logic_view_inventario implements ActionListener, Parametrizable, DocumentListener{
	
	private view_inventario vi;
	private Process_Low_Stock plw;
	private List<Provider> providers;
	
	public Logic_view_inventario(view_inventario vi_) {
		this.vi = vi_;
		this.vi.btnAgregar.addActionListener(this);
		this.vi.btn_noti.addActionListener(this);
		this.vi.btn_entry.addActionListener(this);
		this.vi.comboBoxProveedor.addActionListener(this);
		this.vi.txtDescripcion.getDocument().addDocumentListener(this);
		this.vi.txtNombre.getDocument().addDocumentListener(this);
		this.vi.txtPrecio.getDocument().addDocumentListener(this);
		
		setNoti();
		try {
			this.providers = prdao.listProviders();
			
			for(Provider e: providers) {
				this.vi.comboBoxProveedor.addItem(e.getFullname());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		plw = new Process_Low_Stock(); // hilo que maneja las notificaciones
		plw.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub 
		setNoti();
		if(e.getSource() == vi.btnAgregar) {
			int index_provider = vi.comboBoxProveedor.getSelectedIndex();
			Provider provider = providers.get(index_provider);
			
			String name = vi.txtNombre.getText();
			String description = vi.txtDescripcion.getText();
			double price = Double.parseDouble(vi.txtPrecio.getText());
			int stock = (int) vi.spinnerCantidad.getValue();
			
			Product product = new Product(0, provider.getId(), name, description, price, stock);
			
			if(pdao.insertProduct(product)) {
				sdao.insertSaleInventory(new Sale(0, 5, 0, stock, 0.0, getDateFormatted()));
				JOptionPane.showMessageDialog(vi, "Producto agregado correctamente!");
				resetFields();
			}
			else {
				JOptionPane.showMessageDialog(vi, "No se pudo agregar el producto");
			}
		}
		else if(e.getSource()==vi.btn_noti) {
			if(!low_stock_products.isEmpty()) {
				String str = "Bajo Stock en los siguientes productos:\n";
				for(Product s: low_stock_products) {
					str += "->" + s.getName() + "\n";
				}
				JOptionPane.showMessageDialog(vi, str);
			}
			else {
				JOptionPane.showMessageDialog(vi, "Ninguna notificacion que mostrar!");
			}
		}
		else if(e.getSource()==vi.btn_entry) {
			View_EntrysInventory vhs=new View_EntrysInventory();
	        vhs.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        vhs.setVisible(true);
		}
		setNoti();
	}
	
	private void setNoti() {
		vi.btn_noti.setText(String.valueOf(low_stock_products.size()));
	}
	
	private void resetFields() {
		vi.txtNombre.setText("");
		vi.txtDescripcion.setText("");
		vi.txtPrecio.setText("");
		vi.spinnerCantidad.setValue(0);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		setNoti();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		setNoti();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

}
