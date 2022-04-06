package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleDados;

public class TelaProdutosAVenda implements ActionListener, ItemListener, ListSelectionListener{
	private JFrame janela;
	private JLabel titulo;
	
	//Vetores para mostrar os acessorios e roupas a venda
	private JList<String> listaRoupasAVenda = new JList<String>();
	private String[] listaNomesRoupasAVenda = new String[1000];
	private JList<String> listaAcessoriosAVenda = new JList<String>();
	private String[] listaNomesAcessoriosAVenda = new String[1000];
	
	private JButton botaoBusca;
	private JTextField textoBusca;
	private JComboBox filtroProdutos;
	private JComboBox filtroDepartamentos;
	
	private ControleDados dados;
	
	//Construtor
	public TelaProdutosAVenda() {
		janela = new JFrame("Produtos a Venda");
		titulo = new JLabel("Produtos a venda");
		botaoBusca = new JButton("Buscar");
		textoBusca = new JTextField ("");
		//textoBusca.setForeground(Color.GRAY);
		String s1[] = {"Todos", "Acessorios", "Roupas"};
		filtroProdutos = new JComboBox(s1);
		String s2[] = {"Todos", "Masculino", "Feminino", "Infantil", "Unissex"};
		filtroDepartamentos = new JComboBox(s2);
	}
	
	public void produtosAVenda(ControleDados d) {
		dados = d;
	    int k = 0;
	    int l = 0;
	    
		//Coloca todos os acessorios dos usuarios cadastrados no array
    	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
    		listaNomesAcessoriosAVenda[k] =  dados.getAcessoriosAVenda().get(i).getNome();
    		k++;
    	}
    	
    	//Coloca todas roupas dos usuarios cadastrados no array
    	for(int i = 0; i < dados.getRoupasAVenda().size(); i++){
    		listaNomesRoupasAVenda[l] = dados.getRoupasAVenda().get(i).getNome();
    		l++;
    	}
		
		listaAcessoriosAVenda = new JList<String>(listaNomesAcessoriosAVenda);
	    listaRoupasAVenda = new JList<String>(listaNomesRoupasAVenda);
	    
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(110, 10, 250, 30);
		
		filtroProdutos.setBounds(20, 50, 170, 25);
		filtroDepartamentos.setBounds(200, 50, 170, 25);

		botaoBusca.setBounds(20, 80, 100, 25);
		textoBusca.setBounds(130, 80, 240, 25);
				
	    listaAcessoriosAVenda.setBounds(20, 110, 350, 120);
	    listaAcessoriosAVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listaAcessoriosAVenda.setVisibleRowCount(10);
	    
	    listaRoupasAVenda.setBounds(20, 240, 350, 120);
	    listaRoupasAVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
	    listaRoupasAVenda.setVisibleRowCount(10);
	    
	    janela.setLayout(null);
	    janela.add(filtroProdutos);
	    janela.add(filtroDepartamentos);
	    janela.add(titulo);
	    janela.add(botaoBusca);
	    janela.add(textoBusca);
		janela.add(listaAcessoriosAVenda);
		janela.add(listaRoupasAVenda);

		janela.setSize(400, 450);
		janela.setVisible(true);
		
