#include "LeitorAvaliacao.h"

LeitorAvaliacao* LeitorAvaliacao::leitor = NULL;

LeitorAvaliacao* LeitorAvaliacao::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorAvaliacao();
        return leitor;
    }
    else return leitor;
}

vector<Avaliacao*> busca(vector<Avaliacao*> avaliacoes, Estudante* estudante){
    vector<Avaliacao*> lista;
    for(auto a : avaliacoes){
        if(a->obterAluno() == estudante)
            lista.push_back(a);
    }
    return lista;
}

Avaliacao* ler(ifstream* scan,Estudante aluno){
    float nota;
    string aux, trash;

    try{
        getline(*scan, aux, ';');
        nota = stof(aux);
    } catch (...) {
        throw ExcecaoDado("Dado inválido: " + aux + ".");
    }

    if(!scan->eof())
        getline(*scan, trash, '\n');

    return &Avaliacao(aluno, nota);
}