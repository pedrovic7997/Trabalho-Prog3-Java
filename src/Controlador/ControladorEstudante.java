package Controlador;

import java.util.Scanner;

import Leitor.LeitorEstudante;
import Modelo.Estudante;


public class ControladorEstudante implements IControlador{
	
    public Estudante busca(String matricula){
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
