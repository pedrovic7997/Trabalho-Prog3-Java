import java.util.Scanner;
import java.util.List;

public class Main{
	public static void main(String[] args){
		int opcao;
		Scanner scan = new Scanner(System.in);
		do{
			escreveMenu();
			opcao = scan.nextInt();
			escolherMenu(opcao);
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
		System.out.println("0-Sair do programa;");
	}
	
	public static void escolherMenu(int opcao){
		switch(opcao){
			case 0: System.out.println("Saindo do programa.");
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
			default : System.out.println("Opcão invalida");
		}
	}
	
	public static void menuPeriodo(){
		String opcao = "s";
		Scanner scan = new Scanner(System.in);
		LeitorPeriodo leitor = LeitorPeriodo.obterInstancia();
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Periodos cadastrados:");
			leitor.listar();    
			System.out.println("\nDeseja cadastrar novo periodo?(Digite 's' caso queira ou qualquer tecla caso não queira)");
			
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				Periodo periodo = leitor.ler();
				leitor.anexaHash(periodo);
				System.out.println();
			}
		}
  	}

	public static void menuEstudante(){
		String opcao = "s";
		LeitorEstudante leitor = LeitorEstudante.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Estudantes cadastrados:");
			leitor.listar();    
			System.out.println("\nDeseja cadastrar novo estudante?(Digite 's' caso queira ou qualquer tecla caso não queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				Estudante estudante = leitor.ler();
				leitor.anexaHash(estudante);
			}
			
		}
	}

	public static void menuAtividadeDiscplina(){
		String opcao = "s";
		LeitorAtividade leitor = LeitorAtividade.obterInstancia();
		LeitorDisciplina leitorD = LeitorDisciplina.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			leitorD.listar();
			System.out.println("\nDigite o código da disciplina a qual deseja ver as ativades: ");
			Disciplina disciplina = leitorD.busca(scan.next());
			if(disciplina==null){
				System.out.println("Dado não encontrado. Retornando ao menu. ");
				break;
			}
			System.out.println("\nAtividades cadastradas:");
			leitor.lista(disciplina.obterAtividades());
			System.out.println("\nDeseja cadastrar nova atividade? (Digite 's' caso queira ou qualquer tecla caso não queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				Atividade atividade = leitor.ler();
				disciplina.anexaAtividade(atividade);
			}
		}
	}

	public static void menuDocentes(){
		LeitorDocente leitor = LeitorDocente.obterInstancia();
		String opcao = "s";
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Docentes cadastrados:");
			leitor.listar();
			System.out.println("\nDeseja cadastrar novo docente? (Digite 's' caso queira ou qualquer tecla caso não queira)");
			opcao = scan.next();  
			if(opcao.toLowerCase().equals("s")){
				Docente docente = leitor.ler();
				leitor.anexaHash(docente);
			}
		}
	}

	public static void menuDisciplina(){
		LeitorDisciplina leitor = LeitorDisciplina.obterInstancia();
		Scanner scan = new Scanner(System.in);
		String opcao = "s";
		LeitorDocente leitorD= LeitorDocente.obterInstancia();
		LeitorPeriodo leitorP = LeitorPeriodo.obterInstancia();
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			leitor.listar();	
			System.out.println("\nDeseja cadastrar nova disciplina? (Digite 's' caso queira ou qualquer tecla caso não queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				System.out.println("Docentes cadastrados:");
				leitorD.listar();
				System.out.println("\nInforme o login do docente para a disciplina: ");
				Docente docente = leitorD.busca(scan.next());
				if(docente==null){
					System.out.println("Dado não encontrado. Retornando ao menu. ");
					break;
				}
				System.out.println("\nPeriodos cadastrados:");
				leitorP.listar();
				System.out.println("\nInforme o periodo da disciplina: ");
				Periodo periodo = leitorP.busca(scan.next());
				if(periodo==null){
					System.out.println("Dado não encontrado. Retornando ao menu. ");
					break;
				}
				Disciplina disciplina = leitor.ler(periodo,docente);
				leitor.anexaHash(disciplina);
			}
		}
	}
	
	public static void menuEstudanteDisciplina(){
		String opcao = "s";
		LeitorDisciplina leitorD = LeitorDisciplina.obterInstancia();
		LeitorEstudante leitorE = LeitorEstudante.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			leitorD.listar();
			System.out.println("\nDigite o código da disciplina a qual deseja ver os estudantes cadastrados: ");
			Disciplina disciplina = leitorD.busca(scan.next());
			if(disciplina==null){
				System.out.println("Dado não encontrado. Retornando ao menu.\n");
				break;
			}
			System.out.println("\nEstudantes matriculados nessa disciplina:");
			disciplina.listaEstudante();
			System.out.println("\nDeseja adicionar um estudante a essa materia? (Digite 's' caso queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				System.out.println("\nEstudantes cadastrados:");
				leitorE.listar();
				System.out.println("\nDigite a matricula do estudante que deseja adcionar a disciplina: ");
				Estudante estudante = leitorE.busca(scan.nextInt());
				if(estudante==null){
					System.out.println("Dado não encontrado. Retornando ao menu.");
					break;
				}
				disciplina.anexaEstudante(estudante);
			}
		}
	}

	public static void menuAvaliacao(){
		String opcao = "s";
		LeitorAvaliacao leitor = LeitorAvaliacao.obterInstancia();
		LeitorAtividade leitorA = LeitorAtividade.obterInstancia();
		LeitorDisciplina leitorD = LeitorDisciplina.obterInstancia();
		LeitorEstudante leitorE = LeitorEstudante.obterInstancia();
		Scanner scan = new Scanner(System.in);
		while(opcao.toLowerCase().equals("s")){
			System.out.println("------------------------");
			System.out.println("Disciplinas cadastradas:");
			leitorD.listar();
			System.out.println("\nDigite o código da disciplina a qual deseja ver as avaliações: ");
			Disciplina disciplina = leitorD.busca(scan.next());
			if(disciplina==null){
				System.out.println("Dado não encontrado. Retornando ao menu. ");
				break;
			}
			System.out.println("\nAtividades cadastradas:");
			leitorA.lista(disciplina.obterAtividades());
			System.out.println("\nDigite o numero da atividade a qual deseja ver as avaliações: ");
			Atividade atividade = leitorA.busca(scan.nextInt()-1,disciplina.obterAtividades());
			if(atividade==null){
				System.out.println("Dado não encontrado. Retornando ao menu. ");
				break;
			}
			System.out.println("\nAvaliações cadastradas:");
			leitor.lista(atividade.obterAvaliacoes());
			System.out.println("\nDeseja adicionar uma nova avaliação de um estudante? (Digite 's' caso queira)");
			opcao = scan.next();
			if(opcao.toLowerCase().equals("s")){
				System.out.println("\nEstudantes matriculados nessa disciplina:");
				disciplina.listaEstudante();
				System.out.println("\nDigite a matricula do estudante que deseja adcionar a avaliacao: ");
				Estudante estudante = disciplina.buscaEstudante(scan.nextInt());
				if(estudante==null){
					System.out.println("Dado não encontrado. Retornando ao menu. ");
					break;
				}
				Avaliacao avaliacao = leitor.ler(estudante);
				atividade.anexaAvaliacao(avaliacao);

			}
		}
	}
}

