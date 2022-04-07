package control;

import java.util.ArrayList;

import model.*;

/**
 * Controla as variáveis relacionadas a Roupa na classe Dados
 * @author Luan Melo
 * @author Lucas
 */

public class ControleRoupa {
	
	private ArrayList<Roupa> roupasCompradas = new ArrayList<>();
	private ArrayList<Roupa> roupasAVenda = new ArrayList<>();
	
	/**
	 * Construtor do ControleRoupa, inicializando os dados os dados relacionadas a roupas presentes
	 * @param d Instância de Controle de Dados já usada em outra parte do código
	 */
	public ControleRoupa (ControleDados d) {
		roupasCompradas = d.getRoupasCompradas();
		roupasAVenda = d.getRoupasAVenda();
	}
	
	/**
	 * Coloca uma roupa a venda
	 * @param dadosRoupa dados referente a roupa
	 * @param usuario usuário que possui a roupa
	 * @return
	 */
	public boolean cadastrarRoupa(String[] dadosRoupa, Usuario usuario) {
		if(dadosRoupa[0].isEmpty() || dadosRoupa[1].isEmpty() || dadosRoupa[2].isEmpty() || dadosRoupa[3].isEmpty() || dadosRoupa[4].isEmpty() || dadosRoupa[5].isEmpty() ||
				dadosRoupa[6].isEmpty() || dadosRoupa[7].isEmpty() || dadosRoupa[8].isEmpty() || dadosRoupa[9].isEmpty()){
			return false;
		}
		if(!dadosRoupa[4].matches("[0-9]+")) {
			return false;
		}
		if(!dadosRoupa[0].matches("[A-Za-z ]+") || !dadosRoupa[6].matches("[A-Za-z ]+") ||
				!dadosRoupa[8].matches("[A-Za-z ]+") ){
			return false;
		}
		
		Roupa roupa = new Roupa (dadosRoupa[0], dadosRoupa[1], dadosRoupa[2], dadosRoupa[3], Double.parseDouble(dadosRoupa[4]), 
		dadosRoupa[5], dadosRoupa[6], usuario, dadosRoupa[7], dadosRoupa[8], dadosRoupa[9]);
		
		roupa.setImagem("img/Placeholder.png");
		
		ControleDados.getD().getRoupasAVenda().add(roupa);
		return true;
	}
	
	/**
	 * Salva os dados editados de uma roupa
	 * @param dadosRoupa dados referente a roupa
	 * @param usuario usuário que possui a roupa
	 * @param posicao posição da roupa no array RoupasAVenda
	 * @return
	 */
	public boolean salvarRoupa(String[] dadosRoupa, Usuario usuario, int posicao) {
		if(dadosRoupa[0].isEmpty() || dadosRoupa[1].isEmpty() || dadosRoupa[2].isEmpty() || dadosRoupa[3].isEmpty() || dadosRoupa[4].isEmpty() || dadosRoupa[5].isEmpty() ||
				dadosRoupa[6].isEmpty() || dadosRoupa[7].isEmpty() || dadosRoupa[8].isEmpty() || dadosRoupa[9].isEmpty()){
			return false;
		}
		if(!dadosRoupa[4].matches("[0-9]+")) {
			return false;
		}
		if(!dadosRoupa[0].matches("[A-Za-z ]+") || !dadosRoupa[6].matches("[A-Za-z ]+") ||
				!dadosRoupa[8].matches("[A-Za-z ]+") ){
			return false;
		}
		
		ControleDados.getD().getRoupasAVenda().get(posicao).setNome(dadosRoupa[0]);
		ControleDados.getD().getRoupasAVenda().get(posicao).setDepartamento(dadosRoupa[1]);
		ControleDados.getD().getRoupasAVenda().get(posicao).setDescricao(dadosRoupa[2]);
		ControleDados.getD().getRoupasAVenda().get(posicao).setMarca(dadosRoupa[3]);
		ControleDados.getD().getRoupasAVenda().get(posicao).setPreco(Double.parseDouble(dadosRoupa[4]));
		ControleDados.getD().getRoupasAVenda().get(posicao).setCondicao(dadosRoupa[5]);
		ControleDados.getD().getRoupasAVenda().get(posicao).setCor(dadosRoupa[6]);

		ControleDados.getD().getRoupasAVenda().get(posicao).setTamanho(dadosRoupa[7]);
		ControleDados.getD().getRoupasAVenda().get(posicao).setTecido(dadosRoupa[8]);
		ControleDados.getD().getRoupasAVenda().get(posicao).setEstampa(dadosRoupa[9]);

		return true;
	}
	
