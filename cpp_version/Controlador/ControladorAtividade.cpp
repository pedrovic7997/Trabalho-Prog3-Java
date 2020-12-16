#include "ControladorAtividade.h"

bool verificaCadastroAvaliacao(Atividade* atividade,Estudante* estudante){
    for(Avaliacao* avaliacao : atividade->obterAvaliacoes())
        if(avaliacao->obterAluno()->obterNome() == estudante->obterNome())
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

        disciplina = controlador.busca(codigoDisc);

        if(disciplina == NULL){
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
        disciplina= cDisciplina.busca(codigoDisc);


        if(disciplina == NULL){
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        }
        Estudante* estudante;
        estudante = cEstudante.busca(matricula);

        if(estudante == NULL){
            throw ExcecaoRef("Referência inválida: "+matricula+".");
        }
        int codigoAtiv = atoi(vec[2].c_str());
        Atividade* atividade = lAtividade->busca(codigoAtiv-1, disciplina->obterAtividades());
        Avaliacao* avaliacao = lAvaliacao->ler(vec, *estudante);
        if(verificaCadastroAvaliacao(atividade, estudante))
            throw ExcecaoAval("Avaliação repetida: estudante "+estudante->obterMatricula()+ 
                                " para atividade " +to_string(codigoAtiv) +" de "+disciplina->obterCodigo()+"-"+
                                disciplina->obterPeriodo()->obterCodigo()+".");
        atividade->anexaAvaliacao(avaliacao);
    }
}