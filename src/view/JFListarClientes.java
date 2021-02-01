package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable JTListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 704, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLListarClientes = new JLabel("Listar Clientes");
		JLListarClientes.setHorizontalAlignment(SwingConstants.CENTER);
		JLListarClientes.setFont(new Font("Calisto MT", Font.PLAIN, 20));
		JLListarClientes.setBounds(258, 11, 205, 51);
		contentPane.add(JLListarClientes);
		
		JScrollPane JSPListar = new JScrollPane();
		JSPListar.setBounds(43, 85, 603, 209);
		contentPane.add(JSPListar);
		
		JTListar = new JTable();
		JTListar.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"IdCliente", "Nome Completo", "CPF", "Idade", "E-mail"
			}
		));
		JTListar.getColumnModel().getColumn(4).setMinWidth(30);
		JSPListar.setViewportView(JTListar);
		
		JButton BTNCadastrar = new JButton("Cadastrar Cliente");
		BTNCadastrar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNCadastrar.setBounds(10, 330, 159, 36);
		contentPane.add(BTNCadastrar);
		
		JButton BTNAlterar = new JButton("Alterar Cliente");
		BTNAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTListar.getSelectedRow()!= -1) {
					JFAtualizarClientes af = new JFAtualizarClientes((int)JTListar.getValueAt(JTListar.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um Cliente!");
				}
				readJTable();
			}
		});
		BTNAlterar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNAlterar.setBounds(179, 330, 159, 36);
		contentPane.add(BTNAlterar);
		
		JButton BTNExcluir = new JButton("Excluir Cliente");
		BTNExcluir.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if(JTListar.getSelectedRow() != -1) {
			int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente selecionado?","Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						ClienteDAO dao = new ClienteDAO();
						Cliente c = new Cliente();
						c.setIdCliente((int) JTListar.getValueAt(JTListar.getSelectedRow(), 0));
						dao.delete(c);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
			readJTable();
			}
		});
		BTNExcluir.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNExcluir.setBounds(348, 330, 168, 36);
		contentPane.add(BTNExcluir);
		
		JButton BTNCancelar = new JButton("Cancelar");
		BTNCancelar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNCancelar.setBounds(526, 330, 152, 36);
		contentPane.add(BTNCancelar);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTListar.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
			c.getIdCliente(),
			c.getNomecompleto(),
			c.getCpf(),	
			c.getIdade(),
			c.getEmail()
		});
	}
}

}