package Controlador;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import Leitor.LeitorDisciplina;
import Leitor.LeitorDisciplinaEstudante;
import Modelo.Disciplina;
import Modelo.Estudante;
import Modelo.Periodo;
import Modelo.Docente;


public class ControladorDisciplina implements IControlador {

	public Disciplina busca(String codigo){
		LeitorDisciplina leitor= LeitorDisciplina.obterInstancia();
		return leitor.busca(codigo);
	}

	public Estudante busca(Disciplina disciplina, String matricula){
		LeitorDisciplinaEstudante leitor = LeitorDisciplinaEstudante.obterInstancia();
		return leitor.busca(disciplina,matricula);
	}
	
	public ArrayList<Disciplina> busca(Docente docente){
		LeitorDisciplina leitor= LeitorDisciplina.obterInstancia();
		return leitor.busca(docente);
	}

	public boolean verificaMatriculaEstudante(Disciplina disciplina, String matricula){
		return busca(disciplina,matricula) != null;

	}
	
    public void ler(Scanner scan) throws Exception {
		LeitorDisciplina leitor = LeitorDisciplina.obterInstancia();
		ControladorDocente cDocente = new ControladorDocente();
		ControladorPeriodo cPeriodo = new ControladorPeriodo();
		while(scan.hasNext()){
			String codigo = scan.next();
			Periodo periodo = cPeriodo.busca(codigo);
			if (periodo == null)
				throw new Exception("Referência inválida: " + codigo + ".");
			Disciplina disciplina = leitor.ler(scan, periodo, cDocente);
			leitor.anexaHash(disciplina);
		}
	}

	public void lerMatricula(Scanner scan) throws Exception {
		ControladorEstudante cEstudante = new ControladorEstudante();
		LeitorDisciplinaEstudante lDisciplinaEstudante = LeitorDisciplinaEstudante.obterInstancia();
		while(scan.hasNext()){
			String codigo = scan.next();
			Disciplina disciplina = busca(codigo);
			if(disciplina==null){
				throw new NoSuchElementException("Referência inválida: " + codigo + ".");
			}
			String matricula = scan.next();
			Estudante estudante = cEstudante.busca(matricula);
			if(estudante==null){
				throw new NoSuchElementException("Referência inválida: " + matricula + ".");
			}
			if(verificaMatriculaEstudante(disciplina, estudante.obterMatricula()))
				throw new Exception("Matrícula repetida: "+estudante.obterMatricula()+
							" em "+disciplina.obterCodigo()+"-"+disciplina.obterPeriodo().obterCodigo()+
							".");
			lDisciplinaEstudante.adiciona(disciplina, estudante);
		}
	}

}
