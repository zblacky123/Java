package br.com.projetoescola.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.com.projetoescola.dao.CRUDCurso;
import br.com.projetoescola.domain.Curso;

public class GerenciarCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JButton btnCadastrar;
	private JTextArea txtDescricao;
	private JButton btnAtualizar;
	private JButton btnApagar;
	private JButton btnConsultar;
	private JLabel lblTitulo;
	private JLabel lblDescricao;
	private JLabel lblDataInicio ;
	private JLabel lblDataTermino;
	private JLabel lblHorarioInicio;
	private JLabel lblHorarioTermino;
	private JFormattedTextField txtDataInicio;
	private JFormattedTextField txtDataTermino;
	private JFormattedTextField txtHorarioIncio;
	private JFormattedTextField txtHorarioTermino;
	private Long id = null;
	
	
	MaskFormatter di;
	MaskFormatter dt;
	MaskFormatter hi;
	MaskFormatter ht;
	CRUDCurso cc = new CRUDCurso();
	
	
	
	
	SimpleDateFormat sdf = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GerenciarCurso frame = new GerenciarCurso();
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
	public GerenciarCurso() {
		
		try {
		sdf = new SimpleDateFormat("yyyy-mm-dd");
		setTitle("Gerenciar Cursos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1034, 735);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		carregarTabela();
		
	    btnCadastrar = new JButton("Cadastrar");
		
		btnCadastrar.setBackground(new Color(255, 173, 0));
		btnCadastrar.setForeground(new Color(255, 255, 255));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCadastrar.setBounds(29, 64, 153, 40);
		contentPane.add(btnCadastrar);
		btnCadastrar.setBorder(null);
		
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(new Color(255, 173, 0));
		btnAtualizar.setForeground(new Color(255, 255, 255));
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtualizar.setBounds(29, 115, 153, 40);
		contentPane.add(btnAtualizar);
		btnAtualizar.setBorder(null);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerfomed(ActionEvent e) {
				
				if(id.equals(null)) {
					JOptionPane.showMessageDialog(null, "Selecione um curso para apagar");
				}
				
				else {
					Curso cr = new Curso();
					cr.setIdCurso(id);
					JOptionPane.showMessageDialog(null, cc.apagar(cr));
					carregarTabela();
					limparCampos();
				}
				
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}
		
		btnApagar.setBackground(new Color(255, 173, 0));
		btnApagar.setForeground(new Color(255, 255, 255));
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnApagar.setBounds(29, 171, 153, 40);
		contentPane.add(btnApagar);
		btnApagar.setBorder(null);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(new Color(255, 173, 0));
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConsultar.setBounds(29, 227, 153, 40);
		contentPane.add(btnConsultar);
		btnConsultar.setBorder(null);
		
		
		lblTitulo = new JLabel("Título do Curso");
		lblTitulo.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 20));
		lblTitulo.setBounds(238, 30, 248, 24);
		contentPane.add(lblTitulo);
		
		lblDescricao = new JLabel("Descrição");
		lblDescricao.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 20));
		lblDescricao.setBounds(238, 97, 270, 31);
		contentPane.add(lblDescricao);
		
		
		lblDataInicio = new JLabel("Data Início");
		lblDataInicio.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 20));
		lblDataInicio.setBounds(238, 246, 180, 45);
		contentPane.add(lblDataInicio);
		
		lblDataTermino = new JLabel("Data Término");
		lblDataTermino.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 20));
		lblDataTermino.setBounds(420, 248, 170, 40);
		contentPane.add(lblDataTermino);
		
		lblHorarioInicio = new JLabel("Horário Início");
		lblHorarioInicio.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 20));
		lblHorarioInicio.setBounds(605, 256, 180, 25);
		contentPane.add(lblHorarioInicio);
		
		lblHorarioTermino = new JLabel("Horário Término");
		lblHorarioTermino.setFont(new Font("Swis721 LtEx BT", Font.PLAIN, 20));
		lblHorarioTermino.setBounds(790, 253, 196, 31);
		contentPane.add(lblHorarioTermino);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 20));
		txtTitulo.setBounds(238, 54, 738, 31);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 20));
		txtDescricao.setBackground(new Color(255, 255, 255));
		txtDescricao.setBounds(238, 128, 738, 117);
		contentPane.add(txtDescricao);
		txtDescricao.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		
		di = new MaskFormatter("####-##-##");
		di.setPlaceholderCharacter('_');
		
		txtDataInicio = new JFormattedTextField(di);
		txtDataInicio.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 20));
		txtDataInicio.setBounds(238, 284, 170, 40);
		contentPane.add(txtDataInicio);
		
		
		dt = new MaskFormatter("####-##-##");
		dt.setPlaceholderCharacter('_');
		
		txtDataTermino = new JFormattedTextField(dt);
		txtDataTermino.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 20));
		txtDataTermino.setBounds(420, 285, 170, 40);
		contentPane.add(txtDataTermino);
		
		
		hi = new MaskFormatter("##:##h");
		hi.setPlaceholderCharacter('_');
		
		txtHorarioIncio = new JFormattedTextField(hi);
		txtHorarioIncio.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 20));
		txtHorarioIncio.setBounds(605, 284, 170, 40);
		contentPane.add(txtHorarioIncio);
		
		
		ht = new MaskFormatter("##:##h");
		ht.setPlaceholderCharacter('_');
		txtHorarioTermino = new JFormattedTextField(ht);
		txtHorarioTermino.setFont(new Font("Swis721 Lt BT", Font.PLAIN, 20));
		txtHorarioTermino.setBounds(790, 284, 186, 40);
		contentPane.add(txtHorarioTermino);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1002, 385);
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(GerenciarCurso.class.getResource("/br/com/projetoescola/view/images/background.png")).getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH)));
		contentPane.add(lblNewLabel);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Curso cadCurso = new Curso();
				if(txtTitulo.getText().trim().equals("") 
					|| txtDescricao.getText().trim().equals("")
					|| txtDataInicio.getText().trim().equals("")
					|| txtDataTermino.getText().trim().equals("")
					|| txtHorarioIncio.getText().trim().equals("")
					|| txtHorarioTermino.getText().trim().equals("")
						) {
					JOptionPane.showMessageDialog(null,
							"Você deve preencher todos os campos",
							"Erro",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					cadCurso.setTitulo(txtTitulo.getText());
					cadCurso.setDescricao(txtDescricao.getText());
					cadCurso.setDatainicio(Date.valueOf(txtDataInicio.getText()));
					cadCurso.setDatatermino(Date.valueOf(txtDataTermino.getText()));
					cadCurso.setHorarioinicio(txtHorarioIncio.getText());
					cadCurso.setHorariotermino(txtHorarioTermino.getText());
					
					JOptionPane.showMessageDialog(null, cc.gravar(cadCurso));
					carregarTabela();
					
					limparCampos();
					
				}
				
			}
		});		
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

