package model;
import java.util.ArrayList;
import java.util.Scanner;

import controle.Dados;

public class Usuario {
	Scanner ler = new Scanner(System.in);
	
	private String nome;
	private String telefone;
	private String cpf;
	private String email;
	
	private ArrayList<Acessorio> acessoriosComprados = new ArrayList<>();
	private ArrayList<Acessorio> acessoriosAVenda = new ArrayList<>();
	
	private ArrayList<Roupa> roupasCompradas = new ArrayList<>();
	private ArrayList<Roupa> roupasAVenda = new ArrayList<>();
	
	private ArrayList<Endereco> enderecos = new ArrayList<>();
    
	private SacolaDeCompra sacolausuario = new SacolaDeCompra(this);

	public Usuario() {
	}
	
	//Cadastro de um usuario
    public void cadastrarUsuario() {
		System.out.println("Digite o seu nome:");
		this.nome = ler.nextLine();
		
		System.out.println("Digite o seu telefone:");
		this.telefone = ler.nextLine();
		
		System.out.println("Digite o seu cpf:");
		this.cpf = ler.nextLine();
		
		System.out.println("Digite o seu email:");
		this.email = ler.nextLine();		
		
		String resposta_endereco;
		//Cadastra os enderecos do usuario
		do {
			Endereco endereco = new Endereco(this);
			this.enderecos.add(endereco);
			this.enderecos.get(this.enderecos.size()-1).cadastrarEndereco();
			
			System.out.println("Deseja cadastrar mais um endereco? Digite sim ou nao:");
			resposta_endereco = ler.next();
		}while(resposta_endereco.equals("sim") == true);
	}
	
    //Edita uma informacao do usuario
	public void editarUsuario() {		
		System.out.println("Escreva a informação que deseja editar:");
		String para_editar = ler.next();
		
		switch(para_editar) {
		case "nome":
			System.out.println("Escreva o novo nome:");
			this.nome = ler.nextLine();
			break;
		case "telefone": 
			System.out.println("Escreva o novo telefone:");
			this.telefone = ler.nextLine();
			break;
		case "cpf": 
			System.out.println("Escreva o novo cpf:");
			this.cpf = ler.nextLine();
			break;
		case "email": 
			System.out.println("Escreva o novo email:");
			this.email = ler.nextLine();
			break;
		case "endereco":
			System.out.println("Digite o numero correspondente ao Endereco que deseja editar:");
			
			//Edita os enderecos do usuarios
			for(int i = 0; i < this.enderecos.size(); i++) {
				System.out.println("Endereco " + i+1 + ": O cep do endereco eh: " + this.enderecos.get(i).getCep() +
				" e o numero da residencia eh: " + this.enderecos.get(i).getNumeroResidencia());
			}	
			
			int selecao_endereco = ler.nextInt();
			this.enderecos.get(selecao_endereco-1).editarEndereco();
			break;
		}
	}
	
	//Deleta um usuario
	public void deletarUsuario() {
		this.nome = null;
		this.telefone = null;
		this.cpf = null;
		this.email = null;

		for(int i=0; i < this.enderecos.size(); i++) {
			this.enderecos.get(i).deletarEndereco();
		}
	}
	
