package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaLoginCadastroUsuarios implements ActionListener, ListSelectionListener{
	private JFrame janela;
	private JLabel titulo;
	private JLabel legenda;

	private JButton cadastrarUsuario;
	private JButton selecionarUsuario;
	private JButton atualizarLista;
	private JList<String> listaUsuariosCadastrados = new JList<String>();
	private String[] arrayNomesUsuariosCadastrados = new String[1000];

	public TelaLoginCadastroUsuarios() {
		janela = new JFrame("Usuarios");
		titulo = new JLabel("Usuarios");
		legenda = new JLabel("Selecione ou Cadastre um Usuario para Login");

		cadastrarUsuario = new JButton("Cadastrar");
		selecionarUsuario = new JButton ("Selecionar");
		atualizarLista = new JButton ("Atualizar");
		
		//Adiciona o nome de todos os usuarios ao array
		for(int i = 0; i < Dados.usuarios.size(); i++) {
			arrayNomesUsuariosCadastrados[i] = Dados.usuarios.get(i).getNome();
		}
		
		listaUsuariosCadastrados = new JList<String>(arrayNomesUsuariosCadastrados);
			  
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 10, 250, 30);
		legenda.setFont(new Font("Arial", Font.PLAIN, 12));
		legenda.setBounds(70, 30, 250, 30);
		
		listaUsuariosCadastrados.setBounds(20, 60, 350, 120);
		listaUsuariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaUsuariosCadastrados.setVisibleRowCount(10);
		
		cadastrarUsuario.setBounds(25, 187, 100, 30);
		selecionarUsuario.setBounds(145, 187, 100, 30);
		atualizarLista.setBounds(265, 187, 100, 30);

		janela.setLayout(null);
		janela.add(titulo);
		janela.add(legenda);
		janela.add(listaUsuariosCadastrados);
		janela.add(cadastrarUsuario);
		janela.add(selecionarUsuario);
		janela.add(atualizarLista);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.setSize(400, 260);
		janela.setVisible(true);

		cadastrarUsuario.addActionListener(this);
		selecionarUsuario.addActionListener(this);
		atualizarLista.addActionListener(this);
		listaUsuariosCadastrados.addListSelectionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo usuario
		if(src == cadastrarUsuario)
			new TelaDetalhesUsuario().cadastrarEditarUsuario(1, 0);

		//Seleciona um usuario para logar
		if(src == selecionarUsuario)
			if(listaUsuariosCadastrados.getSelectedIndex() == -1) {
				mensagemErroSelecionar();
			}else {
				 Dados.usuarioPrincipal = Dados.usuarios.get(listaUsuariosCadastrados.getSelectedIndex());
				 mensagemSucessoSelecionar();
				 janela.dispose();
				 TelaMenu menu = new TelaMenu();
			}
		
		// Atualiza a lista de nomes de usuarios
		if(src == atualizarLista) {
			//Adiciona o nome de todos os usuarios ao array de nomes
			for(int i = 0; i < Dados.usuarios.size(); i++)
				arrayNomesUsuariosCadastrados[i] = Dados.usuarios.get(i).getNome();
			
			listaUsuariosCadastrados.setListData((arrayNomesUsuariosCadastrados));
			listaUsuariosCadastrados.updateUI();
		}
	}
	
	//Eventos relacionados ao arraylist
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		//Chama a tela de detalhes passando o usuario clicado pelo index da lista
		if(e.getValueIsAdjusting() && src == listaUsuariosCadastrados) {
			new TelaDetalhesUsuario().cadastrarEditarUsuario(2, 
					listaUsuariosCadastrados.getSelectedIndex());
		}
	}
	
	public void mensagemErroSelecionar() {
		JOptionPane.showMessageDialog(null, "Houve um erro ao selecionar um Usuario", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemSucessoSelecionar() {
		JOptionPane.showMessageDialog(null, "O Login foi feito com " + Dados.usuarios.get(listaUsuariosCadastrados.getSelectedIndex()).getNome(), null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
}
