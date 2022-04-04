package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;
import control.*;

public class TelaMinhaSacola implements ListSelectionListener, ActionListener{
	private JFrame janela;
	private JLabel titulo;

	private JList<String> listaAcessoriosSacola = new JList<String>();
	private String[] listaNomesAcessoriosSacola = new String[1000];
	
	private JList<String> listaRoupasSacola = new JList<String>();
	private String[] listaNomesRoupasSacola = new String[1000];
	
	private JLabel textoValorTotal = new JLabel("Valor: ");
	private JTextField valorTotalSacola;
	private JButton retirarProduto = new JButton("Retirar Produto");
	private JButton esvaziarSacola = new JButton("Esvaziar Sacola");
	private JButton finalizarCompra = new JButton("Finalizar Compra");

	private ControleDados dados;

	public TelaMinhaSacola(ControleDados d) {
		dados = d;
		int k = 0;
	    int l = 0;
	    
	    //Coloca todos os acessorios na sacola
    	for(int i = 0; i < dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); i++){
    		listaNomesAcessoriosSacola[k] =  dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(i).getNome();
    		k++;
    	}
    	
    	//Coloca todos as roupas na sacola
    	for(int i = 0; i < dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); i++){
    		listaNomesRoupasSacola[l] =  dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(i).getNome();
    		l++;
    	}
    	
    	listaAcessoriosSacola = new JList<String>(listaNomesAcessoriosSacola);
    	listaRoupasSacola = new JList<String>(listaNomesRoupasSacola);
		String valorTotal = Double.toString(dados.getUsuarioPrincipal().getSacolausuario().getValorTotal());
    	valorTotalSacola = new JTextField(valorTotal);
    	
    	janela = new JFrame("Minha Sacola");
		titulo = new JLabel("Minha Sacola");
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(130, 10, 250, 30);
				
		listaAcessoriosSacola.setBounds(20, 50, 350, 120);
		listaAcessoriosSacola.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaAcessoriosSacola.setVisibleRowCount(10);
	    
		listaRoupasSacola.setBounds(20, 180, 350, 120);
		listaRoupasSacola.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaRoupasSacola.setVisibleRowCount(10);
		
		retirarProduto.setBounds(20, 305, 170, 30);
		esvaziarSacola.setBounds(200, 305, 170, 30);
		
		textoValorTotal.setBounds(20, 340, 80, 30);
		valorTotalSacola.setBounds(110, 340, 80, 30);
		finalizarCompra.setBounds(200, 340, 170, 30);

	    janela.setLayout(null);
	    janela.add(titulo);
	    janela.add(listaAcessoriosSacola);
	    janela.add(listaRoupasSacola);
	    janela.add(retirarProduto);
	    janela.add(esvaziarSacola);
	    janela.add(textoValorTotal);
	    janela.add(valorTotalSacola);
	    janela.add(finalizarCompra);

		janela.setSize(400, 420);
		janela.setVisible(true);
		
		retirarProduto.addActionListener(this);
		esvaziarSacola.addActionListener(this);
		finalizarCompra.addActionListener(this);
		listaAcessoriosSacola.addListSelectionListener(this);
		listaRoupasSacola.addListSelectionListener(this);
	}
	
	//Detalhes dos produtos
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaAcessoriosSacola) {
			for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++) {
				if(dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios()
				.get(listaAcessoriosSacola.getSelectedIndex()) == dados.getAcessoriosAVenda().get(i)) {
					new TelaDetalheProduto().cadastrarEditarProduto(dados, 1, 3, i);
				}
			}
		}
		
		if(e.getValueIsAdjusting() && src == listaRoupasSacola) {
			for(int i = 0; i < dados.getRoupasAVenda().size(); i++) {
				if(dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas()
				.get(listaRoupasSacola.getSelectedIndex()) == dados.getRoupasAVenda().get(i)) {
					new TelaDetalheProduto().cadastrarEditarProduto(dados, 2, 3, i);
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == retirarProduto) {
			if(listaRoupasSacola.getSelectedIndex() != -1) {
				dados.getUsuarioPrincipal().getSacolausuario().retirarRoupa(listaRoupasSacola.getSelectedIndex());
				mensagemSucessoRetirar();
			}
			
			if(listaAcessoriosSacola.getSelectedIndex() != -1) {
				dados.getUsuarioPrincipal().getSacolausuario().retirarAcessorio(listaAcessoriosSacola.getSelectedIndex());
				mensagemSucessoRetirar();
			}
		}
		
		if(src == esvaziarSacola) {
			dados.getUsuarioPrincipal().getSacolausuario().esvaziarSacola();
			mensagemSucessoEsvaziar();
			janela.dispose();
		}
	}
	
	public void mensagemSucessoEsvaziar() {
		JOptionPane.showMessageDialog(null, "A Sacola foi esvaziada com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoRetirar() {
		JOptionPane.showMessageDialog(null, "O Produto foi retirado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
}
