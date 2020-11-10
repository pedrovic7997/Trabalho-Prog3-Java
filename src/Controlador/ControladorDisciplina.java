package Controlador;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import Leitor.LeitorDisciplina;
import Leitor.LeitorEstudante;
import Leitor.LeitorDisciplinaEstudante;
import Leitor.LeitorPeriodo;
import Leitor.LeitorDocente;
import Modelo.Disciplina;
import Modelo.Estudante;
import Modelo.Periodo;
import Modelo.Docente;


public class ControladorDisciplina implements IControlador {

	// public void menu(String func) throws Exception {
	// 	if(func.equals("Disciplina"))
	// 		menuDisciplina();
	// 	else menuEstudanteDisciplina();
	// }

    // public void menuDisciplina() throws RuntimeException{
	// 	LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
	// 	Scanner scan = new Scanner(System.in);
	// 	String opcao = "s";
	// 	LeitorDocente lDocente= LeitorDocente.obterInstancia();
	// 	LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();
	// 	while(opcao.toLowerCase().equals("s")){
	// 		listar();	
	// 		System.out.println("\nDeseja cadastrar nova disciplina? (Digite 's' caso queira ou qualquer tecla caso não"+
	// 		" queira)");
	// 		opcao = scan.next();
	// 		if(opcao.toLowerCase().equals("s")){
	// 			lDocente.listar();
	// 			System.out.println("\nInforme o login do docente para a disciplina: ");
	// 			String login = scan.next();
	// 			Docente docente = lDocente.busca(login);
	// 			if(docente==null){
	// 				throw new NoSuchElementException("Referência inválida: "+login+".");
	// 			}
	// 			System.out.println("\nPeriodos cadastrados:");
	// 			lPeriodo.listar();
	// 			System.out.println("\nInforme o periodo da disciplina: ");
	// 			String codigo = scan.next();
	// 			Periodo periodo = lPeriodo.busca(codigo);
	// 			if(periodo==null){
	// 				throw new NoSuchElementException("Referência inválida: "+codigo+".");
	// 			}
	// 			Disciplina disciplina = lDisciplina.ler(periodo,docente);
	// 			if(lDisciplina.busca(disciplina.obterCodigo()) != null)
	// 				throw new IllegalArgumentException("Cadastro repetido: "+disciplina.obterCodigo()+".");
	// 			lDisciplina.anexaHash(disciplina);
	// 		}
	// 	}
    // }

    // public void menuEstudanteDisciplina() throws Exception{
	// 	String opcao = "s";
	// 	LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
	// 	LeitorEstudante lEstudante = LeitorEstudante.obterInstancia();
	// 	LeitorDisciplinaEstudante lDisciplinaEstudante = LeitorDisciplinaEstudante.obterInstancia();
	// 	Scanner scan = new Scanner(System.in);
	// 	while(!opcao.toLowerCase().equals("m")){
	// 		opcao = "s";
	// 		lDisciplina.listar();
	// 		System.out.println("\nDigite o código da disciplina a qual deseja ver os estudantes cadastrados: ");
	// 		String codigo = scan.next();
	// 		Disciplina disciplina = lDisciplina.busca(codigo);
	// 		if(disciplina==null){
	// 			throw new NoSuchElementException("Referência inválida: "+codigo+".");
	// 		}
	// 		while(opcao.equalsIgnoreCase("s")){
	// 			System.out.println("\nEstudantes matriculados nessa disciplina:");
				
	// 			lDisciplinaEstudante.lista(disciplina);
	// 			System.out.println("\nDeseja adicionar um estudante a essa materia?(Digite 's' caso queira, 'm' para voltar ao menu "+
	// 					"e qualquer tecla para selecionar outra disciplina)");
	// 			opcao = scan.next();
	// 			if(opcao.toLowerCase().equals("s")){
	// 				System.out.println("\nEstudantes cadastrados:");
	// 				lEstudante.listar();
	// 				System.out.println("\nDigite a matricula do estudante que deseja adcionar a disciplina: ");
	// 				int matricula = scan.nextInt();
	// 				Estudante estudante = lEstudante.busca(matricula);
	// 				if(estudante==null){
	// 					throw new NoSuchElementException("Referência inválida: "+matricula+".");
	// 				}
	// 				if(verificaMatriculaEstudante(disciplina, estudante.obterMatricula()))
	// 					throw new Exception("Matrícula repetida: "+estudante.obterMatricula()+
	// 								" em "+disciplina.obterCodigo()+"-"+disciplina.obterPeriodo().obterCodigo()+
	// 								".");
	// 				lDisciplinaEstudante.adiciona(disciplina, estudante);
	// 			}
	// 		}
	// 	}
	// }

	public void listar(){
		LeitorDisciplina leitor = LeitorDisciplina.obterInstancia();
		leitor.listar();
	}

	public void listar(Disciplina disciplina){
		LeitorDisciplinaEstudante leitor = LeitorDisciplinaEstudante.obterInstancia();
		leitor.lista(disciplina);
	}

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
