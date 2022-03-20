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
	
	//Cadastra uma roupa
	public void cadastrarProduto() {
		System.out.println("Digite o nome da Roupa:");
		this.nome = ler.nextLine();

		System.out.println("Escolha um departamento para a Roupa:");
		this.departamento = ler.nextLine();
		
		System.out.println("Escreva uma descricao da Roupa:");
		this.descricao = ler.nextLine();
		
		System.out.println("Escreva o nome da marca da Roupa:");
		this.marca = ler.nextLine();
		
		System.out.println("Escreva o preco da Roupa:");
		this.preco = ler.nextDouble();
		
		System.out.println("Escolha a condicao de uso em que a Roupa esta:");
		ler.nextLine();
		this.condicao = ler.nextLine();
		
		System.out.println("Escreva a cor da Roupa:");
		this.cor = ler.nextLine();

		System.out.println("Escreva o tamanho da Roupa:");
		this.tamanho = ler.nextLine();
		
		System.out.println("Escreva o tecido da Roupa:");
		this.tecido = ler.nextLine();
		
		System.out.println("Escreva qual a estampa da Roupa:");
		this.estampa = ler.nextLine();
	}
	
	//Edita os dados da roupa
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
			System.out.println("Escreva a nova descricao:");
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
		case "tamanho": 
			System.out.println("Escreva o novo tamanho:");
			this.tamanho = ler.nextLine();
			break;
		case "tecido": 
			System.out.println("Escreva o novo tecido:");
			this.tecido = ler.nextLine();
			break;
		case "estampa": 
			System.out.println("Escreva a nova estampa:");
			this.estampa = ler.nextLine();
			break;
		}
	}
	
	//Deleta uma roupa
	public void deletarProduto() {
		this.nome = null;
		this.departamento = null;
		this.descricao = null;
		this.marca = null;
		this.preco = null;
		this.condicao = null;
		this.cor = null;
		this.tamanho = null;
		this.tecido = null;
		this.estampa = null;
	}
	
	//Gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
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
	
	//Sobreescrita do equals() para comparacao de roupas
	@Override
	 public boolean equals(Object roupa) {
		if (this.nome == ((Roupa) roupa).getNome() && this.departamento == ((Roupa) roupa).getDepartamento() && this.descricao == ((Roupa) roupa).getDescricao()
				 && this.marca == ((Roupa) roupa).getMarca() && this.preco == ((Roupa) roupa).getPreco() && this.condicao == ((Roupa) roupa).getCondicao()
				 && this.cor == ((Roupa) roupa).getCor() && this.usuario == ((Roupa) roupa).getUsuario() && this.estampa == ((Roupa) roupa).getEstampa()
				 && this.tamanho == ((Roupa) roupa).getTamanho() && this.tecido == ((Roupa) roupa).getTecido()){
			return true;
		}
		return false; 
	}
	
	//Sobreescrita do toString para o print das roupas
	@Override
	public String toString() {
		return "Roupa - Nome: " + this.nome + " Vendedor: " + this.usuario.getNome() + " Departamento: " + this.departamento;
	}
}
