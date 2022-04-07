package model;
import java.util.Scanner;

/**
 * Classe que representa os Acessorios que serão vendidos no sistema, herda atributos da Classe Produto
 * @author Luan Melo
 * @author Lucas
 * @param material Se refere a qual material o Acessório é feito
 * @param peso Peso do Acessório 
 * @param medidaLargura Medida da largura do Acessório
 * @param medidaAltura Medida da altura do Acessório
 */
public class Acessorio extends Produto{
	Scanner ler = new Scanner(System.in);
	
	protected String material;
	protected double peso;
	protected double medidaLargura;
	protected double medidaAltura;
	
	public Acessorio(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Acessorio(String n, String dep, String des, String m, double p, String cond, String co, Usuario u, String mat, double pe, double ml,double ma) {
		this.nome = n;
		this.departamento = dep;
		this.descricao = des;
		this.marca = m;
		this.preco = p;
		this.condicao = cond;
		this.cor =co;
		this.usuario = u;
		this.material = mat;
		this.peso = pe;
		this.medidaLargura = ml;
		this.medidaAltura = ma;
		
	}

	//Gets e sets
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getMedidaLargura() {
		return medidaLargura;
	}

	public void setMedidaLargura(double medidaLargura) {
		this.medidaLargura = medidaLargura;
	}

	public double getMedidaAltura() {
		return medidaAltura;
	}

	public void setMedidaAltura(double medidaAltura) {
		this.medidaAltura = medidaAltura;
	}

	//Sobreescrita do toString para o print dos acessorios
	@Override
	public String toString() {
		return "Acessorio - Nome: " + this.nome + " Vendedor: " + this.usuario.getNome() + " Departamento: " + this.departamento;
	}	
}