package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.dao.ClienteDAO;

public class JFAtualizarClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textNome;
	private JTextField textEmail;
	private static int id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarClientes frame = new JFAtualizarClientes(id);
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
	public JFAtualizarClientes(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 657, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		ClienteDAO cdao = new ClienteDAO();
				Cliente c = cdao.read(id);	
				
						JLabel JLId = new JLabel("ID Cliente:");
						JLId.setHorizontalAlignment(SwingConstants.CENTER);
						JLId.setFont(new Font("Calisto MT", Font.PLAIN, 17));
						JLId.setBounds(30, 311, 102, 36);
						contentPane.add(JLId);
						
						JLabel LBLId = new JLabel("New label");
						LBLId.setBounds(159, 311, 143, 35);
						contentPane.add(LBLId);
						JLabel JLTitulo = new JLabel("T\u00EDtulo:\r\n");
						JLTitulo.setBounds(30, 56, 102, 36);
						JLTitulo.setHorizontalAlignment(SwingConstants.CENTER);
						JLTitulo.setFont(new Font("Calisto MT", Font.PLAIN, 17));
						contentPane.add(JLTitulo);
		
		JLabel JLCADASTRAR = new JLabel("Atualizar Cliente");
		JLCADASTRAR.setHorizontalAlignment(SwingConstants.CENTER);
		JLCADASTRAR.setFont(new Font("Calisto MT", Font.PLAIN, 20));
		JLCADASTRAR.setBounds(65, 17, 491, 44);
		contentPane.add(JLCADASTRAR);
		
		JLabel JLCPF = new JLabel("CPF:");
		JLCPF.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		JLCPF.setHorizontalAlignment(SwingConstants.CENTER);
		JLCPF.setBounds(10, 81, 115, 36);
		contentPane.add(JLCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		textCPF.setBounds(163, 81, 393, 36);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel JLNome = new JLabel("Nome Completo:");
		JLNome.setHorizontalAlignment(SwingConstants.CENTER);
		JLNome.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		JLNome.setBounds(10, 145, 141, 36);
		contentPane.add(JLNome);
		
		textNome = new JTextField();
		textNome.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		textNome.setColumns(10);
		textNome.setBounds(163, 145, 393, 36);
		contentPane.add(textNome);
		
		JLabel JLIdade = new JLabel("Idade:");
		JLIdade.setHorizontalAlignment(SwingConstants.CENTER);
		JLIdade.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		JLIdade.setBounds(10, 271, 115, 36);
		contentPane.add(JLIdade);
		
		JLabel JLEmail = new JLabel("E-mail:");
		JLEmail.setHorizontalAlignment(SwingConstants.CENTER);
		JLEmail.setFont(new Font("Calisto MT", Font.PLAIN, 16));
		JLEmail.setBounds(10, 208, 115, 36);
		contentPane.add(JLEmail);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(163, 208, 393, 36);
		contentPane.add(textEmail);
		
		JSpinner JSIdade = new JSpinner();
		JSIdade.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		JSIdade.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		JSIdade.setBounds(163, 271, 393, 36);
		contentPane.add(JSIdade);
		
		
		
		JButton BTNLimpar = new JButton("Limpar\r\n");
		BTNLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNome.setText(null);
				textCPF.setText(null);
				textEmail.setText(null);
				JSIdade.setValue(null);
			}
		});
		BTNLimpar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNLimpar.setBounds(250, 355, 120, 36);
		contentPane.add(BTNLimpar);
		
		LBLId.setText(String.valueOf(c.getIdCliente()));
		textCPF.setText(c.getCpf());
		textNome.setText(c.getNomecompleto());
		JSIdade.setValue(c.getIdade());
		textEmail.setText(c.getEmail());
		
		JButton BTNCadastrar = new JButton("Alterar");
		BTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setIdCliente(Integer.parseInt(LBLId.getText()));
				c.setCpf(textCPF.getText());
				c.setNomecompleto(textNome.getText());
				c.setIdade(Integer.parseInt(JSIdade.getValue().toString()));
				c.setEmail(textEmail.getText());
			dao.update(c);
			dispose();
			}});
		BTNCadastrar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNCadastrar.setBounds(65, 355, 120, 36);
		contentPane.add(BTNCadastrar);
		
		JButton BTNCancelar = new JButton("Cancelar");
		BTNCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BTNCancelar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNCancelar.setBounds(436, 355, 120, 36);
		contentPane.add(BTNCancelar);
	}

}