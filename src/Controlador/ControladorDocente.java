package Controlador;

import java.util.Scanner;

import Leitor.LeitorDocente;
import Modelo.Docente;


public class ControladorDocente implements IControlador{
    // public void menu(String func){
	// 	LeitorDocente leitor = LeitorDocente.obterInstancia();
	// 	String opcao = "s";
	// 	Scanner scan = new Scanner(System.in);
	// 	while(opcao.toLowerCase().equals("s")){
	// 		leitor.listar();
	// 		leitor.mensagem("\nDeseja cadastrar novo docente? (Digite 's' caso queira ou qualquer tecla caso não" 
	// 					+" queira)");
	// 		opcao = scan.next();  
	// 		if(opcao.toLowerCase().equals("s")){
	// 			Docente docente = leitor.ler();
	// 			leitor.anexaHash(docente);
	// 		}
	// 	}
	// }

	public void listar(){
		LeitorDocente leitor = LeitorDocente.obterInstancia();
		leitor.listar();
	}

	public Docente busca(String codigo){
		LeitorDocente leitor= LeitorDocente.obterInstancia();
		return leitor.busca(codigo);
	}
	
	public void ler(Scanner scan){
		LeitorDocente leitor = LeitorDocente.obterInstancia();
		while(scan.hasNext()){
			Docente docente = leitor.ler(scan);
			leitor.anexaHash(docente);
		}
	}
}
