package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Logic_view_login;

import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.Action;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.DropMode;
import java.awt.Toolkit;
import javax.swing.JSeparator;


public class View_Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_email;
	public JPasswordField psf_password;
	private JLabel lbl_textInicioSesion;
	private JLabel lbl_IconUser;
	public JButton btn_join;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Login frame = new View_Login();
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
	public View_Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(View_Login.class.getResource("/view_multimedia/Ingresar.png")));
		setTitle("Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 357, 380);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 348, 345);
        contentPane.add(panel);
        panel.setLayout(null);
                
                btn_join = new JButton("");
                btn_join.setToolTipText("Join");

                btn_join.setBorderPainted(false);
                btn_join.setContentAreaFilled(false);
                btn_join.setIcon(new ImageIcon(View_Login.class.getResource("/view_multimedia/login_24dp_FILL0_wght400_GRAD0_opsz24.png")));
                btn_join.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                	}
                });
                
                JSeparator separator_1 = new JSeparator();
                separator_1.setForeground(Color.DARK_GRAY);
                separator_1.setBounds(68, 230, 225, 8);
                panel.add(separator_1);
                
                JSeparator separator = new JSeparator();
                separator.setForeground(Color.DARK_GRAY);
                separator.setBounds(68, 143, 225, 8);
                panel.add(separator);
                btn_join.setBounds(145, 249, 50, 50);
                panel.add(btn_join);
                
                lbl_IconUser = new JLabel("");
                lbl_IconUser.setIcon(new ImageIcon(View_Login.class.getResource("/view_multimedia/face.png")));
                lbl_IconUser.setBounds(155, 3, 45, 45);
                panel.add(lbl_IconUser);
                
                lbl_textInicioSesion = new JLabel("Inicio de Sesión");
                lbl_textInicioSesion.setFont(new Font("Times New Roman", Font.BOLD, 25));
                lbl_textInicioSesion.setForeground(new Color(255, 255, 255));
                lbl_textInicioSesion.setBounds(90, 33, 167, 52);
                panel.add(lbl_textInicioSesion);
        
        JLabel lbl_email = new JLabel("Usuario");
        lbl_email.setForeground(new Color(255, 255, 255));
        lbl_email.setBounds(57, 90, 70, 15);
        panel.add(lbl_email);
        lbl_email.setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        JLabel lbl_password = new JLabel("Contraseña");
        lbl_password.setForeground(new Color(255, 255, 255));
        lbl_password.setBounds(57, 176, 75, 15);
        panel.add(lbl_password);
        lbl_password.setFont(new Font("Times New Roman", Font.BOLD, 15));
        
        psf_password = new JPasswordField();
        psf_password.setForeground(Color.WHITE);
        psf_password.setBorder(null);
        psf_password.setOpaque(false);
        psf_password.setBounds(68, 209, 225, 20);
        panel.add(psf_password);
        psf_password.setEchoChar('*');
        
        txt_email = new JTextField();
        txt_email.setForeground(Color.WHITE);
        txt_email.setBorder(null);
        txt_email.setOpaque(false);
        txt_email.setBackground(new Color(255, 255, 255));
        txt_email.setBounds(68, 119, 225, 20);
        panel.add(txt_email);
        txt_email.setColumns(10);
        
        JLabel lbl_background = new JLabel("");
        lbl_background.setIcon(new ImageIcon(View_Login.class.getResource("/view_multimedia/background vilet.png")));
        lbl_background.setBounds(0, 0, 345, 345);
        panel.add(lbl_background);

        Logic_view_login lvm=new Logic_view_login(this);
	}
}
