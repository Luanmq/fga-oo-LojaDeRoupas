package model;
import java.util.Scanner;

public class Endereco {
	Scanner ler = new Scanner(System.in);

	 private String pais;
	 private String estado;
	 private String cidade;
	 private String numeroResidencia;
	 private String cep;
	 private String referencia;
	 private Usuario usuario;
	
	public Endereco(Usuario usuario) {
		this.usuario = usuario;
	}
	 
	//Cadastra um endereco
	public void cadastrarEndereco() {
		System.out.println("Digite o nome do seu Pais:");
		this.pais = ler.nextLine();
		
		System.out.println("Digite o nome do seu Estado:");
		this.estado = ler.nextLine();
			
		System.out.println("Digite o nome da sua Cidade:");
		this.cidade = ler.nextLine();
			
		System.out.println("Digite o numero de sua Casa ou Apartamento:");
		this.numeroResidencia = ler.nextLine();
			
		System.out.println("Digite o seu CEP:");
		this.cep = ler.nextLine();
			
		System.out.println("Digite um ponto de referencia proximo ao seu endereco:");
		this.referencia = ler.nextLine();
	}
	
	//Edita os dados do endereco
	public void editarEndereco() {		
		System.out.println("Escreva a informação que deseja editar:");
		String para_editar = ler.next();
		
		switch(para_editar) {
		case "pais":
			System.out.println("Escreva o novo Pais:");
			this.pais = ler.nextLine();
			break;
		case "estado": 
			System.out.println("Escreva o novo Estado:");
			this.estado = ler.nextLine();
			break;
		case "cidade": 
			System.out.println("Escreva a nova Cidade:");
			this.cidade = ler.nextLine();
			break;
		case "numero": 
			System.out.println("Escreva o novo numero da sua Casa ou Apartamento:");
			this.numeroResidencia = ler.nextLine();
			break;
		case "cep": 
			System.out.println("Escreva o novo CEP:");
			this.cep = ler.nextLine();
			break;
		case "referencia": 
			System.out.println("Escreva a nova referencia:");
			this.referencia = ler.nextLine();
			break;
		}	
	}
	
	//Deleta um endereco
	public void deletarEndereco() {
		this.pais = null;
		this.estado = null;
		this.cidade = null;
		this.numeroResidencia = null;
		this.cep = null;
		this.referencia = null;
	
	}
	
	//Gets e sets
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(String numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Sobreescrita do toString para o print dos enderecos
	@Override
	public String toString() {
		return "Pais: " + pais + " Estado: " + estado + " Cidade: " + cidade + " Numero da Residencia: " + 
	numeroResidencia + " CEP: " + cep + " Referencia: " + referencia;
	}	
}
