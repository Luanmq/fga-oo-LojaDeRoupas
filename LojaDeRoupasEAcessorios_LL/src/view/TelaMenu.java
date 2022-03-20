package view;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TelaMenu implements ActionListener{
	private static JFrame janela = new JFrame("Menu");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton verProdutosAVenda = new JButton("Produtos a venda");
	private static JButton verMinhaConta = new JButton("Minha Conta");
	private static JButton verMeusProdutos = new JButton("Meus Produtos");
	private static JButton verMinhaSacola = new JButton("Sacola");

	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(130, 10, 150, 30);
		verProdutosAVenda.setBounds(100, 50, 200, 30);
		verMinhaConta.setBounds(100, 100, 200, 30);
		verMeusProdutos.setBounds(100, 150, 200, 30);
		verMinhaSacola.setBounds(100, 200, 200, 30);

		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(verProdutosAVenda);
		janela.add(verMinhaConta);
		janela.add(verMeusProdutos);
		janela.add(verMinhaSacola);
		
		verProdutosAVenda.addActionListener(this);
		verMinhaConta.addActionListener(this);
		verMeusProdutos.addActionListener(this);
		verMinhaSacola.addActionListener(this);
		
		janela.setSize(400, 300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}	

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == verProdutosAVenda)
			new TelaProdutosAVenda().produtosAVenda();
			
		if(src == verMinhaConta)
			new TelaDetalhesUsuario().cadastrarEditarUsuario(3, 0);
		
		if(src == verMeusProdutos)
			new TelaMeusProdutos();
		
		if(src == verMinhaSacola)
			new TelaMinhaSacola();
	}

	public static void dispose() {
		janela.dispose();
	}
}
