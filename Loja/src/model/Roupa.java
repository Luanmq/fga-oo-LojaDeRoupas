package model;
import java.util.Scanner;

public class Roupa extends Produto {
	Scanner ler = new Scanner(System.in);
	
	protected String tamanho;
	protected String tecido;
	protected String estampa;
	
	public Roupa(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Gets e sets	
	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTecido() {
		return tecido;
	}

	public void setTecido(String tecido) {
		this.tecido = tecido;
	}

	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}
}
