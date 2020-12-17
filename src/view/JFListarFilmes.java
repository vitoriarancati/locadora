package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable JTFilmes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	public JFListarFilmes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLListarFilmes = new JLabel("Listar Filmes");
		JLListarFilmes.setHorizontalAlignment(SwingConstants.CENTER);
		JLListarFilmes.setFont(new Font("Calisto MT", Font.PLAIN, 20));
		JLListarFilmes.setBounds(262, 11, 183, 34);
		contentPane.add(JLListarFilmes);
		
		JScrollPane JSPLista = new JScrollPane();
		JSPLista.setBounds(32, 62, 640, 318);
		contentPane.add(JSPLista);
		
		JTFilmes = new JTable();
		JTFilmes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"IdFilme", "T\u00EDtulo", "Categoria", "Dura\u00E7\u00E3o"
			}
		));
		JSPLista.setViewportView(JTFilmes);
		
		JButton BTNCadastar = new JButton("Cadastrar Filme\r\n");
		BTNCadastar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNCadastar.setBounds(32, 402, 163, 36);
		contentPane.add(BTNCadastar);
		
		JButton BTNAlterar = new JButton("Alterar Filme\r\n");
		BTNAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JTFilmes.getSelectedRow()!= -1) {
					JFAtualizarFilme af = new JFAtualizarFilme(
							(int)JTFilmes.getValueAt(JTFilmes.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		BTNAlterar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNAlterar.setBounds(288, 402, 143, 36);
		contentPane.add(BTNAlterar);
		
		JButton BTNExcluir = new JButton("Excluir Filme");
		BTNExcluir.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNExcluir.setBounds(529, 402, 143, 36);
		contentPane.add(BTNExcluir);
	
	readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTFilmes.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
			f.getIdFilme(),
			f.getTitulo(),
			f.getCategoria(),	
			f.getDuracao()
		});
	}
}
}
