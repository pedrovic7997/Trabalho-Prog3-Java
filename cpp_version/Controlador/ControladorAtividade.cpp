#include "ControladorAtividade.h"

bool verificaCadastroAvaliacao(Atividade* atividade,Estudante* estudante){
    for(Avaliacao* avaliacao : atividade->obterAvaliacoes())
        if(avaliacao->obterAluno() == estudante)
            return true;
    return false;
}

void ControladorAtividade :: ler(ifstream*scan){
    LeitorAtividade* leitor = LeitorAtividade::obterInstancia();
    ControladorDisciplina controlador;
		
    while(!scan->eof()){
        string codigoDisc;
        
        *scan >>codigoDisc;
        Disciplina *disciplina;
        disciplina = controlador.busca(codigoDisc);
        if( disciplina== NULL)
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        Atividade* atividade = leitor->ler(scan);
        disciplina->anexaAtividade(atividade);
    }
}

void ControladorAtividade :: lerAvaliacao(ifstream*scan){
    ControladorDisciplina cDisciplina;
    ControladorEstudante cEstudante;
    LeitorAtividade* lAtividade = LeitorAtividade::obterInstancia();
    LeitorAvaliacao* lAvaliacao = LeitorAvaliacao::obterInstancia();

    while(!scan->eof()){
        string codigoDisc;
        *scan >>codigoDisc;
        string matricula;
        *scan >>matricula;
        Disciplina* disciplina;
        disciplina= cDisciplina.busca(codigoDisc);
        if(disciplina == NULL)
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        Estudante* estudante;
        estudante = cEstudante.busca(matricula);

        if(estudante == NULL)
            throw ExcecaoRef("Referência inválida: "+matricula+".");
        
        char codigoAtiv;
        cin >>codigoAtiv;
        Atividade* atividade = lAtividade->busca(codigoAtiv-1, disciplina->obterAtividades());
        Avaliacao* avaliacao = lAvaliacao->ler(scan, *estudante);
        if(verificaCadastroAvaliacao(atividade, estudante))
            throw ExcecaoAval("Avaliação repetida: estudante "+estudante->obterMatricula()+ 
                                " para atividade " +codigoAtiv +" de "+disciplina->obterCodigo()+"-"+
                                disciplina->obterPeriodo()->obterCodigo()+".");
        atividade->anexaAvaliacao(avaliacao);
    }
}