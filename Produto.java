package Projeto;

import java.io.Serializable;

public class Produto implements Serializable{
	double peso;
	String codigo;
	String descrição;
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public double getPeso() {
		return peso;
	}
	@Override
	public String toString() {
		return "Codigo: "+this.codigo+" Peso: "+this.peso+" Descrição: "+this.descrição;
	}
	
}
