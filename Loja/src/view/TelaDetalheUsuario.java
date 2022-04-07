package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.ControleDados;
import control.ControleUsuario;
import model.Endereco;
/**
 * Tela responsável por mostrar os detalhes do Usuário
 * @author Luan Melo
 * @param janela JFrame que representa a Tela a ser executada
 * @param labelNome JLabel usado para mostrar o nome de um Usuário
 * @param valorNome JTextField usado para mostrar o nome do Usuário cadastrado
 * @param labelSenha JLabel usado para mostrar a senha de um Usuário
 * @param valorSenha JTextField usado para mostrar a senha do Usuário cadastrado
 * @param labelTelefone JLabel usado para mostrar o telefone de um Usuário
 * @param valorTelefone JTextField usado para mostrar o telefone do Usuário cadastrado
 * @param labelCpf JLabel usado para mostrar o CPF de um Usuário
 * @param valorCpf JTextField usado para mostrar o CPF do Usuário cadastrado
 * @param labelEmail JLabel usado para mostrar o email de um Usuário
 * @param valorEmail JTextField usado para mostrar o email do Usuário cadastrado
 * @param labelPais JLabel usado para mostrar o País de um Usuário
 * @param valorPais JTextField usado para mostrar o País do Usuário cadastrado
 * @param labelEstado JLabel usado para mostrar o Estado de um Usuário
 * @param valorEstado JTextField usado para mostrar o Estado do Usuário cadastrado
 * @param labelCidade JLabel usado para mostrar a Cidade de um Usuário
 * @param valorCidade JTextField usado para mostrar a Cidade do Usuário cadastrado
 * @param labelNumeroResidencia JLabel usado para mostrar o Número da Residência de um Usuário
 * @param valorNumeroResidencia JTextField usado para mostrar o Número da Residência do Usuário cadastrado
 * @param labelCep JLabel usado para mostrar o CEP de um Usuário
 * @param valorCep JTextField usado para mostrar o CEP  do Usuário cadastrado
 * @param labelReferencia JLabel usado para mostrar a Referência da residência de um Usuário
 * @param valorReferencia JTextField usado para mostrar a Referência da residência do Usuário cadastrado
 * 
 * @param novoDado Array de String para armazenar os valores do Usuário e utilizar no Cadastro e validações
 * @param dados Instância de Controle de Dados utilizada para o acesso das mesmas informações em todo sistema. A instância tem o seu valor substituído por de outra instância já utilizada no código

 * @param botaoExcluir JButton que quando apertado chama o método excluirUsuario.
 * @param botaoSalvar JButton que quando apertado chama o método cadastrarSalvarUsuario. Ao apertar esse botão os dados do Usuário são armazenados
 * 		no Array novoDado, que por sua vez é passado para o método cadastrarSalvarUsuario.
 * @param botaoCadastrar JButton que quando apertado executa as mesmas funcionalidades que o botaoSalvar, porém se diferencia pela mensagem de erro.
 */

public class TelaDetalheUsuario implements ActionListener {
	private JFrame janela = new JFrame();
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelSenha = new JLabel("Senha: ");
	private JPasswordField valorSenha;
	private JLabel labelTelefone = new JLabel("Telefone: ");
	private JTextField valorTelefone;
	private JLabel labelCpf = new JLabel("CPF: ");
	private JTextField valorCpf;
	private JLabel labelEmail = new JLabel("Email: ");
	private JTextField valorEmail;
	private JLabel labelPais = new JLabel("Pais: ");
	private JTextField valorPais;
	private JLabel labelEstado = new JLabel("Estado: ");
	private JTextField valorEstado;
	private JLabel labelCidade = new JLabel("Cidade: ");
	private JTextField valorCidade;
	private JLabel labelNumeroResidencia = new JLabel("Numero da Residencia: ");
	private JTextField valorNumeroResidencia;
	private JLabel labelCep = new JLabel("Cep: ");
	private JTextField valorCep;
	private JLabel labelReferencia = new JLabel("Referencia: ");
	private JTextField valorReferencia;
	private JLabel labelTituloEndereco = new JLabel("Endereco Nº");
	private JTextField valorPosicaoEndereco = new JTextField(0);
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoCadastrar = new JButton("Cadastrar");
	
