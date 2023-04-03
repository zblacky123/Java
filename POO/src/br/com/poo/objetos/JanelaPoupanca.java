package br.com.poo.objetos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JanelaPoupanca extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public JanelaPoupanca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumBanco = new JLabel("Num do Banco:");
		lblNumBanco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumBanco.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumBanco.setBounds(10, 52, 117, 22);
		contentPane.add(lblNumBanco);
		
		JLabel lblAgencia = new JLabel("Agencia:");
		lblAgencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAgencia.setBounds(174, 54, 70, 19);
		contentPane.add(lblAgencia);
		
		JLabel lblNumConta = new JLabel("Num da Conta:");
		lblNumConta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumConta.setBounds(296, 53, 117, 21);
		contentPane.add(lblNumConta);
		
		JLabel lblTitular = new JLabel("Titular:");
		lblTitular.setBackground(new Color(255, 255, 255));
		lblTitular.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitular.setBounds(10, -2, 53, 19);
		contentPane.add(lblTitular);
		
		JLabel lblSaldoInicial = new JLabel("Saldo Inicial");
		lblSaldoInicial.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSaldoInicial.setBounds(10, 115, 104, 22);
		contentPane.add(lblSaldoInicial);
		
		JLabel lblRendimento = new JLabel("Rendimento:");
		lblRendimento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRendimento.setBounds(307, 117, 89, 19);
		contentPane.add(lblRendimento);
		
		JButton btnVerificarSaldo = new JButton("Verificar Saldo");
		btnVerificarSaldo.setBounds(10, 179, 117, 22);
		contentPane.add(btnVerificarSaldo);
		btnVerificarSaldo.setEnabled(false);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setBounds(151, 179, 117, 23);
		contentPane.add(btnDepositar);
		btnDepositar.setEnabled(false);
		
		
		JButton btnSacar = new JButton("Saque");
		btnSacar.setBounds(296, 179, 117, 22);
		contentPane.add(btnSacar);
		btnSacar.setEnabled(false);
		
		JTextArea txtTitular = new JTextArea();
		txtTitular.setBounds(10, 19, 403, 22);
		contentPane.add(txtTitular);
		
		JTextArea txtNumeroBanco = new JTextArea();
		txtNumeroBanco.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNumeroBanco.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Número agencia obrigatório");
					txtNumeroBanco.requestFocus();
				}
			}
		});
		txtNumeroBanco.setBounds(10, 82, 109, 22);
		contentPane.add(txtNumeroBanco);
		
		JTextArea txtAgencia = new JTextArea();
		txtAgencia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAgencia.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Número agencia obrigatório");
					txtAgencia.requestFocus();
				}
			
			}
		});
		txtAgencia.setBounds(174, 82, 70, 22);
		contentPane.add(txtAgencia);
		
		JTextArea txtSaldoInicial = new JTextArea();
		txtSaldoInicial.setBounds(10, 146, 89, 22);
		contentPane.add(txtSaldoInicial);
		
		JTextArea txtNumeroConta = new JTextArea();
		txtNumeroConta.setBounds(296, 82, 100, 22);
		contentPane.add(txtNumeroConta);
		
		JTextArea txtRendimento = new JTextArea();
		txtRendimento.setBounds(296, 146, 100, 22);
		contentPane.add(txtRendimento);
		
		JTextArea txtTotal = new JTextArea();
		txtTotal.setBounds(124, 213, 178, 37);
		contentPane.add(txtTotal);
	}
}
