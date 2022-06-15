package Projeto;

import java.io.Serializable;

public class Veiculo implements Serializable{
	String placa;
	String marca;
	double autonomia;
	
	
	
	public Veiculo(String marca, String placa, double autonomia) {
		this.placa=placa;
		this.marca=marca;
		this.autonomia=autonomia;
	}
	
	public double getAutonomia() {
		return autonomia;
	}
	
	public String getMarca() {
		return marca;
	}
	public String getPlaca() {
		return placa;
	}

	@Override
	public String toString() {
		
		return "Marca: "+this.marca+ " Placa: "+this.placa;
	}
}
