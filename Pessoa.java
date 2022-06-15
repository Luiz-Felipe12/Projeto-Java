package Projeto;

import java.io.Serializable;

public  abstract class Pessoa implements Serializable{
	String nome;
	String cpf;
	
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	@Override
	public String toString() {
		return "Nome: "+this.nome;
	}
}
