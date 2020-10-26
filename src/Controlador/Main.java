package Controlador;

import java.util.InputMismatchException;
import java.util.Scanner;
import Leitor.*;
import Modelo.*;

public class Main{
	public static void main(String[] args) throws Exception{
		int opcao = -1;
		Scanner scan = new Scanner(System.in);
		do{
			escreveMenu();
			try{
				opcao = scan.nextInt();
			} catch (InputMismatchException e){
				System.out.println("\nOpcão invalida!\n");
				scan.next();
				continue;
			}

			try {
				escolherMenu(opcao,args);				
			} catch (Exception e) {
				System.out.println(e.getMessage()+"\n");
			}

		}while(opcao != 0);
		scan.close();
 
	}

	public static void escreveMenu(){
		System.out.println("Escolha uma opção:");
		System.out.println("1-Cadastro de períodos;");
		System.out.println("2-Cadastro de docentes;");
		System.out.println("3-Cadastro de disciplinas;");
		System.out.println("4-Cadastro de estudantes;");
		System.out.println("5-Matrícula de estudantes em disciplinas;");
		System.out.println("6-Cadastro de atividade de disciplinas;");
		System.out.println("7-Avalição de atividade por parte de estudante;");
		System.out.println("8-Relatórios;");
		System.out.println("9-Salvar dados;");
		System.out.println("10-Carregar dados;");
		System.out.println("0-Sair do programa;");
	}
	
	public static void escolherMenu(int opcao, String[] args) throws Exception{
		switch(opcao){
			case 0: System.out.println("\nSaindo do programa...");
				break;
			case 1: menuPeriodo();
				break;
			case 2: menuDocentes();
				break;
			case 3: menuDisciplina();
				break;
			case 4: menuEstudante();
				break;
			case 5: menuEstudanteDisciplina();
				break;
			case 6: menuAtividadeDiscplina();
				break;
			case 7: menuAvaliacao();
				break;
			case 8: menuRelatorios();
				break;
			case 9: salvaDados(args);
				break;
			case 10: carregaDados(args);
				break;
			default : System.out.println("\nOpcão invalida!\n");
		}
	}

	public static void menuRelatorios() {

		Scanner scan = new Scanner(System.in);
		int opcao = -1;
		do{
			System.out.println("\nEscolha uma opção:");
			System.out.println("1-Visão geral do período acadêmico;");
			System.out.println("2-Estatísticas dos docentes;");
			System.out.println("3-Estatísticas dos estudantes;");
			System.out.println("4-Estatísticas das disciplinas de um docente;");
			System.out.println("0-Voltar ao menu principal:");
			try{
				opcao = scan.nextInt();
			} catch (InputMismatchException e){
				System.out.println("\nOpcão invalida! Voltando ao menu...\n");
				// opcao = 0;
				scan.next();
				continue;
			}
			try{
				escolherMenuRelatorio(opcao);
			} catch (Exception e) {
				System.out.println(e.getMessage()+"\n");
			}
			System.out.println("");
		}while(opcao != 0);
	}

	public static void escolherMenuRelatorio(int opcao) throws Exception {
		Relatorio relatorio = new Relatorio();
		switch(opcao){
			case 1: relatorio.panoramaPeriodo();
				break;
			case 2: relatorio.estatisticaDocentes();
				break;
			case 3: relatorio.estatisticaEstudantes();
				break;
			case 4: relatorio.estatisticaDisciplinasDocente();
				break;
			default :
				System.out.println("\nVoltando ao menu...");
		}
	}

	public static void salvaDados(String[] args) throws Exception{
		Salvar salvar= new Salvar();
		if(args.length>=1){
			salvar.salvaDados(args[0]);
		}
		else {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nInforme o nome do arquivo para onde salvará: ");
			salvar.salvaDados(scan.nextLine());
			System.out.println("");
		}
	}

	public static void carregaDados(String[] args) throws Exception{
		Carregar carregador= new Carregar();
		if(args.length>1){
			carregador.carregaDados(args[1]);
		}
		else {
			Scanner scan = new Scanner(System.in);
			System.out.println("\nInforme o nome do arquivo de onde carregará: ");
			carregador.carregaDados(scan.nextLine());
			System.out.println("");
		}
	}

