package Projeto;

import java.io.Serializable;


public class Motorista extends Pessoa implements Serializable{
	double salario;
	
	 public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getSalario() {
		return salario;
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}
	
}
