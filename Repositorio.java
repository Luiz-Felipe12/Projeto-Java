package Projeto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Repositorio implements Serializable{
	ArrayList<Entrega> repositorio;
	int idCount;
	
	public Repositorio() {
		this.repositorio = new ArrayList<Entrega>();
		idCount = 0;
	}
	public int ultimoID() {
		return idCount;
	}
	public void adicionar(Entrega en) {
		en.setId(idCount);
		this.repositorio.add(en);
		idCount++;
	}
	
	

	public Entrega recuperar(int id) throws CadastroNaoEncontradoException {
		for (Entrega inter : repositorio) {
			if (inter.getId() == id)
				return inter;
		}
		throw new CadastroNaoEncontradoException("NÃO FOI ENCONTRADO CADASTRO COM O ID " + id);
	}
	
	public void remover(int id) throws CadastroNaoEncontradoException {
		
		this.repositorio.remove(recuperar(id));
	}

	public void salvarRepositorio(String caminhoArquivo) throws IOException {
		
		FileOutputStream file= new FileOutputStream(caminhoArquivo);
		ObjectOutputStream os = new ObjectOutputStream(file);
		os.writeObject(this);
		os.close();
	}

	public static Repositorio carregarRepositorio(String caminhoArquivo) throws IOException, ClassNotFoundException {

		FileInputStream file = new FileInputStream(caminhoArquivo);
		ObjectInputStream is = new ObjectInputStream(file);
		Repositorio rep = (Repositorio) is.readObject();
		is.close();
		return rep;
	}
}
