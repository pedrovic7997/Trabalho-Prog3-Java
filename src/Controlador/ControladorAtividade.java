package Controlador;

public class ControladorAtividade implements IControlador{
    public void menu(){
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

    public void menuAvaliacao(){
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
