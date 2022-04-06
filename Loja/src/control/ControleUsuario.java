package control;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
		if(!dadosUsuario[2].matches("[0-9]+") || !dadosUsuario[2].matches("[0-9]+") || 
				!dadosUsuario[8].matches("[0-9]+") || !dadosUsuario[9].matches("[0-9]+")) {
			return false;
		}else {
			Usuario user = new Usuario(dadosUsuario[0], dadosUsuario[1], Long.parseLong(dadosUsuario[2]), Long.parseLong(dadosUsuario[3]), dadosUsuario[4], 
					dadosUsuario[5], dadosUsuario[6], dadosUsuario[7], Integer.parseInt(dadosUsuario[8]), Integer.parseInt(dadosUsuario[9]), dadosUsuario[10]);
		
			ControleDados.getD().getUsuarios().add(user);
			
			return true;
		}
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
	
	//Coloca todos os produtos da Sacola em Produtos comprados do Comprador
	public void finalizarCompra() {
		//Remove o acessorio comprado dos Acessorios A Venda do vendedor
		for(int i = 0; i < ControleDados.getD().getAcessoriosAVenda().size(); i++){
			for(int j = 0; j < ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); j++){
				if(ControleDados.getD().getAcessoriosAVenda().get(i) ==
				ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(j)) {
					
					//Tira os acessorios comprados de Acessorios A Venda
					ControleDados.getD().getAcessoriosAVenda().remove(i);
				}
			}
		}
		
		//Remove a roupa comprada das Roupas A Venda do vendedor
		for(int k = 0; k < ControleDados.getD().getRoupasAVenda().size(); k++){
			for(int l = 0; l < ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); l++){
				if(ControleDados.getD().getRoupasAVenda().get(k) ==
				ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(l)) {
					
					//Tira as roupas compradas de Roupas Venda
			    	ControleDados.getD().getRoupasAVenda().remove(k);
				}
			}
		}
				
		//Coloca todos os acessorios nos acessorios comprados do usuario
    	for(int i = 0; i <  ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); i++){
    		ControleDados.getD().getAcessoriosComprados().add
    		(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(i));
    	}
    	
    	//Coloca todas as roupas nas roupas compradas do usuario
    	for(int i = 0; i <  ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); i++){
    		ControleDados.getD().getRoupasCompradas().add
    		(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(i));
    	}
    	
    	esvaziarSacola();
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

}