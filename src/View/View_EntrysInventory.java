package View;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_EntrysInventory;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;

public class View_EntrysInventory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_mov;
	public JButton btnInventarioActual;
	public JTable table;
	public JButton btn_sales;
	public JTextField txt_dni;
	public JTextField txt_product;
	public JComboBox cmb_date;
	public JComboBox cmb_dateDisponible;
	public JButton btn_apliDate;
	public JButton btn_product;
	public JButton btn_dni;
	public JCheckBox chbx_low_stock;
	private JScrollPane scrollPane;

	public View_EntrysInventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Inventario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		btn_mov = new JButton("Movimientos");
		btn_mov.setBounds(20, 36, 106, 23);
		contentPane.add(btn_mov);
		
		btnInventarioActual = new JButton("Inventario Actual");
		btnInventarioActual.setBounds(157, 36, 127, 23);
		contentPane.add(btnInventarioActual);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 232, 414, 214);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btn_sales = new JButton("Ventas");
		btn_sales.setBounds(318, 36, 106, 23);
		contentPane.add(btn_sales);
		
		cmb_date = new JComboBox();
		cmb_date.setBounds(115, 90, 127, 22);
		contentPane.add(cmb_date);
		
		JLabel lblNewLabel_1 = new JLabel("Fitrar por Fecha:");
		lblNewLabel_1.setBounds(20, 94, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		cmb_dateDisponible = new JComboBox();
		cmb_dateDisponible.setBounds(252, 90, 110, 22);
		contentPane.add(cmb_dateDisponible);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setBounds(20, 129, 85, 14);
		contentPane.add(lblNewLabel_2);
		
		txt_dni = new JTextField();
		txt_dni.setBounds(115, 126, 185, 20);
		contentPane.add(txt_dni);
		txt_dni.setColumns(10);
		
		btn_dni = new JButton("Aplicar");
		btn_dni.setBounds(318, 125, 106, 23);
		contentPane.add(btn_dni);
		
		btn_apliDate = new JButton("->");
		btn_apliDate.setBounds(372, 90, 52, 23);
		contentPane.add(btn_apliDate);
		
		JLabel lblNewLabel_3 = new JLabel("Product:");
		lblNewLabel_3.setBounds(20, 165, 85, 14);
		contentPane.add(lblNewLabel_3);
		
		txt_product = new JTextField();
		txt_product.setBounds(115, 162, 185, 20);
		contentPane.add(txt_product);
		txt_product.setColumns(10);
		
		btn_product = new JButton("Aplicar");
		btn_product.setBounds(318, 159, 106, 23);
		contentPane.add(btn_product);
		
		chbx_low_stock = new JCheckBox("Mostrar Bajo Stock");
		chbx_low_stock.setBounds(20, 202, 172, 23);
		contentPane.add(chbx_low_stock);
		
		new Controller_EntrysInventory(this);
	}
}
