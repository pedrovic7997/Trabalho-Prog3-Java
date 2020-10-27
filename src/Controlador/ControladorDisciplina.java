package Controlador;

import java.util.Scanner;
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

	public void menu(String func) throws Exception {
		if(func.equals("Disciplina"))
			menuDisciplina();
		else menuEstudanteDisciplina();
	}

    public void menuDisciplina() throws Exception{
		LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
		Scanner scan = new Scanner(System.in);
		String opcao = "s";
		LeitorDocente lDocente= LeitorDocente.obterInstancia();
		LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();
		while(opcao.toLowerCase().equals("s")){
			listar();	
			System.out.println("\nDeseja cadastrar nova disciplina? (Digite 's' caso queira ou qualquer tecla caso não"+
			" queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				System.out.println("Docentes cadastrados:");
				lDocente.listar();
				System.out.println("\nInforme o login do docente para a disciplina: ");
				Docente docente = lDocente.busca(scan.next());
				if(docente==null){
					throw new NoSuchElementException("Referência inválida: "+docente.obterLogin()+".");
				}
				System.out.println("\nPeriodos cadastrados:");
				lPeriodo.listar();
				System.out.println("\nInforme o periodo da disciplina: ");
				Periodo periodo = lPeriodo.busca(scan.next());
				if(periodo==null){
					throw new NoSuchElementException("Referência inválida: "+periodo.obterCodigo()+".");
				}
				Disciplina disciplina = lDisciplina.ler(periodo,docente);
				lDisciplina.anexaHash(disciplina);
			}
		}
    }

    public void menuEstudanteDisciplina(){
		String opcao = "s";
		LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
		LeitorEstudante lEstudante = LeitorEstudante.obterInstancia();
		LeitorDisciplinaEstudante lDisciplinaEstudante = LeitorDisciplinaEstudante.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(!opcao.toLowerCase().equals("m")){
			opcao = "s";
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			lDisciplina.listar();
			System.out.println("\nDigite o código da disciplina a qual deseja ver os estudantes cadastrados: ");
			String codigo = scan.next();
			Disciplina disciplina = lDisciplina.busca(codigo);
			if(disciplina==null){
				throw new NoSuchElementException("Referência inválida: "+codigo+".");
			}
			while(opcao.equalsIgnoreCase("s")){
				System.out.println("\nEstudantes matriculados nessa disciplina:");
				
				lDisciplinaEstudante.lista(disciplina);
				System.out.println("\nDeseja adicionar um estudante a essa materia?(Digite 's' caso queira, 'm' para voltar ao menu "+
						"e qualquer tecla para selecionar outra disciplina)");
				opcao = scan.next();
				if(opcao.toLowerCase().equals("s")){
					System.out.println("\nEstudantes cadastrados:");
					lEstudante.listar();
					System.out.println("\nDigite a matricula do estudante que deseja adcionar a disciplina: ");
					Estudante estudante = lEstudante.busca(scan.nextInt());
					if(estudante==null){
						throw new NoSuchElementException("Referência inválida: "+estudante.obterMatricula()+".");
					}
					lDisciplinaEstudante.adiciona(disciplina, estudante);
				}
			}
		}
	}

	public void listar(){
		LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
		lDisciplina.listar();
	}
}
