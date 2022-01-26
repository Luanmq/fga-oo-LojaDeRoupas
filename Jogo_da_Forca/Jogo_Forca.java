import java.util.Random;
import java.util.Scanner;

public class Jogo_Forca {		
	public static void menu() {
    	System.out.println("\nJOGO DA FORCA\nDigite uma opcão:");
    	System.out.println(" 1. Gerenciar Temas\n 2. Gerenciar Palavras\n 3. Jogar\n 4. Sair");
	}
	
	public static void menu_case1() {
    	System.out.println("\nGERENCIAR TEMAS\nDigite uma opcão:");
    	System.out.println(" 1. Cadastrar\n 2. Excluir\n 3. Buscar\n 4. Voltar para o Menu");
	}
	
	public static void menu_case2() {
    	System.out.println("\nGERENCIAR PALAVRAS\nDigite uma opcão:");
    	System.out.println(" 1. Cadastrar\n 2. Excluir\n 3. Buscar\n 4. Listagem\n 5. Voltar para o Menu");
	}
	
	public static void cadastros(String [][] temas_palavras) {
		temas_palavras[0][0] = "animal";
		temas_palavras[0][1] = "rato";
		temas_palavras[0][2] = "gata";
		temas_palavras[0][3] = "cachorro";
		temas_palavras[0][4] = "papagaio";
		temas_palavras[0][5] = "urso";
		temas_palavras[0][6] = "esquilo";
		temas_palavras[0][7] = "leao";
		temas_palavras[0][8] = "tigre";
		temas_palavras[0][9] = "lobo";
		temas_palavras[0][10] = "onca";
	
	temas_palavras[1][0] = "pessoa";
		temas_palavras[1][1] = "luan";
		temas_palavras[1][2] = "lais";
		temas_palavras[1][3] = "lara";
		temas_palavras[1][4] = "carlos";
		temas_palavras[1][5] = "joao";
		temas_palavras[1][6] = "maria";
		temas_palavras[1][7] = "paulo";
		temas_palavras[1][8] = "tiago";
		temas_palavras[1][9] = "julia";
		temas_palavras[1][10] = "pedro";
	
	temas_palavras[2][0] = "lugar";
		temas_palavras[2][1] = "praia";
		temas_palavras[2][2] = "biblioteca";
		temas_palavras[2][3] = "casa";
		temas_palavras[2][4] = "praca";
		temas_palavras[2][5] = "quarto";
		temas_palavras[2][6] = "padaria";
		temas_palavras[2][7] = "comercio";
		temas_palavras[2][8] = "piscina";
		temas_palavras[2][9] = "festa";
		temas_palavras[2][10] = "casarao";
		
	temas_palavras[3][0] = "comida";
		temas_palavras[3][1] = "pao";
		temas_palavras[3][2] = "biscoito";
		temas_palavras[3][3] = "bolacha";
		temas_palavras[3][4] = "leite";
		temas_palavras[3][5] = "manteiga";
		temas_palavras[3][6] = "carne";
		temas_palavras[3][7] = "frango";
		temas_palavras[3][8] = "linguica";
		temas_palavras[3][9] = "doce";
		temas_palavras[3][10] = "acucar";
	
	temas_palavras[4][0] = "objeto";
		temas_palavras[4][1] = "mesa";
		temas_palavras[4][2] = "cadeira";
		temas_palavras[4][3] = "mouse";
		temas_palavras[4][4] = "teclado";
		temas_palavras[4][5] = "tela";
		temas_palavras[4][6] = "lampada";
		temas_palavras[4][7] = "celular";
		temas_palavras[4][8] = "boneca";
		temas_palavras[4][9] = "lapis";
		temas_palavras[4][10] = "bolsa";
	}

	public static boolean verificar_palavra (String tema) {
		boolean valido = false;
		String termo_para_validar;
		termo_para_validar = tema;
		
		termo_para_validar = termo_para_validar.toLowerCase();
		termo_para_validar = termo_para_validar.replaceAll(" ", "");
		if(termo_para_validar.matches("[a-z]*")){
			valido = true;
		}
		
		return valido;
	}
	
	public static boolean verificar_numero (String opcao, int numero_switch) {
		boolean valido = true;
		String termo_para_validar;
		termo_para_validar = opcao;
		
		if(!termo_para_validar.matches("[1-" + numero_switch + "]*")){
			valido = false;
		}
		
		if(termo_para_validar.length() != 1) {
			valido = false;
		}
		
		return valido;
	}
	
	public static void switch_tema(String [][] temas_palavras, String opcao_case1) {
		switch(opcao_case1) {
			case "1": //Cadastrar
				operacoes_tema(temas_palavras);
				break;
				
			case "2": //Excluir
				excluir_tema(temas_palavras);
				break; 
				
			case "3": //Buscar
				buscar_tema(temas_palavras);
				break; 
				
			case "4": //Voltar
				break;
		}
	}

