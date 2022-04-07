package control;

import java.util.ArrayList;

import model.*;

/**
 * Controla as variáveis relacionadas a Acessorio na classe Dados
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
	 * Coloca um acessório a venda
	 * @param dadosAcessorio dados referente a acessório
	 * @param usuario usuário que possui o acessório
	 * @return
	 */
	public boolean cadastrarAcessorio(String[] dadosAcessorio, Usuario usuario) {
		if(dadosAcessorio[0].isEmpty() || dadosAcessorio[1].isEmpty() || dadosAcessorio[2].isEmpty() || dadosAcessorio[3].isEmpty() || dadosAcessorio[4].isEmpty() || dadosAcessorio[5].isEmpty() ||
				dadosAcessorio[6].isEmpty() || dadosAcessorio[7].isEmpty() || dadosAcessorio[8].isEmpty() || dadosAcessorio[9].isEmpty() || dadosAcessorio[10].isEmpty()){
			return false;
		}
		if(!dadosAcessorio[4].matches("[0-9]+") || !dadosAcessorio[8].matches("[0-9]+") || 
				!dadosAcessorio[9].matches("[0-9]+") || !dadosAcessorio[10].matches("[0-9]+")) {
			return false;
		}
		if(!dadosAcessorio[0].matches("[A-Za-z ]+") || !dadosAcessorio[6].matches("[A-Za-z ]+") ){
			return false;
		}
		
		Acessorio accessorio = new Acessorio (dadosAcessorio[0], dadosAcessorio[1], dadosAcessorio[2], dadosAcessorio[3], Double.parseDouble(dadosAcessorio[4]), 
				dadosAcessorio[5], dadosAcessorio[6], usuario, dadosAcessorio[7], Double.parseDouble(dadosAcessorio[8]), Double.parseDouble(dadosAcessorio[9]), Double.parseDouble(dadosAcessorio[10]));
		
		accessorio.setImagem("img/Placeholder.png");
		
		ControleDados.getD().getAcessoriosAVenda().add(accessorio);
		
		return true;
	}
	
	/**
	 * Salva os dados editados de um acessório
	 * @param dadosAcessorio dados referente ao acessório
	 * @param usuario usuário que possui o acessório
	 * @param posicao posição do acessório no array AcessoriosAVenda
	 * @return
	 */
	public boolean salvarAcessorio(String[] dadosAcessorio, Usuario usuario, int posicao) {
		if(dadosAcessorio[0].isEmpty() || dadosAcessorio[1].isEmpty() || dadosAcessorio[2].isEmpty() || dadosAcessorio[3].isEmpty() || dadosAcessorio[4].isEmpty() || dadosAcessorio[5].isEmpty() ||
				dadosAcessorio[6].isEmpty() || dadosAcessorio[7].isEmpty() || dadosAcessorio[8].isEmpty() || dadosAcessorio[9].isEmpty() || dadosAcessorio[10].isEmpty()){
			return false;
		}
		if(!dadosAcessorio[4].matches("[0-9]+") || !dadosAcessorio[8].matches("[0-9]+") || 
				!dadosAcessorio[9].matches("[0-9]+") || !dadosAcessorio[10].matches("[0-9]+")) {
			return false;
		}
		if(!dadosAcessorio[0].matches("[A-Za-z ]+") || !dadosAcessorio[6].matches("[A-Za-z ]+") ){
			return false;
		}
		
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setNome(dadosAcessorio[0]);
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setDepartamento(dadosAcessorio[1]);
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setDescricao(dadosAcessorio[2]);
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setMarca(dadosAcessorio[3]);
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setPreco(Double.parseDouble(dadosAcessorio[4]));
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setCondicao(dadosAcessorio[5]);
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setCor(dadosAcessorio[6]);

		ControleDados.getD().getAcessoriosAVenda().get(posicao).setMaterial(dadosAcessorio[7]);
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setPeso(Double.parseDouble(dadosAcessorio[8]));
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setMedidaLargura(Double.parseDouble(dadosAcessorio[9]));
		ControleDados.getD().getAcessoriosAVenda().get(posicao).setMedidaAltura(Double.parseDouble(dadosAcessorio[10]));

		return true;
	}
	
	/**
	 * Deleta um acessório já existente
	 * @param posicao posição do acessório no array AcessoriosAVenda
	 */
	public void excluirAcessorio(int posicao) {
		for(int i = 0; i < ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); i++){
			if(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(i) ==
			ControleDados.getD().getAcessoriosAVenda().get(posicao)) {
				//Tira as roupas compradas de Roupas Venda
				ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().remove(i);
			}
		}
		
		ControleDados.getD().getAcessoriosAVenda().remove(posicao);	}
	
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