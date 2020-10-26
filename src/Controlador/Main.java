package Controlador;

import java.util.InputMismatchException;
import java.util.Scanner;
import Leitor.*;
import Modelo.*;

public class Main extends Controlador{
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
		Controlador controlador;
		switch(opcao){
			case 0: System.out.println("\nSaindo do programa...");
				break;
			case 1: controlador = new ControladorPeriodo();
				controlador.menu();
				break;
			case 2: menuDocentes();
				controlador = new ControladorDocente();
				controlador.menu();
				break;
			case 3: menuDisciplina();
				controlador = new ControladorDisciplina();
				controlador.menu();
				break;
			case 4: menuEstudante();
				controlador = new ControladorPeriodo();
				controlador.menu();
				break;
			case 5: menuEstudanteDisciplina();
				controlador = new ControladorPeriodo();
				controlador.menu();
				break;
			case 6: menuAtividadeDiscplina();
				controlador = new ControladorPeriodo();
				controlador.menu();
				break;
			case 7: menuAvaliacao();
				controlador = new ControladorPeriodo();
				controlador.menu();
				break;
			case 8: menuRelatorios();
				controlador = new ControladorPeriodo();
				controlador.menu();
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


}