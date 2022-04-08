package model;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Classe que representa a Sacola De Compra do Usuário do sistema
 * @author Lucas 
 * @author Luan Melo
 */
public class SacolaDeCompra {
	 Scanner ler = new Scanner(System.in);
	 
	 private double valorTotal;
	 private ArrayList<Roupa> SacolaParaRoupas = new ArrayList<>();
	 private ArrayList<Acessorio> SacolaParaAcessorios = new ArrayList<>();
	 private Usuario usuarioComprador;
	 
	 /**
	 * Construtor de Sacola de Compra
	 * @param usuario Usuário no qual será cadastrado
	 */
	 public SacolaDeCompra(Usuario usuario) {
			this.usuarioComprador = usuario;
	 }
	 
	//Gets e sets
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ArrayList<Roupa> getSacolaParaRoupas() {
		return SacolaParaRoupas;
	}

	public void setSacolaParaRoupas(ArrayList<Roupa> sacolaParaRoupas) {
		SacolaParaRoupas = sacolaParaRoupas;
	}

	public ArrayList<Acessorio> getSacolaParaAcessorios() {
		return SacolaParaAcessorios;
	}

	public void setSacolaParaAcessorios(ArrayList<Acessorio> sacolaParaAcessorios) {
		SacolaParaAcessorios = sacolaParaAcessorios;
	}

	public Usuario getUsuarioComprador() {
		return usuarioComprador;
	}

	public void setUsuarioComprador(Usuario usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}
	 
	 
}