package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Controller.Logic_view_inventario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class view_inventario extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtDescripcion;
	public JTextField txtPrecio;
	public JTextField txtNombre;
	public JComboBox comboBoxProveedor;
	public JSpinner spinnerCantidad;
	public JButton btnAgregar;


	public view_inventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 276);
		setTitle("Inventario");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(135, 206, 250)); // fondo blanco
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 75, 57, 14);
		lblNombre.setForeground(Color.BLUE); // texto azul
		lblNombre.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(107, 74, 250, 17);
		txtNombre.setBackground(new Color(255, 255, 255)); // fondo azul
		txtNombre.setForeground(new Color(64, 0, 64)); // texto blanco
		txtNombre.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(25, 100, 84, 14);
		lblDescripcion.setForeground(Color.BLUE); // texto azul
		lblDescripcion.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblDescripcion);
	
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(107, 99, 250, 17);
		txtDescripcion.setBackground(new Color(255, 255, 255)); // fondo azul
		txtDescripcion.setForeground(new Color(64, 0, 64)); // texto blanco
		txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
	
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(25, 128, 46, 14);
		lblPrecio.setForeground(Color.BLUE); // texto azul
		lblPrecio.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(76, 125, 86, 17);
		txtPrecio.setBackground(new Color(255, 255, 255)); // fondo azul
		txtPrecio.setForeground(Color.BLACK); // texto blanco
		txtPrecio.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(174, 128, 68, 14);
		lblCantidad.setForeground(Color.BLUE); // texto azul
		lblCantidad.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblCantidad);
	
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(25, 157, 84, 14);
		lblProveedor.setForeground(Color.BLUE); // texto azul
		lblProveedor.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblProveedor);
	
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(153, 196, 89, 23);
		btnAgregar.setBackground(Color.WHITE); // fondo violeta
		btnAgregar.setForeground(Color.BLACK); // texto blanco
		btnAgregar.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		contentPane.add(btnAgregar);
	
		comboBoxProveedor = new JComboBox();
		comboBoxProveedor.setBounds(107, 153, 250, 18);
		comboBoxProveedor.setBackground(Color.WHITE); // fondo azul
		comboBoxProveedor.setForeground(Color.BLACK); // texto blanco
		comboBoxProveedor.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		contentPane.add(comboBoxProveedor);
	
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(252, 125, 30, 20);
		spinnerCantidad.setBackground(Color.BLUE); // fondo azul
		spinnerCantidad.setForeground(Color.WHITE); // texto blanco
		spinnerCantidad.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
		contentPane.add(spinnerCantidad);
	
		JLabel lblNewLabel = new JLabel("Inventario");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 16));
		lblNewLabel.setBounds(146, 29, 85, 17);
		lblNewLabel.setForeground(Color.BLUE); // texto azul
		contentPane.add(lblNewLabel);
		
		Logic_view_inventario lvi = new Logic_view_inventario(this);
	}
}