	public static void switch_palavra(String [][] temas_palavras, String opcao_case2) {
		switch(opcao_case2) {
    	case "1": //Cadastrar
    		operacoes_palavra(temas_palavras);
    		break;
    		
    	case "2": //Excluir
    		excluir_palavra(temas_palavras);
    		break; 
    		
    	case "3": //Buscar
    		buscar_palavra(temas_palavras);
    		break; 
    		
    	case "4": //Listagem
    		listar_palavra(temas_palavras);
    		break;
			
    	case "5": //Voltar
    		break;
		}
	}

	//Vê se tem tema repetido
	public static boolean tema_repetido(String[][] temas_palavras, String tema) {	
		tema = tema.replaceAll(" ", "");		
		for (int j = 0; j < temas_palavras.length; j++) {
			if(tema.equals(temas_palavras[j][0]) == true) {
				return true;
			}		
		}
		return false;
	}

	public static void operacoes_tema(String [][] temas_palavras) {
		System.out.println("\nDigite o tema para ser cadastrado:\nPara finalizar digite fim.");
		Scanner ler = new Scanner(System.in);
		String tema = ler.nextLine();

		int j = 0;
		
		while(tema.equals("fim") == false) {
			if(j > 0 && (tema_repetido(temas_palavras,tema) == true)) {
				System.out.println("\nNão foi possível cadastrar o tema. "
						+ "Verifique se existem temas com esse mesmo nome\nDigite novamente:");
			}else if(verificar_palavra(tema) == false) {
				System.out.println("Houve um erro ao cadastrar o tema digitado, por favor insira novamente: ");
			}else if(cadastrar_tema(temas_palavras,tema) == false){
				System.out.println("\nNão foi possível cadastrar um tema, pois não há mais espaco."
						+ " Tente excluir outro tema antes.");
			}
			
			tema = ler.nextLine();
			j++;
		}
	
		int i = 0;
		System.out.println("\n");
		while(temas_palavras[i][0] != null) {
			System.out.println("Tema cadastrado: " + temas_palavras[i][0]);
			i++;
		}
}
	
	//Realizar o cadastro do tema
	public static boolean cadastrar_tema(String [][] temas_palavras, String tema) {
		boolean valido = false;
		int k = 0;
		
		for(int j = 0; j < temas_palavras.length; j++){
        	if(temas_palavras[k][0] == null) {
        		temas_palavras[k][0] = tema;
    			
        		valido = true;
        		return valido;
    		}
			k++;
        }
		
		return valido;
	}

	
	//Buscar os temas
	public static int buscar_tema(String [][] temas_palavras) {
		Scanner ler = new Scanner(System.in);
		String tema_busca;
		
		System.out.println("\nDigite o tema que deseja buscar:");
		tema_busca = ler.next();
		ler.nextLine();
		
		while (verificar_palavra(tema_busca) == false) {
			System.out.println("Houve um erro ao buscar o tema digitado, por favor insira novamente: ");
			tema_busca = ler.next();
			ler.nextLine();
		}
		
		int j = 0;
		int retorno = 0;
		while(temas_palavras[j][0] != null) {	
			if(temas_palavras[j][0].contains(tema_busca)) {
				System.out.println("\nTema encontrado: " + temas_palavras[j][0]);				
				retorno++;
				return j;
			}
			j++;
		}
		
		if(retorno == 0) {
			System.out.println("\nNão foi possível achar esse tema");
		}
		
		return j;
	}
	
	//Excluir os temas
	public static void excluir_tema(String [][] temas_palavras) {
		int numero_tema = buscar_tema(temas_palavras);
		int j = 0;
		
		if(temas_palavras[numero_tema][0] != null) {
			if(temas_palavras[numero_tema][1] == null) {
				System.out.println("\nO tema " + temas_palavras[numero_tema][0] + " será excluído");
				while(temas_palavras[numero_tema][j] != null) {
					temas_palavras[numero_tema][j] = null;
					j++;
				}
			}else {
				System.out.println("\nNão foi possível excluir o tema. "
						+ "Verifique se existem palavras cadastradas nesse tema.\n");
			}
		}
	}
	
	//Vê se tem palavra repetida
	public static boolean palavra_repetida(String[][] temas_palavras, String palavra, int numero_tema) {
		palavra = palavra.replaceAll(" ", "");
		
		for (int j = 0; j < temas_palavras.length; j++) {
			if(palavra.equals(temas_palavras[numero_tema][j]) == true) {
				return true;
			}		
		}
		return false;
	}

