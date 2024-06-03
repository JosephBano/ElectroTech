package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic_view_employees;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class View_Employees extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lbl_password;
	public JTextField txt_password;
	public JComboBox cmb_employees;
	public JLabel lbl_employeer;
	public JLabel lbl_role;
	public JButton btn_change_role;
	public JButton btn_show_password;
	public JButton btn_save;
	public JComboBox cmb_role;
	private JLabel lbl_icon_Show_Lock;
	public JButton btnAddEmployer;

	public View_Employees() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_Employees.class.getResource("/view_multimedia/badge_24dp_FILL0_wght400_GRAD0_opsz24.png")));
		setTitle("Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmb_employees = new JComboBox();
		cmb_employees.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cmb_employees.setBounds(124, 75, 205, 25);
		contentPane.add(cmb_employees);
		
		lbl_employeer = new JLabel("Empleado");
		lbl_employeer.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lbl_employeer.setBounds(10, 11, 110, 22);
		contentPane.add(lbl_employeer);
		
		lbl_role = new JLabel("Rol de empleado");
		lbl_role.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_role.setBounds(382, 79, 110, 14);
		contentPane.add(lbl_role);
		
		lbl_password = new JLabel("Contraseña");
		lbl_password.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lbl_password.setBounds(30, 211, 95, 37);
		lbl_password.setVisible(false);
		contentPane.add(lbl_password);
		
		txt_password = new JTextField();
		txt_password.setBounds(124, 218, 205, 25);
		txt_password.setVisible(false);
		txt_password.setColumns(10);
		contentPane.add(txt_password);
		
		btn_change_role = new JButton("Cambiar Privilegios");
		btn_change_role.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btn_change_role.setBounds(521, 118, 130, 25);
		btn_change_role.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn_change_role);
		
		btn_save = new JButton("Guardar Datos");
		btn_save.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_save.setBounds(521, 220, 130, 23);
		contentPane.add(btn_save);
		
		btn_show_password = new JButton("Mostrar Contraseña");
		btn_show_password.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btn_show_password.setBounds(379, 219, 130, 25);
		btn_show_password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btn_show_password);
		
		cmb_role = new JComboBox();
		cmb_role.setFont(new Font("Times New Roman", Font.BOLD, 12));
		cmb_role.setBounds(521, 75, 205, 25);
		contentPane.add(cmb_role);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 299, 784, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_banner = new JLabel("");
		lbl_banner.setBounds(0, 0, 784, 124);
		panel.add(lbl_banner);
		lbl_banner.setIcon(new ImageIcon(View_Employees.class.getResource("/view_multimedia/UPS.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(30, 79, 51, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lbl_iconUser = new JLabel("");
		lbl_iconUser.setIcon(new ImageIcon(View_Employees.class.getResource("/view_multimedia/face.png")));
		lbl_iconUser.setBounds(330, 72, 30, 30);
		contentPane.add(lbl_iconUser);
		
		lbl_icon_Show_Lock = new JLabel("");
		lbl_icon_Show_Lock.setIcon(new ImageIcon(View_Employees.class.getResource("/view_multimedia/visibility_lock_.png")));
		lbl_icon_Show_Lock.setBounds(339, 211, 30, 30);
		contentPane.add(lbl_icon_Show_Lock);
		
		JLabel lbl_iconSave = new JLabel("");
		lbl_iconSave.setIcon(new ImageIcon(View_Employees.class.getResource("/view_multimedia/sav.png")));
		lbl_iconSave.setBounds(661, 205, 50, 50);
		contentPane.add(lbl_iconSave);
		
		btnAddEmployer = new JButton("");
		btnAddEmployer.setIcon(new ImageIcon(View_Employees.class.getResource("/view_multimedia/agregar-usuario.png")));
		btnAddEmployer.setBounds(721, 205, 53, 50);
		contentPane.add(btnAddEmployer);
		
		Logic_view_employees lve= new Logic_view_employees(this);
		
	}
}
