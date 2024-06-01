package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic_view_ventas;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;

public class View_ventas extends JFrame {

	private static final long serialVersionUID = 1L;
	public JComboBox cmb_clientes;
	public JComboBox cmb_productos;
	public JTextField txt_cantidad;
	public JTextField txt_precio;
	public JTextField txt_subtotal;
	public JTextField txt_iva;
	public JTextField txt_total;
	public JButton btn_confirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_ventas frame = new View_ventas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View_ventas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 426, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de ventas");
		lblNewLabel.setBounds(173, 11, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setBounds(21, 44, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		cmb_clientes = new JComboBox();
		cmb_clientes.setBounds(77, 40, 321, 18);
		contentPane.add(cmb_clientes);
		
		JLabel lblNewLabel_3 = new JLabel("Productos:");
		lblNewLabel_3.setBounds(21, 79, 58, 14);
		contentPane.add(lblNewLabel_3);
		
		cmb_productos = new JComboBox();
		cmb_productos.setBounds(77, 77, 192, 18);
		contentPane.add(cmb_productos);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad a comprar:");
		lblNewLabel_4.setBounds(21, 120, 113, 14);
		contentPane.add(lblNewLabel_4);
		
		txt_cantidad = new JTextField();
		txt_cantidad.setBounds(144, 118, 65, 17);
		contentPane.add(txt_cantidad);
		txt_cantidad.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setBounds(281, 79, 40, 14);
		contentPane.add(lblNewLabel_2);
		
		txt_precio = new JTextField();
		txt_precio.setEditable(false);
		txt_precio.setBounds(319, 76, 78, 17);
		contentPane.add(txt_precio);
		txt_precio.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("I.V.A 15%:");
		lblNewLabel_5.setBounds(239, 166, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Subtotal:");
		lblNewLabel_6.setBounds(239, 145, 52, 14);
		contentPane.add(lblNewLabel_6);
		
		txt_subtotal = new JTextField();
		txt_subtotal.setEditable(false);
		txt_subtotal.setBounds(301, 138, 78, 17);
		contentPane.add(txt_subtotal);
		txt_subtotal.setColumns(10);
		
		txt_iva = new JTextField();
		txt_iva.setEditable(false);
		txt_iva.setColumns(10);
		txt_iva.setBounds(301, 163, 78, 17);
		contentPane.add(txt_iva);
		
		JLabel lblNewLabel_5_1 = new JLabel("Total:");
		lblNewLabel_5_1.setBounds(239, 191, 65, 14);
		contentPane.add(lblNewLabel_5_1);
		
		txt_total = new JTextField();
		txt_total.setEditable(false);
		txt_total.setColumns(10);
		txt_total.setBounds(301, 188, 78, 17);
		contentPane.add(txt_total);
		
		btn_confirmar = new JButton("Confirmar compra");
		btn_confirmar.setBounds(281, 227, 117, 23);
		contentPane.add(btn_confirmar);
		
		Logic_view_ventas lvv=new Logic_view_ventas(this);
	}
}