	public static void operacoes_palavra(String [][] temas_palavras) {
		int numero_tema = buscar_tema(temas_palavras);

		if((temas_palavras[numero_tema][0] != null) || numero_tema == 0) { // == 0
			System.out.println("\nDigite a palavra para ser cadastrada no tema " + temas_palavras[numero_tema][0] + ":\nPara finalizar digite fim.");
			Scanner ler = new Scanner(System.in);
			String palavra = ler.nextLine();

			int j = 1;
			
			while(palavra.equals("fim") == false) {
				if(j > 0 && palavra_repetida(temas_palavras,palavra,numero_tema) == true) {
					System.out.println("\nNão foi possível cadastrar a palavra. "
							+ "Verifique se existem palavras com esse mesmo nome\nDigite novamente:");
				}else if(verificar_palavra(palavra) == false) {
					System.out.println("Houve um erro ao cadastrar a palavra digitada, por favor insira novamente: ");
				}else if(cadastrar_palavra(temas_palavras,palavra,numero_tema) == false){
					System.out.println("\nNão foi possível cadastrar a palavra, pois não há mais espaco."
							+ " Tente excluir outra palavra antes.");
				}
				
				palavra = ler.nextLine();
				j++;
			}
			
			int i = 1;
			while(temas_palavras[numero_tema][i] != null) {
				System.out.println("Palavra cadastrada: " + temas_palavras[numero_tema][i]);
				i++;
			}
		}
	}
	
	//Realizar o cadastro do tema
	public static boolean cadastrar_palavra(String [][] temas_palavras,String palavra, int numero_tema) {
		boolean valido = false;
		
		int k = 1;
		for(int j = 0; j < temas_palavras.length; j++){
        	if(temas_palavras[numero_tema][k] == null) {
        		temas_palavras[numero_tema][k] = palavra;
    			
        		valido = true;
        		return valido;
    		}
			k++;
        }
		
		return valido;
	}
	
	//Excluir palavras
	public static void excluir_palavra(String [][] temas_palavras) {
		System.out.println("\nDigite a palavra que deseja excluir:");
		Scanner ler = new Scanner(System.in);
		String palavra_excluir = ler.next();
		ler.nextLine();

		int retorno = 0;
		
		for(int j = 0; j < temas_palavras.length; j++){
	        for(int i = 1; i < temas_palavras.length; i++){ 
	        	if(temas_palavras[j][i] != null && temas_palavras[j][i].contains(palavra_excluir)) {
					System.out.println("\nA palavra " + temas_palavras[j][i] + " foi excluída com sucesso");
	        		temas_palavras[j][i] = null;
					retorno++;
				}
	        }
		}
		
		if(retorno == 0) {
			System.out.println("\nNão foi possível achar essa palavra");
		}
	}
	
	//Buscar palavras
	public static void buscar_palavra(String [][] temas_palavras) {
		System.out.println("\nDigite a palavra que deseja buscar:");
		Scanner ler = new Scanner(System.in);

		String palavra_busca = ler.next();
		ler.nextLine();

		int retorno = 0;
		
		for(int j = 0; j < temas_palavras.length; j++){
	        for(int i = 1; i < temas_palavras.length; i++){ 
	        	if(temas_palavras[j][i] != null && temas_palavras[j][i].contains(palavra_busca)) {
					System.out.println("\nPalavra encontrada no tema: " + temas_palavras[j][0]);				
					retorno++;
				}
	        }
		}
	     		
		if(retorno == 0) {
			System.out.println("\nPalavra não encontrada");
		}
	}

	//Listagem de palavras por tema
	public static void listar_palavra(String [][] temas_palavras) {
		int numero_tema = buscar_tema(temas_palavras);
		int retorno = 0;
		
		for(int j = 1; j < temas_palavras.length; j++){
        	if(temas_palavras[numero_tema][j] != null) {
    			System.out.println("Palavra cadastrada: " + temas_palavras[numero_tema][j]);
    			retorno++;
			}
		}
		
		if(retorno == 0) {
			System.out.println("\nNão foi possível palavras nesse tema");
		}
	}

	//Numero de palavra aleatoria
	public static int numero_aleatorio (String [][] temas_palavras, int numero_tema) {
        Random gerador = new Random();
        int numero_de_elementos = 0;
        
        for (int j = 0; j < temas_palavras.length; j++) {
			if(temas_palavras[numero_tema][j] != null) {
				numero_de_elementos++;
			}		
		}
        
        int numero_aleatorio = gerador.nextInt((numero_de_elementos - 1));
        
        do {
        	numero_aleatorio = gerador.nextInt((numero_de_elementos - 1));
        }while (numero_aleatorio <= 0);
        
        return numero_aleatorio;  
	}
	
