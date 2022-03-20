package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;
import model.*;

public class TelaDetalhesUsuario implements ActionListener {	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
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
			
	public void cadastrarEditarUsuario(int opcao, int posicao) {
		int op = opcao;
		int pos = posicao;
		
		janela = new JFrame();
				
		//Cadastrar um usuario
		if(op == 1) {
			janela = new JFrame("Cadastro de Usuario");

			valorNome = new JTextField(200);
			valorTelefone = new JTextField(10);
			valorCpf = new JTextField(11);
			valorEmail = new JTextField(200);
			valorPais = new JTextField(200);
			valorEstado = new JTextField(200);
			valorCidade = new JTextField(200);
			valorNumeroResidencia = new JTextField(10);
			valorCep = new JTextField(10);
			valorReferencia = new JTextField(200);
			
			botaoCadastrar.setBounds(180, 320, 180, 25);
			this.janela.add(botaoCadastrar);
		
		//Mostrar os dados do usuario clicado	
		}else if(op == 2) {
			String nome_usuario = Dados.usuarios.get(pos).getNome();
			janela = new JFrame(nome_usuario);

			valorNome = new JTextField(Dados.usuarios.get(pos).getNome(),200);
			valorTelefone = new JTextField(Dados.usuarios.get(pos).getTelefone(),10);
			valorCpf = new JTextField(Dados.usuarios.get(pos).getCpf(),11);
			valorEmail = new JTextField(Dados.usuarios.get(pos).getEmail(),200);
			
			//Mostrando apenas o primeiro Endereco
			valorPais = new JTextField(Dados.usuarios.get(pos).getEnderecos().get(0).getPais(),200);
			valorEstado = new JTextField(Dados.usuarios.get(pos).getEnderecos().get(0).getEstado(),200);
			valorCidade = new JTextField(Dados.usuarios.get(pos).getEnderecos().get(0).getCidade(),200);
			valorNumeroResidencia = new JTextField(Dados.usuarios.get(pos).getEnderecos().get(0).getNumeroResidencia(),200);
			valorCep = new JTextField(Dados.usuarios.get(pos).getEnderecos().get(0).getCep(),200);
			valorReferencia = new JTextField(Dados.usuarios.get(pos).getEnderecos().get(0).getReferencia(),200);
		
		//Editar ou Excluir conta
		}else if(op == 3) {
			String nome_usuario = Dados.usuarioPrincipal.getNome();
			janela = new JFrame(nome_usuario);

			valorNome = new JTextField(Dados.usuarioPrincipal.getNome(),200);
			valorTelefone = new JTextField(Dados.usuarioPrincipal.getTelefone(),10);
			valorCpf = new JTextField(Dados.usuarioPrincipal.getCpf(),11);
			valorEmail = new JTextField(Dados.usuarioPrincipal.getEmail(),200);
			
			//Mostrando apenas o primeiro Endereco
			valorPais = new JTextField(Dados.usuarioPrincipal.getEnderecos().get(0).getPais(),200);
			valorEstado = new JTextField(Dados.usuarioPrincipal.getEnderecos().get(0).getEstado(),200);
			valorCidade = new JTextField(Dados.usuarioPrincipal.getEnderecos().get(0).getCidade(),200);
			valorNumeroResidencia = new JTextField(Dados.usuarioPrincipal.getEnderecos().get(0).getNumeroResidencia(),200);
			valorCep = new JTextField(Dados.usuarioPrincipal.getEnderecos().get(0).getCep(),200);
			valorReferencia = new JTextField(Dados.usuarioPrincipal.getEnderecos().get(0).getReferencia(),200);
			
			botaoSalvar.setBounds(180, 320, 90, 25);
			botaoExcluir.setBounds(270, 320, 90, 25);
			this.janela.add(botaoSalvar);
			this.janela.add(botaoExcluir);
		}
		
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		
		labelTelefone.setBounds(30, 50, 150, 25);
		valorTelefone.setBounds(180, 50, 180, 25);
		
		labelCpf.setBounds(30, 80, 150, 25);
		valorCpf.setBounds(180, 80, 180, 25);
		
		labelEmail.setBounds(30, 110, 150, 25);
		valorEmail.setBounds(180, 110, 180, 25);
		
		labelPais.setBounds(30, 140, 150, 25);
		valorPais.setBounds(180, 140, 180, 25);
		
		labelEstado.setBounds(30, 170, 150, 25);
		valorEstado.setBounds(180, 170, 180, 25);
		
		labelCidade.setBounds(30, 200, 150, 25);
		valorCidade.setBounds(180, 200, 180, 25);
		
		labelNumeroResidencia.setBounds(30, 230, 150, 25);
		valorNumeroResidencia.setBounds(180, 230, 180, 25);
		
		labelCep.setBounds(30, 260, 150, 25);
		valorCep.setBounds(180, 260, 180, 25);
		
		labelReferencia.setBounds(30, 290, 150, 25);
		valorReferencia.setBounds(180, 290, 180, 25);
		
		this.janela.add(labelNome);
		this.janela.add(valorNome);
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
		
		this.janela.setSize(400, 400);
		this.janela.setVisible(true);
		
		botaoCadastrar.addActionListener(this);
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoCadastrar) {
			Usuario usuarionovo = new Usuario();
				usuarionovo.setNome(valorNome.getText());
				usuarionovo.setTelefone(valorTelefone.getText());
				usuarionovo.setCpf(valorCpf.getText());
				usuarionovo.setEmail(valorEmail.getText());
				
			Endereco endereconovo = new Endereco(usuarionovo);
				endereconovo.setPais(valorPais.getText());
				endereconovo.setEstado(valorEstado.getText());
				endereconovo.setCidade(valorCidade.getText());
				endereconovo.setNumeroResidencia(valorNumeroResidencia.getText());
				endereconovo.setCep(valorCep.getText());
				endereconovo.setReferencia(valorReferencia.getText());
			
			usuarionovo.setEndereco(endereconovo);
			Dados.usuarios.add(usuarionovo);
			
			mensagemSucessoCadastrar();
		}
		if(src == botaoSalvar) {
			Dados.usuarioPrincipal.setNome(valorNome.getText());
			Dados.usuarioPrincipal.setTelefone(valorTelefone.getText());
			Dados.usuarioPrincipal.setCpf(valorCpf.getText());
			Dados.usuarioPrincipal.setEmail(valorEmail.getText());
			
			//Editando apenas o primeiro endereco
			Dados.usuarioPrincipal.getEnderecos().get(0).setPais(valorPais.getText());
			Dados.usuarioPrincipal.getEnderecos().get(0).setEstado(valorEstado.getText());
			Dados.usuarioPrincipal.getEnderecos().get(0).setCidade(valorCidade.getText());
			Dados.usuarioPrincipal.getEnderecos().get(0).setNumeroResidencia(valorNumeroResidencia.getText());
			Dados.usuarioPrincipal.getEnderecos().get(0).setCep(valorCep.getText());
			Dados.usuarioPrincipal.getEnderecos().get(0).setReferencia(valorReferencia.getText());

			mensagemSucessoSalvar();
		}
		if(src == botaoExcluir) {
			//Verificar se existem produtos relacionados ao usuario antes de excluir
			Dados.usuarioPrincipal.deletarUsuario();
			new TelaLoginCadastroUsuarios();
			mensagemSucessoDeletar();
		}
	}
	
	public void mensagemSucessoCadastrar() {
		JOptionPane.showMessageDialog(null, "O Usuario foi cadastrado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
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
