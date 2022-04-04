package model;

public class Endereco {

	 private String pais;
	 private String estado;
	 private String cidade;
	 private int numeroResidencia;
	 private int cep;
	 private String referencia;
	 private Usuario usuario;
	
	public Endereco(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco(String p, String e, String c, int n, int ce, String r, Usuario u) {
		this.pais = p;
		this.estado = e;
		this.cidade = c;
		this.numeroResidencia = n;
		this.cep = ce;
		this.referencia = r;
		this.usuario = u;
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

	public int getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(int numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
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
		return "Pais: " + pais + " | Estado: " + estado + " | Cidade: " + cidade + " | Numero da Residencia: " + 
	numeroResidencia + " | CEP: " + cep + " | Referencia: " + referencia;
	}	
	
}