	//Ver se a letra é repetida
	public static boolean letra_repetida(String[] letras_digitadas_antes, String letra) {
		for (int j = 0; j < letras_digitadas_antes.length; j++) {

			if(letra.equals(letras_digitadas_antes[j]) == true) {
				return true;
			}		
		}
		return false;
	}

	//Vê se existe a letra
		public static int letra_existe(String palavra_sendo_jogada, String letra) {	
			String[] letras_da_palavra = palavra_sendo_jogada.split("(?!^)");
			int letras_na_palavra = 0;
			
			for (int j = 0; j < letras_da_palavra.length; j++) {
				if(letra.equals(letras_da_palavra[j]) == true) {
					letras_na_palavra++;
				}		
			}
			return letras_na_palavra;
		}
		
	//Jogar
	public static void jogar(String [][] temas_palavras) {
		String jogar_novamente = "texto";
		int numero_tema = 0;
		
		do {
			numero_tema = buscar_tema(temas_palavras);			
			if(numero_tema == 0) {
				int numero_palavra = numero_aleatorio (temas_palavras,numero_tema) ;
				int erros = 0;
				int letras_acertadas = 0;
				int i = 0;
				String letra = "letra";
				String []letras_digitadas_antes = new String[50];
				String palavra_sendo_jogada = temas_palavras[numero_tema][numero_palavra];
				

				while(letras_acertadas != palavra_sendo_jogada.length() && erros < 5) {
					System.out.print("\nDigite uma letra:");
					Scanner ler = new Scanner(System.in);
					letra = ler.next();	
					ler.nextLine();


					if(i > 0 && letra_repetida(letras_digitadas_antes, letra) == true) {
						System.out.print("Tente outra letra!");
					}else if(verificar_palavra(letra) == false) {
						System.out.println("Houve um erro ao ler a letra digitada, por favor insira novamente: ");
					}else {
						letras_digitadas_antes[i] = letra;
						int quantidade_de_letras = letra_existe(palavra_sendo_jogada,letra);				
						if (quantidade_de_letras == 0) {
							erros++;
							System.out.print("A palavra não possui essa letra, no momento você possui " + erros + " erros");
							
							if(erros == 5) {
								System.out.print("\n\nFim de jogo, a palavra era: " + palavra_sendo_jogada + 
										"\nVocê perdeu! Digite sim se deseja jogar novamente: ");
								jogar_novamente = ler.next();
								ler.nextLine();
							}
						}else {
							System.out.print("A palavra possui " + quantidade_de_letras + " letras " + letra.toUpperCase());
							letras_acertadas+= quantidade_de_letras;
							
							if(letras_acertadas == palavra_sendo_jogada.length()) {
								System.out.print("\n\nParabéns! A palavra era: " + palavra_sendo_jogada +
										"\nDigite sim se deseja jogar novamente: ");
								jogar_novamente = ler.next();
								ler.nextLine();
							}
						}
			
						i++;
					}
			}
		}
	}while (jogar_novamente.equals("sim") == true && numero_tema == 0);
}
			
	// Main
	public static void main(String[] args) {				
		String [][] temas_palavras = new String[50][50];
		cadastros(temas_palavras);
	
		boolean sair = false;
		String opcao;
		
		do {		
			menu();
			Scanner ler = new Scanner(System.in);
			opcao = ler.nextLine();
			int numero_switch = 4; 
			
			if(verificar_numero(opcao,numero_switch) == false) {
				System.out.println("Houve um erro ao ler a opcao digitada, por favor insira novamente: ");
			}else {
				switch(opcao) {
		    	case "1": //Gerenciar Temas
	    			menu_case1();
		        	String opcao_case1 = ler.nextLine();
		    		numero_switch = 4;
		    		
		    		if(verificar_numero(opcao_case1,numero_switch) == false) {
						System.out.println("Houve um erro ao ler a opcao digitada, por favor insira novamente: ");
		    		}else {
						switch_tema(temas_palavras,opcao_case1);
					}
					break;
			
		    	case "2": //Gerenciar Palavras
		    		menu_case2();
		        	String opcao_case2 = ler.nextLine();
		    		numero_switch = 5;
		    		
		    		if(verificar_numero(opcao_case2,numero_switch) == false) {
						System.out.println("Houve um erro ao ler a opcao digitada, por favor insira novamente: ");
		    		}else {
						switch_palavra(temas_palavras,opcao_case2);
					}
					break;
		    		
		    	case "3": //Jogar
		    		jogar(temas_palavras);
		    		break;
		    		
		    	case "4": //Sair
		        	System.out.print("\nAté mais!");
		        	sair = true;
		        	break;
				}
			}
		}while (sair == false);
	}
}