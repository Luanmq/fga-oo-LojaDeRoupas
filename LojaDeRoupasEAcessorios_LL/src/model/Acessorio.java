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
	
	//Cadastra um acessorio
	public void cadastrarProduto() {
		System.out.println("Digite o nome do Acessorio:");
		this.nome = ler.nextLine();

		System.out.println("Escolha um departamento para o Acessorio:");
		this.departamento = ler.nextLine();
		
		System.out.println("Escreva uma descricao do Acessorio:");
		this.descricao = ler.nextLine();
		
		System.out.println("Escreva o nome da marca do Acessorio:");
		this.marca = ler.nextLine();
		
		System.out.println("Escreva o preco do Acessorio:");
		this.preco = ler.nextDouble();
		
		System.out.println("Escolha a condicao de uso em que o Acessorio esta:");
		ler.nextLine();
		this.condicao = ler.nextLine();
		
		System.out.println("Escreva a cor do Acessorio:");
		this.cor = ler.nextLine();

		System.out.println("Escreva o material do Acessorio:");
		this.material = ler.nextLine();
		
		System.out.println("Escreva o peso do Acessorio em gramas:");
		this.peso = ler.nextLine();
		
		System.out.println("Escreva a medida da largura X altura do Acessorio:");
		//this.medida = ler.nextLine();
	}
	
	//Edita os dados do acessorio
	public void editarProduto() {
		System.out.println("Escreva a informação que deseja editar:");
		String para_editar = ler.next();
		
		switch(para_editar) {
		case "nome": 
			System.out.println("Escreva o novo nome:");
			this.nome = ler.nextLine();
			break;
		case "departamento": 
			System.out.println("Escreva o novo departamento:");
			this.departamento = ler.nextLine();
			break;
		case "descricao": 
			System.out.println("Escreva a nova descricao;");
			this.descricao = ler.nextLine();
			break;
		case "marca": 
			System.out.println("Escreva a nova marca:");
			this.marca = ler.nextLine();
			break;
		case "preco": 
			System.out.println("Escreva o novo preco:");
			this.preco = ler.nextDouble();
			break;
		case "condicao": 
			System.out.println("Escreva a nova condicao:");
			this.condicao = ler.nextLine();
			break;
		case "cor": 
			System.out.println("Escreva a nova cor:");
			this.cor = ler.nextLine();
			break;
		case "material": 
			System.out.println("Escreva o novo material:");
			this.material = ler.nextLine();
			break;
		case "peso": 
			System.out.println("Escreva o peso do Acessorio em gramas:");
			this.peso = ler.nextLine();
			break;
		case "medida": 
			System.out.println("Escreva a medida da largura X altura do Acessorio:");
			//this.medida = ler.nextLine();
			break;
		}
	}

	//Deleta um acessorio
	public void deletarProduto() {
		this.nome = null;
		this.departamento = null;
		this.descricao = null;
		this.marca = null;
		this.preco = null;
		this.condicao = null;
		this.cor = null;
		this.material = null;
		this.peso = null;
		this.medidaLargura = null;
		this.medidaAltura = null;
	}
		
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

	//Sobreescrita do equals() para comparacao de acessorios
	@Override
	 public boolean equals(Object acessorio) {
		if (this.nome == ((Acessorio) acessorio).getNome() && this.departamento == ((Acessorio) acessorio).getDepartamento() && this.descricao == ((Acessorio) acessorio).getDescricao()
				 && this.marca == ((Acessorio) acessorio).getMarca() && this.preco == ((Acessorio) acessorio).getPreco() && this.condicao == ((Acessorio) acessorio).getCondicao()
				 && this.cor == ((Acessorio) acessorio).getCor() && this.usuario == ((Acessorio) acessorio).getUsuario() && this.material == ((Acessorio) acessorio).getMaterial()
				 && this.peso == ((Acessorio) acessorio).getPeso()){
			return true;
		}
		return false; 
	}

	//Sobreescrita do toString para o print dos acessorios
	@Override
	public String toString() {
		return "Acessorio - Nome: " + this.nome + " Vendedor: " + this.usuario.getNome() + " Departamento: " + this.departamento;
	}	
}
