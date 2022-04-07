package model;
/**
 * Classe que representa o Usuário do sistema
 * @author Luan Melo
 * @param nome Nome do Usuário
 * @param senha Senha do Usuário
 * @param telefone Telefone do Usuário
 * @param cpf CPF do Usuário
 * @param email Email do Usuário
 * @param endereco ArrayList que possui os Endereços cadastrados pelo Usuário
 * @param sacolausuario Representa a Sacola de Compras do Usuário
 */
import java.util.ArrayList;

public class Usuario {
	
	private String nome;
	private String senha;
	private long telefone;
	private long cpf;
	private String email;
	private ArrayList<Endereco> enderecos = new ArrayList<>();
	private SacolaDeCompra sacolausuario = new SacolaDeCompra(this);
	
	public Usuario() {
		
	}
	
	public Usuario(String n, String s, long t, long c, String e) {
		
		this.nome = n;
		this.senha = s;
		this.telefone = t;
		this.cpf = c;
		this.email = e;		
	}

	//Gets e sets	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(ArrayList<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	//Retorna um endereco especifico
	public Endereco getEndereco(int i) {
		return enderecos.get(i);
	}
	
	//Modifica um endereco especifico no arraylist enderecos
	public void setEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public SacolaDeCompra getSacolausuario() {
		return sacolausuario;
	}

	public void setSacolausuario(SacolaDeCompra sacolausuario) {
		this.sacolausuario = sacolausuario;
	}
	
	//Sobreescrita do toString para o print dos usuarios
	@Override
	public String toString() {
		return "Nome: " + this.nome + " | Senha: " + this.senha + " | Telefone: " + this.telefone + " | CPF: " + this.cpf + " | Endereco: " + this.getEnderecos();
	}
	
}