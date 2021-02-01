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
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

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
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
				readJTable();
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton BTNCadastrar = new JButton("Cadastrar Filme\r\n");
		BTNCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarFilme cf = new JFCadastrarFilme();
				cf.setVisible(true);
			}
		});
		BTNCadastrar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNCadastrar.setBounds(28, 402, 163, 36);
		contentPane.add(BTNCadastrar);
		
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
		BTNAlterar.setBounds(212, 402, 143, 36);
		contentPane.add(BTNAlterar);
		
		JButton BTNExcluir = new JButton("Excluir Filme");
		BTNExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            if(JTFilmes.getSelectedRow() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						FilmeDAO dao = new FilmeDAO();
						Filme f = new Filme();
						f.setIdFilme((int) JTFilmes.getValueAt(JTFilmes.getSelectedRow(), 0));
						dao.delete(f);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		BTNExcluir.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNExcluir.setBounds(375, 402, 143, 36);
		contentPane.add(BTNExcluir);
		
		JButton BTNCancelar = new JButton("Cancelar");
		BTNCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BTNCancelar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		BTNCancelar.setBounds(540, 402, 143, 36);
		contentPane.add(BTNCancelar);
	
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