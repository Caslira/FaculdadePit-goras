package br.com.lucaslira.TelaDeCadastro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TelaDeCadstroApplication {
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadstroApplication window = new TelaDeCadstroApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaDeCadstroApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(new BorderLayout());

		JLabel titulo = new JLabel("<HTML><H1>Tela de Cadastro de Produtos</H1></HTML>");
		titulo.setFont(new Font("Ebrima", Font.PLAIN, 11));
		titulo.setBackground(Color.WHITE);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(titulo, BorderLayout.NORTH);

		TelaDeEntrada telaDeEntradaDeDados = new TelaDeEntrada();
		frame.getContentPane().add(telaDeEntradaDeDados);
	}

}
