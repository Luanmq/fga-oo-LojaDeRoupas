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
	
	private Usuario usuarioPrincipal = new Usuario();
	private ArrayList<Usuario> usuarios = new ArrayList<>();
	
	/**
	 * Construtor do ControleUsuario, inicializando os dados relacionadas a usuário presentes
	 *  na classe Dados
	 * @param d Instância de Controle de Dados já usada em outra parte do código
	 */
	public ControleUsuario(ControleDados d) {
		usuarioPrincipal = d.getUsuarioPrincipal();
		usuarios = d.getUsuarios();
	}
	
	public ControleUsuario() {
	}

	/**
	 * Define o usuário principal
	 * @param usuarioPrincipal usuário que será o principal (logado no sistema)
	 */
	public void selecionaUsuarioPrincipal(Usuario usuarioPrincipal) {
		ControleDados.getDados().setUsuarioPrincipal(usuarioPrincipal);
	}
	
	/**
	 * Realiza o cadastro de um novo endereço
	 * @param dadosUsuario dados referentes ao novo endereço
	 * @param user usuário no qual o endereço será cadastrado
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean cadastrarEndereco(String[] dadosUsuario, Usuario user) {
		if(dadosUsuario[5] == null || dadosUsuario[6] == null || dadosUsuario[7] == null || dadosUsuario[8] == null || dadosUsuario[9] == null || dadosUsuario[10] == null){
			return false;
		}
		if(!dadosUsuario[8].matches("[0-9]+") || !dadosUsuario[9].matches("[0-9]+")) {
			return false;
		}
		if(!dadosUsuario[5].matches("[A-Za-z ]+") || !dadosUsuario[6].matches("[A-Za-z ]+") || !dadosUsuario[7].matches("[A-Za-z ]+")){
			return false;
		}
		
		Endereco endereco = new Endereco(dadosUsuario[5], dadosUsuario[6], dadosUsuario[7], Long.parseLong(dadosUsuario[8]), Long.parseLong(dadosUsuario[9]),dadosUsuario[10], user);
		user.getEnderecos().add(endereco);
		
		return true;
	}
	
	/**
	 * Salva as edições feitas no endereço
	 * @param dadosUsuario novos dados referentes ao endereço
	 * @param posicao posição do endereço do no array do usuário
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean salvarEndereco(String[] dadosUsuario, int posicao) {
		if(dadosUsuario[5] == null || dadosUsuario[6] == null || dadosUsuario[7] == null || dadosUsuario[8] == null || dadosUsuario[9] == null || dadosUsuario[10] == null){
			return false;
		}
		if(!dadosUsuario[8].matches("[0-9]+") || !dadosUsuario[9].matches("[0-9]+")) {
			return false;
		}
		if(!dadosUsuario[5].matches("[A-Za-z ]+") || !dadosUsuario[6].matches("[A-Za-z ]+") || !dadosUsuario[7].matches("[A-Za-z ]+")){
			return false;
		}
		
		ControleDados.getDados().getUsuarioPrincipal().getEnderecos().get(posicao).setPais(dadosUsuario[5]);
		ControleDados.getDados().getUsuarioPrincipal().getEnderecos().get(posicao).setEstado(dadosUsuario[6]);
		ControleDados.getDados().getUsuarioPrincipal().getEnderecos().get(posicao).setCidade(dadosUsuario[7]);
		ControleDados.getDados().getUsuarioPrincipal().getEnderecos().get(posicao).setNumeroResidencia(Long.parseLong(dadosUsuario[8]));
		ControleDados.getDados().getUsuarioPrincipal().getEnderecos().get(posicao).setCep(Long.parseLong(dadosUsuario[9]));
		ControleDados.getDados().getUsuarioPrincipal().getEnderecos().get(posicao).setReferencia(dadosUsuario[10]);

		return true;
	}

	/**
	 * Realiza o cadastro de um novo usuario
	 * @param dadosUsuario dados referentes ao usuario
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean cadastrarUsuario(String[] dadosUsuario) {
		if(dadosUsuario[0] == null || dadosUsuario[1] == null || dadosUsuario[2] == null || dadosUsuario[3] == null || dadosUsuario[4] == null){
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
		if(!dadosUsuario[4].equals(usuarioPrincipal.getEmail())){
			for(int i = 0; i < ControleDados.getDados().getUsuarios().size(); i++) {
				if(ControleDados.getDados().getUsuarios().get(i).getEmail().equals(dadosUsuario[4])) {
					mensagemEmailExistente();
					return false;
				}
			}
		}
			
		Usuario user = new Usuario(dadosUsuario[0], dadosUsuario[1], Long.parseLong(dadosUsuario[2]), Long.parseLong(dadosUsuario[3]), dadosUsuario[4]);
		boolean auxiliar = cadastrarEndereco(dadosUsuario, user);
		
		if(auxiliar == true) {
			ControleDados.getDados().getUsuarios().add(user);
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * Salva as edições feitas no usuário
	 * @param dadosUsuario novos dados referentes ao usuario
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean salvarUsuario(String[] dadosUsuario) {
		if(dadosUsuario[0] == null || dadosUsuario[1] == null || dadosUsuario[2] == null || dadosUsuario[3] == null || dadosUsuario[4] == null){
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
		if(!dadosUsuario[4].equals(usuarioPrincipal.getEmail())){
			for(int i = 0; i < ControleDados.getDados().getUsuarios().size(); i++) {
				if(ControleDados.getDados().getUsuarios().get(i).getEmail().equals(dadosUsuario[4])) {
					mensagemEmailExistente();
					return false;
				}
			}
		}
			
		ControleDados.getDados().getUsuarioPrincipal().setNome(dadosUsuario[0]);
		ControleDados.getDados().getUsuarioPrincipal().setSenha(dadosUsuario[1]);
		ControleDados.getDados().getUsuarioPrincipal().setTelefone(Long.parseLong(dadosUsuario[2]));
		ControleDados.getDados().getUsuarioPrincipal().setCpf(Long.parseLong(dadosUsuario[3]));
		ControleDados.getDados().getUsuarioPrincipal().setEmail(dadosUsuario[4]);

		return true;
	}
	
	/**
	 * Deleta um usuário já existente
	 */
	public void excluirUsuario() {
		int UsuarioSelecionado = -1;	
		//Procuro pelo usuario principal em meu arraylist
		for(int i = 0; i < usuarios.size(); i++) {
			if( usuarios.get(i).getEmail().equals(usuarioPrincipal.getEmail())) {
				UsuarioSelecionado = i;	
			}
		}
		
		//Remove o usuario selecionado, seus produtos a venda e seus produtos comprados
		usuarios.remove(UsuarioSelecionado);
	}
	
	/**
	 * Adiciona um acessório na sacola do usuário principal (usuário logado)
	 * @param acessorioNovo acessório a ser adicionado na sacola
	 */
	public void adicionarAcessorioNaSacola(Acessorio acessorioNovo) {

		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().add(acessorioNovo);
		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getValorTotal() + acessorioNovo.getPreco()); 
		
	}
	
	/**
	 * Adiciona uma roupa na sacola do usuário principal (usuário logado)
	 * @param roupaNova roupa a ser adicionada na sacola
	 */
	public void adicionarRoupaNaSacola(Roupa roupaNova) {
		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().add(roupaNova);
		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getValorTotal() + roupaNova.getPreco()); 
	}
	
	/**
	 * Retira um acessório da sacola do usuario principal
	 * @param acessorioExcluido acessório a ser excluído
	 */
	public void retirarAcessorioNaSacola(Acessorio acessorioExcluido) {

		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().remove(acessorioExcluido);
		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getValorTotal() - acessorioExcluido.getPreco()); 
	}
	
	/**
	 * Retira uma roupa na sacola do usuario principal
	 * @param roupaExcluida roupa a ser excluída
	 */
	public void retirarRoupaNaSacola(Roupa roupaExcluida) {

		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().remove(roupaExcluida);
		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().setValorTotal(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getValorTotal() - roupaExcluida.getPreco()); 
		
	}	
	
	/**
	 * Limpa os dados da Sacola para acessórios e da Sacola para roupas do usuário principal (usuário logado)
	 */
	public void  esvaziarSacola() {

		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().clear();
		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().clear();
		ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().setValorTotal(0); 
	}
	
	/**
	 * Coloca todos os produtos da Sacola em Produtos comprados do Comprador
	 */
	public void finalizarCompra() {
		//Remove o acessorio comprado dos Acessorios A Venda do vendedor
		for(int i = 0; i < ControleDados.getDados().getAcessoriosAVenda().size(); i++){
			for(int j = 0; j < ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); j++){
				if(ControleDados.getDados().getAcessoriosAVenda().get(i) ==
				ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(j)) {
					
					//Tira os acessorios comprados de Acessorios A Venda
					ControleDados.getDados().getAcessoriosAVenda().remove(i);
					break;
				}
			}
		}
		
		//Remove a roupa comprada das Roupas A Venda do vendedor
		for(int k = 0; k < ControleDados.getDados().getRoupasAVenda().size(); k++){
			for(int l = 0; l < ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); l++){
				if(ControleDados.getDados().getRoupasAVenda().get(k) ==
				ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(l)) {
					
					//Tira as roupas compradas de Roupas Venda
			    	ControleDados.getDados().getRoupasAVenda().remove(k);
			    	break;
				}
			}
		}
				
		//Coloca todos os acessorios nos acessorios comprados do usuario
    	for(int i = 0; i <  ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); i++){
    		ControleDados.getDados().getAcessoriosComprados().add
    		(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(i));
    	}
    	
    	//Coloca todas as roupas nas roupas compradas do usuario
    	for(int i = 0; i <  ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); i++){
    		ControleDados.getDados().getRoupasCompradas().add
    		(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(i));
    	}
    	
    	esvaziarSacola();
	}
	
	//Gets e Sets
	public Usuario getUsuarioPrincipal() {
		return usuarioPrincipal;
	}

	public void setUsuarioPrincipal(Usuario usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public String getNomeUsuarioPrincipal() { 
		return usuarioPrincipal.getNome();
	}

	public String getSenhaUsuarioPrincipal() { 
		return usuarioPrincipal.getSenha();
	}

	public long getTelefoneUsuarioPrincipal() {
		return usuarioPrincipal.getTelefone();
	}

	public long getCpfUsuarioPrincipal() {
		return usuarioPrincipal.getCpf();
	}

	public String getEmailUsuarioPrincipal() {
		return usuarioPrincipal.getEmail();
	}

	public ArrayList<Endereco> getEnderecosUsuarioPrincipal() {
		return usuarioPrincipal.getEnderecos();
	}

	//retorna o endereco i do usuario principal
	public Endereco getEnderecoUsuarioPrincipal(int i) {
		return usuarioPrincipal.getEndereco(i);
	}

	public SacolaDeCompra getSacolaUsuarioUsuarioPrincipal() {
		return usuarioPrincipal.getSacolausuario();
	}

	public String getNome(int i) {
		return usuarios.get(i).getNome();
	}

	public String getSenha(int i) { 
		return usuarios.get(i).getSenha();
	}

	public long getTelefone(int i) {
		return usuarios.get(i).getTelefone();
	}

	public long getCpf(int i) {
		return usuarios.get(i).getCpf();
	}

	public String getEmail(int i) {
		return usuarios.get(i).getEmail();
	}

	public ArrayList<Endereco> getEnderecos(int i) {
		return usuarios.get(i).getEnderecos();
	}

	//retorna o endereco j do usuario i
	public Endereco getEndereco(int i, int j) {
		return usuarios.get(i).getEndereco(j);
	}

	public SacolaDeCompra getSacolaUsuario(int i) {
		return usuarios.get(i).getSacolausuario();
	}

	public void mensagemEmailExistente() {
		JOptionPane.showMessageDialog(null,"Erro ao salvar os dados!\n "
				+ "Este email ja existe, tente outro\n", null, 
				JOptionPane.WARNING_MESSAGE);
	}

}