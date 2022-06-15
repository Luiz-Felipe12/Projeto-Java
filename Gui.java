package Projeto;

import java.io.IOException;
import java.util.Scanner;


public class Gui {

	public static void main(String[] args) throws AutonomiaExcedidaException, CadastroNaoEncontradoException {
		
		Motorista carlos= new Motorista();
		carlos.setCpf("001");
		carlos.setNome("Carlos Nobrega");
		carlos.salario=2;
		
		Motorista jurandir= new Motorista();
		jurandir.setCpf("002");
		jurandir.setNome("Jurandir");
		carlos.salario=2;
		
		Ajudante aloisio= new Ajudante(1, jurandir, "aloisio", "003");
		Ajudante jubiriudo= new Ajudante(1, carlos, "jubiriudo", "004");
		
		Veiculo van= new Veiculo("Wolks", "00",200);
		Veiculo caminhao= new Veiculo("Mercedez", "11",85);
		
		Produto celular= new Produto();
		Produto tv= new Produto();
		
		celular.peso= 2;
		celular.codigo="0";
		
		tv.peso=32;
		tv.codigo="1";
		
	
		boolean continuar = true;
		Scanner sc = new Scanner(System.in);
		
		Repositorio repositorio = null;
		String arquivoRepositorio = "./entregas.dat";
		
		

		
		try {
			repositorio = Repositorio.carregarRepositorio(arquivoRepositorio);
		} catch (IOException e) {
			System.out.println("Não foi possível carregar o repositório.");
			repositorio = new Repositorio();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		while (continuar) {

			System.out.println("**************   MENU   *******************");
			System.out.println("* Digite 1 para cadastrar uma Entrega     *");
			System.out.println("* Digite 2 para consultar uma Entrega     *");
			System.out.println("* Digite 3 para Mostrar todas as Entregas *");
			System.out.println("* Digite 4 para Cancelar uma Entrega      *");
			System.out.println("* Digite 0 para Sair                      *");
			System.out.println("*******************************************");

			int leitura = sc.nextInt();
			if (leitura == 1) { // Cadastrar Entrega
				System.out.println("Digite a distancia da entrega"); 
				
				double dis= sc.nextDouble();
				Entrega e1=new Entrega(dis);
				
				if(dis>100) {
					if(dis>van.autonomia) {
						throw  new AutonomiaExcedidaException();
					}
					e1.motorista=jurandir;
					e1.carro= van;
					e1.ajud=aloisio;
					e1.aumento(2);
					
					e1.escolherPRODUTO(celular, tv); //METODO PARA SELEÇÃO DO PRODUTO
					
					
					repositorio.adicionar(e1);
					
					try {
						repositorio.salvarRepositorio(arquivoRepositorio);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar o arquivo.");
					}
					
					
					
				}else{
					if(dis>caminhao.autonomia) {
						throw  new AutonomiaExcedidaException();
					}
					
					e1.motorista=carlos;
					e1.carro= caminhao;
					e1.ajud=jubiriudo;
					e1.aumento(2);
				    
					e1.escolherPRODUTO(celular, tv); //METODO PARA SELEÇÃO DO PRODUTO
					
					repositorio.adicionar(e1);
					
					try {
						repositorio.salvarRepositorio(arquivoRepositorio);
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Não foi possível salvar o arquivo.");
					}
				}
			
			}else if (leitura == 2) {// CONSULTAR ENTEGA
				
				System.out.println("Digite o ID da Entrega a ser consultado:");
				leitura = sc.nextInt();
				Entrega resp = null;
				try {
					resp = repositorio.recuperar(leitura);
					System.out.println(resp);
				} catch (CadastroNaoEncontradoException e) {
					System.out.println(e.getMessage());
				}
				
			} else if (leitura == 3) {
			// exibir todos as Entregas do repositório
				
			System.out.println("TODOS OS ITENS DO REPOSITÓRIO:");
			for (int i = 0; i < repositorio.ultimoID(); i++) {
				try {
					Entrega a = repositorio.recuperar(i);
					System.out.println(a.toString());
				} catch (CadastroNaoEncontradoException e) {
					System.out.println("Não foi encontrado item com ID" + i);
				}
			}
			} else if (leitura == 4) {//Cancelar Entrega
				System.out.println("Digite o ID da Entrega a ser Cancelada:");
				leitura = sc.nextInt();
				Entrega a = repositorio.recuperar(leitura);
				a.aviso();
				repositorio.remover(leitura);
				
			
			}else if (leitura == 0) {
				continuar = false;
			}
		}
		
	}

}
