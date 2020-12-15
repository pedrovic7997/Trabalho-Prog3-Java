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
        try{
            disciplina = controlador.busca(codigoDisc);
        }
        catch(...){
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        }
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
        try{
            disciplina= cDisciplina.busca(codigoDisc);

        }
        catch(...){
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        }
        Estudante* estudante;
        try{
            estudante = cEstudante.busca(matricula);

        }
        catch(...){
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        }
        
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