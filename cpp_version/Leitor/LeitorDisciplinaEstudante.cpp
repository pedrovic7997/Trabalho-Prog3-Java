#include "LeitorDisciplinaEstudante.h"

LeitorDisciplinaEstudante* LeitorDisciplinaEstudante::leitor = nullptr;

LeitorDisciplinaEstudante::LeitorDisciplinaEstudante(){}

LeitorDisciplinaEstudante* LeitorDisciplinaEstudante::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorDisciplinaEstudante();
        return leitor;
    }
    else return leitor;
}

void LeitorDisciplinaEstudante::adiciona(Disciplina* disciplina, Estudante* estudante){
    bool contains = false;
    for(map<string,vector<Disciplina*>>::iterator it = mapEstudante.begin(); it != mapEstudante.end(); ++it){
        if(it->first == estudante->obterMatricula()){
            contains = true;
        }
    }
    if(!contains){
        vector<Disciplina*> novo;
        mapEstudante[estudante->obterMatricula()] = novo;
    }
    mapEstudante[estudante->obterMatricula()].push_back(disciplina);

    contains = false;
    for(map<string,vector<Estudante*>>::iterator it = mapDisciplina.begin(); it != mapDisciplina.end(); ++it){
        if(it->first == disciplina->obterCodigo() + disciplina->obterPeriodo()->obterCodigo()){
            contains = true;
        }
    }
    if(!contains){
        vector<Estudante*> novo;
        mapDisciplina[disciplina->obterCodigo() + disciplina->obterPeriodo()->obterCodigo()] = novo;
    }
    mapDisciplina[disciplina->obterCodigo() + disciplina->obterPeriodo()->obterCodigo()].push_back(estudante);
}

Estudante* LeitorDisciplinaEstudante::busca(Disciplina* disciplina,string matricula){
    bool contains = false;
    for(map<string,vector<Estudante*>>::iterator it = mapDisciplina.begin(); it != mapDisciplina.end(); ++it){
        if(it->first == disciplina->obterCodigo() + disciplina->obterPeriodo()->obterCodigo()){
            contains = true;
        }
    }
    if(!contains){
        return nullptr;
    }
    for(auto e : mapDisciplina[disciplina->obterCodigo() + disciplina->obterPeriodo()->obterCodigo()]){
        if(e->obterMatricula() == matricula)
            return e;
    }
    return nullptr;
}

vector<Estudante*> LeitorDisciplinaEstudante::busca(Disciplina* disciplina){
    return mapDisciplina[disciplina->obterCodigo() + disciplina->obterPeriodo()->obterCodigo()];
}

vector<Disciplina*> LeitorDisciplinaEstudante::busca(Estudante* estudante){
    return mapEstudante[estudante->obterMatricula()];
}