	//O usuario pode ver os produtos a venda e decidir se vai colocar um deles na sacola de compra
	/*public boolean comprar() {
		System.out.println("Deseja comprar uma Roupa ou um Acessorio? Digite 1 para Acessorio ou 2 para Roupa:");
		int para_comprar = ler.nextInt();

		switch(para_comprar) {
			case 1:
				System.out.println("Esses sao todos os Acessorios disponiveis para compra:");
				for(int i = 0; i < Dados.usuarios.size(); i++) {
					for(int j = 0; j < Dados.usuarios.get(i).acessoriosAVenda.size(); j++){
						System.out.print("Acessorio " + (j+1) + ": ");
						System.out.print(Dados.usuarios.get(i).acessoriosAVenda.get(j).getNome());
						System.out.print(" | Vendedor " + (i+1) + ": ");
						System.out.println(Dados.usuarios.get(i).getNome());
					}
				}
				
				System.out.println("Para comprar digite respectivamente o numero do vendedor"
						+ "e o numero do Acessorio escolhido, caso nao queira comprar nenhum acessorio digite zero "
						+ "nos dois");
				int resposta_compra_vendedor = ler.nextInt();
				resposta_compra_vendedor -= 1; 
				int resposta_compra_acessorio = ler.nextInt();
				resposta_compra_acessorio -=1;
				
				/*if(resposta_compra_vendedor == -1 && resposta_compra_acessorio == -1) {
					System.out.println("Nenhum Produto foi adicionado a Sacola");
					return false;
				}else {
					System.out.println("O Produto foi adicionado a Sacola");
					this.sacolausuario.setUsuarioComprador(this);
					this.sacolausuario.adicionarAcessorio(resposta_compra_vendedor,resposta_compra_acessorio);	
					return true;
				}
				
			case 2:
				System.out.println("Essas sao todas as Roupas disponiveis para compra:");
				
				for(int i = 0; i < Dados.usuarios.size(); i++) {
					for(int j = 0; j < Dados.usuarios.get(i).roupasAVenda.size(); j++){
						System.out.print("Roupa " + (j+1) + ": ");
						System.out.print(Dados.usuarios.get(i).roupasAVenda.get(j).getNome());
						System.out.print(" | Vendedor " + (i+1) + ": ");
						System.out.println(Dados.usuarios.get(i).getNome());
					}
				}
				
				System.out.println("Qual dessas Roupas deseja comprar? Digite o primeiro numero referente ao vendedor "
						+ "e segundo numero referente a Roupa escolhida, caso nao queira comprar nenhuma Roupa digite zero "
						+ "nos dois");
				int resposta_compra_vendedor2 = ler.nextInt();
				resposta_compra_vendedor2 -= 1; 
				int resposta_compra_roupa = ler.nextInt();
				resposta_compra_roupa -=1;
				
				if(resposta_compra_vendedor2 == -1 && resposta_compra_roupa == -1) {
					System.out.println("Nenhum Produto foi adicionado a Sacola");
					return false;
				}else {
					System.out.println("O Produto foi adicionado a Sacola");
					this.sacolausuario.setUsuarioComprador(this);
					this.sacolausuario.adicionarRoupa(resposta_compra_vendedor2,resposta_compra_roupa);	
					return true;
				}
		}
		
		return false;
	}*/
	
	//O usuario pode cadastrar um produto e coloca-lo a venda
	public void venderAcessorio() {
		String resposta_acessoriosAVenda;
		//Cadastra um acessorio
		do {	
			Acessorio acessorionovo = new Acessorio(this);
			acessoriosAVenda.add(acessorionovo);
			acessoriosAVenda.get(acessoriosAVenda.size()-1).cadastrarProduto();
						 
			System.out.println("Deseja vender mais um acessorio? Digite sim ou nao:");
			resposta_acessoriosAVenda = ler.next();
		}while(resposta_acessoriosAVenda.equals("sim") == true);
	}
	
	public void venderRoupa() {
		String resposta_roupaAVenda;
		//Cadastra um acessorio
		do {	
			Roupa roupanova = new Roupa(this);
			roupasAVenda.add(roupanova);
			roupasAVenda.get(roupasAVenda.size()-1).cadastrarProduto();
						 
			System.out.println("Deseja vender mais uma Roupa? Digite sim ou nao:");
			resposta_roupaAVenda = ler.next();
		}while(resposta_roupaAVenda.equals("sim") == true);
	}
	
	//Gets e sets	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Acessorio> getAcessoriosComprados() {
		return acessoriosComprados;
	}

	public void setAcessoriosComprados(ArrayList<Acessorio> acessoriosComprados) {
		this.acessoriosComprados = acessoriosComprados;
	}

	public ArrayList<Acessorio> getAcessoriosAVenda() {
		return acessoriosAVenda;
	}

	public void setAcessoriosAVenda(ArrayList<Acessorio> acessoriosAVenda) {
		this.acessoriosAVenda = acessoriosAVenda;
	}

	public ArrayList<Roupa> getRoupasCompradas() {
		return roupasCompradas;
	}

	public void setRoupasCompradas(ArrayList<Roupa> roupasCompradas) {
		this.roupasCompradas = roupasCompradas;
	}

	public ArrayList<Roupa> getRoupasAVenda() {
		return roupasAVenda;
	}

	public void setRoupasAVenda(ArrayList<Roupa> roupasAVenda) {
		this.roupasAVenda = roupasAVenda;
	}

	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}
	
	//Sobrecarga do metodo setEnderecos para colocar um objeto endereco dentro do array
	//@Overload
	public void setEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public SacolaDeCompra getSacola() {
		return sacolausuario;
	}

	public void setSacola(SacolaDeCompra sacola) {
		this.sacolausuario = sacola;
	}
	
	//Sobreescrita do toString para o print dos usuarios
	@Override
	public String toString() {
		return "Nome: " + this.nome + " CPF: " + this.cpf + " Endereco: " + this.getEnderecos();
	}
}
