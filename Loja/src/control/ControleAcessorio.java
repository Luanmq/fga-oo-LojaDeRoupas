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

	/*//Coloca um acessorio a venda
	public boolean cadastrarAcessorio(String[] novoDado) {
		
		ControleDados.getD().getAcessoriosAVenda().add(novoDado);

	}*/
	
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
	
	public String getPesoAC(int i) {
		return ac.get(i).getPeso();
	}
	
	public String getMedidaLarguraAC(int i) {
		return ac.get(i).getMedidaLargura();
	}
	
	public String getMedidaAlturaAC(int i) {
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
	
	public String getPesoAV(int i) {
		return av.get(i).getPeso();
	}
	
	public String getMedidaLarguraAV(int i) {
		return av.get(i).getMedidaLargura();
	}
	
	public String getMedidaAlturaAV(int i) {
		return av.get(i).getMedidaAltura();
	}	

}

