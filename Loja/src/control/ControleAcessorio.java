package control;

import java.util.ArrayList;

import model.*;

public class ControleAcessorio {
	
	private ArrayList<Acessorio> ac = new ArrayList<>();
	private ArrayList<Acessorio> av = new ArrayList<>();
	
	public ControleAcessorio (ControleDados d) {
		ac = d.getAcessoriosComprados();
		av = d.getAcessoriosAVenda();
	}

	//Coloca um acessorio a venda
	public boolean cadastrarAcessorio(String[] dadosAcessorio, Usuario usuario) {
		if(!dadosAcessorio[4].matches("[0-9]+") || !dadosAcessorio[8].matches("[0-9]+") || 
				!dadosAcessorio[9].matches("[0-9]+") || !dadosAcessorio[10].matches("[0-9]+")) {
			return false;
		}
		if(dadosAcessorio[0].isEmpty() || dadosAcessorio[1].isEmpty() || dadosAcessorio[2].isEmpty() || dadosAcessorio[3].isEmpty() || dadosAcessorio[4].isEmpty() || dadosAcessorio[5].isEmpty() ||
				dadosAcessorio[6].isEmpty() || dadosAcessorio[7].isEmpty() || dadosAcessorio[8].isEmpty() || dadosAcessorio[9].isEmpty() || dadosAcessorio[10].isEmpty()){
			return false;
		}
		if(!dadosAcessorio[0].matches("[A-Za-z ]+") || !dadosAcessorio[6].matches("[A-Za-z ]+") ){
			return false;
		}
		
		Acessorio accessorio = new Acessorio (dadosAcessorio[0], dadosAcessorio[1], dadosAcessorio[2], dadosAcessorio[3], Double.parseDouble(dadosAcessorio[4]), 
				dadosAcessorio[5], dadosAcessorio[6], usuario, dadosAcessorio[7], Double.parseDouble(dadosAcessorio[8]), Double.parseDouble(dadosAcessorio[9]), Double.parseDouble(dadosAcessorio[10]));
	
		ControleDados.getD().getAcessoriosAVenda().add(accessorio);
		
		return true;
	}
	
	//Deleta um acessorio ja existente
	public void excluirAcessorio(int posicao) {
		ControleDados.getD().getAcessoriosComprados().remove(posicao);	
	}
	
	//Gets e sets
	public ArrayList<Acessorio> getAc() {
		return ac;
	}

	public void setAc(ArrayList<Acessorio> ac) {
		this.ac = ac;
	}

	public ArrayList<Acessorio> getAv() {
		return av;
	}

	public void setAv(ArrayList<Acessorio> av) {
		this.av = av;
	}
	
	public String getNomeAC(int i) {
		return ac.get(i).getNome();
	}
	
	public String getDepartamentoAC(int i) {
		return ac.get(i).getDepartamento();
	}
	
	public String getDescricaoAC(int i) {
		return ac.get(i).getDescricao();
	}
	
	public String getMarcaAC(int i) {
		return ac.get(i).getMarca();
	}
	
	public Double getPrecoAC(int i) {
		return ac.get(i).getPreco();
	}
	
	public String getCondicaoAC(int i) {
		return ac.get(i).getCondicao();
	}
	
	public String getCorAC(int i) {
		return ac.get(i).getCor();
	}

	public Usuario getUsuarioAC(int i) {
		return ac.get(i).getUsuario();
	}
	
	public String getMaterialAC(int i) {
		return ac.get(i).getMaterial();
	}
	
	public double getPesoAC(int i) {
		return ac.get(i).getPeso();
	}
	
	public double getMedidaLarguraAC(int i) {
		return ac.get(i).getMedidaLargura();
	}
	
	public double getMedidaAlturaAC(int i) {
		return ac.get(i).getMedidaAltura();
	}
	
	public String getNomeAV(int i) {
		return av.get(i).getNome();
	}
	
	public String getDepartamentoAV(int i) {
		return av.get(i).getDepartamento();
	}
	
	public String getDescricaoAV(int i) {
		return av.get(i).getDescricao();
	}
	
	public String getMarcaAV(int i) {
		return av.get(i).getMarca();
	}
	
	public Double getPrecoAV(int i) {
		return av.get(i).getPreco();
	}
	
	public String getCondicaoAV(int i) {
		return av.get(i).getCondicao();
	}
	
	public String getCorAV(int i) {
		return av.get(i).getCor();
	}

	public Usuario getUsuarioAV(int i) {
		return av.get(i).getUsuario();
	}
	
	public String getMaterialAV(int i) {
		return av.get(i).getMaterial();
	}
	
	public double getPesoAV(int i) {
		return av.get(i).getPeso();
	}
	
	public double getMedidaLarguraAV(int i) {
		return av.get(i).getMedidaLargura();
	}
	
	public double getMedidaAlturaAV(int i) {
		return av.get(i).getMedidaAltura();
	}	

}