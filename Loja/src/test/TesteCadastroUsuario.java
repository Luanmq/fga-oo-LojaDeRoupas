package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.ControleDados;
import control.ControleUsuario;
import model.Endereco;
import model.Usuario;

/**
 * Testa se a validação presente na função cadastrarUsuario está funcionando
 * @author Luan Melo
 * @author Lucas
 */
class TesteCadastroUsuario {
	ControleUsuario controleUsuario = new ControleUsuario();
	
	@Test
	void testCadastrarUsuario() {
		String[] dados = new String[11];
		
		dados[0] = "Bruno Silva";
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "bruno123@gmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "7711811";
		dados[10] = "Shopping";
		
		assertTrue(controleUsuario.cadastrarUsuario(dados));
		
		dados[0] = null;
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "bruno@gmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "7711811";
		dados[10] = "Shopping";

		assertFalse(controleUsuario.cadastrarUsuario(dados));
		
		dados[0] = "Bruno Silva";
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "bruno@gmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = null;
		dados[9] = "7711811";
		dados[10] = "Shopping";

		assertFalse(controleUsuario.cadastrarUsuario(dados));
		
		dados[0] = "Bruno Silva";
		dados[1] = "carro";
		dados[2] = "a";
		dados[3] = "805743618";
		dados[4] = "bruno@gmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "7711811";
		dados[10] = "Shopping";

		assertFalse(controleUsuario.cadastrarUsuario(dados));
		
		dados[0] = "Bruno Silva";
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "bruno@gmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "a";
		dados[10] = "Shopping";

		assertFalse(controleUsuario.cadastrarUsuario(dados));
		
		dados[0] = "1";
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "bruno@gmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "7711811";
		dados[10] = "Shopping";

		assertFalse(controleUsuario.cadastrarUsuario(dados));
		
		dados[0] = "Bruno Silva";
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "bruno@gmail.com";
		dados[5] = "1";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "7711811";
		dados[10] = "Shopping";

		assertFalse(controleUsuario.cadastrarUsuario(dados));
		
		dados[0] = "Bruno Silva";
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "brunogmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "7711811";
		dados[10] = "Shopping";

		assertFalse(controleUsuario.cadastrarUsuario(dados));
		
		Usuario bruno = new Usuario();
		bruno.setEmail("bruno@gmail.com");
		
		ControleDados controleDados = new ControleDados();
		controleDados.getUsuarios().add(bruno);
		
		dados[0] = "Bruno Silva";
		dados[1] = "carro";
		dados[2] = "998808198";
		dados[3] = "805743618";
		dados[4] = "bruno@gmail.com";
		dados[5] = "Brasil";
		dados[6] = "DF";
		dados[7] = "Gama";
		dados[8] = "211";
		dados[9] = "7711811";
		dados[10] = "Shopping";
		
		assertFalse(new ControleUsuario(controleDados).cadastrarUsuario(dados));
	}
}