package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import control.*;

public class TelaMeusProdutos implements ListSelectionListener{
	private JFrame janela;
	private JLabel tituloAVenda;
	private JLabel tituloComprados;
	private ControleDados dados;
	
	//Vetores para mostrar os acessorios e roupas a venda
	private JList<String> listaMeusAcessoriosAVenda = new JList<String>();
	private String[] listaNomesMeusAcessoriosAVenda = new String[1000];
	private JList<String> listaMinhasRoupasAVenda = new JList<String>();
	private String[] listaNomesMinhasRoupasAVenda = new String[1000];
	
	//Vetores para mostrar os acessorios e roupas compradas
	private JList<String> listaMeusAcessoriosComprados = new JList<String>();
	private String[] listaNomesMeusAcessoriosComprados = new String[1000];
	private JList<String> listaMinhasRoupasCompradas = new JList<String>();
	private String[] listaNomesMinhasRoupasCompradas = new String[1000];
	
	public TelaMeusProdutos(ControleDados d) {
		dados = d;
		int k = 0;
	    int l = 0;
	    
	    //Coloca todos os acessorios a venda do usuarios cadastrado no array
    	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
    		if(dados.getUsuarioPrincipal() == dados.getAcessoriosAVenda().get(i).getUsuario()) {
    			listaNomesMeusAcessoriosAVenda[k] =  dados.getAcessoriosAVenda().get(i).getNome();
    		}
    		k++;
    	}
    	
    	//Coloca todas as roupas a venda do usuarios cadastrado no array
    	for(int i = 0; i < dados.getRoupasAVenda().size(); i++){
    		if(dados.getUsuarioPrincipal() == dados.getRoupasAVenda().get(i).getUsuario()) {
    			listaNomesMinhasRoupasAVenda[l] =  dados.getRoupasAVenda().get(i).getNome();
    		}
    		l++;
    	}
		
		int m = 0;
		int n = 0;
		
		//Coloca todos os acessorios comprados do usuario cadastrado no array
    	for(int i = 0; i < dados.getAcessoriosComprados().size(); i++){
    		if(dados.getUsuarioPrincipal() == dados.getAcessoriosComprados().get(i).getUsuario()) {
    			listaNomesMeusAcessoriosComprados[m] =  dados.getAcessoriosComprados().get(i).getNome();
    		}
    		m++;
    	}
    	
    	//Coloca todos os acessorios dos usuarios cadastrados no array
    	for(int i = 0; i < dados.getRoupasCompradas().size(); i++){
    		if(dados.getUsuarioPrincipal() == dados.getRoupasCompradas().get(i).getUsuario()) {
    			listaNomesMinhasRoupasCompradas[n] =  dados.getRoupasCompradas().get(i).getNome();
    		}
    		n++;
    	}
    	
    	listaMeusAcessoriosAVenda = new JList<String>(listaNomesMeusAcessoriosAVenda);
		listaMinhasRoupasAVenda = new JList<String>(listaNomesMinhasRoupasAVenda);
		
    	listaMeusAcessoriosComprados = new JList<String>(listaNomesMeusAcessoriosComprados);
    	listaMinhasRoupasCompradas = new JList<String>(listaNomesMinhasRoupasCompradas);
    	
    	janela = new JFrame("Meus produtos");
		tituloAVenda = new JLabel("Produtos a venda");
		tituloComprados = new JLabel("Produtos comprados");
		
		tituloAVenda.setFont(new Font("Arial", Font.BOLD, 20));
		tituloAVenda.setBounds(110, 10, 250, 30);
				
		listaMeusAcessoriosAVenda.setBounds(20, 50, 350, 120);
		listaMeusAcessoriosAVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaMeusAcessoriosAVenda.setVisibleRowCount(10);
	    
		listaMinhasRoupasAVenda.setBounds(20, 180, 350, 120);
		listaMinhasRoupasAVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaMinhasRoupasAVenda.setVisibleRowCount(10);
		
		tituloComprados.setFont(new Font("Arial", Font.BOLD, 20));
		tituloComprados.setBounds(110, 310, 250, 30);
				
		listaMeusAcessoriosComprados.setBounds(20, 350, 350, 120);
		listaMeusAcessoriosComprados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaMeusAcessoriosComprados.setVisibleRowCount(10);
	    
		listaMinhasRoupasCompradas.setBounds(20, 480, 350, 120);
		listaMinhasRoupasCompradas.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaMinhasRoupasCompradas.setVisibleRowCount(10);
	    
	    janela.setLayout(null);
	    janela.add(tituloAVenda);
	    janela.add(listaMeusAcessoriosAVenda);
	    janela.add(listaMinhasRoupasAVenda);
	    janela.add(tituloComprados);
	    janela.add(listaMeusAcessoriosComprados);
		janela.add(listaMinhasRoupasCompradas);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setSize(400, 650);
		janela.setVisible(true);
		
		listaMeusAcessoriosAVenda.addListSelectionListener(this);
		listaMinhasRoupasAVenda.addListSelectionListener(this);
		listaMeusAcessoriosComprados.addListSelectionListener(this);
		listaMinhasRoupasCompradas.addListSelectionListener(this);
	}
	
	//Detalhes dos produtos
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaMeusAcessoriosAVenda) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 1, 3, 
					listaMeusAcessoriosAVenda.getSelectedIndex());
		}
		
		if(e.getValueIsAdjusting() && src == listaMinhasRoupasAVenda) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 2, 3, 
					listaMinhasRoupasAVenda.getSelectedIndex());
		}
		
		if(e.getValueIsAdjusting() && src == listaMeusAcessoriosComprados) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 2, 3, 
					listaMeusAcessoriosComprados.getSelectedIndex());
		}
				
		if(e.getValueIsAdjusting() && src == listaMinhasRoupasCompradas) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 2, 3, 
					listaMinhasRoupasCompradas.getSelectedIndex());
		}
	}
}
