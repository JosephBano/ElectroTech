package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;

import Model.Product;
import Model.Sale;
import View.View_EntrysInventory;

public class Controller_EntrysInventory implements Parametrizable, ActionListener{

	private View_EntrysInventory vei;
	private List<Product> products;
	private List<Sale> sales;
	
	public Controller_EntrysInventory(View_EntrysInventory vei_) {
		this.vei = vei_;
		vei.btn_mov.addActionListener(this);
		vei.btnInventarioActual.addActionListener(this);
		
		try {
			products = pdao.listProducts();
			sales = sdao.listSales();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vei.btn_mov.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vei.btn_mov) {
			vei.btn_mov.setEnabled(false);
			vei.btnInventarioActual.setEnabled(true);
			
			DefaultListModel<String> listModel = new DefaultListModel<>();
			vei.list.setModel(listModel);
			
			for(Sale s: sales) {
				listModel.addElement(String.format("Cliente: %d; Product: %d; Amount: %d; Total: %.2f; Date: %s",
						s.getClientId(),
						s.getProductId(),
						s.getAmount(),
						s.getTotal(),
						s.getDate()));
			}
			
			vei.list.setModel(listModel);
			
		}
		else if(e.getSource()==vei.btnInventarioActual) {
			vei.btn_mov.setEnabled(true);
			vei.btnInventarioActual.setEnabled(false);
			
			DefaultListModel<String> listModel = new DefaultListModel<>();
			vei.list.setModel(listModel);
			
			for(Product p: products) {
				listModel.addElement(String.format("Nombre: %s; Price: %.2f; Stock: %d; Description: %s",
						p.getName(),
						p.getPrice(),
						p.getStock(),
						p.getDescription()));
			}
			
			vei.list.setModel(listModel);
		}
	}
}
