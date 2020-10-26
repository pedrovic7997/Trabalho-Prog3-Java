package Controlador;

import java.util.Scanner;

import Leitor.LeitorDocente;
import Modelo.Docente;


public class ControladorDocente implements IControlador{
    public void menu(String func){
		LeitorDocente leitor = LeitorDocente.obterInstancia();
		String opcao = "s";
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			leitor.mensagem("------------------------");
			leitor.mensagem("Docentes cadastrados:");
			leitor.listar();
			leitor.mensagem("\nDeseja cadastrar novo docente? (Digite 's' caso queira ou qualquer tecla caso não" 
						+" queira)");
			opcao = scan.next();  
			if(opcao.toLowerCase().equals("s")){
				Docente docente = leitor.ler();
				if(leitor.busca(docente.obterLogin()) != null)
					throw new IllegalArgumentException("Cadastro repetido: "+docente.obterLogin()+".");
				leitor.anexaHash(docente);
			}
		}
	}

	public void listar(){
		LeitorDocente leitor = LeitorDocente.obterInstancia();
		leitor.listar();
	}

	public Docente busca(String codigo){
		LeitorDocente leitor= LeitorDocente.obterInstancia();
		return leitor.busca(codigo);
	}
	
}
