package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.ControleAcessorio;
import control.ControleDados;
import control.ControleRoupa;
import model.Usuario;

/**
 * Testa se a validação presente na função cadastrarRoupa está funcionando
 * @author Luan Melo
 * @author Lucas
 */
class TesteCadastroRoupa {
	ControleRoupa controleRoupa = new ControleRoupa();
	
	@Test
	void testCadastrarRoupa() {
		String[] dados = new String[10];
		
		dados[0] = "Blusa ";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "200";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "M";
		dados[8] = "Algodao";
		dados[9] = "Logo Nike";

		Usuario user = new Usuario();
		
		Usuario usuario = ControleDados.getDados().getUsuarioPrincipal();		
		assertTrue(controleRoupa.cadastrarRoupa(dados, usuario));
		
		dados[0] = "";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "200";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "M";
		dados[8] = "Algodao";
		dados[9] = "Logo Nike";

		
		assertFalse(controleRoupa.cadastrarRoupa(dados, usuario));
		
		dados[0] = "Blusa ";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "a";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "M";
		dados[8] = "Algodao";
		dados[9] = "Logo Nike";

		
		assertFalse(controleRoupa.cadastrarRoupa(dados, usuario));
		
		dados[0] = "33 ";
		dados[1] = "Masculino";
		dados[2] = "produto pouco utilizado";
		dados[3] = "nike";
		dados[4] = "200";
		dados[5] = "Otima";
		dados[6] = "azul";
		dados[7] = "M";
		dados[8] = "Algodao";
		dados[9] = "Logo Nike";

		
		assertFalse(controleRoupa.cadastrarRoupa(dados, usuario));
	}

}