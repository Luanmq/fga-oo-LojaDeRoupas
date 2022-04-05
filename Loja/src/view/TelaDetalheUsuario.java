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
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoCadastrar = new JButton("Cadastrar");
	
	private String[] novoDado = new String[11];
	private ControleDados dados;
			
	public void cadastrarEditarUsuario(ControleDados d, int opcao, int posicao) {
		dados = d;
		int op = opcao;
		int pos = posicao;
				
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
		
		}//Editar ou Excluir conta
		else if(op == 2) {
			String nomeUsuario = dados.getUsuarioPrincipal().getNome();
			janela = new JFrame(nomeUsuario);

			valorNome = new JTextField(dados.getUsuarioPrincipal().getNome(),200);
			valorSenha = new JPasswordField (dados.getUsuarioPrincipal().getSenha(),20);
			valorTelefone = new JTextField(Long.toString(dados.getUsuarioPrincipal().getTelefone()),10);
			valorCpf = new JTextField(Long.toString(dados.getUsuarioPrincipal().getCpf()),11);
			valorEmail = new JTextField(dados.getUsuarioPrincipal().getEmail(),200);
			
			//Mostrando apenas o primeiro Endereco
			valorPais = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(0).getPais(),200);
			valorEstado = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(0).getEstado(),200);
			valorCidade = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(0).getCidade(),200);
			valorNumeroResidencia = new JTextField(Integer. toString(dados.getUsuarioPrincipal().getEnderecos().get(0).getNumeroResidencia()),200);
			valorCep = new JTextField(Integer. toString(dados.getUsuarioPrincipal().getEnderecos().get(0).getCep()),200);
			valorReferencia = new JTextField(dados.getUsuarioPrincipal().getEnderecos().get(0).getReferencia(),200);
			
			botaoSalvar.setBounds(180, 350, 90, 25);
			botaoExcluir.setBounds(270, 350, 90, 25);
			this.janela.add(botaoSalvar);
			this.janela.add(botaoExcluir);
			
			janela.dispose();
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
		
		this.janela.setLayout(null);
		
		this.janela.setSize(400, 430);
		this.janela.setVisible(true);
		
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

			boolean auxiliar;
			
			auxiliar = new ControleUsuario(dados).cadastrarUsuario(novoDado);
			if(auxiliar == true) {
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

			boolean auxiliar;
	
			auxiliar = new ControleUsuario(dados).salvarUsuario(novoDado);
			if(auxiliar == true) {
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
	}
	
	public void mensagemSucessoCadastrar() {
		JOptionPane.showMessageDialog(null, "O Usuario foi cadastrado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	

	public void mensagemErroSalvar() {
		JOptionPane.showMessageDialog(null,"Erro ao salvar os dados!\n "
				+ "Pode ter ocorrido um dos tres erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Observe que os campos CPF, telefone, numero da residencia e cep devem conter apenas numeros\n"
				+ "3. O  email cadastrado ja existe, tente outro", null, 
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