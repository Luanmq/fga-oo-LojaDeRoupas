package view;

import java.awt.Font;
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
//TelaInicial
public class TelaLoginCadastroUsuario implements ActionListener{

	private JFrame janela = new JFrame("Login e Cadastro");
	private JLabel email = new JLabel("Email");
	private JTextField valorEmail = new JTextField(20);
	private JLabel senha = new JLabel("Senha");
	private JPasswordField valorSenha = new JPasswordField(20);
	private JButton logarUsuario  = new JButton ("Logar");
	private JButton cadastrarUsuario = new JButton("Cadastrar");
	
	public static ControleDados dados = new ControleDados();

	public TelaLoginCadastroUsuario( ) {
		
		email.setFont(new Font("Arial", Font.BOLD, 15));
		email.setBounds(10, 10, 80, 25);
		valorEmail.setBounds(100, 10, 160, 25);
		
		senha.setFont(new Font("Arial", Font.BOLD, 15));
		senha.setBounds(10, 40, 80, 25);
		valorSenha.setBounds(100, 40, 160, 25);
		
		logarUsuario.setBounds(95, 80, 80, 25);		
		cadastrarUsuario.setBounds(180, 80, 90, 25);
		
		janela.setLayout(null);
		janela.add(email);
		janela.add(valorEmail);
		janela.add(senha);
		janela.add(valorSenha);
		janela.add(logarUsuario);
		janela.add(cadastrarUsuario);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setBounds(600, 300, 300, 150);
		janela.setVisible(true);
		
		cadastrarUsuario.addActionListener(this);
		logarUsuario.addActionListener(this);
		
	}
	
	public static void main(String[] args) {

		TelaLoginCadastroUsuario telaInicial = new TelaLoginCadastroUsuario();
	
	}
	
	int UsuarioSelecionado = -1;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo usuario
		if(src == cadastrarUsuario) {
			new TelaDetalheUsuario().cadastrarEditarUsuario(dados, 1 , 0);
		}
			
		
		//Loga com um usuario
		if(src == logarUsuario) {
			//Procuro pelo usuario de email digitado
			for(int i = 0; i < dados.getUsuarios().size(); i++) {
				if( dados.getUsuarios().get(i).getEmail().equals(valorEmail.getText())) {
					UsuarioSelecionado = i;	
				}
			}
			
			if(UsuarioSelecionado != -1 && dados.getUsuarios().get(UsuarioSelecionado).getSenha().equals(valorSenha.getText())) {
				new ControleUsuario(dados).selecionaUsuarioPrincipal(dados.getUsuarios().get(UsuarioSelecionado));
				mensagemSucessoLogar();
				janela.dispose();
				TelaMenu menu = new TelaMenu(dados);
			}else {
				mensagemErroLogar();
			 }
		}
	}
	
	public void mensagemSucessoLogar() {
		JOptionPane.showMessageDialog(null, "O login foi feito com sucesso!\n Seja bem-vindo, " + dados.getUsuarios().get(UsuarioSelecionado).getNome(), null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemErroLogar() {
		JOptionPane.showMessageDialog(null, "O usuario ou senha esta incorreto", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
}
