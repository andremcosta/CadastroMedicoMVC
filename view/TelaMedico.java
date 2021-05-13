package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

import control.MedicoControl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaMedico extends JFrame {

	private JPanel contentPane;
	boolean nomeOk = false;
	boolean crmOk = false;
	boolean cargaOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMedico frame = new TelaMedico();
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
	public TelaMedico() {
		nomeOk = false;
		crmOk = false;
		cargaOk = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setFocusable(true);
		
		JLabel lblNewLabel = new JLabel("CRM");
		lblNewLabel.setBounds(10, 11, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 50, 95, 14);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_1_1 = new JLabel("Carga Horaria");
		lblNewLabel_1_1.setBounds(10, 173, 95, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nascimento");
		lblNewLabel_1_2.setBounds(10, 91, 95, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contrato");
		lblNewLabel_1_1_1.setBounds(10, 130, 95, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
	    MaskFormatter mascaraData = null;
	    MaskFormatter mascaraCarga = null;
	    
		try {
            mascaraData = new MaskFormatter("##/##/####");
            mascaraCarga = new MaskFormatter("##");
            mascaraCarga.setPlaceholderCharacter('_');
            mascaraData.setPlaceholderCharacter('_');			
		} catch (Exception e) {
			System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
		}		
		
		JLabel lblFormatCrm = new JLabel("");
		lblFormatCrm.setForeground(Color.RED);
		lblFormatCrm.setBounds(243, 11, 168, 14);
		contentPane.add(lblFormatCrm);
		
		JLabel lblFormatNome = new JLabel("");
		lblFormatNome.setForeground(Color.RED);
		lblFormatNome.setBounds(243, 78, 168, 14);
		contentPane.add(lblFormatNome);
		
		JLabel lblFormatCarga = new JLabel("");
		lblFormatCarga.setForeground(Color.RED);
		lblFormatCarga.setBounds(202, 173, 151, 14);
		contentPane.add(lblFormatCarga);
		
		JButton btnEnvia = new JButton("Envia");
		
		JFormattedTextField txtNome = new JFormattedTextField();
		txtNome.setBounds(151, 47, 260, 20);
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (MedicoControl.validaNome(txtNome.getText())) {
					lblFormatNome.setText("");
					nomeOk=true;
					if(nomeOk == true && crmOk == true && cargaOk == true) {
						btnEnvia.setEnabled(true);
					}
				} else {
					lblFormatNome.setText("Não use números"); 
					nomeOk=false;
					btnEnvia.setEnabled(false);
				}
			}
		});	
		contentPane.add(txtNome);
		
		JFormattedTextField txtNascimento = new JFormattedTextField(mascaraData);
		txtNascimento.setBounds(151, 88, 65, 20);
		contentPane.add(txtNascimento);
		
		JFormattedTextField txtContrato = new JFormattedTextField(mascaraData);
		txtContrato.setBounds(151, 127, 65, 20);
		contentPane.add(txtContrato);
		
		JFormattedTextField txtCargaHoraria = new JFormattedTextField(mascaraCarga);
		txtCargaHoraria.setBounds(151, 170, 41, 20);
		txtCargaHoraria.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (MedicoControl.validaCarga(txtCargaHoraria.getText())) {
					lblFormatCarga.setText("");
					cargaOk=true;
					if(nomeOk == true && crmOk == true && cargaOk == true) {
						btnEnvia.setEnabled(true);					
					}
				} else {
					lblFormatCarga.setText("Deve ser entre 20 e 60"); 
					cargaOk=false;
					btnEnvia.setEnabled(false);
				}
			}
		});	
		contentPane.add(txtCargaHoraria);
		
		JTextField txtCrm = new JTextField();
		txtCrm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (MedicoControl.validaCrm(txtCrm.getText())) {
					lblFormatCrm.setText("");
					crmOk=true;
					if(nomeOk == true && crmOk == true && cargaOk == true) {
						btnEnvia.setEnabled(true);
					}
				} else {
					lblFormatCrm.setText("Formato incorreto"); 
					btnEnvia.setEnabled(false);
					crmOk=false;
				}
			}
		});		
		txtCrm.setBounds(151, 11, 82, 20);
		contentPane.add(txtCrm);		
		
		
		btnEnvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = MedicoControl.saveMedico(txtCrm.getText() ,
						txtNome.getText(),txtCargaHoraria.getText(),
						txtNascimento.getText(), txtContrato.getText());
				if (b) {
					JOptionPane.showMessageDialog(null, "Envio com sucesso");
					txtCargaHoraria.setText("");
					txtContrato.setText("");
					txtCrm.setText("");
					txtNascimento.setText("");
					txtNome.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível enviar os dados");
				}
				
				
			}
		});
		
		btnEnvia.setBounds(295, 208, 89, 23);
		btnEnvia.setEnabled(false);
		contentPane.add(btnEnvia);
		

		setVisible(true);
	}
}
