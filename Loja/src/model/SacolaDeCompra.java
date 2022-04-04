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
	 
	 //Adiciona um acessorio na Sacola para acessorios
	 public void adicionarAcessorio(Acessorio acessorioDentroDaSacola) {
		  this.valorTotal += acessorioDentroDaSacola.getPreco();
		  this.SacolaParaAcessorios.add(acessorioDentroDaSacola);
	  }
	 
	 //Retira um acessorio da Sacola para acessorios
	 public void retirarAcessorio() {
		  System.out.println("Quais desses Acessorios deseja retirar da sacola:");
		  int i = 0;
		  
		  //Mostra os acessorios na sacola
		  for(Acessorio acessorio : SacolaParaAcessorios) {
			  System.out.print("Acessorio " + i+1 + ":" + acessorio);
			  i++;
		  }
		  
		  //Le qual deseja retirar e retira
		  int resposta_retirar = ler.nextInt();
		  this.valorTotal = valorTotal - SacolaParaAcessorios.get(resposta_retirar-1).getPreco();
		  this.SacolaParaAcessorios.remove(resposta_retirar-1);		  
	  }
	 
	  //Adiciona uma roupa na Sacola para roupas
	  public void adicionarRoupa(Roupa roupaDentroDaSacola) {
		  this.valorTotal += roupaDentroDaSacola.getPreco();
		  this.SacolaParaRoupas.add(roupaDentroDaSacola);
	  }
	
	  //Retira uma roupa da Sacola para roupas
	  public void retirarRoupa() {
		  System.out.println("Quais dessas Roupas deseja retirar da sacola:");
		  int i = 0;
		 
		  //Mostra as roupas na sacola
		  for(Roupa roupa : SacolaParaRoupas) {
			  System.out.print("Roupa " + i+1 + ":" + roupa);
			  i++;
		  }
		  
		  //Le qual deseja retirar e retira
		  int resposta_retirar = ler.nextInt();
		  this.valorTotal = valorTotal - SacolaParaRoupas.get(resposta_retirar-1).getPreco();
		  this.SacolaParaRoupas.remove(resposta_retirar-1);		  
	  }
	  
	  //Limpa os dados da Sacola para acessorios e da Sacola para roupas
	  public void esvaziarSacola() {
		  SacolaParaAcessorios.clear();
		  SacolaParaRoupas.clear();
		  this.valorTotal = 0;
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