	/**
	 * Deleta uma roupa já existente
	 * @param posicao posição da roupa no array RoupasAVenda
	 */
	public void excluirRoupa(int posicao) {
		for(int i = 0; i < ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); i++){
			if(ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(i) ==
			ControleDados.getD().getRoupasAVenda().get(posicao)) {
				//Tira as roupas compradas de Roupas Venda
				ControleDados.getD().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().remove(i);
			}
		}
		
		ControleDados.getD().getRoupasAVenda().remove(posicao);
	}

	//Gets e sets
	public ArrayList<Roupa> getAc() {
		return roupasCompradas;
	}

	public void setAc(ArrayList<Roupa> roupasCompradas) {
		this.roupasCompradas = roupasCompradas;
	}

	public ArrayList<Roupa> getAv() {
		return roupasAVenda;
	}

	public void setAv(ArrayList<Roupa> roupasAVenda) {
		this.roupasAVenda = roupasAVenda;
	}
	
	public String getNomeAC(int i) {
		return roupasCompradas.get(i).getNome();
	}
	
	public String getDepartamentoAC(int i) {
		return roupasCompradas.get(i).getDepartamento();
	}
	
	public String getDescricaoAC(int i) {
		return roupasCompradas.get(i).getDescricao();
	}
	
	public String getMarcaAC(int i) {
		return roupasCompradas.get(i).getMarca();
	}
	
	public Double getPrecoAC(int i) {
		return roupasCompradas.get(i).getPreco();
	}
	
	public String getCondicaoAC(int i) {
		return roupasCompradas.get(i).getCondicao();
	}
	
	public String getCorAC(int i) {
		return roupasCompradas.get(i).getCor();
	}

	public Usuario getUsuarioAC(int i) {
		return roupasCompradas.get(i).getUsuario();
	}
	
	public String getTamanhoAC(int i) {
		return roupasCompradas.get(i).getTamanho();
	}
	
	public String getTecidoAC(int i) {
		return roupasCompradas.get(i).getTecido();
	}
	
	public String EstampaAC(int i) {
		return roupasCompradas.get(i).getEstampa();
	}
	
	public String getNomeAV(int i) {
		return roupasAVenda.get(i).getNome();
	}
	
	public String getDepartamentoAV(int i) {
		return roupasAVenda.get(i).getDepartamento();
	}
	
	public String getDescricaoAV(int i) {
		return roupasAVenda.get(i).getDescricao();
	}
	
	public String getMarcaAV(int i) {
		return roupasAVenda.get(i).getMarca();
	}
	
	public Double getPrecoAV(int i) {
		return roupasAVenda.get(i).getPreco();
	}
	
	public String getCondicaoAV(int i) {
		return roupasAVenda.get(i).getCondicao();
	}
	
	public String getCorAV(int i) {
		return roupasAVenda.get(i).getCor();
	}

	public Usuario getUsuarioAV(int i) {
		return roupasAVenda.get(i).getUsuario();
	}
	
	public String getTamanhoAV(int i) {
		return roupasAVenda.get(i).getTamanho();
	}
	
	public String getTecidoAV(int i) {
		return roupasAVenda.get(i).getTecido();
	}
	
	public String EstampaAV(int i) {
		return roupasAVenda.get(i).getEstampa();
	}

}