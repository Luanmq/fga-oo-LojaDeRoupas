package model;
import java.util.ArrayList;
import java.util.Scanner;

public class SacolaDeCompra {
	 Scanner ler = new Scanner(System.in);
	 
	 private double valorTotal;
	 private ArrayList<Roupa> SacolaParaRoupas = new ArrayList<>();
	 private ArrayList<Acessorio> SacolaParaAcessorios = new ArrayList<>();
	 private Usuario usuarioComprador;
	 
	 public SacolaDeCompra(Usuario usuario) {
			this.usuarioComprador = usuario;
	 }
	  //Mostra os produtos na sacola, joga para produtos comprados do usuario que deseja comprar e
	  //retira os produtos dos usuarios que venderam
	 /* public void finalizarCompra() {
		  System.out.println("O valor total da compra eh " + this.valorTotal);
		  
		  //Mostra os acessorios na sacola
		  System.out.println("Os acessorios a serem comprados sao:");
		  for(Acessorio acessorio : SacolaParaAcessorios) {
			  System.out.print(acessorio);
		  }
		  
		  //Mostra as roupas na sacola
		  System.out.println("\nAs roupas a serem compradas sao:");
		  for(Roupa roupa : SacolaParaRoupas) {
			  System.out.print(roupa);
		  }
		  
		  System.out.println("\nDeseja finalizar a compra? Digite sim ou nao:");
		  String resposta_finalizar;
		  resposta_finalizar = ler.next();
		  if(resposta_finalizar.equals("sim") == true ) {
			  //Adiciona os acessorios a produtos comprados do usuario comprador
			  for(Acessorio acessorioComprado : SacolaParaAcessorios) {
				  acessorioComprado.setUsuario(getUsuarioComprador());
				  this.getUsuarioComprador().getAcessoriosComprados().add(acessorioComprado);	  
			  }
			  
			  //Adiciona as roupas a produtos comprados do usuario comprador
			  for(Roupa roupaComprada : SacolaParaRoupas) {
				  roupaComprada.setUsuario(getUsuarioComprador());
				  this.getUsuarioComprador().getRoupasCompradas().add(roupaComprada);
			  }
			  
			  //Retira os acessorios comprados dos acessorios a venda do usuario que vendeu
			  for(int i = 0; i < SacolaParaAcessorios.size(); i++) {
				for(int j = 0; j < SacolaParaAcessorios.get(i).getUsuario().getAcessoriosAVenda().size(); j++) {
					if(SacolaParaAcessorios.get(i).getUsuario().getAcessoriosAVenda().get(j).equals(SacolaParaAcessorios.get(i)) == true){
						SacolaParaAcessorios.get(i).getUsuario().getAcessoriosAVenda().get(j).deletarProduto();
					 }
				}
			  }
			  
			  //Retira as roupas compradas das roupas a venda do usuario que vendeu
			  for(int i = 0; i < SacolaParaRoupas.size(); i++) {
				for(int j = 0; j < SacolaParaRoupas.get(i).getUsuario().getRoupasAVenda().size(); j++) {
					if(SacolaParaRoupas.get(i).getUsuario().getRoupasAVenda().get(j).equals(SacolaParaRoupas.get(i)) == true){
						SacolaParaRoupas.get(i).getUsuario().getRoupasAVenda().get(j).deletarProduto();
					 }
				}
			  }
			  
			  //Apos adicionar todos os produtos esvazia a sacola
			  esvaziarSacola();
		  }
	  }*/
	 
	//Gets e sets
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ArrayList<Roupa> getSacolaParaRoupas() {
		return SacolaParaRoupas;
	}

	public void setSacolaParaRoupas(ArrayList<Roupa> sacolaParaRoupas) {
		SacolaParaRoupas = sacolaParaRoupas;
	}

	public ArrayList<Acessorio> getSacolaParaAcessorios() {
		return SacolaParaAcessorios;
	}

	public void setSacolaParaAcessorios(ArrayList<Acessorio> sacolaParaAcessorios) {
		SacolaParaAcessorios = sacolaParaAcessorios;
	}

	public Usuario getUsuarioComprador() {
		return usuarioComprador;
	}

	public void setUsuarioComprador(Usuario usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}
	 
	 
}