package control;

import java.util.ArrayList;

import model.*;

/**
 * Controla as variáveis relacionadas a acessório na classe Dados
 * @author Luan Melo
 * @author Lucas
 */

public class ControleAcessorio {

	private ArrayList<Acessorio> acessoriosComprados = new ArrayList<>();
	private ArrayList<Acessorio> acessoriosAVenda = new ArrayList<>();

	/**
	 * Construtor do ControleAcessorio, inicializando os dados os dados relacionadas a acessório presentes
	 * @param d Instância de Controle de Dados já usada em outra parte do código
	 */
	public ControleAcessorio (ControleDados d) {		
		acessoriosComprados = d.getAcessoriosComprados();
		acessoriosAVenda = d.getAcessoriosAVenda();
	}
	/**
	 * Construtor do ControleAcessorio
	 */
	public ControleAcessorio() {
	}

	/**
	 * Coloca um acessório a venda e verifica se seus dados são válidos
	 * @param dadosAcessorio dados referente a acessório
	 * @param usuario usuário que possui o acessório
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean cadastrarAcessorio(String[] dadosAcessorio, Usuario usuario) {
		if(dadosAcessorio[0] == null || dadosAcessorio[1] == null || dadosAcessorio[2] == null || dadosAcessorio[3] == null || dadosAcessorio[4] == null || dadosAcessorio[5] == null ||
				dadosAcessorio[6] == null || dadosAcessorio[7] == null || dadosAcessorio[8] == null || dadosAcessorio[9] == null || dadosAcessorio[10] == null){
			return false;
		}
		if(!dadosAcessorio[4].matches("[0-9.]+") || !dadosAcessorio[8].matches("[0-9.]+") || 
				!dadosAcessorio[9].matches("[0-9.]+") || !dadosAcessorio[10].matches("[0-9.]+")) {
			return false;
		}
		if(!dadosAcessorio[0].matches("[A-Za-z ]+") || !dadosAcessorio[6].matches("[A-Za-z ]+") ){
			return false;
		}

		Acessorio accessorio = new Acessorio (dadosAcessorio[0], dadosAcessorio[1], dadosAcessorio[2], dadosAcessorio[3], Double.parseDouble(dadosAcessorio[4]), 
				dadosAcessorio[5], dadosAcessorio[6], usuario, dadosAcessorio[7], Double.parseDouble(dadosAcessorio[8]), Double.parseDouble(dadosAcessorio[9]), Double.parseDouble(dadosAcessorio[10]));

		accessorio.setImagem("img/Placeholder.png");

		ControleDados.getDados().getAcessoriosAVenda().add(accessorio);

		return true;
	}

	/**
	 * Salva os dados editados de um acessório
	 * @param dadosAcessorio dados referente ao acessório
	 * @param usuario usuário que possui o acessório
	 * @param posicao posição do acessório no array AcessoriosAVenda
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean salvarAcessorio(String[] dadosAcessorio, Usuario usuario, int posicao) {
		if(dadosAcessorio[0] == null || dadosAcessorio[1] == null || dadosAcessorio[2] == null || dadosAcessorio[3] == null || dadosAcessorio[4] == null || dadosAcessorio[5] == null ||
				dadosAcessorio[6] == null || dadosAcessorio[7] == null || dadosAcessorio[8] == null || dadosAcessorio[9] == null || dadosAcessorio[10] == null){
			return false;
		}
		if(!dadosAcessorio[4].matches("[0-9]+") || !dadosAcessorio[8].matches("[0-9]+") || 
				!dadosAcessorio[9].matches("[0-9]+") || !dadosAcessorio[10].matches("[0-9]+")) {
			return false;
		}
		if(!dadosAcessorio[0].matches("[A-Za-z ]+") || !dadosAcessorio[6].matches("[A-Za-z ]+") ){
			return false;
		}

		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setNome(dadosAcessorio[0]);
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setDepartamento(dadosAcessorio[1]);
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setDescricao(dadosAcessorio[2]);
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setMarca(dadosAcessorio[3]);
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setPreco(Double.parseDouble(dadosAcessorio[4]));
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setCondicao(dadosAcessorio[5]);
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setCor(dadosAcessorio[6]);

		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setMaterial(dadosAcessorio[7]);
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setPeso(Double.parseDouble(dadosAcessorio[8]));
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setMedidaLargura(Double.parseDouble(dadosAcessorio[9]));
		ControleDados.getDados().getAcessoriosAVenda().get(posicao).setMedidaAltura(Double.parseDouble(dadosAcessorio[10]));

		return true;
	}

	/**
	 * Deleta um acessório já existente
	 * @param posicao posição do acessório no array AcessoriosAVenda
	 */
	public void excluirAcessorio(int posicao) {
		for(int i = 0; i < ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); i++){
			if(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(i) ==
			ControleDados.getDados().getAcessoriosAVenda().get(posicao)) {
				//Tira as roupas compradas de Roupas Venda
				ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().remove(i);
			}
		}

