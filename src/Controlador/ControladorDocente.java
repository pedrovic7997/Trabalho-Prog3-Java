package Controlador;

import java.util.Scanner;

import Leitor.LeitorDocente;
import Modelo.Docente;


public class ControladorDocente implements IControlador{
    public void menu(String func){
		LeitorDocente lDocente = LeitorDocente.obterInstancia();
		String opcao = "s";
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Docentes cadastrados:");
			lDocente.listar();
			System.out.println("\nDeseja cadastrar novo docente? (Digite 's' caso queira ou qualquer tecla caso não" 
						+" queira)");
			opcao = scan.next();  
			if(opcao.toLowerCase().equals("s")){
				Docente docente = lDocente.ler();
				if(lDocente.busca(docente.obterLogin()) != null)
					throw new IllegalArgumentException("Cadastro repetido: "+docente.obterLogin()+".");
				lDocente.anexaHash(docente);
			}
		}
	}
}
