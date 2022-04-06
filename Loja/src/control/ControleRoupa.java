package control;

import java.util.ArrayList;

import model.*;

public class ControleRoupa {
	
	private ArrayList<Roupa> rc = new ArrayList<>();
	private ArrayList<Roupa> rv = new ArrayList<>();
	
	public ControleRoupa (ControleDados d) {
		rc = d.getRoupasCompradas();
		rv = d.getRoupasAVenda();
	}
	
	//Coloca uma roupa a venda
	public boolean cadastrarRoupa(String[] dadosRoupa, Usuario usuario) {
		if(!dadosRoupa[4].matches("[0-9]+")) {
			return false;
		}
		if(dadosRoupa[0].isEmpty() || dadosRoupa[1].isEmpty() || dadosRoupa[2].isEmpty() || dadosRoupa[3].isEmpty() || dadosRoupa[4].isEmpty() || dadosRoupa[5].isEmpty() ||
				dadosRoupa[6].isEmpty() || dadosRoupa[7].isEmpty() || dadosRoupa[8].isEmpty() || dadosRoupa[9].isEmpty()){
			return false;
		}
		if(!dadosRoupa[0].matches("[A-Za-z ]+") || !dadosRoupa[6].matches("[A-Za-z ]+") ||
				!dadosRoupa[8].matches("[A-Za-z ]+") ){
			return false;
		}
		
		Roupa roupa = new Roupa (dadosRoupa[0], dadosRoupa[1], dadosRoupa[2], dadosRoupa[3], Double.parseDouble(dadosRoupa[4]), 
		dadosRoupa[5], dadosRoupa[6], usuario, dadosRoupa[7], dadosRoupa[8], dadosRoupa[9]);
	
		ControleDados.getD().getRoupasAVenda().add(roupa);
		return true;
	}
	
	//Deleta uma roupa ja existente
	public void excluirRoupa(int posicao) {
		ControleDados.getD().getRoupasCompradas().remove(posicao);	
	}

	//Gets e sets
	public ArrayList<Roupa> getAc() {
		return rc;
	}

	public void setAc(ArrayList<Roupa> rc) {
		this.rc = rc;
	}

	public ArrayList<Roupa> getAv() {
		return rv;
	}

	public void setAv(ArrayList<Roupa> rv) {
		this.rv = rv;
	}
	
	public String getNomeAC(int i) {
		return rc.get(i).getNome();
	}
	
	public String getDepartamentoAC(int i) {
		return rc.get(i).getDepartamento();
	}
	
	public String getDescricaoAC(int i) {
		return rc.get(i).getDescricao();
	}
	
	public String getMarcaAC(int i) {
		return rc.get(i).getMarca();
	}
	
	public Double getPrecoAC(int i) {
		return rc.get(i).getPreco();
	}
	
	public String getCondicaoAC(int i) {
		return rc.get(i).getCondicao();
	}
	
	public String getCorAC(int i) {
		return rc.get(i).getCor();
	}

	public Usuario getUsuarioAC(int i) {
		return rc.get(i).getUsuario();
	}
	
	public String getTamanhoAC(int i) {
		return rc.get(i).getTamanho();
	}
	
	public String getTecidoAC(int i) {
		return rc.get(i).getTecido();
	}
	
	public String EstampaAC(int i) {
		return rc.get(i).getEstampa();
	}
	
	public String getNomeAV(int i) {
		return rv.get(i).getNome();
	}
	
	public String getDepartamentoAV(int i) {
		return rv.get(i).getDepartamento();
	}
	
	public String getDescricaoAV(int i) {
		return rv.get(i).getDescricao();
	}
	
	public String getMarcaAV(int i) {
		return rv.get(i).getMarca();
	}
	
	public Double getPrecoAV(int i) {
		return rv.get(i).getPreco();
	}
	
	public String getCondicaoAV(int i) {
		return rv.get(i).getCondicao();
	}
	
	public String getCorAV(int i) {
		return rv.get(i).getCor();
	}

	public Usuario getUsuarioAV(int i) {
		return rv.get(i).getUsuario();
	}
	
	public String getTamanhoAV(int i) {
		return rv.get(i).getTamanho();
	}
	
	public String getTecidoAV(int i) {
		return rv.get(i).getTecido();
	}
	
	public String EstampaAV(int i) {
		return rv.get(i).getEstampa();
	}

}