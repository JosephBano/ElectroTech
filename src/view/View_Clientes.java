package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Logic_view_client;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class View_Clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_Name;
	public JTextField txt_Address;
	public JTextField txt_ContactDetails;
	public JButton btn_Add;
	public JButton btn_Update;

	
	public View_Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_Clientes.class.getResource("/view_multimedia/Clientes.png")));
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JLabel lbl_Datos = new JLabel("DATOS");
	    lbl_Datos.setBounds(283, 11, 87, 14);
	    lbl_Datos.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    lbl_Datos.setForeground(new Color(0, 0, 0));
	    contentPane.add(lbl_Datos);

	    txt_Name = new JTextField();
	    txt_Name.setBackground(new Color(255, 255, 255));
	    txt_Name.setBounds(283, 68, 192, 25);
	    txt_Name.setForeground(new Color(192, 192, 192));
	    txt_Name.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_Name.setBorder(null);
	    contentPane.add(txt_Name);

	    JLabel lbl_Address = new JLabel("Dirección");
	    lbl_Address.setBounds(283, 114, 73, 14);
	    lbl_Address.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_Address.setForeground(new Color(0, 0, 0));
	    contentPane.add(lbl_Address);

	    txt_Address = new JTextField();
	    txt_Address.setForeground(new Color(192, 192, 192));
	    txt_Address.setBackground(new Color(255, 255, 255));
	    txt_Address.setBounds(283, 139, 192, 25);
	    txt_Address.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_Address.setBorder(null);
	    contentPane.add(txt_Address);

	    JLabel lbl_ContactDetails = new JLabel("Detalles de Contacto");
	    lbl_ContactDetails.setBounds(283, 186, 145, 14);
	    lbl_ContactDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_ContactDetails.setForeground(new Color(0, 0, 0));
	    contentPane.add(lbl_ContactDetails);

	    txt_ContactDetails = new JTextField();
	    txt_ContactDetails.setForeground(new Color(192, 192, 192));
	    txt_ContactDetails.setBackground(new Color(255, 255, 255));
	    txt_ContactDetails.setBounds(283, 211, 192, 25);
	    txt_ContactDetails.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_ContactDetails.setBorder(null);
	    contentPane.add(txt_ContactDetails);

	    btn_Add = new JButton("Agregar Cliente");
	    btn_Add.setToolTipText("Add");
	    btn_Add.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    btn_Add.setForeground(new Color(0, 0, 0));
	    btn_Add.setBounds(286, 294, 120, 25);
	    btn_Add.setOpaque(true);
	    btn_Add.setBorderPainted(false);
	    btn_Add.setBackground(new Color(149, 219, 179));
	    btn_Add.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Aquí va el código para agregar un nuevo cliente a la base de datos
	        }
	    });
	    contentPane.add(btn_Add);

	    btn_Update = new JButton("Actualizar Cliente");
	    btn_Update.setToolTipText("Update");
	    btn_Update.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    btn_Update.setForeground(new Color(0, 0, 0));
	    btn_Update.setOpaque(true);
	    btn_Update.setBorderPainted(false);
	    btn_Update.setBackground(new Color(255, 172, 132));
	    btn_Update.setBounds(410, 294, 131, 25);
	    btn_Update.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Aquí va el código para actualizar la información de un cliente existente en la base de datos
	        }
	    });
	    contentPane.add(btn_Update);
	    
	    JSeparator separator = new JSeparator();
	    separator.setForeground(new Color(0, 0, 0));
	    separator.setBounds(283, 95, 192, 8);
	    contentPane.add(separator);
	    
	    JPanel panel = new JPanel();
	    panel.setBounds(0, 0, 237, 441);
	    contentPane.add(panel);
	    panel.setLayout(null);
	    
	    JLabel lbl_icono = new JLabel("New label");
	    lbl_icono.setBounds(63, 153, 129, 135);
	    panel.add(lbl_icono);
	    lbl_icono.setIcon(new ImageIcon(View_Clientes.class.getResource("/view_multimedia/Clientes.png")));
	    
	    JLabel lbl_fondo = new JLabel("New label");
	    lbl_fondo.setBounds(0, 0, 237, 441);
	    panel.add(lbl_fondo);
	    lbl_fondo.setIcon(new ImageIcon(View_Clientes.class.getResource("/view_multimedia/fondoMorado.png")));
	    
	    JLabel lblNewLabel = new JLabel("Usuario");
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lblNewLabel.setBounds(283, 43, 61, 14);
	    contentPane.add(lblNewLabel);
	    
	    JSeparator separator_1 = new JSeparator();
	    separator_1.setForeground(new Color(0, 0, 0));
	    separator_1.setBounds(286, 166, 189, 2);
	    contentPane.add(separator_1);
	    
	    JSeparator separator_2 = new JSeparator();
	    separator_2.setForeground(new Color(0, 0, 0));
	    separator_2.setBounds(283, 242, 192, 8);
	    contentPane.add(separator_2);
	    
	    JLabel lbl_IconUpdate = new JLabel("");
	    lbl_IconUpdate.setIcon(new ImageIcon(View_Clientes.class.getResource("/view_multimedia/agregar-usuario.png")));
	    lbl_IconUpdate.setBounds(244, 286, 40, 40);
	    contentPane.add(lbl_IconUpdate);
	    
	    JLabel lbl_IconRefresh = new JLabel("");
	    lbl_IconRefresh.setIcon(new ImageIcon(View_Clientes.class.getResource("/view_multimedia/rotacion.png")));
	    lbl_IconRefresh.setBounds(543, 286, 40, 40);
	    contentPane.add(lbl_IconRefresh);
	    
	    Logic_view_client lvc = new Logic_view_client(this);
	}
}
