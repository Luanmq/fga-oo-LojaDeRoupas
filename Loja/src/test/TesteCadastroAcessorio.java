package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.*;
import model.*;

/**
 * Testa se a validação presente na função cadastrarAcessório está funcionando
 * @author Luan Melo
 * @author Lucas
 */
class TesteCadastroAcessorio {
	ControleAcessorio controleAcessorio = new ControleAcessorio();
	
	@Test
	void testCadastrarAcessorio() {
		String[] dados = new String[11];
		
		dados[0] = "tenis jordan";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "2000";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "borracha";
		dados[8] = "100";
		dados[9] = "70";
		dados[10] = "30";

		Usuario user = new Usuario();
		
		Usuario usuario = ControleDados.getDados().getUsuarioPrincipal();		
		assertTrue(controleAcessorio.cadastrarAcessorio(dados, usuario));
		
		dados[0] = "";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "2000";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "borracha";
		dados[8] = "100";
		dados[9] = "70";
		dados[10] = "30";
		
		assertFalse(controleAcessorio.cadastrarAcessorio(dados, usuario));
		
		dados[0] = "tenis jordan";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "aa";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "borracha";
		dados[8] = "100";
		dados[9] = "70";
		dados[10] = "30";
		
		assertFalse(controleAcessorio.cadastrarAcessorio(dados, usuario));
		
		dados[0] = "1";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "2000";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "borracha";
		dados[8] = "100";
		dados[9] = "70";
		dados[10] = "30";
		
		assertFalse(controleAcessorio.cadastrarAcessorio(dados, usuario));
		
	}

}
