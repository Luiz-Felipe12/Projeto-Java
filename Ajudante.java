package Projeto;

public class Ajudante extends Pessoa{
	double salario;
	Motorista motor;
	
	 public Ajudante(double salario, Motorista m,String cpf, String nome) {
		 this.motor=m;
		 this.salario=salario;
		 this.cpf=cpf;
		 this.nome=nome;
		
	}
	public double getSalario() {
		return salario;
	}
}