		ControleDados.getDados().getAcessoriosAVenda().remove(posicao);	
	}

	//Gets e sets
	public ArrayList<Acessorio> getAc() {
		return acessoriosComprados;
	}

	public void setAc(ArrayList<Acessorio> acessoriosComprados) {
		this.acessoriosComprados = acessoriosComprados;
	}

	public ArrayList<Acessorio> getAv() {
		return acessoriosAVenda;
	}

	public void setAv(ArrayList<Acessorio> acessoriosAVenda) {
		this.acessoriosAVenda = acessoriosAVenda;
	}

	public String getNomeAC(int i) {
		return acessoriosComprados.get(i).getNome();
	}

	public String getDepartamentoAC(int i) {
		return acessoriosComprados.get(i).getDepartamento();
	}

	public String getDescricaoAC(int i) {
		return acessoriosComprados.get(i).getDescricao();
	}

	public String getMarcaAC(int i) {
		return acessoriosComprados.get(i).getMarca();
	}

	public Double getPrecoAC(int i) {
		return acessoriosComprados.get(i).getPreco();
	}

	public String getCondicaoAC(int i) {
		return acessoriosComprados.get(i).getCondicao();
	}

	public String getCorAC(int i) {
		return acessoriosComprados.get(i).getCor();
	}

	public Usuario getUsuarioAC(int i) {
		return acessoriosComprados.get(i).getUsuario();
	}

	public String getMaterialAC(int i) {
		return acessoriosComprados.get(i).getMaterial();
	}

	public double getPesoAC(int i) {
		return acessoriosComprados.get(i).getPeso();
	}

	public double getMedidaLarguraAC(int i) {
		return acessoriosComprados.get(i).getMedidaLargura();
	}

	public double getMedidaAlturaAC(int i) {
		return acessoriosComprados.get(i).getMedidaAltura();
	}

	public String getNomeAV(int i) {
		return acessoriosAVenda.get(i).getNome();
	}

	public String getDepartamentoAV(int i) {
		return acessoriosAVenda.get(i).getDepartamento();
	}

	public String getDescricaoAV(int i) {
		return acessoriosAVenda.get(i).getDescricao();
	}

	public String getMarcaAV(int i) {
		return acessoriosAVenda.get(i).getMarca();
	}

	public Double getPrecoAV(int i) {
		return acessoriosAVenda.get(i).getPreco();
	}

	public String getCondicaoAV(int i) {
		return acessoriosAVenda.get(i).getCondicao();
	}

	public String getCorAV(int i) {
		return acessoriosAVenda.get(i).getCor();
	}

	public Usuario getUsuarioAV(int i) {
		return acessoriosAVenda.get(i).getUsuario();
	}

	public String getMaterialAV(int i) {
		return acessoriosAVenda.get(i).getMaterial();
	}

	public double getPesoAV(int i) {
		return acessoriosAVenda.get(i).getPeso();
	}

	public double getMedidaLarguraAV(int i) {
		return acessoriosAVenda.get(i).getMedidaLargura();
	}

	public double getMedidaAlturaAV(int i) {
		return acessoriosAVenda.get(i).getMedidaAltura();
	}	

} 