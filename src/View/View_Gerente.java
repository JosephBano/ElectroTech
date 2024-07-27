package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Logic_view_gerente;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;

public class View_Gerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_Inventario;
	public JButton btn_cliente;
	public JButton btn_proveedor;
	public JButton btn_ventas;
	public JButton btn_employees;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Gerente frame = new View_Gerente();
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
	public View_Gerente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_Gerente.class.getResource("/view_multimedia/UPS ICONO.png")));
		setTitle("Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_7 = new JLabel("WINDOW ADMIN");
		lblNewLabel_7.setFont(new Font("Roboto", Font.BOLD | Font.ITALIC, 41));
		lblNewLabel_7.setBounds(231, 27, 372, 65);
		contentPane.add(lblNewLabel_7);
		
		btn_Inventario = new JButton("");
		btn_Inventario.setIcon(new ImageIcon(View_Gerente.class.getResource("/view_multimedia/Inventario.png")));
		btn_Inventario.setToolTipText("Inventario");
		btn_Inventario.setBounds(10, 131, 120, 120);
		contentPane.add(btn_Inventario);
		
		btn_employees = new JButton("");
		btn_employees.setIcon(new ImageIcon(View_Gerente.class.getResource("/view_multimedia/Gestion.png")));
		btn_employees.setToolTipText("Empleados");
		btn_employees.setBounds(638, 131, 120, 120);
		contentPane.add(btn_employees);
		
		btn_proveedor = new JButton("");
		btn_proveedor.setIcon(new ImageIcon(View_Gerente.class.getResource("/view_multimedia/proveedor.png")));
		btn_proveedor.setToolTipText("Proveedores");
		btn_proveedor.setBounds(324, 131, 120, 120);
		contentPane.add(btn_proveedor);
		
		btn_ventas = new JButton("");
		btn_ventas.setIcon(new ImageIcon(View_Gerente.class.getResource("/view_multimedia/ventas.png")));
		btn_ventas.setToolTipText("Ventas");
		btn_ventas.setBounds(483, 131, 120, 120);
		contentPane.add(btn_ventas);
		
		btn_cliente = new JButton("");
		btn_cliente.setToolTipText("Clientes");
		btn_cliente.setIcon(new ImageIcon(View_Gerente.class.getResource("/view_multimedia/Clientes.png")));
		btn_cliente.setBounds(165, 131, 120, 120);
		contentPane.add(btn_cliente);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(View_Gerente.class.getResource("/view_multimedia/UPS.png")));
		lblNewLabel.setBounds(0, 291, 768, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(View_Gerente.class.getResource("/view_multimedia/topbanner.png")));
		lblNewLabel_1.setBounds(0, 0, 768, 120);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("INVENTARIO");
		lblNewLabel_2.setFont(new Font("Roboto", Font.BOLD, 12));
		lblNewLabel_2.setBounds(33, 262, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("CLIENTES");
		lblNewLabel_3.setFont(new Font("Roboto", Font.BOLD, 12));
		lblNewLabel_3.setBounds(193, 262, 70, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("PROVEEDORES");
		lblNewLabel_4.setFont(new Font("Roboto", Font.BOLD, 12));
		lblNewLabel_4.setBounds(346, 262, 84, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("VENTAS");
		lblNewLabel_5.setFont(new Font("Roboto", Font.BOLD, 12));
		lblNewLabel_5.setBounds(519, 262, 70, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("EMPLEADOS");
		lblNewLabel_6.setFont(new Font("Roboto", Font.BOLD, 12));
		lblNewLabel_6.setBounds(664, 262, 77, 14);
		contentPane.add(lblNewLabel_6);
		Logic_view_gerente lvg=new Logic_view_gerente(this);
	}
}
