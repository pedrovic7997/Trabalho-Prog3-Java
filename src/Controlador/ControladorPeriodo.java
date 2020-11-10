package Controlador;

import java.util.Scanner;

import Leitor.LeitorPeriodo;
import Modelo.Periodo;

public class ControladorPeriodo implements IControlador{
	
    // public void menu(String func){
	// 	String opcao = "s";
	// 	Scanner scan = new Scanner(System.in);
	// 	LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();
	// 	while(opcao.toLowerCase().equals("s")){
	// 		System.out.println("------------------------");
	// 		System.out.println("Periodos cadastrados:");
	// 		lPeriodo.listar();    
	// 		System.out.println("\nDeseja cadastrar novo periodo?(Digite 's' caso queira ou qualquer tecla caso não" 
	// 						+" queira)");
			
	// 		opcao = scan.next();
	// 		if(opcao.toLowerCase().equals("s")){
	// 			Periodo periodo = lPeriodo.ler();
	// 			if(lPeriodo.busca(periodo.obterCodigo()) != null)
	// 				throw new IllegalArgumentException("Cadastro repetido: "+periodo+".");
	// 			lPeriodo.anexaHash(periodo);
	// 			System.out.println();
	// 		}
	// 	}
	//   }
	  
	public void ler(Scanner scan) throws Exception {
		LeitorPeriodo leitor = LeitorPeriodo.obterInstancia();
		while(scan.hasNext()){
			Periodo periodo = leitor.ler(scan);
			leitor.anexaHash(periodo);
		}
	}

	public Periodo busca(String codigo){
		LeitorPeriodo leitor = LeitorPeriodo.obterInstancia();
		return leitor.busca(codigo);
	}
}
