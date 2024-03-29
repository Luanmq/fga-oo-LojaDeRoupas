package model;
/**
 * Classe que representa os Produtos cadastrados no sistema
 * @author Luan Melo
  * @author Lucas
 */
public abstract class Produto {
	protected String imagem;
	protected String nome;
	protected String departamento;
	protected String descricao;
	protected String marca;
	protected double preco;
	protected String condicao;
	protected String cor;
	protected Usuario usuario;
	
	//Gets e sets
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
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
	
}