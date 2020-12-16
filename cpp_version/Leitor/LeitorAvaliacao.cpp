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
    for(Avaliacao* a : avaliacoes){
        if(a->obterAluno()->obterMatricula() == estudante->obterMatricula())
            lista.push_back(a);
    }
    return lista;
}

Avaliacao* LeitorAvaliacao::ler(vector<string> vec,Estudante aluno){
    double nota;
    string trash;

    try{
        nota = stof(vec[3]);
    } catch (...) {
        throw ExcecaoDado("Dado inválido: " + vec[3] + ".");
    }

    return new Avaliacao(aluno, nota);
}