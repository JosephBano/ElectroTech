package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Client;
import model.ClientDAO;
import model.Product;
import model.ProductDAO;
import view.View_ventas;

public class Logic_view_ventas implements ActionListener {
	private View_ventas vv;
	private List<Client> clients;
	private List<Product> products;
	private ClientDAO cdao = new ClientDAO();
	private ProductDAO pdao = new ProductDAO();

	public Logic_view_ventas(View_ventas vv) {
		super();
		// TODO Auto-generated constructor stub
		this.vv = vv;
		this.vv.btn_confirmar.addActionListener(this);
		this.vv.cmb_clientes.addActionListener(this);
		this.vv.cmb_productos.addActionListener(this);
		
		SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 100000, 1);//crea un modelo en el Spinner para controlar los limites de stock
        this.vv.spn_cant.setModel(spinnerModel); //se aplica el modelo
		
		try {//carga los clientes y productos en las listas
			clients = cdao.listClient("Cliente");
			products = pdao.readProducts();
			for(Client c: clients) {
				this.vv.cmb_clientes.addItem(c.getName());
			}
			for(Product p: products) {
				this.vv.cmb_productos.addItem(p.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.vv.spn_cant.addChangeListener(new ChangeListener() { // se usa en lugar del actionLisner ya que el spinner no tiene la funcion de action listener
			  @Override
			  public void stateChanged(ChangeEvent e) {
				  updateValues();
			  }
			});
		
		updateValues(); // se cargar los valores iniciales
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 // TODO Auto-generated method stub
		updateValues();
		if(e.getSource()==vv.btn_confirmar) {
			List<Product> productsNew = new ArrayList();
			String product = (String) vv.cmb_productos.getSelectedItem();
			for(Product p: products) {
				if(p.getName().equals(product)) {
					p.setStock(p.getStock() - (int) vv.spn_cant.getValue());
					productsNew.add(p);
				}
				else {
					productsNew.add(p);
				}
			}
			try {
				pdao.updateStockProduct(productsNew);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(vv, "Producto vendido con exito!");
		}
		else if(e.getSource()==vv.cmb_productos) {
			vv.spn_cant.setValue(0);
			updateValues();
		}
    } 
	
	public void updateValues() {
	    String product = (String) vv.cmb_productos.getSelectedItem();
	    
	    for (Product p : products) {
	        if (p.getName().equals(product)) {
	            double price = p.getPrice();
	            double subtotal = p.getPrice() * (int) vv.spn_cant.getValue();
	            double iva = subtotal * 0.15;
	            double total = subtotal + iva;
	            
	            int newMaxValue = p.getStock(); // en este bloque se actualiza el modelo segun el stock del producto seleccionado
                SpinnerNumberModel model = (SpinnerNumberModel) vv.spn_cant.getModel();
                model.setMaximum(newMaxValue);
	            
	            vv.txt_precio.setText(String.format("%.2f$", price));
	            vv.txt_subtotal.setText(String.format("%.2f$", subtotal));
	            vv.txt_iva.setText(String.format("%.2f$", iva));
	            vv.txt_total.setText(String.format("%.3f$", total));
	        }
	    }
	}
}
