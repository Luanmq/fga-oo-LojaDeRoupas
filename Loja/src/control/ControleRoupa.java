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
	 * Construtor do ControleRoupa
	 */
	public ControleRoupa() {
		
	}

	/**
	 * Coloca uma roupa a venda e verifica se seus dados são válidos
	 * @param dadosRoupa dados referente a roupa
	 * @param usuario usuário que possui a roupa
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean cadastrarRoupa(String[] dadosRoupa, Usuario usuario) {
		if(dadosRoupa[0] == null || dadosRoupa[1] == null || dadosRoupa[2] == null || dadosRoupa[3] == null || dadosRoupa[4] == null || dadosRoupa[5] == null ||
				dadosRoupa[6] == null || dadosRoupa[7] == null || dadosRoupa[8] == null || dadosRoupa[9] == null){
			return false;
		}
		if(!dadosRoupa[4].matches("[0-9.]+")) {
			return false;
		}
		if(!dadosRoupa[0].matches("[A-Za-z ]+") || !dadosRoupa[6].matches("[A-Za-z ]+") ||
				!dadosRoupa[8].matches("[A-Za-z ]+") ){
			return false;
		}

		Roupa roupa = new Roupa (dadosRoupa[0], dadosRoupa[1], dadosRoupa[2], dadosRoupa[3], Double.parseDouble(dadosRoupa[4]), 
		dadosRoupa[5], dadosRoupa[6], usuario, dadosRoupa[7], dadosRoupa[8], dadosRoupa[9]);

		roupa.setImagem("img/Placeholder.png");

		ControleDados.getDados().getRoupasAVenda().add(roupa);
		return true;
	}

	/**
	 * Salva os dados editados de uma roupa
	 * @param dadosRoupa dados referente a roupa
	 * @param usuario usuário que possui a roupa
	 * @param posicao posição da roupa no array RoupasAVenda
	 * @return retorna uma verificação se a operação foi bem sucedida
	 */
	public boolean salvarRoupa(String[] dadosRoupa, Usuario usuario, int posicao) {
		if(dadosRoupa[0] == null || dadosRoupa[1] == null || dadosRoupa[2] == null || dadosRoupa[3] == null || dadosRoupa[4] == null || dadosRoupa[5] == null ||
				dadosRoupa[6] == null || dadosRoupa[7] == null || dadosRoupa[8] == null || dadosRoupa[9] == null){
			return false;
		}
		if(!dadosRoupa[4].matches("[0-9]+")) {
			return false;
		}
		if(!dadosRoupa[0].matches("[A-Za-z ]+") || !dadosRoupa[6].matches("[A-Za-z ]+") ||
				!dadosRoupa[8].matches("[A-Za-z ]+") ){
			return false;
		}

		ControleDados.getDados().getRoupasAVenda().get(posicao).setNome(dadosRoupa[0]);
		ControleDados.getDados().getRoupasAVenda().get(posicao).setDepartamento(dadosRoupa[1]);
		ControleDados.getDados().getRoupasAVenda().get(posicao).setDescricao(dadosRoupa[2]);
		ControleDados.getDados().getRoupasAVenda().get(posicao).setMarca(dadosRoupa[3]);
		ControleDados.getDados().getRoupasAVenda().get(posicao).setPreco(Double.parseDouble(dadosRoupa[4]));
		ControleDados.getDados().getRoupasAVenda().get(posicao).setCondicao(dadosRoupa[5]);
		ControleDados.getDados().getRoupasAVenda().get(posicao).setCor(dadosRoupa[6]);

		ControleDados.getDados().getRoupasAVenda().get(posicao).setTamanho(dadosRoupa[7]);
		ControleDados.getDados().getRoupasAVenda().get(posicao).setTecido(dadosRoupa[8]);
		ControleDados.getDados().getRoupasAVenda().get(posicao).setEstampa(dadosRoupa[9]);

		return true;
	}

	/**
	 * Deleta uma roupa já existente
	 * @param posicao posição da roupa no array RoupasAVenda
	 */
	public void excluirRoupa(int posicao) {
		for(int i = 0; i < ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); i++){
			if(ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(i) ==
			ControleDados.getDados().getRoupasAVenda().get(posicao)) {
				//Tira as roupas compradas de Roupas Venda
				ControleDados.getDados().getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().remove(i);
			}
		}

		ControleDados.getDados().getRoupasAVenda().remove(posicao);
	}

	//Gets e sets
	public ArrayList<Roupa> getRc() {
		return roupasCompradas;
	}

	public void setRc(ArrayList<Roupa> roupasCompradas) {
		this.roupasCompradas = roupasCompradas;
	}

	public ArrayList<Roupa> getRv() {
		return roupasAVenda;
	}

	public void setRv(ArrayList<Roupa> roupasAVenda) {
		this.roupasAVenda = roupasAVenda;
	}

	public String getNomeRC(int i) {
		return roupasCompradas.get(i).getNome();
	}

	public String getDepartamentoRC(int i) {
		return roupasCompradas.get(i).getDepartamento();
	}

	public String getDescricaoRC(int i) {
		return roupasCompradas.get(i).getDescricao();
	}

	public String getMarcaRC(int i) {
		return roupasCompradas.get(i).getMarca();
	}

	public Double getPrecoRC(int i) {
		return roupasCompradas.get(i).getPreco();
	}

	public String getCondicaoRC(int i) {
		return roupasCompradas.get(i).getCondicao();
	}

	public String getCorRC(int i) {
		return roupasCompradas.get(i).getCor();
	}

	public Usuario getUsuarioRC(int i) {
		return roupasCompradas.get(i).getUsuario();
	}

	public String getTamanhoRC(int i) {
		return roupasCompradas.get(i).getTamanho();
	}

	public String getTecidoRC(int i) {
		return roupasCompradas.get(i).getTecido();
	}

	public String getEstampaRC(int i) {
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

	public String getMarcaRV(int i) {
		return roupasAVenda.get(i).getMarca();
	}

	public Double getPrecoRV(int i) {
		return roupasAVenda.get(i).getPreco();
	}

	public String getCondicaoRV(int i) {
		return roupasAVenda.get(i).getCondicao();
	}

	public String getCorRV(int i) {
		return roupasAVenda.get(i).getCor();
	}

	public Usuario getUsuarioRV(int i) {
		return roupasAVenda.get(i).getUsuario();
	}

	public String getTamanhoRV(int i) {
		return roupasAVenda.get(i).getTamanho();
	}

	public String getTecidoRV(int i) {
		return roupasAVenda.get(i).getTecido();
	}

	public String getEstampaRV(int i) {
		return roupasAVenda.get(i).getEstampa();
	}

} 