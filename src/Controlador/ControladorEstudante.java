package Controlador;

import java.util.Scanner;

import Leitor.LeitorEstudante;
import Modelo.Estudante;


public class ControladorEstudante implements IControlador{
	
    // public void menu(String func){
	// 	String opcao = "s";
	// 	LeitorEstudante lEstudante = LeitorEstudante.obterInstancia();
	// 	Scanner scan = new Scanner(System.in);
	// 	while(opcao.toLowerCase().equals("s")){
	// 		System.out.println("------------------------");
	// 		System.out.println("Estudantes cadastrados:");
	// 		lEstudante.listar();    
	// 		System.out.println("\nDeseja cadastrar novo estudante?(Digite 's' caso queira ou qualquer tecla caso não" 
	// 						+" queira)");
	// 		opcao = scan.next();
	// 		if(opcao.toLowerCase().equals("s")){
	// 			Estudante estudante = lEstudante.ler();
	// 			lEstudante.anexaHash(estudante);
	// 		}
	// 	}
	// }

	public void listar(){
		LeitorEstudante leitor = LeitorEstudante.obterInstancia();
		leitor.listar();
	}

	public Estudante busca(int matricula){
		LeitorEstudante lEstudante = LeitorEstudante.obterInstancia();
		return lEstudante.busca(matricula);
	}

	public void ler(Scanner scan){
		LeitorEstudante leitor = LeitorEstudante.obterInstancia();
		while(scan.hasNext()){
			Estudante estudante = leitor.ler(scan);
			leitor.anexaHash(estudante);
		}
	}
}
