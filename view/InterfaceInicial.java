package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dal.Conexao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class InterfaceInicial extends JFrame {

	static Connection conexao = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceInicial frame = new InterfaceInicial();
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
	public InterfaceInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar Paciente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPaciente();
			}
		});
		btnNewButton.setBounds(24, 40, 180, 147);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cadastrar Médico");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaMedico();
				
			}
		});
		btnNewButton_1.setBounds(231, 40, 180, 147);
		contentPane.add(btnNewButton_1);
		

	}
}
