package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

import controller.Logic_view_addEmployers;

import javax.swing.ImageIcon;

public class View_addEmployers extends JFrame {

 private static final long serialVersionUID = 1L;
 public JPanel contentPane;
 public JTextField txtNombre;
 public JTextField txtCorreo;
 public JTextField txtClave;
 public JTextField txtTelefono;
 public JLabel lbl_empleados;
 public JButton btnAgregar;
 public JComboBox cmb_rol;

 public View_addEmployers() {
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 550, 471);
  contentPane = new JPanel();
  contentPane.setBackground(new Color(147, 0, 147));
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  setContentPane(contentPane);
  contentPane.setLayout(null);

  JLabel lblNombre = new JLabel("Nombre");
  lblNombre.setBounds(81, 154, 53, 14);
  lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 13)); // fuente Cambria
  lblNombre.setForeground(new Color(255, 255, 255)); // texto azul
  contentPane.add(lblNombre);

  txtNombre = new JTextField();
  txtNombre.setForeground(new Color(255, 255, 255));
  txtNombre.setBounds(88, 179, 169, 17);
  txtNombre.setBorder(null); // borde magenta
  txtNombre.setOpaque(false);
  contentPane.add(txtNombre);
  txtNombre.setColumns(10);

  JLabel lblCorreo = new JLabel("Correo");
  lblCorreo.setBounds(81, 237, 46, 14);
  lblCorreo.setFont(new Font("Times New Roman", Font.BOLD, 13)); // fuente Cambria
  lblCorreo.setForeground(new Color(255, 255, 255)); // texto azul
  contentPane.add(lblCorreo);

  txtCorreo = new JTextField();
  txtCorreo.setForeground(new Color(255, 255, 255));
  txtCorreo.setBounds(88, 262, 169, 17);
  txtCorreo.setBorder(null); // borde magenta
  txtCorreo.setOpaque(false);
  contentPane.add(txtCorreo);
  txtCorreo.setColumns(10);

  JLabel lblClave = new JLabel("Clave");
  lblClave.setBounds(81, 318, 46, 14);
  lblClave.setFont(new Font("Times New Roman", Font.BOLD, 13)); // fuente Cambria
  lblClave.setForeground(new Color(255, 255, 255)); // texto azul
  contentPane.add(lblClave);

  txtClave = new JTextField();
  txtClave.setForeground(new Color(255, 255, 255));
  txtClave.setBounds(88, 343, 169, 17);
  txtClave.setBorder(null); // borde magenta
  txtClave.setOpaque(false);
  contentPane.add(txtClave);
  txtClave.setColumns(10);

  JLabel lblFuncion = new JLabel("Función");
  lblFuncion.setBounds(334, 151, 46, 20);
  lblFuncion.setFont(new Font("Times New Roman", Font.BOLD, 13)); // fuente Cambria
  lblFuncion.setForeground(new Color(255, 255, 255)); // texto azul
  contentPane.add(lblFuncion);

  JLabel lblTelefono = new JLabel("Teléfono");
  lblTelefono.setBounds(334, 237, 53, 14);
  lblTelefono.setFont(new Font("Times New Roman", Font.BOLD, 13)); // fuente Cambria
  lblTelefono.setForeground(new Color(255, 255, 255)); // texto azul
  contentPane.add(lblTelefono);

  txtTelefono = new JTextField();
  txtTelefono.setForeground(new Color(255, 255, 255));
  txtTelefono.setBounds(334, 250, 169, 17);
  txtTelefono.setBorder(null); // borde magenta
  txtTelefono.setOpaque(false);
  contentPane.add(txtTelefono);
  txtTelefono.setColumns(10);

  btnAgregar = new JButton("Agregar");
  btnAgregar.setForeground(new Color(255, 255, 255));
  btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 13));
  btnAgregar.setIcon(new ImageIcon(View_addEmployers.class.getResource("/view_multimedia/done_all_24dp_FILL0_wght400_GRAD0_opsz24.png")));
  btnAgregar.setBounds(216, 389, 129, 32);
  btnAgregar.setBorder(null);
  btnAgregar.setOpaque(false);
  contentPane.add(btnAgregar);

  lbl_empleados = new JLabel("Empleados");
  lbl_empleados.setBounds(233, 11, 83, 14);
  lbl_empleados.setFont(new Font("Times New Roman", Font.BOLD, 17)); // fuente Cambria
  lbl_empleados.setForeground(new Color(0, 0, 0)); // texto azul
  contentPane.add(lbl_empleados);
  
  JSeparator separator = new JSeparator();
  separator.setForeground(new Color(0, 0, 0));
  separator.setBounds(88, 207, 169, 2);
  contentPane.add(separator);
  
  JSeparator separator_1 = new JSeparator();
  separator_1.setForeground(Color.BLACK);
  separator_1.setBounds(88, 281, 169, 2);
  contentPane.add(separator_1);
  
  JSeparator separator_2 = new JSeparator();
  separator_2.setForeground(new Color(0, 0, 0));
  separator_2.setBounds(88, 361, 169, 2);
  contentPane.add(separator_2);
  
  JSeparator separator_1_1 = new JSeparator();
  separator_1_1.setForeground(Color.BLACK);
  separator_1_1.setBounds(334, 277, 169, 2);
  contentPane.add(separator_1_1);
  
  JSeparator separator_1_1_1 = new JSeparator();
  separator_1_1_1.setForeground(Color.BLACK);
  separator_1_1_1.setBounds(334, 207, 169, 2);
  contentPane.add(separator_1_1_1);
  
  JLabel lblNewLabel = new JLabel("");
  lblNewLabel.setIcon(new ImageIcon(View_addEmployers.class.getResource("/view_multimedia/person_add_24dp_FILL0_wght400_GRAD0_opsz24.png")));
  lblNewLabel.setBounds(221, 39, 96, 96);
  contentPane.add(lblNewLabel);
  
  cmb_rol = new JComboBox();
  cmb_rol.setBounds(334, 176, 169, 22);
  contentPane.add(cmb_rol);
  
  Logic_view_addEmployers lvae = new Logic_view_addEmployers(this);
 }
}

