package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class View_Proveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public View_Proveedor() {
		setForeground(new Color(172, 210, 230));
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_Proveedor.class.getResource("/view_multimedia/proveedor.png")));
		setFont(new Font("Times New Roman", Font.PLAIN, 13));
		setTitle("Registro de Proveedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_data = new JPanel();
		panel_data.setForeground(new Color(0, 0, 0));
		panel_data.setBackground(new Color(228, 241, 248));
		panel_data.setBounds(0, 0, 784, 445);
		contentPane.add(panel_data);
		panel_data.setLayout(null);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBorder(null);
	    panel_1.setBackground(new Color(228, 241, 248));
	    panel_1.setBounds(249, 0, 360, 451);
	    panel_data.add(panel_1);
	    panel_1.setLayout(null);
	    
	    
	    JButton btn_save = new JButton("Guardar");
	    btn_save.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    
	    JButton btn_close = new JButton("Cerrar");
	    btn_close.setToolTipText("Cerrar");
	    btn_close.setOpaque(true);
	    btn_close.setBorderPainted(false);
	    btn_close.setBackground(new Color(228, 139, 141));
	    btn_close.setBounds(169, 417, 89, 23);
	    panel_1.add(btn_close);
	    btn_save.setOpaque(true);
	    btn_save.setBackground(new Color(164, 242, 209));
	    btn_save.setBorderPainted(false);
	    btn_save.setToolTipText("save");
	    btn_save.setBounds(70, 417, 89, 23);
	    panel_1.add(btn_save);
	    
	    
	    JLabel lbl_proveedor = new JLabel("Proveedor");
	    lbl_proveedor.setBounds(0, 11, 120, 20);
	    panel_1.add(lbl_proveedor);
	    lbl_proveedor.setFont(new Font("Times New Roman", Font.BOLD, 25));
	    lbl_proveedor.setForeground(new Color(0, 0, 0));
	    
	    JFormattedTextField txt_Names = new JFormattedTextField();
	    txt_Names.setBackground(new Color(228, 241, 248));
	    txt_Names.setForeground(Color.GRAY);
	    txt_Names.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    txt_Names.setToolTipText("");
	    txt_Names.setBounds(70, 63, 200, 28);
	    panel_1.add(txt_Names);
	    txt_Names.setBorder(null);
	    	    	    
	    JTextField txt_Surname = new JTextField();
	    txt_Surname.setForeground(Color.GRAY);
	    txt_Surname.setBackground(new Color(228, 241, 248));
	    txt_Surname.setBounds(80, 102, 200, 21);
	    panel_1.add(txt_Surname);
	    txt_Surname.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    txt_Surname.setBorder(null);
	    	    	    	    
	    JLabel lbl_Email = new JLabel("Email");
	    lbl_Email.setBounds(28, 140, 72, 14);
	    panel_1.add(lbl_Email);
	    lbl_Email.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_Email.setForeground(new Color(0, 0, 0));
	    	    	    	    	    
	    JTextField txt_Email = new JTextField();
	    txt_Email.setBackground(new Color(228, 241, 248));
	    txt_Email.setForeground(Color.GRAY);
	    txt_Email.setBounds(70, 156, 200, 26);
	    panel_1.add(txt_Email);
	    txt_Email.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_Email.setBorder(null);
	    	    	    	    	    	    
	    JLabel lbl_RUC = new JLabel("RUC");
	    lbl_RUC.setBounds(28, 192, 38, 14);
	    panel_1.add(lbl_RUC);
	    lbl_RUC.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_RUC.setForeground(new Color(0, 0, 0));
	    	    	    	    	    	    	    
	    JTextField txt_RUC = new JTextField();
	    txt_RUC.setForeground(Color.GRAY);
	    txt_RUC.setBackground(new Color(228, 241, 248));
	    txt_RUC.setBounds(70, 204, 200, 21);
	    panel_1.add(txt_RUC);
	    txt_RUC.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_RUC.setBorder(null);
	    	    	    	    	    	    	    	    
	    JLabel lbl_Code = new JLabel("Código");
	    lbl_Code.setBounds(28, 236, 81, 20);
	    panel_1.add(lbl_Code);
	    lbl_Code.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_Code.setForeground(new Color(0, 0, 0));
	    	    	    	    	    	    	    	    	    
	    JTextField txt_Code = new JTextField();
	    txt_Code.setForeground(Color.GRAY);
	    txt_Code.setBackground(new Color(228, 241, 248));
	    txt_Code.setBounds(70, 260, 200, 20);
	    panel_1.add(txt_Code);
	    txt_Code.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_Code.setBorder(null);
	    	    	    	    	    	    	    	    	    	    
	    JLabel lbl_Phone = new JLabel("Teléfono");
	    lbl_Phone.setBounds(28, 291, 81, 14);
	    panel_1.add(lbl_Phone);
	    lbl_Phone.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_Phone.setForeground(new Color(0, 0, 0));
	    	    	    	    	    	    	    	    	    	    	    
	    JTextField txt_Phone = new JTextField();
	    txt_Phone.setBackground(new Color(228, 241, 248));
	    txt_Phone.setForeground(Color.GRAY);
	    txt_Phone.setBounds(70, 313, 200, 28);
	    panel_1.add(txt_Phone);
	    txt_Phone.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_Phone.setBorder(null);
	    	    	    	    	    	    	    	    	    	    	    	    
	    JLabel lbl_SocialReason = new JLabel("Razón Social:");
	    lbl_SocialReason.setBounds(28, 352, 120, 14);
	    panel_1.add(lbl_SocialReason);
	    lbl_SocialReason.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_SocialReason.setForeground(new Color(0, 0, 0));
	    	    	    	    	    	    	    	    	    	    	    	    	    
	    JTextField txt_SocialReason = new JTextField();
	    txt_SocialReason.setHorizontalAlignment(SwingConstants.LEFT);
	    txt_SocialReason.setBackground(new Color(228, 241, 248));
	    txt_SocialReason.setForeground(Color.GRAY);
	    txt_SocialReason.setBounds(70, 377, 200, 20);
	    panel_1.add(txt_SocialReason);
	    txt_SocialReason.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    txt_SocialReason.setBorder(null);
	    
	    JSeparator separator = new JSeparator();
	    separator.setForeground(Color.BLACK);
	    separator.setBackground(Color.BLACK);
	    separator.setBounds(70, 92, 200, 5);
	    panel_1.add(separator);
	    
	    JSeparator separator_1 = new JSeparator();
	    separator_1.setForeground(Color.BLACK);
	    separator_1.setBackground(Color.BLACK);
	    separator_1.setBounds(70, 132, 200, 5);
	    panel_1.add(separator_1);
	    
	    JSeparator separator_1_1 = new JSeparator();
	    separator_1_1.setForeground(Color.BLACK);
	    separator_1_1.setBackground(Color.BLACK);
	    separator_1_1.setBounds(70, 188, 200, 5);
	    panel_1.add(separator_1_1);
	    
	    JSeparator separator_1_1_1 = new JSeparator();
	    separator_1_1_1.setForeground(Color.BLACK);
	    separator_1_1_1.setBackground(Color.BLACK);
	    separator_1_1_1.setBounds(70, 230, 200, 5);
	    panel_1.add(separator_1_1_1);
	    
	    JLabel lbl_NombresYApellidos = new JLabel("DATOS");
	    lbl_NombresYApellidos.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    lbl_NombresYApellidos.setBounds(28, 50, 52, 14);
	    panel_1.add(lbl_NombresYApellidos);
	    
	    JSeparator separator_1_1_1_1 = new JSeparator();
	    separator_1_1_1_1.setBounds(70, 280, 200, 5);
	    panel_1.add(separator_1_1_1_1);
	    separator_1_1_1_1.setForeground(Color.BLACK);
	    separator_1_1_1_1.setBackground(Color.BLACK);
	    
	    JSeparator separator_1_1_1_1_1 = new JSeparator();
	    separator_1_1_1_1_1.setForeground(Color.BLACK);
	    separator_1_1_1_1_1.setBackground(Color.BLACK);
	    separator_1_1_1_1_1.setBounds(70, 343, 200, 5);
	    panel_1.add(separator_1_1_1_1_1);
	    
	    JSeparator separator_1_1_1_1_1_1 = new JSeparator();
	    separator_1_1_1_1_1_1.setForeground(Color.BLACK);
	    separator_1_1_1_1_1_1.setBackground(Color.BLACK);
	    separator_1_1_1_1_1_1.setBounds(70, 401, 200, 5);
	    panel_1.add(separator_1_1_1_1_1_1);
	   
	    	    	    	    	    	    	    	    	    	    	    	    	    	    
	    JLabel lblNewLabel = new JLabel("New label");
	    lblNewLabel.setIcon(new ImageIcon(View_Proveedor.class.getResource("/view_multimedia/proveedor.png")));
	    lblNewLabel.setBounds(51, 133, 114, 125);
	    panel_data.add(lblNewLabel);
	    
	    JLabel lbl_fondo = new JLabel("");
	    lbl_fondo.setIcon(new ImageIcon(View_Proveedor.class.getResource("/view_multimedia/Fondo.png")));
	    lbl_fondo.setBounds(0, 0, 246, 451);
	    panel_data.add(lbl_fondo);
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(128, 128, 255));
	    panel.setBounds(609, 0, 175, 451);
	    panel_data.add(panel);
	    panel.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setBounds(20, 130, 145, 145);
	    lblNewLabel_1.setIcon(new ImageIcon(View_Proveedor.class.getResource("/view_multimedia/UPS ICONO.png")));
	    panel.add(lblNewLabel_1);
	}
}