private void carregarTabela() {
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 384, 1002, 301);
	contentPane.add(scrollPane);
	
	String[] cabecalho = {
			"Id Curso",
			"Título do Curso",
			"Descrição do Curso",
			"Data de Início",
			"Data de Término",
			"Horário de Início",
			"Horário de Término"
	};
	
	Object[][] dados = new Object[cc.listar().size()][7];
	
	for(int i = 0 ; i < dados.length ; i++) {
		dados[i][0] = cc.listar().get(i).getIdCurso();
		dados[i][1] = cc.listar().get(i).getTitulo();
		dados[i][2] = cc.listar().get(i).getDescricao();
		dados[i][3] = cc.listar().get(i).getDatainicio();
		dados[i][4] = cc.listar().get(i).getDatatermino();
		dados[i][5] = cc.listar().get(i).getHorarioinicio();
		dados[i][6] = cc.listar().get(i).getHorariotermino();
	}
	
	DefaultTableModel model = new DefaultTableModel(dados, cabecalho);
	
	JTable table = new JTable(model);
	table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			txtTitulo.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),1)));
			txtDescricao.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),2)));
			txtDataInicio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),3)));
			txtDataTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),4)));
			txtHorarioIncio.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),5)));
			txtHorarioTermino.setText(String.valueOf(table.getValueAt(table.getSelectedRow(),6)));
			
			id = Long.parseLong(String.valueOf(table.getValueAt(table.getSelectedRow(),0)));
			
			
		}
	});
	table.setBackground(new Color(255, 255, 255));
	scrollPane.setViewportView(table);
	
}

private void limparCampos() {
	
	txtTitulo.setText("");
	txtDescricao.setText("");
	txtDataInicio.setText("");
	txtDataTermino.setText("");
	txtHorarioIncio.setText("");
	txtHorarioTermino.setText("");
	
}


}






