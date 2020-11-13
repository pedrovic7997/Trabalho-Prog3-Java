package Controlador;

import java.util.Scanner;

import Leitor.LeitorPeriodo;
import Modelo.Periodo;

public class ControladorPeriodo implements IControlador{
	
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
