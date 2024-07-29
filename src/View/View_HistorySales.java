package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_View_HistorySales;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class View_HistorySales extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable tb_Client;
	private JScrollPane scrollPane;

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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 464, 192);
		panel.add(scrollPane);
		
		tb_Client = new JTable();
		scrollPane.setViewportView(tb_Client);
		tb_Client.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblNewLabel = new JLabel("Historial de ventas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 16, 464, 14);
		contentPane.add(lblNewLabel);
		
		new Controller_View_HistorySales(this);
		
	}
}
