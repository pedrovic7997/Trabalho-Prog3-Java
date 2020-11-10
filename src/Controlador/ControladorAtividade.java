package Controlador;

import java.util.NoSuchElementException;
import java.util.Scanner;

import Leitor.LeitorAtividade;
import Leitor.LeitorAvaliacao;
import Modelo.Atividade;
import Modelo.Avaliacao;
import Modelo.Disciplina;
import Modelo.Estudante;

public class ControladorAtividade implements IControlador{
	
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
			String codigoDisc = scan.next();
			Disciplina disciplina = cDisciplina.busca(codigoDisc);
			if (disciplina == null){
				throw new NoSuchElementException("Referência inválida: "+codigoDisc+".");
			}
			String matricula = scan.next();
			Estudante estudante = cEstudante.busca(matricula);
			if (estudante == null){
				throw new NoSuchElementException("Referência inválida: "+matricula+".");
			}
			int codigoAtiv = scan.nextInt();
			Atividade atividade = lAtividade.busca(codigoAtiv-1, disciplina.obterAtividades());
			if (atividade == null){
				throw new NoSuchElementException("Referência inválida: "+codigoAtiv+".");
			}
			Avaliacao avaliacao = lAvaliacao.ler(scan, estudante);
			if(verificaCadastroAvaliacao(atividade, estudante))
				throw new Exception("Avaliação repetida: estudante "+estudante.obterMatricula()+ 
									" para atividade " +codigoAtiv +" de "+disciplina.obterCodigo()+"-"+
									disciplina.obterPeriodo().obterCodigo()+".");
			atividade.anexaAvaliacao(avaliacao);
		}
	}
}
