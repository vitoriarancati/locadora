package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField textTitulo;
	private JTextField textCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 758, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel JLCadastrarFilme = new JLabel("Cadastrar Filme");
		JLCadastrarFilme.setBounds(172, 11, 382, 36);
		JLCadastrarFilme.setForeground(Color.BLACK);
		JLCadastrarFilme.setToolTipText("");
		JLCadastrarFilme.setHorizontalAlignment(SwingConstants.CENTER);
		JLCadastrarFilme.setFont(new Font("Calisto MT", Font.PLAIN, 20));
		contentPane.add(JLCadastrarFilme);
		
		JLabel JLTitulo = new JLabel("T\u00EDtulo:\r\n");
		JLTitulo.setBounds(30, 74, 102, 36);
		JLTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLTitulo.setFont(new Font("Calisto MT", Font.PLAIN, 17));
		contentPane.add(JLTitulo);
		
		textTitulo = new JTextField();
		textTitulo.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		textTitulo.setBounds(159, 76, 522, 36);
		contentPane.add(textTitulo);
		textTitulo.setColumns(10);
		
		JLabel JLCategoria = new JLabel("Categoria:");
		JLCategoria.setBounds(30, 139, 102, 36);
		JLCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		JLCategoria.setFont(new Font("Calisto MT", Font.PLAIN, 17));
		contentPane.add(JLCategoria);
		
		textCategoria = new JTextField();
		textCategoria.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		textCategoria.setBounds(159, 141, 522, 36);
		textCategoria.setColumns(10);
		contentPane.add(textCategoria);
		
		JLabel JLSinopse = new JLabel("Sinopse\r\n:");
		JLSinopse.setBounds(30, 201, 102, 36);
		JLSinopse.setHorizontalAlignment(SwingConstants.CENTER);
		JLSinopse.setFont(new Font("Calisto MT", Font.PLAIN, 17));
		contentPane.add(JLSinopse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 201, 522, 79);
		contentPane.add(scrollPane);
		
		JTextArea textSinopse = new JTextArea();
		textSinopse.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 12));
		textSinopse.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(textSinopse);
		
		JLabel JLDuracao = new JLabel("Dura\u00E7\u00E3o:");
		JLDuracao.setHorizontalAlignment(SwingConstants.CENTER);
		JLDuracao.setFont(new Font("Calisto MT", Font.PLAIN, 17));
		JLDuracao.setBounds(30, 301, 102, 36);
		contentPane.add(JLDuracao);
		
		JSpinner JSDuracao = new JSpinner();
		JSDuracao.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		JSDuracao.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		JSDuracao.setBounds(159, 303, 110, 36);
		contentPane.add(JSDuracao);
		
		JLabel JLAudio = new JLabel("\u00C1udio:\r\n\r\n");
		JLAudio.setHorizontalAlignment(SwingConstants.CENTER);
		JLAudio.setFont(new Font("Calisto MT", Font.PLAIN, 17));
		JLAudio.setBounds(329, 301, 102, 36);
		contentPane.add(JLAudio);
		
		JRadioButton RBDublado = new JRadioButton("Dublado");
		RBDublado.setHorizontalAlignment(SwingConstants.CENTER);
		RBDublado.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		RBDublado.setBounds(444, 301, 110, 36);
		contentPane.add(RBDublado);
		
		JRadioButton RBLegendado = new JRadioButton("Legendado\r\n");
		RBLegendado.setHorizontalAlignment(SwingConstants.CENTER);
		RBLegendado.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		RBLegendado.setBounds(571, 301, 110, 36);
		contentPane.add(RBLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(RBDublado);
		audio.add(RBLegendado);
		
		JButton BTNCadastra = new JButton("Cadastrar");
		BTNCadastra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(textTitulo.getText());
				f.setCategoria(textCategoria.getText());
				f.setSinopse(textSinopse.getText());
				f.setDuracao(Integer.parseInt(JSDuracao.getValue().toString()));
				if(RBDublado.isSelected()) {
					f.setDublado(true);
				}else if (RBLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
				dispose();
			}
			});
		BTNCadastra.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNCadastra.setBounds(103, 390, 120, 36);
		contentPane.add(BTNCadastra);
		
		JButton BTNLimpar = new JButton("Limpar");
		BTNLimpar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textTitulo.setText(null);
				textCategoria.setText(null);
				textSinopse.setText(null);
				JSDuracao.setValue(0);
				audio.clearSelection();
			}
		});
		BTNLimpar.setBounds(311, 390, 120, 36);
		contentPane.add(BTNLimpar);
		
		JButton BTNCancelar = new JButton("Cancelar\r\n");
		BTNCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		BTNCancelar.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		BTNCancelar.setBounds(525, 390, 120, 36);
		contentPane.add(BTNCancelar);
	}
}