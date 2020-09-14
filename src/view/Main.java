package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MetodosController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtVencedor;
	private JTextField txtPerdedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtVencedor = new JTextField();
		txtVencedor.setForeground(new Color(0, 0, 0));
		txtVencedor.setBackground(new Color(230, 230, 250));
		txtVencedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtVencedor.setBounds(175, 157, 86, 20);
		contentPane.add(txtVencedor);
		txtVencedor.setColumns(10);
		txtVencedor.setEditable(false);
		
		txtPerdedor = new JTextField();
		txtPerdedor.setForeground(new Color(0, 0, 0));
		txtPerdedor.setBackground(new Color(230, 230, 250));
		txtPerdedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtPerdedor.setBounds(175, 207, 86, 20);
		contentPane.add(txtPerdedor);
		txtPerdedor.setColumns(10);
		txtPerdedor.setEditable(false);
		
		JLabel lblCarro1 = new JLabel("Carro 1");
		lblCarro1.setForeground(new Color(0, 128, 0));
		lblCarro1.setBackground(new Color(0, 0, 128));
		lblCarro1.setBounds(24, 53, 70, 14);
		contentPane.add(lblCarro1);
		lblCarro1.setFont(new java.awt.Font("sansserif", 1, 16));
		
		JLabel lblCarro2 = new JLabel("Carro 2");
		lblCarro2.setForeground(new Color(128, 0, 0));
		lblCarro2.setBounds(24, 122, 70, 14);
		contentPane.add(lblCarro2);
		lblCarro2.setFont(new java.awt.Font("sansserif", 1, 16));
		
		JButton btnNewButton = new JButton("Correr");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new java.awt.Font("sansserif", 1, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setEnabled(false);
				for(int i= 1; i <= 2; i++) {
					Thread t1 = new MetodosController("Carro "+ i, txtVencedor, lblCarro1, lblCarro2, txtPerdedor);    
					t1.start();                  
				}
			}
		});
		btnNewButton.setBounds(10, 206, 89, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(184, 134, 11));
		separator.setBounds(24, 91, 400, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Vencedor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
		lblNewLabel.setBounds(175, 132, 86, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Perdedor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.ITALIC, 12));
		lblNewLabel_1.setBounds(175, 188, 86, 14);
		contentPane.add(lblNewLabel_1);
	}
}
