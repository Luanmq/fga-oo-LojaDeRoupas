package view;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

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

	public TelaProdutosAVenda() {
		janela = new JFrame("Produtos a Venda");
		titulo = new JLabel("Produtos a venda");
		botaoBusca = new JButton("Buscar");
		textoBusca = new JTextField ("Digite o Produto para buscar: ");
		textoBusca.setForeground(Color.GRAY);
		String s1[] = {"Todos", "Acessorios", "Roupas"};
		filtroProdutos = new JComboBox(s1);
		String s2[] = {"Todos", "Masculino", "Feminino", "Infantil", "Unissex"};
		filtroDepartamentos = new JComboBox(s2);
	}
	
	public void produtosAVenda() {
	    int k = 0;
	    int l = 0;
	    
		//Coloca todos os acessorios dos usuarios cadastrados no array
    	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
    		listaNomesAcessoriosAVenda[k] =  Dados.acessoriosAVenda.get(i).getNome();
    		k++;
    	}
    	
    	//Coloca todas roupas dos usuarios cadastrados no array
    	for(int j = 0; j < Dados.roupasAVenda.size(); j++){
    		listaNomesRoupasAVenda[l] = Dados.roupasAVenda.get(j).getNome();
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
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
	    	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
	    		if(Dados.acessoriosAVenda.get(i).getNome().contains(textoBusca.getText()) == true) {
	  				listaNomesAcessoriosAVenda[k] = Dados.acessoriosAVenda.get(i).getNome();
	  			}
	  			k++;
	    	}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			    
		    //Procura as roupas com o mesmo nome
    		Arrays.fill(listaNomesRoupasAVenda, null);
		    int l = 0;
	    	for(int j = 0; j < Dados.roupasAVenda.size(); j++){
	    		if(Dados.roupasAVenda.get(j).getNome().contains(textoBusca.getText()) == true) {
	    			listaNomesRoupasAVenda[l] = Dados.roupasAVenda.get(j).getNome();
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
		    	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
		    		listaNomesAcessoriosAVenda[k] =  Dados.acessoriosAVenda.get(i).getNome();
		    		k++;
		    	}
		    	
		    	//Coloca todas roupas dos usuarios cadastrados no array
		    	for(int j = 0; j < Dados.roupasAVenda.size(); j++){
		    		listaNomesRoupasAVenda[l] = Dados.roupasAVenda.get(j).getNome();
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
            	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
            		listaNomesAcessoriosAVenda[k] =  Dados.acessoriosAVenda.get(i).getNome();
            		k++;
            	}
            	
            	//Coloca todas roupas dos usuarios cadastrados no array
            	for(int j = 0; j < Dados.roupasAVenda.size(); j++){
            		listaNomesRoupasAVenda[l] = Dados.roupasAVenda.get(j).getNome();
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
            	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
		  			if(Dados.acessoriosAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
		  				listaNomesAcessoriosAVenda[k] = Dados.acessoriosAVenda.get(i).getNome();
		  			}
	  			
		  			k++;
				}
				
	  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
			    listaAcessoriosAVenda.updateUI();
  			 	
				//Esvazio o array para preencher com os resultados da busca
        		Arrays.fill(listaNomesRoupasAVenda, null);
	  			int l = 0;
	  			for(int i = 0; i < Dados.roupasAVenda.size(); i++){
		  			if(Dados.roupasAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
		  				listaNomesAcessoriosAVenda[l] = Dados.roupasAVenda.get(i).getNome();
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
        	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
	  			if(Dados.acessoriosAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[k] = Dados.acessoriosAVenda.get(i).getNome();
	  			}
  			
	  			k++;
			}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			 	
			//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesRoupasAVenda, null);
  			int l = 0;
  			for(int i = 0; i < Dados.roupasAVenda.size(); i++){
	  			if(Dados.roupasAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[l] = Dados.roupasAVenda.get(i).getNome();
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
        	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
	  			if(Dados.acessoriosAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[k] = Dados.acessoriosAVenda.get(i).getNome();
	  			}
  			
	  			k++;
			}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			 	
			//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesRoupasAVenda, null);
  			int l = 0;
  			for(int i = 0; i < Dados.roupasAVenda.size(); i++){
	  			if(Dados.roupasAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[l] = Dados.roupasAVenda.get(i).getNome();
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
        	for(int i = 0; i < Dados.acessoriosAVenda.size(); i++){
	  			if(Dados.acessoriosAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[k] = Dados.acessoriosAVenda.get(i).getNome();
	  			}
  			
	  			k++;
			}
			
  			listaAcessoriosAVenda.setListData((listaNomesAcessoriosAVenda));
		    listaAcessoriosAVenda.updateUI();
			 	
			//Esvazio o array para preencher com os resultados da busca
    		Arrays.fill(listaNomesRoupasAVenda, null);
  			int l = 0;
  			for(int i = 0; i < Dados.roupasAVenda.size(); i++){
	  			if(Dados.roupasAVenda.get(i).getDepartamento().equals(filtroDepartamentos.getSelectedItem()) == true) {
	  				listaNomesAcessoriosAVenda[l] = Dados.roupasAVenda.get(i).getNome();
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
			new TelaDetalhesProduto().cadastrarEditarProduto(1, 2, 
					listaAcessoriosAVenda.getSelectedIndex());
		}
		
		//Chama a tela de detalhes passando o acessorio clicado pelo index da lista
		if(e.getValueIsAdjusting() && src == listaRoupasAVenda) {
			new TelaDetalhesProduto().cadastrarEditarProduto(2, 2, 
					listaRoupasAVenda.getSelectedIndex());
		}
	}
	
	public void mensagemErroBuscarAcessorios() {
		JOptionPane.showMessageDialog(null, "Nao foi possivel encontrar nenhum Acessorio", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}	
	
	public void mensagemErroBuscarRoupas() {
		JOptionPane.showMessageDialog(null, "Nao foi possivel encontrar nenhuma Roupa", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
}
