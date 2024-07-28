package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller_EntrysInventory;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JButton;

public class View_EntrysInventory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JList list;
	public JButton btn_mov;
	public JButton btnInventarioActual;

	public View_EntrysInventory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Inventario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		list = new JList();
		list.setBounds(10, 74, 414, 187);
		contentPane.add(list);
		
		btn_mov = new JButton("Movimientos");
		btn_mov.setBounds(86, 36, 106, 23);
		contentPane.add(btn_mov);
		
		btnInventarioActual = new JButton("Inventario Actual");
		btnInventarioActual.setBounds(230, 36, 127, 23);
		contentPane.add(btnInventarioActual);
		
		new Controller_EntrysInventory(this);
	}

}
