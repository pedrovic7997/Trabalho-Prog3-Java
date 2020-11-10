package Controlador;

import java.util.Scanner;

import Leitor.LeitorDocente;
import Modelo.Docente;


public class ControladorDocente implements IControlador{
    
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
