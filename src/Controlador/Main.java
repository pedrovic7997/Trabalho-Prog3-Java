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
			menu();
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

	public static void menu(){
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
		IControlador controlador;
		switch(opcao){
			case 0: System.out.println("\nSaindo do programa...");
				break;
			case 1: controlador = new ControladorPeriodo();
				controlador.menu("");
				break;
			case 2:
				controlador = new ControladorDocente();
				controlador.menu("");
				break;
			case 3:
				controlador = new ControladorDisciplina();
				controlador.menu("");
				break;
			case 4:
				controlador = new ControladorEstudante();
				controlador.menu("");
				break;
			case 5:
				controlador = new ControladorDisciplina();
				controlador.menu("Disciplina");
				break;
			case 6:
				controlador = new ControladorAtividade();
				controlador.menu("");
				break;
			case 7:
				controlador = new ControladorAtividade();
				controlador.menu("Avaliacao");
				break;
			case 8:
				controlador = new Relatorio();
				controlador.menu("");
				break;
			case 9: salvaDados(args);
				break;
			case 10: carregaDados(args);
				break;
			default : System.out.println("\nOpcão invalida!\n");
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