		botaoBusca.addActionListener(this);
		listaAcessoriosAVenda.addListSelectionListener(this);
		listaRoupasAVenda.addListSelectionListener(this);
		filtroProdutos.addItemListener(this);
		filtroDepartamentos.addItemListener(this);
	}
	
	//Busca
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoBusca) {
  			//Procura os acessorios com o mesmo nome
    		Arrays.fill(listaNomesAcessoriosAVenda, null);
			int k = 0;
	    	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
	    		if((dados.getAcessoriosAVenda().get(i).getNome().toLowerCase()).contains(textoBusca.getText().toLowerCase()) == true) {
	    			listaNomesAcessoriosAVenda[k] = dados.getAcessoriosAVenda().get(i).getNome();
	  			}
	  			k++;
	    	}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			    
		    //Procura as roupas com o mesmo nome
    		Arrays.fill(listaNomesRoupasAVenda, null);
		    int l = 0;
	    	for(int j = 0; j < dados.getRoupasAVenda().size(); j++){
	    		if((dados.getRoupasAVenda().get(j).getNome().toLowerCase()).contains(textoBusca.getText().toLowerCase()) == true) {
	    			listaNomesRoupasAVenda[l] = dados.getRoupasAVenda().get(j).getNome();
	  			}
	    		l++;
	    	}
	  		
		    listaRoupasAVenda.setListData((listaNomesRoupasAVenda));
		    listaRoupasAVenda.updateUI();
	  	}
	}
	
	//Filtros
	public void itemStateChanged(ItemEvent e) {
		
		if (e.getSource() == filtroProdutos) {						
			if(filtroProdutos.getSelectedItem().equals("Todos") == true) {				
				listaAcessoriosAVenda.setVisible(true);
				listaRoupasAVenda.setVisible(true);
				listaAcessoriosAVenda.setBounds(20, 110, 350, 120);
			    listaAcessoriosAVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			    listaAcessoriosAVenda.setVisibleRowCount(10);
			    listaRoupasAVenda.setBounds(20, 240, 350, 120);
			    listaRoupasAVenda.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			    listaRoupasAVenda.setVisibleRowCount(10);
			    
			    int k = 0;
			    int l = 0;
			    
				//Coloca todos os acessorios dos usuarios cadastrados no array
		    	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
		    		listaNomesAcessoriosAVenda[k] =  dados.getAcessoriosAVenda().get(i).getNome();
		    		k++;
		    	}
		    	
		    	//Coloca todas roupas dos usuarios cadastrados no array
		    	for(int j = 0; j < dados.getRoupasAVenda().size(); j++){
		    		listaNomesRoupasAVenda[l] = dados.getRoupasAVenda().get(j).getNome();
		    		l++;
		    	}
				
				listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
			    listaAcessoriosAVenda.updateUI();
			    
			    listaRoupasAVenda.setListData((listaNomesRoupasAVenda));
	  			listaRoupasAVenda.updateUI();
			      
			}else if(filtroProdutos.getSelectedItem().equals("Acessorios") == true){				
            	listaAcessoriosAVenda.setVisible(true);
				listaRoupasAVenda.setVisible(false);
				
            }else if(filtroProdutos.getSelectedItem().equals("Roupas") == true){
        		listaAcessoriosAVenda.setVisible(false);
				listaRoupasAVenda.setVisible(true);
        		listaRoupasAVenda.setBounds(20, 110, 350, 120);        
            }
        }
        
        if (e.getSource() == filtroDepartamentos) {
        	if(filtroDepartamentos.getSelectedItem().equals("Todos") == true) {
        		int k = 0;
        	    int l = 0;
        	    
        		//Coloca todos os acessorios dos usuarios cadastrados no array
            	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
            		listaNomesAcessoriosAVenda[k] =  dados.getAcessoriosAVenda().get(i).getNome();
            		k++;
            	}
            	
            	//Coloca todas roupas dos usuarios cadastrados no array
            	for(int j = 0; j < dados.getRoupasAVenda().size(); j++){
            		listaNomesRoupasAVenda[l] = dados.getRoupasAVenda().get(j).getNome();
            		l++;
            	}
				
				listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
			    listaAcessoriosAVenda.updateUI();
			    
			    listaRoupasAVenda.setListData((listaNomesRoupasAVenda));
	  			listaRoupasAVenda.updateUI();
        	}
        	
        	if(filtroDepartamentos.getSelectedItem().equals("Masculino") == true) {
				//Esvazio o array para preencher com os resultados da busca
        		Arrays.fill(listaNomesAcessoriosAVenda, null);
	  			int k = 0;
            	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
		  			if(dados.getAcessoriosAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
		  				listaNomesAcessoriosAVenda[k] = dados.getAcessoriosAVenda().get(i).getNome();
		  			}
	  			
		  			k++;
				}
				
	  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
			    listaAcessoriosAVenda.updateUI();
  			 	
				//Esvazio o array para preencher com os resultados da busca
        		Arrays.fill(listaNomesRoupasAVenda, null);
	  			int l = 0;
	  			for(int i = 0; i < dados.getRoupasAVenda().size(); i++){
		  			if(dados.getRoupasAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
		  				listaNomesAcessoriosAVenda[l] = dados.getRoupasAVenda().get(i).getNome();
		  			}
	  			
		  			l++;
				}
		  
	  			listaRoupasAVenda.setListData((listaNomesRoupasAVenda));
	  			listaRoupasAVenda.updateUI();
			}
		}
        
        if(filtroDepartamentos.getSelectedItem().equals("Feminino") == true) {
        	//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesAcessoriosAVenda, null);
  			int k = 0;
        	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
	  			if(dados.getAcessoriosAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[k] = dados.getAcessoriosAVenda().get(i).getNome();
	  			}
  			
	  			k++;
			}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			 	
			//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesRoupasAVenda, null);
  			int l = 0;
  			for(int i = 0; i < dados.getRoupasAVenda().size(); i++){
	  			if(dados.getRoupasAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[l] = dados.getRoupasAVenda().get(i).getNome();
	  			}
  			
	  			l++;
			}
	  
  			listaRoupasAVenda.setListData((listaNomesRoupasAVenda));
  			listaRoupasAVenda.updateUI();
		}
        
        if(filtroDepartamentos.getSelectedItem().equals("Infantil") == true) {
        	//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesAcessoriosAVenda, null);
  			int k = 0;
        	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
	  			if(dados.getAcessoriosAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[k] = dados.getAcessoriosAVenda().get(i).getNome();
	  			}
  			
	  			k++;
			}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			 	
			//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesRoupasAVenda, null);
  			int l = 0;
  			for(int i = 0; i < dados.getRoupasAVenda().size(); i++){
	  			if(dados.getRoupasAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[l] = dados.getRoupasAVenda().get(i).getNome();
	  			}
  			
	  			l++;
			}
	  
  			listaRoupasAVenda.setListData((listaNomesRoupasAVenda));
  			listaRoupasAVenda.updateUI();
		}
        
        if(filtroDepartamentos.getSelectedItem().equals("Unissex") == true) {
        	//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesAcessoriosAVenda, null);
  			int k = 0;
        	for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++){
	  			if(dados.getAcessoriosAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[k] = dados.getAcessoriosAVenda().get(i).getNome();
	  			}
  			
	  			k++;
			}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			 	
			//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesRoupasAVenda, null);
  			int l = 0;
  			for(int i = 0; i < dados.getRoupasAVenda().size(); i++){
	  			if(dados.getRoupasAVenda().get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[l] = dados.getRoupasAVenda().get(i).getNome();
	  			}
  			
	  			l++;
			}
	  
  			listaRoupasAVenda.setListData((listaNomesRoupasAVenda));
  			listaRoupasAVenda.updateUI();
		}
	}	
	
	//Detalhes dos produtos
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		//Chama a tela de detalhes passando o acessorio clicado pelo index da lista
		if(e.getValueIsAdjusting() && src == listaAcessoriosAVenda) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 1, 2, 
					listaAcessoriosAVenda.getSelectedIndex());
		}
		
		//Chama a tela de detalhes passando o acessorio clicado pelo index da lista
		if(e.getValueIsAdjusting() && src == listaRoupasAVenda) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 2, 2, 
					listaRoupasAVenda.getSelectedIndex());
		}
	}
	
	/*public void mensagemErroBuscarAcessorios() {
		JOptionPane.showMessageDialog(null, "Nao foi possivel encontrar nenhum Acessorio", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}	
	
	public void mensagemErroBuscarRoupas() {
		JOptionPane.showMessageDialog(null, "Nao foi possivel encontrar nenhuma Roupa", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}*/
}