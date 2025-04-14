package br.dev.vitor.calculadoratabuada.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import br.dev.vitor.calculadoratabuada.model.Tabuada;

public class TelaTabuada {

	private JLabel labelMultiplicando;
	private JTextField txtMultiplicando;
	private JLabel labelMinMultiplicador;
	private JTextField txtMinMultiplicador;
	private JLabel labelMaxMultiplicador;
	private JTextField txtMaxMultiplicador;
	private JButton btnCalcular;
	private JButton btnLimpar;
	private JLabel labelResultado;
	private JScrollPane scrollTabuada;
	private JList<String> listaTabuada;

	private Font labels = new Font("Bahnschrift", Font.PLAIN, 15);
	private Color labelColor = new Color(0, 0, 0);
	
	public void criarTela() {

		JFrame tela = new JFrame();

		// Definir o tamanho da tela
		// através de um objeto Dimension
		Dimension tamanho = new Dimension();
		tamanho.setSize(335, 700);
		tela.setSize(tamanho);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setTitle("Tabuada");
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);

		// Criar um JLabel e um JTextField para o multiplicando
		labelMultiplicando = new JLabel();
		labelMultiplicando.setFont(labels);
		labelMultiplicando.setForeground(labelColor);
		labelMultiplicando.setText("Valor do multiplicando:");
		labelMultiplicando.setBounds(50, 40, 150, 30);

		txtMultiplicando = new JTextField();
		txtMultiplicando.setHorizontalAlignment(JTextField.RIGHT);
		txtMultiplicando.setBounds(210, 40, 60, 30);

		// Criar um JLabel e um JTextField para o multiplicando
		labelMinMultiplicador = new JLabel();
		labelMinMultiplicador.setFont(labels);
		labelMinMultiplicador.setText("Mínimo multiplicador");
		labelMinMultiplicador.setBounds(50, 80, 150, 30);

		txtMinMultiplicador = new JTextField();
		txtMinMultiplicador.setHorizontalAlignment(JTextField.RIGHT);
		txtMinMultiplicador.setBounds(210, 80, 60, 30);

		labelMaxMultiplicador = new JLabel();
		labelMaxMultiplicador.setFont(labels);
		labelMaxMultiplicador.setText("Máximo multiplicador");
		labelMaxMultiplicador.setBounds(50, 120, 150, 30);

		txtMaxMultiplicador = new JTextField();
		txtMaxMultiplicador.setHorizontalAlignment(JTextField.RIGHT);
		txtMaxMultiplicador.setBounds(210, 120, 60, 30);

		// Criando os botões da tela
		btnCalcular = new JButton();
		btnCalcular.setText("Calcular");
		btnCalcular.setBounds(50, 160, 105, 30);

		btnLimpar = new JButton();
		btnLimpar.setText("Limpar");
		btnLimpar.setBounds(165, 160, 105, 30);

		// Label do resultado
		labelResultado = new JLabel();
		labelResultado.setText("Resultado: ");
		labelResultado.setBounds(50, 200, 200, 30);

		// Criando a lista que exbirá a tabuada
		listaTabuada = new JList();

		// Criando o painel de rolagem para a lista
		scrollTabuada = new JScrollPane(listaTabuada);
		scrollTabuada.setBounds(50, 240, 220, 380);

		// Adicionando os componentes ao painel de conteúdo
		tela.getContentPane().add(labelMultiplicando);
		tela.getContentPane().add(txtMultiplicando);
		tela.getContentPane().add(labelMinMultiplicador);
		tela.getContentPane().add(txtMinMultiplicador);
		tela.getContentPane().add(labelMaxMultiplicador);
		tela.getContentPane().add(txtMaxMultiplicador);
		tela.getContentPane().add(btnCalcular);
		tela.getContentPane().add(btnLimpar);
		tela.getContentPane().add(labelResultado);
		tela.getContentPane().add(scrollTabuada);

		// Adicionar um ouvinte de ação (Listener) ao botão calcular
		btnCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Tabuada tabuada = new Tabuada();

				double multiplicando = Double.parseDouble(txtMultiplicando.getText());
				double minmultiplicador = Double.parseDouble(txtMinMultiplicador.getText());
				double maxmultiplicador = Double.parseDouble(txtMaxMultiplicador.getText());

				tabuada.setMultiplicando(multiplicando);
				tabuada.setMaiorMultiplicador(maxmultiplicador);
				tabuada.setMenorMultiplicador(minmultiplicador);

				String resultado[] = tabuada.exibirTabuada();

				listaTabuada.setListData(resultado);

			}
		});

		btnLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtMaxMultiplicador.setText(null);
				txtMinMultiplicador.setText(null);
				txtMultiplicando.setText(null);
				txtMultiplicando.requestFocus();
				listaTabuada.setListData(new String[0]);

			}
		});

		// Tornar a tela vísivel deverá ser a última linha deste método
		tela.setVisible(true);

	}

}
