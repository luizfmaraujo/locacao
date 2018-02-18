package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import base.Locacao;
import base.Utilitario;
import util.FileUtil;

public class ViewPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldArquivo;
	private JTextField textFieldPessoas;
	private JTextField textFieldRetirada;
	private JTextField textFieldDevolucao;
	FileUtil arquivo = new FileUtil();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal frame = new ViewPrincipal();
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
	public ViewPrincipal() {
		setType(Type.UTILITY);
		setTitle("Locadora de Ve\u00EDculos 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		menuBar.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNomeDoArquivo = new JLabel("Nome do Arquivo:");
		panel.add(lblNomeDoArquivo);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

		JLabel lblTipoDeCarro = new JLabel("Cart\u00E3o Fidelidade:");
		panel_1.add(lblTipoDeCarro);

		JComboBox comboBoxFidelidade = new JComboBox();
		comboBoxFidelidade.setModel(new DefaultComboBoxModel(new String[] { "N\u00E3o", "Sim" }));
		panel_1.add(comboBoxFidelidade);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);

		JLabel lblDataDaRetirada = new JLabel("Data da Retirada:");
		panel_3.add(lblDataDaRetirada);

		textFieldRetirada = new JTextField();
		panel_3.add(textFieldRetirada);
		textFieldRetirada.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);

		JLabel lblDataDaDevolucao = new JLabel("Data da Devolucao:");
		panel_4.add(lblDataDaDevolucao);

		textFieldDevolucao = new JTextField();
		panel_4.add(textFieldDevolucao);
		textFieldDevolucao.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);

		JLabel label = new JLabel("Quantidade de Pessoas:");
		panel_2.add(label);

		textFieldPessoas = new JTextField();
		textFieldPessoas.setColumns(10);
		panel_2.add(textFieldPessoas);

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);

		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7);

		JLabel labelMelhorPreco = new JLabel("Melhor Pre\u00E7o Encontrado:");
		labelMelhorPreco.setForeground(new Color(255, 0, 0));
		labelMelhorPreco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMelhorPreco.setVisible(false);
		panel_7.add(labelMelhorPreco);

		JLabel labelPreco = new JLabel("");
		labelPreco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_7.add(labelPreco);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JLabel labelMelhorLocadora = new JLabel("Locadora:");
		labelMelhorLocadora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelMelhorLocadora.setVisible(false);
		panel_6.add(labelMelhorLocadora);

		JLabel labelLocadora = new JLabel("");
		labelLocadora.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_6.add(labelLocadora);

		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);

		JLabel lblTotalDaLocacao = new JLabel("Total da Loca\u00E7\u00E3o:");
		lblTotalDaLocacao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTotalDaLocacao.setVisible(false);
		panel_8.add(lblTotalDaLocacao);

		JLabel label_4 = new JLabel("");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_8.add(label_4);

		JLabel lblModeloCarro = new JLabel("Modelo do Carro:");
		lblModeloCarro.setVisible(false);
		lblModeloCarro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblModeloCarro);

		JLabel labelCarro = new JLabel("");
		labelCarro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(labelCarro);

		textFieldArquivo = new JTextField();
		panel.add(textFieldArquivo);
		textFieldArquivo.setColumns(10);

		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9, BorderLayout.SOUTH);

		JLabel lblInformacao = new JLabel(
				"Preencha o nome do arquivo(entrada, entrada1 ou entrada2) ou preencha os campos ");
		lblInformacao.setForeground(Color.RED);
		panel_9.add(lblInformacao);

		JButton btnProcurarArquivo = new JButton("Procurar Arquivo");
		btnProcurarArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textFieldArquivo.getText() == null) || (textFieldArquivo.getText().trim().equals(""))) {
					lblInformacao.setText("Você deve preencher o campo Nome do Arquivo");
					textFieldArquivo.setFocusable(true);
				} else {
					try {
						String conteudoEntrada = arquivo.read(textFieldArquivo.getText());
						String dados[] = conteudoEntrada.split(Pattern.quote(";"));
						comboBoxFidelidade.setSelectedIndex(Integer.parseInt(dados[0].toString()));
						textFieldRetirada.setText(dados[1].toString());
						textFieldDevolucao.setText(dados[2].toString());
						textFieldPessoas.setText(dados[3].toString().trim());
						lblInformacao.setText("Clique no botão Procurar para consultar os dados do arquivo");
					} catch (Exception e1) {
						textFieldArquivo.setFocusable(true);
						lblInformacao.setText("O nome do arquivo deve ser: 'entrada','entrada1' ou 'entrada2'");
					}
				}
			}
		});
		panel.add(btnProcurarArquivo);

		Button button = new Button("Procurar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilitario util = new Utilitario();
				Locacao melhorLocacao = new Locacao();
				try {
					Date dataInicial = util.converteStringEmData(textFieldRetirada.getText());
					Date dataFinal = util.converteStringEmData(textFieldDevolucao.getText());
					if (dataFinal.compareTo(dataInicial) < 0) {
						lblInformacao.setText("A Data da Devolução não pode ser anterior a Data de Retirada");
						textFieldRetirada.setFocusable(true);
					} else {
						int diasSemana = util.calculaQuantidadeDiasDaSemana(dataInicial, dataFinal);
						int diasFimdeSemana = util.calculaQuantidadeDiasFimDeSemana(dataInicial, dataFinal);
						if (comboBoxFidelidade.getSelectedIndex() == 0) {
							melhorLocacao = Utilitario.calculaMelhorLocadora(diasFimdeSemana, diasSemana,
									Integer.parseInt(textFieldPessoas.getText()), false);
						} else {
							melhorLocacao = Utilitario.calculaMelhorLocadora(diasFimdeSemana, diasSemana,
									Integer.parseInt(textFieldPessoas.getText()), true);
						}
						labelMelhorPreco.setVisible(true);
						labelMelhorLocadora.setVisible(true);
						lblModeloCarro.setVisible(true);
						labelPreco.setForeground(new Color(255, 0, 0));
						labelPreco.setText("R$" + Integer.toString(melhorLocacao.getTotalLocacao()) + ",00");
						labelLocadora.setText(melhorLocacao.getLocadora().getNome());
						labelCarro.setText(melhorLocacao.carro.nome);
						lblInformacao.setText("Encontrada Melhor Locadora!!!");
					}
				} catch (Exception e1) {
					textFieldArquivo.setFocusable(true);
					lblInformacao.setText(
							"Os dados devem ser preenchidos de forma correta, os campos data no formato 'dd/mm/AAAA' e o campo "
									+ "quantidade de pessoas deve ser preenchido com um valor compreendido entre 1 e 7");
				}
			}
		});
		panel_5.add(button);

	}

}
