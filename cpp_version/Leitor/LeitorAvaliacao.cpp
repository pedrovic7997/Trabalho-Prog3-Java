#include "LeitorAvaliacao.h"

LeitorAvaliacao* LeitorAvaliacao::leitor = nullptr;

LeitorAvaliacao::LeitorAvaliacao(){}

LeitorAvaliacao* LeitorAvaliacao::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorAvaliacao();
        return leitor;
    }
    else return leitor;
}

vector<Avaliacao*> LeitorAvaliacao::busca(vector<Avaliacao*> avaliacoes, Estudante* estudante){
    vector<Avaliacao*> lista;
    for(auto a : avaliacoes){
        if(a->obterAluno() == estudante)
            lista.push_back(a);
    }
    return lista;
}

Avaliacao* LeitorAvaliacao::ler(ifstream* scan,Estudante aluno){
    float nota;
    string aux, trash;

    try{
        getLineTeste(scan,&aux,";\n");
        nota = stof(aux);
    } catch (...) {
        throw ExcecaoDado("Dado inválido: " + aux + ".");
    }

    if(!scan->eof())
        getLineTeste(scan,&trash,";\n");

    return new Avaliacao(aluno, nota);
}