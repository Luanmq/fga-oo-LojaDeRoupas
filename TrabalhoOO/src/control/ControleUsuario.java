package control;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;

/**
 * Controla as variáveis relacionadas a usuários presentes na classe Dados
 * @author Luan Melo
 * @author Lucas
 */

public class ControleUsuario {
	
	private Usuario up = new Usuario();
	private ArrayList<Usuario> u = new ArrayList<>();
	
	/**
	 * Construtor do ControleUsuario, inicializando os dados os dados relacionadas a usuário presentes
	 *  na classe Dados
	 * @param d Instância de Controle de Dados já usada em outra parte do código
	 */
	public ControleUsuario(ControleDados d) {
		up = d.getUsuarioPrincipal();
		u = d.getUsuarios();
	}
	
	/**
	 * Define o usuário principal
	 * @param usuarioPrincipal usuário que será o principal (logado no sistema)
	 */
	public void selecionaUsuarioPrincipal(Usuario usuarioPrincipal) {
		ControleDados.getD().setUsuarioPrincipal(usuarioPrincipal);
	}
	
	/**
	 * Realiza o cadastro de um novo endereço
	 * @param dadosEndereco dados referentes ao endereço
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean cadastrarEndereco(String[] dadosEndereco) {
		if(dadosEndereco[5].isEmpty() || dadosEndereco[6].isEmpty() || dadosEndereco[7].isEmpty() || dadosEndereco[8].isEmpty() || dadosEndereco[9].isEmpty() || dadosEndereco[10].isEmpty()){
			return false;
		}
		if(!dadosEndereco[8].matches("[0-9]+") || !dadosEndereco[9].matches("[0-9]+")) {
			return false;
		}
		if(!dadosEndereco[5].matches("[A-Za-z ]+") || !dadosEndereco[6].matches("[A-Za-z ]+") || !dadosEndereco[7].matches("[A-Za-z ]+")){
			return false;
		}
		
		Endereco endereco = new Endereco(dadosEndereco[5], dadosEndereco[6], dadosEndereco[7], Long.parseLong(dadosEndereco[8]), Long.parseLong(dadosEndereco[9]),dadosEndereco[10]);
		up.getEnderecos().add(endereco);
		
		System.out.println(up.getEnderecos());
		return true;
	}
	
	/**
	 * Salva as edições feitas no endereço
	 * @param dadosUsuario dados referentes ao endereço
	 * @param posicao posição do endereço do usuário
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean salvarEndereco(String[] dadosUsuario, int posicao) {
		if(dadosUsuario[5].isEmpty() || dadosUsuario[6].isEmpty() || dadosUsuario[7].isEmpty() || dadosUsuario[8].isEmpty() || dadosUsuario[9].isEmpty() || dadosUsuario[10].isEmpty()){
			return false;
		}
		if(!dadosUsuario[8].matches("[0-9]+") || !dadosUsuario[9].matches("[0-9]+")) {
			return false;
		}
		if(!dadosUsuario[5].matches("[A-Za-z ]+") || !dadosUsuario[6].matches("[A-Za-z ]+") || !dadosUsuario[7].matches("[A-Za-z ]+")){
			return false;
		}
		
		ControleDados.getD().getUsuarioPrincipal().getEnderecos().get(posicao).setPais(dadosUsuario[5]);
		ControleDados.getD().getUsuarioPrincipal().getEnderecos().get(posicao).setEstado(dadosUsuario[6]);
		ControleDados.getD().getUsuarioPrincipal().getEnderecos().get(posicao).setCidade(dadosUsuario[7]);
		ControleDados.getD().getUsuarioPrincipal().getEnderecos().get(posicao).setNumeroResidencia(Long.parseLong(dadosUsuario[8]));
		ControleDados.getD().getUsuarioPrincipal().getEnderecos().get(posicao).setCep(Long.parseLong(dadosUsuario[9]));
		ControleDados.getD().getUsuarioPrincipal().getEnderecos().get(posicao).setReferencia(dadosUsuario[10]);

		return true;
	}


	/**
	 * Realiza o cadastro de um novo usuario
	 * @param dadosUsuario dados referentes ao usuario
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean cadastrarUsuario(String[] dadosUsuario) {
		if(dadosUsuario[0].isEmpty() || dadosUsuario[1].isEmpty() || dadosUsuario[2].isEmpty() || dadosUsuario[3].isEmpty() || dadosUsuario[4].isEmpty()){
			return false;
		}
		if(!dadosUsuario[2].matches("[0-9]+") || !dadosUsuario[3].matches("[0-9]+")) {
			return false;
		}
		if(!dadosUsuario[0].matches("[A-Za-z ]+")){
			return false;
		}
		if(!dadosUsuario[4].contains("@")){
			return false;			
		}
		if(!dadosUsuario[4].equals(up.getEmail())){
			for(int i = 0; i < ControleDados.getD().getUsuarios().size(); i++) {
				if(ControleDados.getD().getUsuarios().get(i).getEmail().equals(dadosUsuario[4])) {
					mensagemEmailExistente();
					return false;
				}
			}
		}
			
		Usuario user = new Usuario(dadosUsuario[0], dadosUsuario[1], Long.parseLong(dadosUsuario[2]), Long.parseLong(dadosUsuario[3]), dadosUsuario[4]);
		u.add(user);
		return true;
	}
	
	/**
	 * Salva as edições feitas no usuário
	 * @param dadosUsuario dados referentes ao usuario
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean salvarUsuario(String[] dadosUsuario) {
		if(dadosUsuario[0].isEmpty() || dadosUsuario[1].isEmpty() || dadosUsuario[2].isEmpty() || dadosUsuario[3].isEmpty() || dadosUsuario[4].isEmpty()){
			return false;
		}
		if(!dadosUsuario[2].matches("[0-9]+") || !dadosUsuario[3].matches("[0-9]+")) {
			return false;
		}
		if(!dadosUsuario[0].matches("[A-Za-z ]+")){
			return false;
		}
		if(!dadosUsuario[4].contains("@")){
			return false;			
		}
		if(!dadosUsuario[4].equals(up.getEmail())){
			for(int i = 0; i < ControleDados.getD().getUsuarios().size(); i++) {
				if(ControleDados.getD().getUsuarios().get(i).getEmail().equals(dadosUsuario[4])) {
					mensagemEmailExistente();
					return false;
				}
			}
		}
			
		ControleDados.getD().getUsuarioPrincipal().setNome(dadosUsuario[0]);
		ControleDados.getD().getUsuarioPrincipal().setSenha(dadosUsuario[1]);
		ControleDados.getD().getUsuarioPrincipal().setTelefone(Long.parseLong(dadosUsuario[2]));
		ControleDados.getD().getUsuarioPrincipal().setCpf(Long.parseLong(dadosUsuario[3]));
		ControleDados.getD().getUsuarioPrincipal().setEmail(dadosUsuario[4]);

		return true;
	}
	
	/**
	 * Deleta um usuário já existente
	 */
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
	
