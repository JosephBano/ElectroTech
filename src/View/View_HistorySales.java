package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller_View_HistorySales;

import javax.swing.JList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;

public class View_HistorySales extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JList list;

	public View_HistorySales() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 41, 464, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		list = new JList();
		list.setBounds(10, 11, 444, 170);
		panel.add(list);
		
		JLabel lblNewLabel = new JLabel("Historial de ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 16, 464, 14);
		contentPane.add(lblNewLabel);
		
		new Controller_View_HistorySales(this);
		
	}
}
