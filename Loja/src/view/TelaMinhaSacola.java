package view;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import control.*;

public class TelaMinhaSacola implements ListSelectionListener{
	private JFrame janela;
	private JLabel titulo;

	private JList<String> listaAcessoriosSacola = new JList<String>();
	private String[] listaNomesAcessoriosSacola = new String[1000];
	
	private JList<String> listaRoupasSacola = new JList<String>();
	private String[] listaNomesRoupasSacola = new String[1000];
	
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
				
	    janela.setLayout(null);
	    janela.add(titulo);
	    janela.add(listaAcessoriosSacola);
	    janela.add(listaRoupasSacola);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setSize(400, 350);
		janela.setVisible(true);
		
		listaAcessoriosSacola.addListSelectionListener(this);
		listaRoupasSacola.addListSelectionListener(this);
	}
	
	//Detalhes dos produtos
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaAcessoriosSacola) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 1, 3, 
					listaAcessoriosSacola.getSelectedIndex());
		}
		
		if(e.getValueIsAdjusting() && src == listaRoupasSacola) {
			new TelaDetalheProduto().cadastrarEditarProduto(dados, 2, 3, 
					listaRoupasSacola.getSelectedIndex());
		}
	}
}
