package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.Controller_View_resetPsw;

public class View_resetPsw extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_email;
	public JButton btn_recuperar;

	public View_resetPsw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 238, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 222, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btn_recuperar = new JButton("Recuperar");
		btn_recuperar.setForeground(new Color(255, 255, 255));
		btn_recuperar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btn_recuperar.setBorder(null);
		btn_recuperar.setOpaque(false);
        btn_recuperar.setContentAreaFilled(false);
		btn_recuperar.setBounds(65, 164, 89, 23);
		panel.add(btn_recuperar);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(15, 125, 194, 1);
		panel.add(separator);
		
		txt_email = new JTextField();
		txt_email.setForeground(new Color(255, 255, 255));
		txt_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txt_email.setBorder(null);
		txt_email.setOpaque(false);
		txt_email.setBounds(15, 90, 194, 29);
		panel.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inserte su correo electrónico");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(29, 11, 171, 49);
		panel.add(lblNewLabel);
		
		JLabel Background = new JLabel("");
		Background.setIcon(new ImageIcon(View_resetPsw.class.getResource("/view_multimedia/background vilet.png")));
		Background.setBounds(0, 0, 222, 261);
		panel.add(Background);
		
		new Controller_View_resetPsw(this);
	}

}