	private JButton botaoAnterior = new JButton("<");
	private JButton botaoProximo = new JButton(">");
	
	private String[] novoDado = new String[11];
	private ControleDados dados;
	
	private Endereco enderecoParaCadastrar;
	private int posicaoEndereco;
		
	/**
	 * Método responsável por selecionar qual tipo de Tela abrir
	 * @param d Instância de Controle de Dados já usada em outra parte do código
	 * @param opcao Inteiro que define qual tipo de Tela será aberta.
	 * (1) opcao = 1: Tela para cadastro de um Usuário.
	 * (2) opcao = 2: Tela para Editar ou Excluir um Usuário.
	 * @param posicao Posição do Usuário no ArrayList de usuários 
	 */
	public void cadastrarEditarUsuario(ControleDados d, int opcao) {
		posicaoEndereco = 0;
		valorPosicaoEndereco.setText(Integer.toString(posicaoEndereco));

		dados = d;
		int op = opcao;
		
		Endereco enderecoParaCadastrar = new Endereco(dados.getUsuarioPrincipal());

		//Cadastrar um usuario
		if(op == 1) {
			janela = new JFrame("Cadastro de Usuario");

			valorNome = new JTextField(200);
			valorSenha = new JPasswordField(20);
			valorTelefone = new JTextField(10);
			valorCpf = new JTextField(11);
			valorEmail = new JTextField(200);
			valorPais = new JTextField(200);
			valorEstado = new JTextField(200);
			valorCidade = new JTextField(200);
			valorNumeroResidencia = new JTextField(10);
			valorCep = new JTextField(10);
			valorReferencia = new JTextField(200);
			
			botaoCadastrar.setBounds(180, 350, 180, 25);
			this.janela.add(botaoCadastrar);
			
			janela.dispose();
		}
		//Editar ou Excluir conta
		else if(op == 2) {
			String nomeUsuario = dados.getUsuarioPrincipal().getNome();
			janela = new JFrame(nomeUsuario);

			valorNome = new JTextField(dados.getUsuarioPrincipal().getNome(),200);
			valorSenha = new JPasswordField (dados.getUsuarioPrincipal().getSenha(),20);
			valorTelefone = new JTextField(Long.toString(dados.getUsuarioPrincipal().getTelefone()),10);
			valorCpf = new JTextField(Long.toString(dados.getUsuarioPrincipal().getCpf()),11);
			valorEmail = new JTextField(dados.getUsuarioPrincipal().getEmail(),200);
			
			//Mostrando apenas o primeiro Endereco
			System.out.println(new ControleUsuario(dados).getUp().getEnderecos().get(posicaoEndereco).getPais());
			valorPais = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getPais());
			valorEstado = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getEstado(),200);
			valorCidade = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getCidade(),200);
			valorNumeroResidencia = new JTextField(Long.toString(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getNumeroResidencia()),200);
			valorCep = new JTextField(Long.toString(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getCep()),200);
			valorReferencia = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getReferencia(),200);
			
			botaoSalvar.setBounds(180, 350, 90, 25);
			botaoExcluir.setBounds(270, 350, 90, 25);
			this.janela.add(botaoSalvar);
			this.janela.add(botaoExcluir);			
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		
		labelSenha.setBounds(30, 50, 150, 25);
		valorSenha.setBounds(180, 50, 180, 25);
		
		labelTelefone.setBounds(30, 80, 150, 25);
		valorTelefone.setBounds(180, 80, 180, 25);
		
		labelCpf.setBounds(30, 110, 150, 25);
		valorCpf.setBounds(180, 110, 180, 25);
		
		labelEmail.setBounds(30, 140, 150, 25);
		valorEmail.setBounds(180, 140, 180, 25);
		
		labelPais.setBounds(30, 170, 150, 25);
		valorPais.setBounds(180, 170, 180, 25);
		
		labelEstado.setBounds(30, 200, 150, 25);
		valorEstado.setBounds(180, 200, 180, 25);
		
		labelCidade.setBounds(30, 230, 150, 25);
		valorCidade.setBounds(180, 230, 180, 25);
		
		labelNumeroResidencia.setBounds(30, 260, 150, 25);
		valorNumeroResidencia.setBounds(180, 260, 180, 25);
		
		labelCep.setBounds(30, 290, 150, 25);
		valorCep.setBounds(180, 290, 180, 25);
		
		labelReferencia.setBounds(30, 320, 150, 25);
		valorReferencia.setBounds(180, 320, 180, 25);

		botaoAnterior.setBounds(30, 350, 75, 25);
		botaoProximo.setBounds(105, 350, 75, 25);
		
		labelTituloEndereco.setBounds(30, 380, 75, 25);
		valorPosicaoEndereco.setBounds(105, 380, 35, 25);
		
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelSenha);
		this.janela.add(valorSenha);
		this.janela.add(labelTelefone);
		this.janela.add(valorTelefone);
		this.janela.add(labelCpf);
		this.janela.add(valorCpf);
		this.janela.add(labelEmail);
		this.janela.add(valorEmail);
		this.janela.add(labelPais);
		this.janela.add(valorPais);
		this.janela.add(labelEstado);
		this.janela.add(valorEstado);
		this.janela.add(labelCidade);
		this.janela.add(valorCidade);
		this.janela.add(labelNumeroResidencia);
		this.janela.add(valorNumeroResidencia);
		this.janela.add(labelCep);
		this.janela.add(valorCep);
		this.janela.add(labelReferencia);
		this.janela.add(valorReferencia);
		this.janela.add(botaoProximo);
		this.janela.add(botaoAnterior);
		this.janela.add(labelTituloEndereco);
		this.janela.add(valorPosicaoEndereco);

		this.janela.setLayout(null);
		
		this.janela.setSize(400, 450);
		this.janela.setVisible(true);
		
		botaoProximo.addActionListener(this);
		botaoAnterior.addActionListener(this);
		botaoCadastrar.addActionListener(this);
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoCadastrar) {
			novoDado[0] = valorNome.getText();
			novoDado[1] = valorSenha.getText();
			novoDado[2] = valorTelefone.getText();
			novoDado[3] = valorCpf.getText();
			novoDado[4] = valorEmail.getText();
			
			novoDado[5] = valorPais.getText();
			novoDado[6] = valorEstado.getText();
			novoDado[7] = valorCidade.getText();
			novoDado[8] = valorNumeroResidencia.getText();
			novoDado[9] = valorCep.getText();
			novoDado[10] = valorReferencia.getText();
			
			boolean auxiliarUsuario = new ControleUsuario(dados).cadastrarUsuario(novoDado);
			boolean auxiliarEndereco = new ControleUsuario(dados).cadastrarEndereco(novoDado);
			
			if(auxiliarUsuario == true && auxiliarEndereco == true) {
				mensagemSucessoCadastrar();	
				
			}else {
				mensagemErroSalvar();
			}
		}
		
		if(src == botaoSalvar) {
			novoDado[0] = valorNome.getText();
			novoDado[1] = valorSenha.getText();
			novoDado[2] = valorTelefone.getText();
			novoDado[3] = valorCpf.getText();
			novoDado[4] = valorEmail.getText();
			
			novoDado[5] = valorPais.getText();
			novoDado[6] = valorEstado.getText();
			novoDado[7] = valorCidade.getText();
			novoDado[8] = valorNumeroResidencia.getText();
			novoDado[9] = valorCep.getText();
			novoDado[10] = valorReferencia.getText();
			
			boolean auxiliarUsuario = new ControleUsuario(dados).salvarUsuario(novoDado);
			boolean auxiliarEndereco = new ControleUsuario(dados).salvarEndereco(novoDado, posicaoEndereco);
			
			if(auxiliarUsuario == true && auxiliarEndereco == true) {
				mensagemSucessoSalvar();	
				
			}else {
				mensagemErroSalvar();
			}
		}
		if(src == botaoExcluir) {
			//Verificar se existem produtos relacionados ao usuario antes de excluir
			new ControleUsuario(dados).excluirUsuario();
			new TelaLoginCadastroUsuario();
			mensagemSucessoDeletar();
		}
		
		if(src == botaoProximo) {
			novoDado[0] = valorNome.getText();
			novoDado[1] = valorSenha.getText();
			novoDado[2] = valorTelefone.getText();
			novoDado[3] = valorCpf.getText();
			novoDado[4] = valorEmail.getText();
			
			novoDado[5] = valorPais.getText();
			novoDado[6] = valorEstado.getText();
			novoDado[7] = valorCidade.getText();
			novoDado[8] = valorNumeroResidencia.getText();
			novoDado[9] = valorCep.getText();
			novoDado[10] = valorReferencia.getText();
			
			boolean auxiliar;
			auxiliar = new ControleUsuario(dados).cadastrarEndereco(novoDado);
			
			//Se todos os dados foram preenchidos corretamente é permitido passar para o proximo endereco
			if(auxiliar == true) {
					boolean proximoVazio = false;
					try {
						//Tenta ler o pais do proximo endereço
						dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getPais();
			        } catch (IndexOutOfBoundsException error) {
			        	//Ve se o endereco lido é vazio ou nao
			        	proximoVazio = true;
			        }
			        
					if(proximoVazio = true) {
						posicaoEndereco++;
						valorPosicaoEndereco.setText(Integer.toString(posicaoEndereco));
						
						valorPais.setText("");
						valorEstado.setText("");
						valorCidade.setText("");
						valorNumeroResidencia.setText("");
						valorCep.setText("");
						valorReferencia.setText("");
					}else {
						posicaoEndereco++;
						valorPosicaoEndereco.setText(Integer.toString(posicaoEndereco));
						
						System.out.println(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getPais());
						valorPais.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getPais());
						valorEstado.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getEstado());
						valorCidade.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getCidade());
						valorNumeroResidencia.setText(Long.toString(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getNumeroResidencia()));
						valorCep.setText(Long.toString(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getCep()));
						valorReferencia.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getReferencia());
					}
			}else {
				mensagemErroSalvar();
			}
	}
		
		if(src == botaoAnterior) {
			if(posicaoEndereco != 0) {
				posicaoEndereco--;
				valorPosicaoEndereco.setText(Integer.toString(posicaoEndereco));
				
				valorPais.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getPais());
				valorEstado.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getEstado());
				valorCidade.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getCidade());
				valorNumeroResidencia.setText(Long.toString(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getNumeroResidencia()));
				valorCep.setText(Long.toString(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getCep()));
				valorReferencia.setText(dados.getUsuarioPrincipal().getEnderecos().get(posicaoEndereco).getReferencia());
			}
		}
	}
	
	public void mensagemSucessoCadastrar() {
		JOptionPane.showMessageDialog(null, "O Usuario foi cadastrado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroSalvar() {
		JOptionPane.showMessageDialog(null,"Erro ao salvar os dados!\n "
				+ "Pode ter ocorrido um dos quatro erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Os campos CPF, telefone, numero da residencia e cep nao contem apenas numeros \n"
				+ "3. O  email cadastrado ja existe ou nao e valido \n"
				+ "4. Os campos nome, pais, estado e cidade nao contem apenas letras", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoSalvar() {
		JOptionPane.showMessageDialog(null, "Os dados foram atualizados com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoDeletar() {
		JOptionPane.showMessageDialog(null, "O Usuario foi deletado com sucesso, porem será preciso fazer o Login novamente", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
		TelaMenu.dispose();
	}
}