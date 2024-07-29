package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Sale;
import View.View_HistorySales;

public class Controller_View_HistorySales implements Parametrizable{

	private View_HistorySales vhs;
	
	public Controller_View_HistorySales(View_HistorySales vhs_) {
		this.vhs = vhs_;
	
		try {
			List<Sale> sales = sdao.listSalesClient(client_history.getID());

	        ResultSet rs=conn.getQuery("SELECT * FROM electrotech.sale WHERE id_client = "+client_history.getID()+";");

	        DefaultTableModel model = new DefaultTableModel(new String[]{"CLIENTE", "PRODUCTO", "CANTIDAD", "MONTO", "FECHA"}, 0);
	        model.addRow(new Object[]{"CLIENTE", "PRODUCTO", "CANTIDAD", "MONTO", "FECHA"});
	        for(Sale s: sales) {
	            String column1 = client_history.getName();
	            int column2 = s.getProductId();
	            int column3 = s.getAmount();
	            double column4 = s.getTotal();
	            String column5 = s.getDate();
	            model.addRow(new Object[]{column1, column2, column3, column4, column5});
	        }
	        vhs_.tb_Client.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
