package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Logic_view_ventas;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class View_ventas extends JFrame {

	private static final long serialVersionUID = 1L;
	public JComboBox cmb_clientes;
	public JComboBox cmb_productos;
	public JTextField txt_precio;
	public JTextField txt_subtotal;
	public JTextField txt_iva;
	public JTextField txt_total;
	public JButton btn_confirmar;
	public JSpinner spn_cant;


	public View_ventas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 315);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(261, 263, 118, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Registro de ventas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(151, 6, 118, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(21, 44, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cmb_clientes = new JComboBox();
		cmb_clientes.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		cmb_clientes.setBounds(77, 40, 321, 18);
		contentPane.add(cmb_clientes);
		
		JLabel lblNewLabel_3 = new JLabel("Productos:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(21, 81, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		cmb_productos = new JComboBox();
		cmb_productos.setBounds(87, 79, 192, 18);
		contentPane.add(cmb_productos);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad a comprar:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(21, 120, 131, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(239, 120, 52, 14);
		contentPane.add(lblNewLabel_2);
		
		txt_precio = new JTextField();
		txt_precio.setEditable(false);
		txt_precio.setBounds(301, 118, 78, 17);
		contentPane.add(txt_precio);
		txt_precio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("I.V.A 15%:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(220, 190, 71, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Subtotal:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(233, 165, 58, 14);
		contentPane.add(lblNewLabel_6);
		
		txt_subtotal = new JTextField();
		txt_subtotal.setEditable(false);
		txt_subtotal.setBounds(301, 162, 78, 17);
		contentPane.add(txt_subtotal);
		txt_subtotal.setColumns(10);
		
		txt_iva = new JTextField();
		txt_iva.setEditable(false);
		txt_iva.setColumns(10);
		txt_iva.setBounds(301, 188, 78, 17);
		contentPane.add(txt_iva);
		
		JLabel lblNewLabel_5_1 = new JLabel("Total:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setBounds(239, 216, 65, 14);
		contentPane.add(lblNewLabel_5_1);
		
		txt_total = new JTextField();
		txt_total.setEditable(false);
		txt_total.setColumns(10);
		txt_total.setBounds(301, 214, 78, 17);
		contentPane.add(txt_total);
		
		btn_confirmar = new JButton("Confirmar compra");
		btn_confirmar.setForeground(Color.WHITE);
		btn_confirmar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btn_confirmar.setBackground(Color.MAGENTA);
		btn_confirmar.setContentAreaFilled(false);
		//btn_confirmar.setOpaque(false);
		btn_confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_confirmar.setBounds(239, 242, 159, 23);
		contentPane.add(btn_confirmar);
		
		spn_cant = new JSpinner();
		spn_cant.setBounds(162, 118, 46, 20);
		contentPane.add(spn_cant);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(View_ventas.class.getResource("/view_multimedia/Fondo morado camo.jpeg")));
		lblNewLabel_7.setBounds(0, 0, 413, 276);
		contentPane.add(lblNewLabel_7);
		
		Logic_view_ventas lvv=new Logic_view_ventas(this);
	}
}
