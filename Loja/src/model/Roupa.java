package model;
import java.util.Scanner;
/**
 * Classe que representa as Roupas que serão vendidas no sistema, herda atributos da Classe Produto
 * @author Luan Melo
 * @param tamanho Tamanho da Roupa, podendo ser: PP, P, M, G, GG
 * @param tecido Tecido da Roupa
 * @param estampa String para informa qual a estampa da Roupa
 */

public class Roupa extends Produto {
	Scanner ler = new Scanner(System.in);
	
	protected String tamanho;
	protected String tecido;
	protected String estampa;
	
	public Roupa(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Roupa (String n, String dep, String des, String m, double p, String cond, String co, Usuario u, String tam, String t, String e) {
		this.nome = n;
		this.departamento = dep;
		this.descricao = des;
		this.marca = m;
		this.preco = p;
		this.condicao = cond;
		this.cor =co;
		this.usuario = u;
		this.tamanho = tam;
		this.tecido = t;
		this.estampa = e;
	
		
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
	
	//Sobreescrita do toString para o print das roupas
	@Override
	public String toString() {
		return "Roupa - Nome: " + this.nome + " Vendedor: " + this.usuario.getNome() + " Departamento: " + this.departamento;
	}
}