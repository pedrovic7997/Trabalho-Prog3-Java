package Controlador;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Leitor.LeitorDisciplina;
import Leitor.LeitorAtividade;
import Leitor.LeitorAvaliacao;
import Leitor.LeitorDisciplinaEstudante;
import Modelo.Atividade;
import Modelo.Avaliacao;
import Modelo.Disciplina;
import Modelo.Estudante;

public class ControladorAtividade implements IControlador{
	
	// public void menu(String func) throws Exception {
	// 	if(func.equals("Atividade"))
	// 		menuAtvidade();
	// 	else menuAvaliacao();
	// }
	
	// public void menuAtvidade(){
	// 	String opcao = "s";
	// 	LeitorAtividade leitor = LeitorAtividade.obterInstancia();
	// 	ControladorDisciplina cDisciplina = new ControladorDisciplina();
	// 	Scanner scan = new Scanner(System.in);
	// 	while(!opcao.toLowerCase().equals("m")){
	// 		opcao = "s";
	// 		cDisciplina.listar();
	// 		leitor.mensagem("\nDigite o código da disciplina a qual deseja ver as ativades: ");
	// 		String codigo = scan.next();
	// 		Disciplina disciplina = cDisciplina.busca(codigo);
	// 		if (disciplina==null) {
	// 			throw new NoSuchElementException("Referência inválida: "+codigo+".");
	// 		}
	// 		while(opcao.toLowerCase().equals("s")){
	// 			leitor.mensagem("\nAtividades cadastradas:");
	// 			leitor.lista(disciplina.obterAtividades());
	// 			leitor.mensagem("\nDeseja cadastrar nova atividade? (Digite 's' caso queira, 'm' para voltar ao menu "+
	// 						"e qualquer tecla para selecionar outra disciplina)");
	// 			opcao = scan.next();
	// 			if(opcao.toLowerCase().equals("s")){
	// 				Atividade atividade = leitor.ler();
	// 				disciplina.anexaAtividade(atividade);
	// 			}
	// 		}
	// 	}
    // }

    // public void menuAvaliacao() throws Exception{
	// 	String opcao = "s";
	// 	LeitorAvaliacao leitor = LeitorAvaliacao.obterInstancia();
	// 	LeitorAtividade lAtividade = LeitorAtividade.obterInstancia();
	// 	ControladorDisciplina cDisciplina = new ControladorDisciplina();
	// 	Scanner scan = new Scanner(System.in);
	// 	while(!opcao.toLowerCase().equals("m")){
	// 		opcao = "s";
	// 		cDisciplina.listar();
	// 		leitor.mensagem("\nDigite o código da disciplina a qual deseja ver as avaliações: ");
	// 		Disciplina disciplina = cDisciplina.busca(scan.next());
	// 		if(disciplina==null){
	// 			leitor.mensagem("Dado não encontrado. Retornando ao menu. ");
	// 			break;
	// 		}
	// 		leitor.mensagem("\nAtividades cadastradas:");
	// 		lAtividade.lista(disciplina.obterAtividades());
	// 		leitor.mensagem("\nDigite o numero da atividade a qual deseja ver as avaliações: ");
	// 		int codigo = scan.nextInt()-1;
	// 		Atividade atividade = lAtividade.busca(codigo,disciplina.obterAtividades());
	// 		if(atividade==null){
	// 			throw new NoSuchElementException("Referencia invalida: "+codigo+".");
	// 		}
	// 		while(opcao.toLowerCase().equals("s")){
	// 			leitor.mensagem("\nAvaliações cadastradas:");
	// 			leitor.lista(atividade.obterAvaliacoes());
	// 			leitor.mensagem("\nDeseja adicionar uma nova avaliação de um estudante?(Digite 's' caso queira, 'm' para voltar ao menu "+
	// 						"e qualquer tecla para selecionar outra disciplina)");
	// 			opcao = scan.next();
	// 			if(opcao.toLowerCase().equals("s")){
	// 				leitor.mensagem("\nEstudantes matriculados nessa disciplina:");
	// 				cDisciplina.listar(disciplina);
	// 				leitor.mensagem("\nDigite a matricula do estudante que deseja adcionar a avaliacao: ");
	// 				int matricula = scan.nextInt();
	// 				Estudante estudante = cDisciplina.busca(disciplina, matricula);
	// 				if(estudante == null){
	// 					throw new NoSuchElementException("Referencia invalida: "+matricula+".");
	// 				}
	// 				codigo++;
	// 				Avaliacao avaliacao = leitor.ler(estudante);
	// 				if(verificaCadastroAvaliacao(atividade,estudante))
	// 					throw new Exception("Avaliação repetida: estudante "+estudante.obterMatricula()+ 
	// 							" para atividade " +codigo +" de "+disciplina.obterCodigo()+"-"+
	// 							disciplina.obterPeriodo().obterCodigo()+".");
	// 				atividade.anexaAvaliacao(avaliacao);
	// 			}
	// 		}
	// 	}
	// }

	private boolean verificaCadastroAvaliacao(Atividade atividade,Estudante estudante){
		for(Avaliacao avaliacao : atividade.obterAvaliacoes())
			if(avaliacao.obterAluno() == estudante)
				return true;
		return false;
	}

	public void ler(Scanner scan) throws Exception {
		LeitorAtividade leitor = LeitorAtividade.obterInstancia();
		ControladorDisciplina controlador = new ControladorDisciplina();
		
		while(scan.hasNext()){
			Disciplina disciplina = controlador.busca(scan.next());
			Atividade atividade = leitor.ler(scan);
			disciplina.anexaAtividade(atividade);
		}
	}

	public void lerAvaliacao(Scanner scan) throws Exception {
		ControladorDisciplina cDisciplina = new ControladorDisciplina();
		ControladorEstudante cEstudante = new ControladorEstudante();
		LeitorAtividade lAtividade = LeitorAtividade.obterInstancia();
		LeitorAvaliacao lAvaliacao = LeitorAvaliacao.obterInstancia();

		while(scan.hasNext()){
			int codigo = scan.nextInt();
			Disciplina disciplina = cDisciplina.busca(scan.next());
			Estudante estudante = cEstudante.busca(scan.next());
			Atividade atividade = lAtividade.busca(codigo-1, disciplina.obterAtividades());
			Avaliacao avaliacao = lAvaliacao.ler(scan, estudante);
			if(verificaCadastroAvaliacao(atividade, estudante))
				throw new Exception("Avaliação repetida: estudante "+estudante.obterMatricula()+ 
									" para atividade " +codigo +" de "+disciplina.obterCodigo()+"-"+
									disciplina.obterPeriodo().obterCodigo()+".");
			atividade.anexaAvaliacao(avaliacao);
		}
	}
}