	/**
	 * Adiciona um acessório na sacola do usuario principal (usuário logado)
	 * @param acessorioNovo acessório a ser adicionado
	 */
	public void adicionarAcessorioNaSacola(Acessorio acessorioNovo) {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().add(acessorioNovo);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() + acessorioNovo.getPreco()); 
		
	}
	
	/**
	 * Adiciona uma roupa na sacola do usuario principal (usuário logado)
	 * @param roupaNova roupa a ser adicionada
	 */
	public void adicionarRoupaNaSacola(Roupa roupaNova) {
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().add(roupaNova);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() + roupaNova.getPreco()); 
	}
	
	/**
	 * Retira um acessorio na sacola do usuario principal v
	 * @param acessorioExcluido acessório a ser excluído
	 */
	public void retirarAcessorioNaSacola(Acessorio acessorioExcluido) {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().remove(acessorioExcluido);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() - acessorioExcluido.getPreco()); 
		
	}
	
	/**
	 * Retira uma roupa na sacola do usuario principal v
	 * @param roupaExcluida roupa a ser excluída
	 */
	public void retirarRoupaNaSacola(Roupa roupaExcluida) {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().remove(roupaExcluida);
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getValorTotal() - roupaExcluida.getPreco()); 
		
	}	
	
	/**
	 * Limpa os dados da Sacola para acessórios e da Sacola para roupas do usuário principal (usuário logado)
	 */
	public void  esvaziarSacola() {

		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().clear();
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().clear();
		ControleDados.getD().getUsuarioPrincipal().getSacolausuario().setValorTotal(0); 
	}
	
	/**
	 * Coloca todos os produtos da Sacola em Produtos comprados do Comprador
	 */
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
	
	public void mensagemEmailExistente() {
		JOptionPane.showMessageDialog(null,"Erro ao salvar os dados!\n "
				+ "Este email ja existe, tente outro\n", null, 
				JOptionPane.WARNING_MESSAGE);
	}

}