import java.util.Scanner;

public class Jogo_Forca {		
	public static void menu() {
    	System.out.println("\nJOGO DA FORCA\nDigite uma opção:");
    	System.out.println(" 1. Gerenciar Temas\n 2. Gerenciar Palavras\n 3. Jogar\n 4. Sair");
	}
	
	public static void menu_case1() {
    	System.out.println("\nGERENCIAR TEMAS\nDigite uma opção:");
    	System.out.println(" 1. Cadastrar\n 2. Excluir\n 3. Buscar\n 4. Voltar para o Menu");
	}
	
	public static void menu_case2() {
    	System.out.println("\nGERENCIAR PALAVRAS\nDigite uma opção:");
    	System.out.println(" 1. Cadastrar\n 2. Excluir\n 3. Buscar\n 4. Listagem\n 5. Voltar para o Menu");
	}
	
	//Vê se tem tema repetido
	public static boolean tema_repetido(String[][] temas_palavras, String tema) {	
		for (int j = 0; j < temas_palavras.length; j++) {
			if(tema.equals(temas_palavras[j][0]) == true) {
				return true;
			}		
		}
		return false;
	}

	//Cadastra os temas
	public static void cadastrar_tema(String [][] temas_palavras) {
		System.out.println("\nDigite o tema para ser cadastrado:\nPara finalizar digite fim.");
		Scanner ler = new Scanner(System.in);
		String tema = ler.next();
		int i = 0;

		while(tema.equals("fim") == false) {
			if(i > 0 && tema_repetido(temas_palavras,tema) == true) {
				System.out.println("\nNão foi possível cadastrar o tema. "
						+ "Verifique se existem temas com esse mesmo nome\nDigite novamente:");
				tema = ler.next();
			}else {
				temas_palavras[i][0] = tema;
				i++;
				tema = ler.next();
			}
		}
		
		int j = 0;
		System.out.println("\n");
		while(temas_palavras[j][0] != null) {
			System.out.println("Tema cadastrado: " + temas_palavras[j][0]);
			j++;
		}
		
	}
	
	//Buscar os temas
	public static int buscar_tema(String [][] temas_palavras) {
		System.out.println("\nDigite o tema que deseja buscar:");
		Scanner ler = new Scanner(System.in);
		String tema_busca = ler.next();
		
		int j = 0;
		int retorno = 0;
		while(temas_palavras[j][0] != null) {	
			if(temas_palavras[j][0].equals(tema_busca)) {
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
		for (int j = 0; j < temas_palavras.length; j++) {
			if(palavra.equals(temas_palavras[numero_tema][j]) == true) {
				return true;
			}		
		}
		return false;
	}

	//Cadastra as palavras
	public static void cadastrar_palavra(String [][] temas_palavras) {
		int numero_tema = buscar_tema(temas_palavras);
		
		if(temas_palavras[numero_tema][0] != null) {
			System.out.println("\nDigite a palavra para ser cadastrada no tema " + temas_palavras[numero_tema][0] + ":\nPara finalizar digite fim.");
			Scanner ler = new Scanner(System.in);
			String palavra = ler.next();
			int i = 1;
			
			while(palavra.equals("fim") == false) {
				if(i > 0 && palavra_repetida(temas_palavras,palavra,numero_tema) == true) {
					System.out.println("\nNão foi possível cadastrar a palavra. "
							+ "Verifique se existem palavras com esse mesmo nome\nDigite novamente:");
					palavra = ler.next();
				}else {
					temas_palavras[numero_tema][i] = palavra;
					i++;
					palavra = ler.next();
				}
			}
			
			int j = 1;
			while(temas_palavras[numero_tema][j] != null) {
				System.out.println("Palavra cadastrada: " + temas_palavras[numero_tema][j]);
				j++;
			}
		}
		
	}
	
	//Excluir palavras
	public static void excluir_palavra(String [][] temas_palavras) {
		System.out.println("\nDigite a palavra que deseja excluir:");
		Scanner ler = new Scanner(System.in);
		String palavra_excluir = ler.next();
		int retorno = 0;
		
		for(int j = 0; j < temas_palavras.length; j++){
	        for(int i = 1; i < temas_palavras.length; i++){ 
	        	if(temas_palavras[j][i] != null && temas_palavras[j][i].equals(palavra_excluir)) {
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
		int retorno = 0;
		
		for(int j = 0; j < temas_palavras.length; j++){
	        for(int i = 1; i < temas_palavras.length; i++){ 
	        	if(temas_palavras[j][i] != null && temas_palavras[j][i].equals(palavra_busca)) {
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
		int j = 1;
		
		while(temas_palavras[numero_tema][j] != null) {
			System.out.println("Palavra cadastrada: " + temas_palavras[numero_tema][j]);
			j++;
		}
	}

			
	// Main
	public static void main(String[] args) {				
		String [][] temas_palavras = new String[50][50];
		Scanner ler = new Scanner(System.in);
		boolean sair = true;
		int opcao = 0;
		
		do {			
			menu();
	    	opcao = ler.nextInt();
	    	
	    	switch(opcao) {
		    	case 1: //Gerenciar Temas
		    		menu_case1();
		        	int opcao_case1 = ler.nextInt();
		        	
		        	switch(opcao_case1) {
			        	case 1: //Cadastrar
			        		cadastrar_tema(temas_palavras);
			        		break;
			        		
			        	case 2: //Excluir
			        		excluir_tema(temas_palavras);
			        		break; 
			        		
			        	case 3: //Buscar
			        		buscar_tema(temas_palavras);
			        		break; 
			        		
			        	case 4: //Voltar
		    				break;}
	    		break;
    		
		    	case 2: //Gerenciar Palavras
		    		menu_case2();
		        	int opcao_case2 = ler.nextInt();
		    		
		    		switch(opcao_case2) {
			        	case 1: //Cadastrar
			        		cadastrar_palavra(temas_palavras);
			        		break;
			        		
			        	case 2: //Excluir
			        		excluir_palavra(temas_palavras);
			        		break; 
			        		
			        	case 3: //Buscar
			        		buscar_palavra(temas_palavras);
			        		break; 
			        		
			        	case 4: //Listagem
			        		listar_palavra(temas_palavras);
			        		break;
		    				
				    	case 5: //Voltar
							break;}
	       
	        	break;
		    		
		    	case 3: //Jogar
		        	System.out.println("3");
		    		break;
		    		
		    	case 4: //Sair X
		        	System.out.println("\nAté mais!");
		        	sair = false;
		    		break;		
	    	}
		}while (sair == true);
	}
}
