package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.bean.Cliente;
import model.dao.ClienteDAO;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textCPF;
	private JTextField textNome;
	private JTextField textEmail;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente();
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
	public CadastrarCliente() {
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLCADASTRAR = new JLabel("Cadastrar Cliente");
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
		BTNLimpar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNLimpar.setBounds(250, 355, 120, 36);
		contentPane.add(BTNLimpar);
		
		JButton BTNCadastrar = new JButton("Cadastrar");
		BTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				c.setCpf(textCPF.getText());
				c.setNomecompleto(textNome.getText());
				c.setIdade(Integer.parseInt(JSIdade.getValue().toString()));
				c.setEmail(textEmail.getText());
			
			dao.create(c);
			}});
		BTNCadastrar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNCadastrar.setBounds(65, 355, 120, 36);
		contentPane.add(BTNCadastrar);
		
		JButton BTNCancelar = new JButton("Cancelar");
		BTNCancelar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNCancelar.setBounds(436, 355, 120, 36);
		contentPane.add(BTNCancelar);
	}
}
