package Projeto;

import java.io.Serializable;
import java.util.Scanner;

public class Entrega implements Serializable,Avisos,Dinheiro{
	String endereço;
	int id;
	
	Veiculo carro;
	Motorista motorista;
	Produto prod;
	double distancia;
	double preço;
	Ajudante ajud;
	
	public Entrega(double distancia) {
		this.distancia= distancia;
		this.calcularFRETE();
	}
	public void setAjud(Ajudante ajud) {
		this.ajud = ajud;
	}
	public Ajudante getAjud() {
		return ajud;
	}
	public double getPreço() {
		return preço;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getEndereço() {
		return endereço;
	}
	public double getDistancia() {
		return distancia;
	}
	
	void escolherPRODUTO(Produto celular, Produto tv) { //recebe do usuario a escolha entre os produtos tv e celular, recebe também o  endereço
		int leitura=0;
		Scanner sc= new Scanner(System.in);
		int cont=0;
		while(cont==0) {
			System.out.println("Digite 1 para escolher um celular para envio, ou 2 para escolher uma tv");
			leitura = sc.nextInt();
			cont++;
		}
		
		
		if(leitura==1) {
	    	this.prod=celular;
	    	this.prod.descrição="Celular";
			
			System.out.println("Digite o endereço de entrega");
			String ende= sc.next();
			
			this.endereço=ende;
	    }else {
	    	this.prod=tv;
	    	this.prod.descrição="TV";
			System.out.println("Digite o endereço de entrega");
			String ende= sc.next();
			
			this.endereço=ende;
	    }
		
	}
	
	void calcularFRETE() { //calcula o frete
		if(this.distancia>100) {
			this.preço=distancia*0.5;
		}else {
			this.preço=distancia*2;
					
		}
			
	}
	
	@Override
	public String toString() {
		return 	"ID: "+this.id+" Frete: R$"+this.preço+" Distancia: "+this.distancia+" KM Endereço: "+this.endereço+"\nMotorista: "+this.motorista.toString()+ "\nProduto: "+this.prod.toString()+"\nVeiculo: "+ 
				this.carro.toString()+"\n";
	}
	@Override
	public void aumento(int aumento) {
		this.motorista.salario+=aumento;
	
		
	}
	@Override
	public void aviso() {
		System.out.println("Entrega com id "+this.id+" Foi Cancelada");
		
	}
	
	
}
