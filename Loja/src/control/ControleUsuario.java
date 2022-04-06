package control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;

public class ControleUsuario {
	
	private Usuario up = new Usuario();
	private ArrayList<Usuario> u = new ArrayList<>();
	
	public ControleUsuario(ControleDados d) {
		up = d.getUsuarioPrincipal();
		u = d.getUsuarios();
	}
	
	//Define o usuario principal
	public void selecionaUsuarioPrincipal(Usuario usuarioPrincipal) {
		
		ControleDados.getD().setUsuarioPrincipal(usuarioPrincipal);
	
	}
	
	//Realiza o cadastro de um novo usuario
	public boolean cadastrarUsuario(String[] dadosUsuario) {
		if(!dadosUsuario[2].matches("[0-9]+") || !dadosUsuario[3].matches("[0-9]+") || 
				!dadosUsuario[8].matches("[0-9]+") || !dadosUsuario[9].matches("[0-9]+")) {
			return false;
		}
		if(dadosUsuario[0].isEmpty() || dadosUsuario[1].isEmpty() || dadosUsuario[2].isEmpty() || dadosUsuario[3].isEmpty() || dadosUsuario[4].isEmpty() || dadosUsuario[5].isEmpty() ||
				dadosUsuario[6].isEmpty() || dadosUsuario[7].isEmpty() || dadosUsuario[8].isEmpty() || dadosUsuario[9].isEmpty() || dadosUsuario[10].isEmpty()){
			return false;
		}
		if(!dadosUsuario[0].matches("[A-Za-z ]+") || !dadosUsuario[5].matches("[A-Za-z ]+") || !dadosUsuario[6].matches("[A-Za-z ]+") || !dadosUsuario[7].matches("[A-Za-z ]+")){
			return false;
		}
		if(!dadosUsuario[4].contains("@")){
			return false;			
		}
				
		for(int i = 0; i < ControleDados.getD().getUsuarios().size(); i++) {
		
			if(ControleDados.getD().getUsuarios().get(i).getEmail().equals(dadosUsuario[4])) {
				mensagemEmailExistente();
				return false;
			}
			
		}
			
		Usuario user = new Usuario(dadosUsuario[0], dadosUsuario[1], Long.parseLong(dadosUsuario[2]), Long.parseLong(dadosUsuario[3]), dadosUsuario[4], 
				dadosUsuario[5], dadosUsuario[6], dadosUsuario[7], Integer.parseInt(dadosUsuario[8]), Integer.parseInt(dadosUsuario[9]), dadosUsuario[10]);
	
		ControleDados.getD().getUsuarios().add(user);
		
		return true;
		
		
	}
	
	//Salva a edicao de um usuario ja existente
	public boolean salvarUsuario(String[] dadosUsuario) {		
		if(!dadosUsuario[2].matches("[0-9]+") || !dadosUsuario[2].matches("[0-9]+") || 
				!dadosUsuario[8].matches("[0-9]+") || !dadosUsuario[9].matches("[0-9]+")) {
			return false;
		}else {
			Usuario user = new Usuario(dadosUsuario[0], dadosUsuario[1], Long.parseLong(dadosUsuario[2]), Long.parseLong(dadosUsuario[3]), dadosUsuario[4], 
					dadosUsuario[5], dadosUsuario[6], dadosUsuario[7], Integer.parseInt(dadosUsuario[8]), Integer.parseInt(dadosUsuario[9]), dadosUsuario[10]);
		
			ControleDados.getD().setUsuarioPrincipal(user);
			
			return true;
		}
		
	}
	
	//Deleta um usuario ja existente
	public void excluirUsuario() {
		int UsuarioSelecionado = -1;	
		//Procuro pelo usuario principal em meu arraylist
		for(int i = 0; i < u.size(); i++) {
			if( u.get(i).getEmail().equals(up.getEmail())) {
				UsuarioSelecionado = i;	
			}
		}
		u.remove(UsuarioSelecionado);
	}
	
	//Adiciona um acessorio na sacola do usuario principal
	public void adicionarAcessorioNaSacola(Acessorio acessorioNovo) {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().add(acessorioNovo);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() + acessorioNovo.getPreco()); 
		
	}
	
	//Adiciona uma roupa na sacola do usuario principal
	public void adicionarRoupaNaSacola(Roupa roupaNova) {
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().add(roupaNova);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() + roupaNova.getPreco()); 
	}
	
	//Retira um acessorio na sacola do usuario principal
	public void retirarAcessorioNaSacola(Acessorio acessorioExcluido) {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().remove(acessorioExcluido);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() - acessorioExcluido.getPreco()); 
		
	}
	
	//Retira uma roupa na sacola do usuario principal
	public void retirarRoupaNaSacola(Roupa roupaExcluida) {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().remove(roupaExcluida);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() - roupaExcluida.getPreco()); 
		
	}	
	
	//Limpa os dados da Sacola para acessorios e da Sacola para roupas do usuario principal
	public void  esvaziarSacola() {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().clear();
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().clear();
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(0); 
		
	}	
	
	//Gets e Sets
	public Usuario getUp() {
		return up;
	}

	public void setUp(Usuario up) {
		this.up = up;
	}

	public ArrayList<Usuario> getU() {
		return u;
	}

	public void setU(ArrayList<Usuario> u) {
		this.u = u;
	}
	
	public String getNomeUP() { 
		return up.getNome();
	}
	
	public String getSenhaUP() { 
		return up.getSenha();
	}

	public long getTelefoneUP() {
		return up.getTelefone();
	}

	public long getCpfUP() {
		return up.getCpf();
	}

	public String getEmailUP() {
		return up.getEmail();
	}
	
	public ArrayList<Endereco> getEnderecosUP() {
		return up.getEnderecos();
	}
	
	//retorna o endereco i do usuario principal
	public Endereco getEnderecoUP(int i) {
		return up.getEndereco(i);
	}
	
	public SacolaDeCompra getSacolaUsuarioUP() {
		return up.getSacolausuario();
	}
	
	public String getNome(int i) { 
		return u.get(i).getNome();
	}
	
	public String getSenha(int i) { 
		return u.get(i).getSenha();
	}

	public long getTelefone(int i) {
		return u.get(i).getTelefone();
	}

	public long getCpf(int i) {
		return u.get(i).getCpf();
	}

	public String getEmail(int i) {
		return u.get(i).getEmail();
	}
	
	public ArrayList<Endereco> getEnderecos(int i) {
		return u.get(i).getEnderecos();
	}
	
	//retorna o endereco j do usuario i
	public Endereco getEndereco(int i, int j) {
		return u.get(i).getEndereco(j);
	}
	
	public SacolaDeCompra getSacolaUsuario(int i) {
		return u.get(i).getSacolausuario();
	}
	
	public void mensagemEmailExistente() {
		JOptionPane.showMessageDialog(null,"Erro ao salvar os dados!\n "
				+ "Este email ja existe, tente outro\n", null, 
				JOptionPane.WARNING_MESSAGE);
	}

}