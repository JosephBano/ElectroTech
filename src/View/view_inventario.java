package View;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Logic_view_inventario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class view_inventario extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtDescripcion;
	public JTextField txtPrecio;
	public JTextField txtNombre;
	public JComboBox comboBoxProveedor;
	public JSpinner spinnerCantidad;
	public JButton btnAgregar;
	public JButton btn_entry;
	public JButton btn_noti;


	public view_inventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 276);
		setTitle("Inventario");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(135, 206, 250)); // fondo blanco
					
					btn_noti = new JButton("0");
					btn_noti.setOpaque(false);
					btn_noti.setForeground(Color.WHITE);
					btn_noti.setFont(new Font("Times New Roman", Font.BOLD, 15));
					btn_noti.setContentAreaFilled(false);
					btn_noti.setBackground((Color) null);
					btn_noti.setBounds(294, 11, 68, 23);
					contentPane.add(btn_noti);
					
					btn_entry = new JButton("Registro");
					btn_entry.setHorizontalAlignment(SwingConstants.LEFT);
					btn_entry.setOpaque(false);
					btn_entry.setForeground(Color.WHITE);
					btn_entry.setFont(new Font("Times New Roman", Font.BOLD, 15));
					btn_entry.setContentAreaFilled(false);
					btn_entry.setBackground((Color) null);
					btn_entry.setBounds(0, 10, 109, 23);
					contentPane.add(btn_entry);
					
					JSeparator separator_2 = new JSeparator();
					separator_2.setForeground(Color.WHITE);
					separator_2.setBounds(107, 149, 86, 1);
					contentPane.add(separator_2);
					
					JSeparator separator_1 = new JSeparator();
					separator_1.setForeground(Color.WHITE);
					separator_1.setBounds(107, 104, 255, 1);
					contentPane.add(separator_1);
					
					JSeparator separator = new JSeparator();
					separator.setForeground(new Color(255, 255, 255));
					separator.setBounds(107, 72, 255, 1);
					contentPane.add(separator);
			
					txtNombre = new JTextField();
					txtNombre.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					txtNombre.setBorder(null);
					txtNombre.setOpaque(false);
					txtNombre.setBounds(107, 51, 250, 17);
					txtNombre.setBackground(new Color(255, 255, 255)); // fondo azul
					txtNombre.setForeground(new Color(255, 255, 255)); // texto blanco
					contentPane.add(txtNombre);
					txtNombre.setColumns(10);
		
			JLabel lbl_inventario = new JLabel("Inventario");
			lbl_inventario.setFont(new Font("Cambria", Font.BOLD, 16));
			lbl_inventario.setBounds(146, 11, 85, 17);
			lbl_inventario.setForeground(new Color(255, 255, 255)); // texto azul
			contentPane.add(lbl_inventario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 52, 57, 14);
		lblNombre.setForeground(new Color(255, 255, 255)); // texto azul
		lblNombre.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblNombre);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setBounds(25, 84, 84, 14);
		lblDescripcion.setForeground(new Color(255, 255, 255)); // texto azul
		lblDescripcion.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblDescripcion);
	
		txtDescripcion = new JTextField();
		txtDescripcion.setBorder(null);
		txtDescripcion.setOpaque(false);
		txtDescripcion.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDescripcion.setBounds(107, 82, 250, 17);
		txtDescripcion.setBackground(new Color(255, 255, 255)); // fondo azul
		txtDescripcion.setForeground(new Color(255, 255, 255)); // texto blanco
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
	
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(22, 130, 46, 14);
		lblPrecio.setForeground(new Color(255, 255, 255)); // texto azul
		lblPrecio.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPrecio.setBounds(107, 128, 86, 17);
		txtPrecio.setBorder(null);
		txtPrecio.setOpaque(false);
		txtPrecio.setForeground(new Color(255, 255, 255)); // texto blanco
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(233, 136, 68, 14);
		lblCantidad.setForeground(new Color(255, 255, 255)); // texto azul
		lblCantidad.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblCantidad);
	
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(25, 168, 84, 14);
		lblProveedor.setForeground(new Color(255, 255, 255)); // texto azul
		lblProveedor.setFont(new Font("Cambria", Font.PLAIN, 14)); // fuente Cambria
		contentPane.add(lblProveedor);
	
		btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAgregar.setBounds(146, 203, 102, 23);
		btnAgregar.setBackground(null); // fondo violeta
		btnAgregar.setOpaque(false);
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setForeground(new Color(255, 255, 255)); // texto blanco
		contentPane.add(btnAgregar);
	
		comboBoxProveedor = new JComboBox();
		comboBoxProveedor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBoxProveedor.setBounds(107, 167, 250, 18);
		comboBoxProveedor.setForeground(Color.BLACK); // texto blanco
		comboBoxProveedor.setBorder(new LineBorder(new Color(0, 0, 0)));
		comboBoxProveedor.setOpaque(false);
		contentPane.add(comboBoxProveedor);
	
		spinnerCantidad = new JSpinner();
		
		spinnerCantidad.setBounds(311, 130, 30, 20);
		spinnerCantidad.setBackground(Color.BLUE); // fondo azul
		spinnerCantidad.setForeground(Color.WHITE); // texto blanco
		spinnerCantidad.setBorder(null);
		spinnerCantidad.setOpaque(false);
		contentPane.add(spinnerCantidad);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(view_inventario.class.getResource("/view_multimedia/Fondo azul camo.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 372, 237);
		contentPane.add(lblNewLabel_1);
		
		Logic_view_inventario lvi = new Logic_view_inventario(this);
	}
}
