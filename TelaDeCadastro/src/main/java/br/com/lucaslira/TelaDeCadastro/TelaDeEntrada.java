package br.com.lucaslira.TelaDeCadastro;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import br.com.lucaslira.TelaDeCadastro.model.Produtos;

public class TelaDeEntrada extends JPanel {

	// Lista para guardar produtos
		private List<Produtos> produtos = new ArrayList<>();

		public TelaDeEntrada() {

			this.setLayout(new GridLayout(0, 2));

			JLabel nomeDoProduto = new JLabel("Nome: ");
			this.add(nomeDoProduto);

			final JTextField nomeDoProdutoField = new JTextField();
			this.add(nomeDoProdutoField);

			JLabel quantidadeDoProduto = new JLabel("Quantidade de Itens: ");
			this.add(quantidadeDoProduto);

			final JTextField quantidadeDoProdutoField = new JTextField();
			this.add(quantidadeDoProdutoField);

			JLabel preçoDoProduto = new JLabel("Valor: ");
			this.add(preçoDoProduto);

			final JTextField preçoDoProdutoField = new JTextField();
			this.add(preçoDoProdutoField);

			JButton btnAdicionar = new JButton("Adicionar");
			this.add(btnAdicionar);
			btnAdicionar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Você clicou no botão adicionar");

					String nome = nomeDoProdutoField.getText();
					int quantidade = Integer.parseInt(quantidadeDoProdutoField.getText());
					double valor = Double.parseDouble(preçoDoProdutoField.getText());

					Produtos produto = new Produtos(nome, valor, quantidade);
					produtos.add(produto);
					System.out.println("Quantidade cadastrada " + produtos.size());

					nomeDoProdutoField.setText("");
					quantidadeDoProdutoField.setText("");
					preçoDoProdutoField.setText("");
				}

			});

			JButton btnRelatorio = new JButton("Relatório");
			this.add(btnRelatorio);
			btnRelatorio.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < produtos.size(); i++) {
						System.out.println(produtos.get(i));
					}

					Object[] colunas = { "Nome", "Quantidade", "Valo Unitário(R$)", "TOTAL(R$)" };
					Object[][] linhas = new Object[produtos.size() + 2][4];

					for (int i = 0; i < produtos.size(); i++) {
						Object[] linha = new Object[] { produtos.get(i).getNome().toUpperCase(),
								produtos.get(i).getQuantidade(), produtos.get(i).getValor(),
								produtos.get(i).getValor() * produtos.get(i).getQuantidade() };
						linhas[i] = linha;

					}

					int somaQuantidade = 0;
					double totalValorGeral = 0;

					for (Produtos produto : produtos) {
						somaQuantidade += produto.getQuantidade();
						totalValorGeral = totalValorGeral + (produto.getQuantidade() * produto.getValor());

					}
					linhas[produtos.size() + 1] = new Object[] { "TOTAL", somaQuantidade, "", totalValorGeral };

					JTable tabela = new JTable(linhas, colunas);

					JScrollPane jscroll = new JScrollPane(tabela);
					jscroll.setSize(new Dimension(500, 500));

					JOptionPane.showMessageDialog(null, new JScrollPane(tabela));

				}

			});
		}
}
