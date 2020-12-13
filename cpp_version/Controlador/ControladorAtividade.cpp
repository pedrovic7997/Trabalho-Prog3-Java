#include "ControladorAtividade.h"

bool ControladorAtividade :: verificaCadastroAvaliacao(Atividade atividade,Estudante estudante){
    for(Avaliacao avaliacao : atividade.obterAvaliacoes())
        if(avaliacao.obterAluno() == estudante)
            return true;
    return false;
}

void ControladorAtividade :: ler(ifstream scan){
    LeitorAtividade leitor = LeitorAtividade.obterInstancia();
    ControladorDisciplina controlador = new ControladorDisciplina();
		
    while(scan.peek() != EOF){
        string codigoDisc;
        scan >>codigoDisc;
        Disciplina disciplina = controlador.busca(codigoDisc);
        if(disciplina == null)
            throw new Exception("Referência inválida: "+codigoDisc+".");
        Atividade atividade = leitor.ler(scan);
        disciplina.anexaAtividade(atividade);
    }
}

void ControladorAtividade :: lerAvaliacao(ifstream scan){
    ControladorDisciplina cDisciplina = new ControladorDisciplina();
    ControladorEstudante cEstudante = new ControladorEstudante();
    LeitorAtividade lAtividade = LeitorAtividade.obterInstancia();
    LeitorAvaliacao lAvaliacao = LeitorAvaliacao.obterInstancia();

    while(scan.hasNext()){
        String codigoDisc = scan.next().trim();
        Disciplina disciplina = cDisciplina.busca(codigoDisc);
        if (disciplina == null){
            throw new NoSuchElementException("Referência inválida: "+codigoDisc+".");
        }
        String matricula = scan.next().trim();
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