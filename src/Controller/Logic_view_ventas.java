package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.Client;
import Model.ClientDAO;
import Model.Product;
import Model.ProductDAO;
import Model.Sale;
import View.View_ventas;

public class Logic_view_ventas implements ActionListener, Parametrizable {
	private View_ventas vv;
	private List<Client> clients = new ArrayList<>();
	private List<Product> products = new ArrayList<>();
	
	double price, subtotal, iva, total;
	

	public Logic_view_ventas(View_ventas vv) {
		super();
		// TODO Auto-generated constructor stub
		this.vv = vv;
		this.vv.btn_confirmar.addActionListener(this);
		this.vv.cmb_clientes.addActionListener(this);
		this.vv.cmb_productos.addActionListener(this);
		
		try {
			clients = cdao.listClient();
			products = pdao.listProducts();
			
			for(Client c: clients) {
				this.vv.cmb_clientes.addItem(c.getName());
			}
			for(Product p: products) {
				this.vv.cmb_productos.addItem(p.getName());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 100000, 1);//crea un modelo en el Spinner para controlar los limites de stock
        this.vv.spn_cant.setModel(spinnerModel); //se aplica el modelo
		
		this.vv.spn_cant.addChangeListener(new ChangeListener() { 
			  @Override
			  public void stateChanged(ChangeEvent e) {
				  updateValues();
			  }
			});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 // TODO Auto-generated method stub
		if(e.getSource()==vv.btn_confirmar) {
			
			int index_p = vv.cmb_productos.getSelectedIndex();
			int index_c = vv.cmb_clientes.getSelectedIndex();
			int amount = (int) vv.spn_cant.getValue();
			
			Product product = products.get(index_p);
			Client client = clients.get(index_c);
			
			product.setStock(product.getStock()-amount);

			if(pdao.updateStockProduct(product)) {
								
				Sale new_sale = new Sale(0, client.getID(), product.getId(), amount, total);				
				sdao.insertSale(new_sale);
				
				JOptionPane.showMessageDialog(vv, "Producto vendido con exito!");
			}
			
		}
		else if(e.getSource()==vv.cmb_productos) {
			vv.spn_cant.setValue(0);
			updateValues();
		}
    } 
	
	public void updateValues() {
				
		int index_p = vv.cmb_productos.getSelectedIndex();
		Product product = products.get(index_p);
	    
		price = product.getPrice();
        subtotal = product.getPrice() * (int) vv.spn_cant.getValue();
        iva = subtotal * 0.15;
        total = subtotal + iva;
        
        int newMaxValue = product.getStock(); // en este bloque se actualiza el modelo segun el stock del producto seleccionado
        SpinnerNumberModel model = (SpinnerNumberModel) vv.spn_cant.getModel();
        model.setMaximum(newMaxValue);
        
        vv.txt_precio.setText(String.format("%.2f$", price));
        vv.txt_subtotal.setText(String.format("%.2f$", subtotal));
        vv.txt_iva.setText(String.format("%.2f$", iva));
        vv.txt_total.setText(String.format("%.3f$", total));

	}
}