	public static void menuPeriodo(){
		String opcao = "s";
		Scanner scan = new Scanner(System.in);
		LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Periodos cadastrados:");
			lPeriodo.listar();    
			System.out.println("\nDeseja cadastrar novo periodo?(Digite 's' caso queira ou qualquer tecla caso não" 
							+" queira)");
			
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				Periodo periodo = lPeriodo.ler();
				if(lPeriodo.busca(periodo.obterCodigo()) != null)
					throw new IllegalArgumentException("Cadastro repetido: "+periodo+".");
				lPeriodo.anexaHash(periodo);
				System.out.println();
			}
		}
  	}

	public static void menuEstudante(){
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
				lEstudante.anexaHash(estudante);
			}
		}
	}

	public static void menuAtividadeDiscplina(){
		String opcao = "s";
		LeitorAtividade lAtividade = LeitorAtividade.obterInstancia();
		LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(!opcao.toLowerCase().equals("m")){
			opcao = "s";
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			lDisciplina.listar();
			System.out.println("\nDigite o código da disciplina a qual deseja ver as ativades: ");
			Disciplina disciplina = lDisciplina.busca(scan.next());
			if(disciplina==null){
				System.out.println("Dado não encontrado. Retornando ao menu. ");
				break;
			}
			while(opcao.toLowerCase().equals("s")){
				System.out.println("\nAtividades cadastradas:");
				lAtividade.lista(disciplina.obterAtividades());
				System.out.println("\nDeseja cadastrar nova atividade? (Digite 's' caso queira, 'm' para voltar ao menu "+
							"e qualquer tecla para selecionar outra disciplina)");
				opcao = scan.next();
				if(opcao.toLowerCase().equals("s")){
					Atividade atividade = lAtividade.ler();
					disciplina.anexaAtividade(atividade);
				}
			}
		}
	}

	public static void menuDocentes(){
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

	public static void menuDisciplina(){
		LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
		Scanner scan = new Scanner(System.in);
		String opcao = "s";
		LeitorDocente lDocente= LeitorDocente.obterInstancia();
		LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			lDisciplina.listar();	
			System.out.println("\nDeseja cadastrar nova disciplina? (Digite 's' caso queira ou qualquer tecla caso não"+
			" queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				System.out.println("Docentes cadastrados:");
				lDocente.listar();
				System.out.println("\nInforme o login do docente para a disciplina: ");
				Docente docente = lDocente.busca(scan.next());
				if(docente==null){
					System.out.println("Dado não encontrado. Retornando ao menu. ");
					break;
				}
				System.out.println("\nPeriodos cadastrados:");
				lPeriodo.listar();
				System.out.println("\nInforme o periodo da disciplina: ");
				Periodo periodo = lPeriodo.busca(scan.next());
				if(periodo==null){
					System.out.println("Dado não encontrado. Retornando ao menu. ");
					break;
				}
				Disciplina disciplina = lDisciplina.ler(periodo,docente);
				lDisciplina.anexaHash(disciplina);
			}
		}
	}
	
	public static void menuEstudanteDisciplina(){
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
			Disciplina disciplina = lDisciplina.busca(scan.next());
			if(disciplina==null){
				System.out.println("Dado não encontrado. Retornando ao menu.\n");
				break;
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
						System.out.println("Dado não encontrado. Retornando ao menu.");
						break;
					}
					lDisciplinaEstudante.adiciona(disciplina, estudante);
				}
			}
		}
	}

	public static void menuAvaliacao(){
		String opcao = "s";
		LeitorAvaliacao lAvaliacao = LeitorAvaliacao.obterInstancia();
		LeitorAtividade lAtividade = LeitorAtividade.obterInstancia();
		LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
		LeitorDisciplinaEstudante lDisciplinaEstudante = LeitorDisciplinaEstudante.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(!opcao.toLowerCase().equals("m")){
			opcao = "s";
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			lDisciplina.listar();
			System.out.println("\nDigite o código da disciplina a qual deseja ver as avaliações: ");
			Disciplina disciplina = lDisciplina.busca(scan.next());
			if(disciplina==null){
				System.out.println("Dado não encontrado. Retornando ao menu. ");
				break;
			}
			System.out.println("\nAtividades cadastradas:");
			lAtividade.lista(disciplina.obterAtividades());
			System.out.println("\nDigite o numero da atividade a qual deseja ver as avaliações: ");
			Atividade atividade = lAtividade.busca(scan.nextInt()-1,disciplina.obterAtividades());
			if(atividade==null){
				System.out.println("Dado não encontrado. Retornando ao menu. ");
				break;
			}
			while(opcao.toLowerCase().equals("s")){
				System.out.println("\nAvaliações cadastradas:");
				lAvaliacao.lista(atividade.obterAvaliacoes());
				System.out.println("\nDeseja adicionar uma nova avaliação de um estudante?(Digite 's' caso queira, 'm' para voltar ao menu "+
							"e qualquer tecla para selecionar outra disciplina)");
				opcao = scan.next();
				if(opcao.toLowerCase().equals("s")){
					System.out.println("\nEstudantes matriculados nessa disciplina:");
					lDisciplinaEstudante.lista(disciplina);
					System.out.println("\nDigite a matricula do estudante que deseja adcionar a avaliacao: ");
					Estudante estudante = lDisciplinaEstudante.busca(disciplina,scan.nextInt());
					if(estudante==null){
						System.out.println("Dado não encontrado. Retornando ao menu. ");
						break;
					}
					Avaliacao avaliacao = lAvaliacao.ler(estudante);
					atividade.anexaAvaliacao(avaliacao);
				}
			}
		}
	}
}