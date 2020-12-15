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

    string linha;
    getline(*scan, linha);
    while (getline(*scan, linha)) {
        Tokenizer tok(linha, ';');
        vector<string> vec = tok.remaining();
        for (int i = 0; i < vec.size(); i++){
            vec[i] = trim(vec[i]);
        }
        string codigoDisc = vec[0];
        Disciplina *disciplina;
        try{
            disciplina = controlador.busca(codigoDisc);
        }
        catch(...){
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        }
        Atividade* atividade = leitor->ler(vec);
        disciplina->anexaAtividade(atividade);
    }
}

void ControladorAtividade :: lerAvaliacao(ifstream*scan){
    ControladorDisciplina cDisciplina;
    ControladorEstudante cEstudante;
    LeitorAtividade* lAtividade = LeitorAtividade::obterInstancia();
    LeitorAvaliacao* lAvaliacao = LeitorAvaliacao::obterInstancia();

    string linha;
    getline(*scan, linha);
    while (getline(*scan, linha)) {
        Tokenizer tok(linha, ';');
        vector<string> vec = tok.remaining();
        for (int i = 0; i < vec.size(); i++){
            vec[i] = trim(vec[i]);
        }
        string codigoDisc = vec[0];
        string matricula = vec[1];
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
        
        char codigoAtiv = vec[2];
        Atividade* atividade = lAtividade->busca(codigoAtiv-1, disciplina->obterAtividades());
        Avaliacao* avaliacao = lAvaliacao->ler(vec, *estudante);
        if(verificaCadastroAvaliacao(atividade, estudante))
            throw ExcecaoAval("Avaliação repetida: estudante "+estudante->obterMatricula()+ 
                                " para atividade " +codigoAtiv +" de "+disciplina->obterCodigo()+"-"+
                                disciplina->obterPeriodo()->obterCodigo()+".");
        atividade->anexaAvaliacao(avaliacao);
    }
}