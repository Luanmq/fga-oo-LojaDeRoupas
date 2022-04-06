package model;

import java.util.ArrayList;

public class Dados {
	//Usuario responsavel pelas acoes no sistema
	private Usuario usuarioPrincipal = new Usuario();
	
	//Lista com todos os usuarios cadastrados no sistema
	private ArrayList<Usuario> usuarios = new ArrayList<>();

	//Listas de acessorios e roupas no sistema
	private ArrayList<Acessorio> acessoriosComprados = new ArrayList<>();
	private ArrayList<Roupa> roupasCompradas = new ArrayList<>();
	
	private ArrayList<Acessorio> acessoriosAVenda = new ArrayList<>();
	private ArrayList<Roupa> roupasAVenda = new ArrayList<>();
	
	//Pre cadastro de dados
	public void precadastros() {
		  Usuario bruno = new Usuario();
			  bruno.setNome("Bruno Silva");
			  bruno.setSenha("carro");
			  bruno.setTelefone(998808198);
			  bruno.setCpf(805743618);
			  bruno.setEmail("bruno@gmail.com");
			  	
		  Endereco enderecobruno = new Endereco(bruno);
		  		enderecobruno.setPais("Brasil");
				enderecobruno.setEstado("DF");
				enderecobruno.setCidade("Gama");
				enderecobruno.setNumeroResidencia(211);
				enderecobruno.setCep(7711811);
				enderecobruno.setReferencia("Shopping");
				bruno.setEndereco(enderecobruno);
				
		  Roupa blusapreta = new Roupa(bruno);
		  		blusapreta.setImagem("img/Roupa.0.png");
		  		blusapreta.setNome("Blusa Preta");
			 	blusapreta.setDepartamento("Masculino");
			 	blusapreta.setDescricao("Blusa preta com estampa de listras na frente");
			 	blusapreta.setMarca("Adidas");
			 	blusapreta.setPreco(35.00);
			 	blusapreta.setCondicao("Boa");
			 	blusapreta.setCor("Preta");
			 	blusapreta.setTamanho("M");
			 	blusapreta.setTecido("Algodao");
			 	blusapreta.setEstampa("Listras");
			 	roupasAVenda.add(blusapreta);
		  
		  Acessorio bonejeans = new Acessorio(bruno);
		  		bonejeans.setImagem("img/Acess.0.png");
			  	bonejeans.setNome("Bone Jeans");
			  	bonejeans.setDepartamento("Unissex");
			  	bonejeans.setDescricao("Bone com tecido jeans azul");
			  	bonejeans.setMarca("Ciclone");
			  	bonejeans.setPreco(25.00);
			  	bonejeans.setCondicao("Boa");
			  	bonejeans.setCor("Azul");
			  	bonejeans.setMaterial("Jeans");
			  	bonejeans.setPeso(300);
			  	bonejeans.setMedidaLargura(20);
			  	bonejeans.setMedidaAltura(20);
			  	acessoriosAVenda.add(bonejeans);
			  	usuarios.add(bruno);
			  
		  Usuario lucas = new Usuario();
		  		lucas.setNome("Lucas Costa");
		  		lucas.setSenha("futebol");
			  	lucas.setTelefone(992508198);
			  	lucas.setCpf(805743699);
			  	lucas.setEmail("lucascosta@gmail.com");
			  	
		  Endereco enderecolucas = new Endereco(lucas);
				  enderecolucas.setPais("Brasil");
				  enderecolucas.setEstado("TO");
				  enderecolucas.setCidade("Palmas");
				  enderecolucas.setNumeroResidencia(2111);
				  enderecolucas.setCep(7669911);
				  enderecolucas.setReferencia("Centro");
				  lucas.setEndereco(enderecolucas);
		  		  
		  Roupa blusaverde = new Roupa(lucas);
		  		blusaverde.setImagem("img/Roupa.1.png");
			  	blusaverde.setNome("Blusa Verde Nike");
			  	blusaverde.setDepartamento("Infatil");
			  	blusaverde.setDescricao("Blusa infantil verde da marca Nike");
			  	blusaverde.setMarca("Nike");
			  	blusaverde.setPreco(30.00);
			  	blusaverde.setCondicao("Ruim");
			  	blusaverde.setCor("Verde");
			  	blusaverde.setTamanho("PP");
			  	blusaverde.setTecido("Poliester");
			  	blusaverde.setEstampa("Sem estampa");
			 	roupasAVenda.add(blusaverde);
		  
		  Acessorio oculospreto = new Acessorio(lucas);
		  		oculospreto.setImagem("img/Acess.1.png");
			  	oculospreto.setNome("Oculos preto chique");
			  	oculospreto.setDepartamento("Feminino");
			  	oculospreto.setDescricao("Oculos preto da marca Chilli Beans");
			  	oculospreto.setMarca("Chilli Beans");
			  	oculospreto.setPreco(50.00);
			  	oculospreto.setCondicao("Otima");
			  	oculospreto.setCor("Preto");
			  	oculospreto.setMaterial("Metal");
			  	oculospreto.setPeso(100.00);
			  	oculospreto.setMedidaLargura(10);
			  	oculospreto.setMedidaAltura(10);
			  	acessoriosAVenda.add(oculospreto);
			  	usuarios.add(lucas);

		Usuario sofia = new Usuario();	
				sofia.setNome("Sofia Alice");
				sofia.setSenha("computador");	
				sofia.setTelefone(944408198);
				sofia.setCpf(775743699);
				sofia.setEmail("sofiaalice@gmail.com");
				
		Endereco enderecosofia = new Endereco(sofia);
			enderecosofia.setPais("Brasil");
			enderecosofia.setEstado("BA");
			enderecosofia.setCidade("Salvador");
			enderecosofia.setNumeroResidencia(201);
			enderecosofia.setCep(7719441);
			enderecosofia.setReferencia("Praca");
			sofia.setEndereco(enderecosofia);
		  		  
		  Roupa vestidorosa = new Roupa(sofia);
		  		vestidorosa.setImagem("img/Roupa.2.png");
			  	vestidorosa.setNome("Vestido florido rosa");
			  	vestidorosa.setDepartamento("Infantil");
			  	vestidorosa.setDescricao("Vestido rosa florido e infantil");
			  	vestidorosa.setMarca("Melissa");
			  	vestidorosa.setPreco(40.00);
			  	vestidorosa.setCondicao("Boa");
			  	vestidorosa.setCor("Rosa");
			  	vestidorosa.setTamanho("P");
			  	vestidorosa.setTecido("Algodao");
			  	vestidorosa.setEstampa("Flores");
			  	roupasAVenda.add(vestidorosa);
		  
		  Acessorio sapatilha = new Acessorio(sofia);
		  		sapatilha.setImagem("img/Acess.2.png");
			  	sapatilha.setNome("Sapatilha de balé");
			  	sapatilha.setDepartamento("Feminino");
			  	sapatilha.setDescricao("Sapatilha de balé rosa claro");
			  	sapatilha.setMarca("Bale Calçados");
			  	sapatilha.setPreco(45.00);
			  	sapatilha.setCondicao("Boa");
			  	sapatilha.setCor("Rosa");
			  	sapatilha.setMaterial("Algodao");
			  	sapatilha.setPeso(200.00);
			  	sapatilha.setMedidaLargura(30);
			  	sapatilha.setMedidaAltura(20);
			  	acessoriosAVenda.add(sapatilha);
			  	usuarios.add(sofia);

		  Usuario helena = new Usuario();
		  		helena.setNome("Helena Carvalho");
				helena.setSenha("livro");
		  		helena.setTelefone(957708198);
		  		helena.setCpf(665743699);
		  		helena.setEmail("helenacarvo@gmail.com");
		  		
		  Endereco enderecohelena = new Endereco(helena);
			  enderecohelena.setPais("Brasil");
			  enderecohelena.setEstado("RJ");
			  enderecohelena.setCidade("Rio de Janeiro");
			  enderecohelena.setNumeroResidencia(22);
			  enderecohelena.setCep(788441);
			  enderecohelena.setReferencia("Cristo");
			  helena.setEndereco(enderecohelena);
		  		  
		  Roupa calcajeanspreta = new Roupa(helena);
		  		calcajeanspreta.setImagem("img/Roupa.3.png");
			  	calcajeanspreta.setNome("Calca Jeans preta");
			  	calcajeanspreta.setDepartamento("Masculino");
			  	calcajeanspreta.setDescricao("Calca jeans preta rasgada");
			  	calcajeanspreta.setMarca("Levi");
			  	calcajeanspreta.setPreco(140.00);
			  	calcajeanspreta.setCondicao("Otima");
			  	calcajeanspreta.setCor("Preta");
			  	calcajeanspreta.setTamanho("M");
			  	calcajeanspreta.setTecido("Jeans");
			  	calcajeanspreta.setEstampa("Sem estampa");
			  	roupasAVenda.add(calcajeanspreta);
		  
		  Acessorio cintocouro = new Acessorio(helena);
		  		cintocouro.setImagem("img/Acess.3.png");
			  	cintocouro.setNome("Cinto de couro");
			  	cintocouro.setDepartamento("Unissex");
			  	cintocouro.setDescricao("Cinto de couro marrom");
			  	cintocouro.setMarca("Cintos Silveira");
			  	cintocouro.setPreco(30.00);
			  	cintocouro.setCondicao("Ruim");
			  	cintocouro.setCor("Marrom");
			  	cintocouro.setMaterial("Couro");
			  	cintocouro.setPeso(300.00);
			  	cintocouro.setMedidaLargura(5);
			  	cintocouro.setMedidaAltura(10);
			  	acessoriosAVenda.add(cintocouro);
			  	usuarios.add(helena);
	  }
	
	//Gets e sets
	public Usuario getUsuarioPrincipal() {
		return usuarioPrincipal;
	}

	public void setUsuarioPrincipal(Usuario usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Acessorio> getAcessoriosComprados() {
		return acessoriosComprados;
	}

	public void setAcessoriosComprados(ArrayList<Acessorio> acessoriosComprados) {
		this.acessoriosComprados = acessoriosComprados;
	}

	public ArrayList<Roupa> getRoupasCompradas() {
		return roupasCompradas;
	}

	public void setRoupasCompradas(ArrayList<Roupa> roupasCompradas) {
		this.roupasCompradas = roupasCompradas;
	}

	public ArrayList<Acessorio> getAcessoriosAVenda() {
		return acessoriosAVenda;
	}

	public void setAcessoriosAVenda(ArrayList<Acessorio> acessoriosAVenda) {
		this.acessoriosAVenda = acessoriosAVenda;
	}

	public ArrayList<Roupa> getRoupasAVenda() {
		return roupasAVenda;
	}

	public void setRoupasAVenda(ArrayList<Roupa> roupasAVenda) {
		this.roupasAVenda = roupasAVenda;
	}
	
}