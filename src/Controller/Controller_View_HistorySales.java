package Controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Provider;
import Model.Sale;
import View.View_HistorySales;

public class Controller_View_HistorySales implements Parametrizable{

	private View_HistorySales vhs;
	public JTable tbl_history;
	
	public Controller_View_HistorySales(View_HistorySales vhs_) {
		this.vhs = vhs_;
	
		try {
			List<Sale> sales = sdao.listSalesClient(client_history.getID());
			List<Provider> providers = prdao.listProviders();
			
			DefaultListModel model = new DefaultListModel();
			
			
			for(Sale s: sales) {
				System.out.println(String.format("Cliente: %s; Product: %d; Amount: %d; Total: %.2f; Date: %s",
						client_history.getName(),
						s.getProductId(),
						s.getAmount(),
						s.getTotal(),
						s.getDate()));
				model.addElement(String.format("Cliente: %s; Product: %d; Amount: %d; Total: %.2f; Date: %s",
						client_history.getName(),
						s.getProductId(),
						s.getAmount(),
						s.getTotal(),
						s.getDate()));
			}
			
			this.vhs.list.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
