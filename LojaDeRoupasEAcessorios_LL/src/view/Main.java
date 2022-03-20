package view;
import controle.*;
import model.Acessorio;
import model.Roupa;
import model.Usuario;

public class Main {
	 public static void main(String[] args) {	  
	  	 //Inicializa os dados pre cadastrados
		 Dados.precadastros();
	 	 
		 TelaLoginCadastroUsuarios tela = new TelaLoginCadastroUsuarios();
	 }
	
	 /*
	 public static boolean selecionarOuCadastrar() {
		 Scanner ler = new Scanner(System.in);
		 
		 //Lista usuarios cadastrados no sistema
		 System.out.println("L&L - Venda de Roupas e Acessorios");
		 System.out.println("Usuarios Cadastrados:");
		 for(int i = 0; i < Dados.usuarios.size(); i++) {
			System.out.println("Usuario " + (i + 1) + ": " + Dados.usuarios.get(i));
		 }
		 
		 System.out.println("Digite o numero do Usuario que deseja fazer login "
		 		+ "ou 0 para Cadastrar um novo:");
		 int resposta = ler.nextInt();
		 if(resposta > 0) {
			 //Faz o usuario selecionado ser o novo usuario principal
			 Dados.usuarioPrincipal = Dados.usuarios.get(resposta-1);
			 return true;
		 }else if(resposta == 0) {
			 //Cadastra um novo usuario
			 Usuario usuarionovo = new Usuario();
			 Dados.usuarios.add(usuarionovo);
			 Dados.usuarios.get(Dados.usuarios.size()-1).cadastrarUsuario();			 
			return false;
		 }
		return false;
	}
	 
	  public static void menu() {
		  int opcao = 0;

		  do {
			  System.out.println("\n");
			  System.out.println("L&L - Venda de Roupas e Acessorios");
			  System.out.println("Seja bem-vindo! Selecione uma opcao:");
			  System.out.println("1: Ver Todos os Produtos a venda\n2: Ver minha Conta\n3: Ver minha Sacola\n4: Busca\n5: Sair");
			  
			  Scanner ler = new Scanner(System.in);
			  opcao = ler.nextInt();
			  
			  switch(opcao) {
				//Mostra todos os Produtos a venda
			  	case 1:
					mostrarEComprarProdutos();
					break;
				
				//Mostra a Conta
			  	case 2:
			  		verMinhaConta();
				  break;
			  	
				//Sacola
			  	case 3:
					verSacola();
			  		break;
			  		
			  	//Busca
			  	case 4:
			  		busca();
			  		break;
			  		
			  	//Sair	
			  	case 5:
			  		System.out.println("Volte sempre!");
			  		break;
			  }
		 }while(opcao != 5);
	}
	  public static void verMinhaConta() {
		  Scanner ler = new Scanner(System.in);

		  System.out.println("1: Ver meus Produtos\n2: Ver informacoes da Conta\n3: Sair");
		  int opcao2 = ler.nextInt();
		  switch(opcao2) {
		  	//Produtos do Usuario
		  	case 1:
		  		verProdutos();
		  		break;
		  		
		  	//Conta do Usuario
		  	case 2:
		  		verConta();
		  		break;
		  	
		  	//Sair
		  	case 3:
		  		break;
		  }
	 }
	  
	  public static void busca() {
		  Scanner ler = new Scanner(System.in);

		  System.out.println("1: Buscar pelo nome do Acessorio ou Roupa\n2: Filtrar por Acessario ou Roupa\n3: Filtrar por departamento\n4: Sair");
		  int opcao = ler.nextInt();
		  switch(opcao) {
		  	//Buscar por nome
		  	case 1:
		  		System.out.println("Digite o Nome do Acessorios ou Roupa para buscar");
		  		ler.nextLine();
		  		String nome_busca = ler.nextLine();
		  		
		  		//Mostra os acessorios com o mesmo nome
	  			int acessorios_encontrados = 0;
		  		for(int i = 0; i < Dados.usuarios.size(); i++) {
	  			  for(int j = 0; j < Dados.usuarios.get(i).getAcessoriosAVenda().size(); j++){
	  				  if(Dados.usuarios.get(i).getAcessoriosAVenda().get(j).getNome().contains(nome_busca)) {
							System.out.println(Dados.usuarios.get(i).getAcessoriosAVenda().get(j));
							acessorios_encontrados++;
						}
					}
	  			}
		  		
		  		if(acessorios_encontrados == 0) {
		  			System.out.println("Nenhum Acessorio foi encontrado");
		  		}
  			 	
		  		//Mostra as roupas com o mesmo nome
	  			int roupas_encontradas = 0;
		  		for(int i = 0; i < Dados.usuarios.size(); i++) {
		  			for(int j = 0; j < Dados.usuarios.get(i).getRoupasAVenda().size(); j++){
						if(Dados.usuarios.get(i).getRoupasAVenda().get(j).getNome().contains(nome_busca)) {
		  					  System.out.println(Dados.usuarios.get(i).getRoupasAVenda().get(j));
								roupas_encontradas++;
						}
					}
	  			}
		  		
		  		if(roupas_encontradas == 0) {
		  			System.out.println("Nenhuma Roupa foi encontrada");
		  		}

		  		break;
		  	
		  	//Buscar por acessorio ou roupa	
		  	case 2:
		  		System.out.println("Digite 1 para buscar por todos os Acessorios e 2 para buscar por todas as Roupas");
		  		int opcao_busca = ler.nextInt();
		  		if(opcao_busca == 1) {
		  			//Mostra todos os acessorios dos usuarios cadastrados no sistema
		  			int acessorios_encontrados2 = 0;
		  			for(int i = 0; i < Dados.usuarios.size(); i++) {
		  			  for(int j = 0; j < Dados.usuarios.get(i).getAcessoriosAVenda().size(); j++){
							System.out.println(Dados.usuarios.get(i).getAcessoriosAVenda().get(j));
							acessorios_encontrados2++;
						}
		  			}
		  			
		  			if(acessorios_encontrados2 == 0) {
			  			System.out.println("Nenhum Acessorio foi encontrado");
			  		}
		  			
		  		}else if(opcao_busca == 2) {
			  		//Mostra todas roupas dos usuarios cadastrados no sistema
		  			int roupas_encontradas2 = 0;
		  			for(int i = 0; i < Dados.usuarios.size(); i++) {
			  			for(int j = 0; j < Dados.usuarios.get(i).getRoupasAVenda().size(); j++){
							System.out.println(Dados.usuarios.get(i).getRoupasAVenda().get(j));
		  					  roupas_encontradas2++;
						}
		  			}
		  			
		  			if(roupas_encontradas2 == 0) {
			  			System.out.println("Nenhuma Roupa foi encontrada");
			  		}
		  		}
		  		break;
		  	
		  	
		  	case 3:
		  		System.out.println("Digite o Departamento do Acessorios ou Roupa para buscar");
		  		ler.nextLine();
		  		String departamento_busca = ler.nextLine();
		  		
		  		//Mostra os acessorios com o mesmo nome
	  			int acessorios_encontrados3 = 0;
		  		for(int i = 0; i < Dados.usuarios.size(); i++) {
	  			  for(int j = 0; j < Dados.usuarios.get(i).getAcessoriosAVenda().size(); j++){
	  				  if(Dados.usuarios.get(i).getAcessoriosAVenda().get(j).getDepartamento().contains(departamento_busca)) {
							System.out.println(Dados.usuarios.get(i).getAcessoriosAVenda().get(j));
							acessorios_encontrados3++;
						}
					}
	  			}
		  		if(acessorios_encontrados3 == 0) {
		  			System.out.println("Nenhum Acessorio foi encontrado");
		  		}
  			 	
		  		//Mostra as roupas com o mesmo nome
	  			int roupas_encontradas3 = 0;
		  		for(int i = 0; i < Dados.usuarios.size(); i++) {
		  			for(int j = 0; j < Dados.usuarios.get(i).getRoupasAVenda().size(); j++){
						if(Dados.usuarios.get(i).getRoupasAVenda().get(j).getDepartamento().contains(departamento_busca)) {
		  					  System.out.println(Dados.usuarios.get(i).getRoupasAVenda().get(j));
								roupas_encontradas3++;
						}
					}
	  			}
		  		
		  		if(roupas_encontradas3 == 0) {
		  			System.out.println("Nenhuma Roupa foi encontrada");
		  		}
		  		
		  		break;
		  	
		  	//Sair
		  	case 4:
		  		break;
		  }
	  }
	  
	  public static void mostrarEComprarProdutos () {
		  Scanner ler = new Scanner(System.in);
		  
		  System.out.println("Roupas e Acessorios a venda:");
		  mostrarAcessoriosERoupas();
		  
		  System.out.println("Deseja comprar algum produto? Digite sim ou não abaixo:");
		  String resposta = ler.next();
		  
		  if(resposta.equals("sim")) {
			Dados.usuarioPrincipal.comprar();
		  }
	  }
	  
	  public static void verProdutos() {
		  Scanner ler = new Scanner(System.in);

		  System.out.println("1: Cadastrar um Produto\n2: Editar um Produto\n3: Deletar um produto"
			  		+ "\n4:Ver Produtos a venda\n5:Ver Produtos comprados\n6: Sair");
		  int opcao = ler.nextInt();
		  		
		  switch(opcao) {
		  	//Cadastrar
		  	case 1:
		  		System.out.println("Digite 1 para cadastrar uma Roupa e"
		  				+ " 2 para cadastrar um Acessorio:");
		  		int resposta = ler.nextInt();
				  switch(resposta) {
				  	//Ao cadastrar uma roupa colocamos ela automaticamente a venda
				  	case 1:
				  		Dados.usuarioPrincipal.venderRoupa();
					  break;
					  
					//Ao cadastrar um acessorio colocamos ela automaticamente a venda
				  	case 2:
				  		Dados.usuarioPrincipal.venderAcessorio();
					  break;
		  		}
		  		break;
		  	
		  	//Editar	
		  	case 2:
		  		System.out.println("Digite 1 para editar uma Roupa e"
		  				+ " 2 para editar um Acessorio:");
		  		int resposta2 = ler.nextInt();
				  switch(resposta2) {
				  	case 1:
				  		int i = 0;
				  		//Mostra todas as roupas cadastrados do usuario
				  		for(Roupa roupa : Dados.usuarioPrincipal.getRoupasAVenda()) {
				  			System.out.println((i+1) + ": " + roupa);
						  }
				  		
				  		//Seleciona para editar
				  		System.out.println("Digite o número da Roupa que deseja editar:");
				  		int posicaoRoupa = ler.nextInt();
				  		Dados.usuarioPrincipal.getRoupasAVenda().get(posicaoRoupa-1).editarProduto();
				  		break;
				  	
				  	case 2:
				  		int j = 0;
				  		//Mostra todas os acessorios cadastrados do usuario
				  		for(Acessorio acessorio : Dados.usuarioPrincipal.getAcessoriosAVenda()) {
				  			System.out.println((j+1) + ": " + acessorio);
						  }
				  		
				  		//Seleciona para editar
				  		System.out.println("Digite o número do Acessorio que deseja editar:");
				  		int posicaoAcessorio = ler.nextInt();
				  		Dados.usuarioPrincipal.getAcessoriosAVenda().get(posicaoAcessorio-1).editarProduto();
				  		break;
				  }
				  break;
		  	
			//Deletar
		  	case 3:
		  		System.out.println("Digite 1 para deletar uma Roupa e"
		  				+ " 2 para deletar um Acessorio:");
		  		int resposta3 = ler.nextInt();
				  switch(resposta3) {
					  //Deletar uma roupa	
					  case 1:
				  		int i = 0;
				  		//Mostra todas as roupas cadastrados do usuario
				  		for(Roupa roupa : Dados.usuarioPrincipal.getRoupasAVenda()) {
				  			System.out.println((i+1) + ": " + roupa);
						  }
				  		
				  		//Seleciona para editar
				  		System.out.println("Digite o número da Roupa que deseja editar:");
				  		int posicaoRoupa = ler.nextInt();
				  		Dados.usuarioPrincipal.getRoupasAVenda().get(posicaoRoupa-1).deletarProduto();
				  		break;
					  
				  	  //Deletar um acessorio	
					  case 2:
				  		int j = 0;
				  		//Mostra todas os acessorios cadastrados do usuario
				  		for(Acessorio acessorio : Dados.usuarioPrincipal.getAcessoriosAVenda()) {
				  			System.out.println((j+1) + ": " + acessorio);
						  }
				  		
				  		//Seleciona para editar
				  		System.out.println("Digite o número do Acessorio que deseja deletar:");
				  		int posicaoAcessorio = ler.nextInt();
				  		Dados.usuarioPrincipal.getAcessoriosAVenda().get(posicaoAcessorio-1).deletarProduto();
				  		break;
				  }
				  break;
		  	
			//Ver Produtos a venda
		  	case 4:
		  		System.out.println("Produtos a venda do Usuario: ");
				
		  		//Mostra todas os acessorios cadastrados do usuario
		  		for(Acessorio acessorio : Dados.usuarioPrincipal.getAcessoriosAVenda()) {
		  			System.out.println(acessorio);
				  }
		  		
		  		//Mostra todas as roupas cadastrados do usuario
		  		for(Roupa roupa : Dados.usuarioPrincipal.getRoupasAVenda()) {
		  			System.out.println(roupa);
				  }
		  		break;
		  	
		  	//Ver Produtos comprados
		  	case 5:
		  		System.out.println("Produtos comprados do Usuario");
		  		
		  		//Mostra todas os acessorios cadastrados do usuario
		  		for(Acessorio acessorio : Dados.usuarioPrincipal.getAcessoriosComprados()){
		  			System.out.println(acessorio);
				  }
		  		
		  		//Mostra todas as roupas cadastrados do usuario
		  		for(Roupa roupa : Dados.usuarioPrincipal.getRoupasCompradas()) {
		  			System.out.println(roupa);
				  }
		  		break;

		  	//Sair
		  	case 6:
		  		break;
			}
	  }
	  
	  public static void verConta() {
		  Scanner ler = new Scanner(System.in);

		  System.out.println("1: Editar minha conta\n2: Deletar minha conta\n3: Ver dados da conta\n 4: Sair");
		  int opcao = ler.nextInt();
		  		
		  switch(opcao) {
		  	//Editar usuario
		  	case 1:
		  		Dados.usuarioPrincipal.editarUsuario();
		  		break;
			
		  	//Deletar usuario
		  	case 2:
		  		Dados.usuarioPrincipal.deletarUsuario();
		  		break;
			
		  	//Ver dados cadastrados do usuario
		  	case 3:
		  		System.out.println(Dados.usuarioPrincipal);

		  	//Sair
		  	case 4:
		  		break;
		  }
	  }
	  
	  public static void verSacola() {
		  Scanner ler = new Scanner(System.in);

		  System.out.println("1: Ver Produtos na Sacola\n2: Finalizar compra\n3: Sair");
		  int opcao = ler.nextInt();
		  		
		  switch(opcao) {
		  	//Mostra os produtos na sacola
		  	case 1:
				System.out.println("Produtos dentro da Sacola:");
		  		for(Acessorio acessorio : Dados.usuarioPrincipal.getSacola().getSacolaParaAcessorios()) {
					System.out.println(acessorio);
		  		}
		  		
		  		for(Roupa roupa : Dados.usuarioPrincipal.getSacola().getSacolaParaRoupas()) {
			  		System.out.println(roupa);
		  		}
		  		break;
		  	
		  	//Chama a funcao finalizar compra
		  	case 2:
		  		Dados.usuarioPrincipal.getSacola().finalizarCompra();
		  		break;
			
		  	//Sai da sacola
		  	case 3:
		  		break;
		  }
	  }
	  
	  public static void mostrarAcessoriosERoupas() {
		  for(int i = 0; i < Dados.usuarios.size(); i++) {
			//Mostra todos os acessorios dos usuarios cadastrados no sistema
			for(int j = 0; j < Dados.usuarios.get(i).getAcessoriosAVenda().size(); j++){
				System.out.println(Dados.usuarios.get(i).getAcessoriosAVenda().get(j));
			}
			//Mostra todas roupas dos usuarios cadastrados no sistema
			for(int j = 0; j < Dados.usuarios.get(i).getRoupasAVenda().size(); j++){
				System.out.println(Dados.usuarios.get(i).getRoupasAVenda().get(j));
			}
		  }
	  }
	  */
}
