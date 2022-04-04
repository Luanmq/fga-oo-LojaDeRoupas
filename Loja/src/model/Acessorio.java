package model;
import java.util.Scanner;

public class Acessorio extends Produto{
	Scanner ler = new Scanner(System.in);
	
	protected String material;
	protected String peso;
	protected String medidaLargura;
	protected String medidaAltura;
	
	public Acessorio(Usuario usuario) {
		this.usuario = usuario;
	}

	//Gets e sets
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getMedidaLargura() {
		return medidaLargura;
	}

	public void setMedidaLargura(String medidaLargura) {
		this.medidaLargura = medidaLargura;
	}

	public String getMedidaAltura() {
		return medidaAltura;
	}

	public void setMedidaAltura(String medidaAltura) {
		this.medidaAltura = medidaAltura;
	}
}
