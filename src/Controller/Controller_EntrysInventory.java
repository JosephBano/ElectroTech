package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Client;

import Model.Product;
import Model.Sale;
import View.View_EntrysInventory;

public class Controller_EntrysInventory implements Parametrizable, ActionListener{

	private View_EntrysInventory vei;
	private List<Product> products;
	private List<Sale> sales;
	private List<String> dates;
	
	private String [] columMov = new String[]{"CLIENTE", "PRODUCTO", "CANTIDAD", "ACCION", "FECHA"};
	private String [] columInv = new String[]{"PROVEEDOR", "NOMBRE", "DESCRIPCION", "PRECIO", "STOCK"};
	private String [] columSales = new String[]{"CLIENTE", "PRODUCTO", "CANTIDAD", "MONTO", "FECHA"};

	private boolean flag = false;
	
	public Controller_EntrysInventory(View_EntrysInventory vei_) {
		this.vei = vei_;
		vei.btn_mov.addActionListener(this);
		vei.btnInventarioActual.addActionListener(this);
		vei.btn_sales.addActionListener(this);
		vei.btn_dni.addActionListener(this);
		vei.btn_apliDate.addActionListener(this);
		vei.btn_product.addActionListener(this);
		vei.cmb_date.addActionListener(this);
		vei.cmb_dateDisponible.addActionListener(this);
		
		initialData();
		for(String s: contCmb) {
			vei.cmb_date.addItem(s);
		}
		setAvailableDates();
		
		vei.chbx_low_stock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	initialData();
    			
    			List<Product> produ_aux = new ArrayList<>();
    			
    			for(Product p: products) {
    				if(p.getStock()>5) {
    					produ_aux.add(p);
    				}
    			}
    			if(vei.chbx_low_stock.isSelected()) {
    				vei.table.setModel(setTableModelProduct(columInv, produ_aux));
    			}
    			else {
    				vei.table.setModel(setTableModelProduct(columInv, products));
    			}
            }
        });

		btn_mov();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vei.btn_mov) {
			btn_mov();
		}
		else if(e.getSource()==vei.btnInventarioActual) {
			initialData();
			//tipoLista
			vei.btn_mov.setEnabled(true);
			vei.btn_sales.setEnabled(true);
			vei.btnInventarioActual.setEnabled(false);
			//Filtro fechas
			vei.cmb_date.setEnabled(false);
			vei.cmb_dateDisponible.setEnabled(false);
			vei.btn_apliDate.setEnabled(false);
			//low Inventori
			vei.chbx_low_stock.setEnabled(true);
			//client
			vei.btn_dni.setEnabled(false);
			vei.txt_dni.setEnabled(false);
			
			
	        vei.table.setModel(setTableModelProduct(columInv, products));
		}
		else if(e.getSource()==vei.btn_sales) {
			initialData();
			vei.btn_mov.setEnabled(true);
			vei.btn_sales.setEnabled(false);
			vei.btnInventarioActual.setEnabled(true);
			//Filtro fechas
			vei.cmb_date.setEnabled(true);
			vei.cmb_dateDisponible.setEnabled(true);
			vei.btn_apliDate.setEnabled(true);
			//low Inventori
			vei.chbx_low_stock.setEnabled(false);
			//client
			vei.btn_dni.setEnabled(true);
			vei.txt_dni.setEnabled(true);
			flag=true;
			
			
			vei.table.setModel(setTableModelSales(columSales, sales));
		}
		else if(e.getSource()==vei.cmb_date) {
			setAvailableDates();
		}
		else if(e.getSource()==vei.btn_apliDate) {
			initialData();
			String date_filter = (String) vei.cmb_dateDisponible.getSelectedItem();
			
			List<Sale> aux = new ArrayList<>();
			
			for(Sale s: sales) {
				if(s.getDate().contains(date_filter)) {
					aux.add(s);
				}
			}
			
			vei.table.setModel(setTableModelSales(columSales, aux));
		}
		else if(e.getSource()==vei.btn_dni) {
			initialData();
			try {
				int id = cdao.IDClientBydni(vei.txt_dni.getText());
				List<Sale> sales_aux = sdao.listSalesClient(id);
				if(!sales_aux.isEmpty()) {
					if(flag) {
						vei.table.setModel(setTableModelSales(columSales, sales_aux));
					}
					else {
						vei.table.setModel(setTableModelMovimiento(columMov, sales_aux));
					}
				}
				else {
					JOptionPane.showMessageDialog(vei, "Client not found");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==vei.btn_product) {
			try {
				List<Sale> sales_aux = sdao.listSalesProduct(vei.txt_product.getText());
				if(!sales_aux.isEmpty()) {
					if(flag) {
						vei.table.setModel(setTableModelSales(columSales, sales_aux));
					}
					else {
						vei.table.setModel(setTableModelMovimiento(columMov, sales_aux));
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	
	
	private void btn_mov() {
	
		initialData();
		vei.btn_mov.setEnabled(false);
		vei.btn_sales.setEnabled(true);
		vei.btnInventarioActual.setEnabled(true);
		//Filtro fechas
		vei.cmb_date.setEnabled(true);
		vei.cmb_dateDisponible.setEnabled(true);
		vei.btn_apliDate.setEnabled(true);
		//low Inventori
		vei.chbx_low_stock.setEnabled(false);
		//client
		vei.btn_dni.setEnabled(true);
		vei.txt_dni.setEnabled(true);
		flag = false;
		
        vei.table.setModel(setTableModelMovimiento(columMov, sales));
	}
	
	private DefaultTableModel setTableModelSales(String [] rows, List<Sale> sale_aux) {
		
		DefaultTableModel table_model = new DefaultTableModel(rows, 0);
		
		for(Sale s: sale_aux) {
			try {
				if(s.getClientId()!=5) {
					String column1 = cdao.NameClientByID(s.getClientId());
					int column2 = s.getProductId();
		            int column3 = s.getAmount();
		            double column4 = s.getTotal();
		            String column5 = s.getDate();
		            table_model.addRow(new Object[]{column1, column2, column3, column4, column5});
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return table_model;
	}
	
	
	private DefaultTableModel setTableModelProduct(String [] rows, List<Product> products_aux) {
		
		DefaultTableModel table_model = new DefaultTableModel(rows, 0);
		
		for(Product p: products_aux) {
			String column1 = String.valueOf(p.getProvider());
			String column2 = p.getName();
			String column3 = p.getDescription();
			double column4 = p.getPrice();
			int column5 = p.getStock();
			table_model.addRow(new Object[]{column1, column2, column3, column4, column5});
		}
		
		return table_model;
	}

	
	
	private DefaultTableModel setTableModelMovimiento(String [] rows, List<Sale> sale_aux) {
		
		DefaultTableModel table_model = new DefaultTableModel(rows, 0);
		
		for(Sale s: sale_aux) {
			try {
				String column1 = cdao.NameClientByID(s.getClientId());
				int column2 = s.getProductId();
	            int column3 = s.getAmount();
	            String column4 = "";
	            if(s.getTotal()==0) {	
	            	 column4 = "Ingreso";
	            }
	            else {
	            	column4 = "Egreso";
	            }
	            String column5 = s.getDate();
	            table_model.addRow(new Object[]{column1, column2, column3, column4, column5});
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return table_model;
	}		
	
	
	
	private void setAvailableDates() {
		int swt = vei.cmb_date.getSelectedIndex();
		List<String> aux = new ArrayList<>();
		vei.cmb_dateDisponible.removeAllItems();
		switch(swt) {
		case 0:
			for(String s: dates) {
				aux.add(s.split("-")[2]);
			}
			
			for(String s:removeDuplicates(aux)) {
				vei.cmb_dateDisponible.addItem(s);
			}
			break;
		case 1:
			for(String s: dates) {
				aux.add(s.split("-")[1] +"-"+ s.split("-")[2]);
			}
			for(String s:removeDuplicates(aux)) {
				vei.cmb_dateDisponible.addItem(s);
			}
			break;
		case 2:
			for(String s:removeDuplicates(dates)) {
				vei.cmb_dateDisponible.addItem(s);
			}
			break;
		}
	}
	
	
	private List<String> removeDuplicates(List<String> list) {
        // Convertir la lista a un conjunto para eliminar duplicados
        Set<String> set = new HashSet<>(list);
        // Convertir el conjunto de nuevo a una lista
        return new ArrayList<>(set);
    }
	
	private void initialData() {
		try {
			products = pdao.listProducts();
			sales = sdao.listSales();
			dates = sdao.listSalesDates();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
