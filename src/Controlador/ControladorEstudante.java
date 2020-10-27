package Controlador;

import java.util.Scanner;

import Leitor.LeitorEstudante;
import Modelo.Estudante;


public class ControladorEstudante implements IControlador{
	
    public void menu(String func){
		String opcao = "s";
		LeitorEstudante lEstudante = LeitorEstudante.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Estudantes cadastrados:");
			lEstudante.listar();    
			System.out.println("\nDeseja cadastrar novo estudante?(Digite 's' caso queira ou qualquer tecla caso não" 
							+" queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				Estudante estudante = lEstudante.ler();
				if(lEstudante.busca(estudante.obterMatricula()) != null)
					throw new IllegalArgumentException("Cadastro repetido: "+estudante.obterMatricula()+".");
				lEstudante.anexaHash(estudante);
			}
		}
	}
}
