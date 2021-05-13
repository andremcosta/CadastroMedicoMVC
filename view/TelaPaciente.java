package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import control.MedicoControl;
import control.PacienteControl;

public class TelaPaciente  extends JFrame {

	private JPanel contentPane;
	boolean nomeOk = false;
	boolean cpfOk = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
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
	public TelaPaciente() {
		nomeOk = false;
		cpfOk = false;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setFocusable(true);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(10, 11, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 50, 95, 14);
		contentPane.add(lblNome);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nascimento");
		lblNewLabel_1_2.setBounds(10, 91, 95, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Registro");
		lblNewLabel_1_1_1.setBounds(10, 130, 95, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
	    MaskFormatter mascaraData = null;
	    MaskFormatter mascaraCarga = null;
	    MaskFormatter mascaraCpf = null;
	    
		try {
            mascaraData = new MaskFormatter("##/##/####");
            mascaraCarga = new MaskFormatter("##");
            mascaraCpf = new MaskFormatter("###.###.###-##");
            mascaraCarga.setPlaceholderCharacter('_');
            mascaraData.setPlaceholderCharacter('_');
            mascaraCpf.setPlaceholderCharacter('_');
		} catch (Exception e) {
			System.err.println("Erro na formatação: " + e.getMessage());
            System.exit(-1);
		}		
		
		JLabel lblFormatCpf = new JLabel("");
		lblFormatCpf.setForeground(Color.RED);
		lblFormatCpf.setBounds(243, 11, 168, 14);
		contentPane.add(lblFormatCpf);
		
		JLabel lblFormatNome = new JLabel("");
		lblFormatNome.setForeground(Color.RED);
		lblFormatNome.setBounds(243, 78, 168, 14);
		contentPane.add(lblFormatNome);
		
		JButton btnEnvia = new JButton("Envia");
		
		JFormattedTextField txtNome = new JFormattedTextField();
		txtNome.setBounds(151, 47, 260, 20);
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (PacienteControl.validaNome(txtNome.getText())) {
					lblFormatNome.setText("");
					nomeOk=true;
					if(nomeOk == true && cpfOk == true) {
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
		
		JFormattedTextField txtRegistro = new JFormattedTextField(mascaraData);
		txtRegistro.setBounds(151, 127, 65, 20);
		contentPane.add(txtRegistro);
		
		JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (PacienteControl.validaCpf(txtCpf.getText())) {
					lblFormatCpf.setText("");
					cpfOk=true;
					if(nomeOk == true && cpfOk == true) {
						btnEnvia.setEnabled(true);
					}
				} else {
					lblFormatCpf.setText("CPF inválido"); 
					btnEnvia.setEnabled(false);
					cpfOk=false;
				}
			}
		});		
		txtCpf.setBounds(151, 11, 82, 20);
		contentPane.add(txtCpf);		
		
		
		btnEnvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = PacienteControl.savePaciente(txtCpf.getText() ,
						txtNome.getText(),
						txtNascimento.getText(), txtRegistro.getText());
				if (b) {
					JOptionPane.showMessageDialog(null, "Envio com sucesso");
					txtRegistro.setText("");
					txtCpf.setText("");
					txtNascimento.setText("");
					txtNome.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível enviar os dados");
				}
				
				
			}
		});
		
		btnEnvia.setBounds(294, 182, 89, 23);
		btnEnvia.setEnabled(false);
		contentPane.add(btnEnvia);
		

		setVisible(true);
	}
}

