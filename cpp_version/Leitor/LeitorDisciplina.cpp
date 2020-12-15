#include "LeitorDisciplina.h"

LeitorDisciplina* LeitorDisciplina::leitor = nullptr;

LeitorDisciplina::LeitorDisciplina(){}

LeitorDisciplina* LeitorDisciplina::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorDisciplina();
        return leitor;
    }
    else return leitor;
}

vector<Disciplina*> LeitorDisciplina::busca(Periodo* periodo){
    vector<Disciplina*> lista;
    for(map<string,Disciplina*>::iterator it = mapa.begin(); it != mapa.end(); ++it){
        if(it->second->obterPeriodo() == periodo)
            lista.push_back(it->second);
    }
    return lista;
}

vector<Disciplina*> LeitorDisciplina::busca(Docente* docente){
    vector<Disciplina*> lista;
    for(map<string,Disciplina*>::iterator it = mapa.begin(); it != mapa.end(); ++it){
        if(it->second->obterDocente() == docente)
            lista.push_back(it->second);
    }
    return lista;
}

Disciplina* LeitorDisciplina::busca(string codigo){
    for(map<string,Disciplina*>::iterator it = mapa.begin(); it != mapa.end(); ++it)
        if(it->first == codigo)
            return it->second;
    return nullptr;
}

Disciplina* LeitorDisciplina::ler(ifstream* scan, Periodo* periodo){
    ControladorDocente cDocente;
    string trash;
    
    string codigo;
    getLineTeste(scan,&codigo,";\n");
    trim(codigo);

    if(busca(codigo + "-" + periodo->obterCodigo()) != NULL){
        throw ExcecaoCad("Cadastro repetido: "+codigo+"-"+periodo->obterCodigo()+".");
    }

    string nome;
    getLineTeste(scan,&nome,";\n");
    trim(nome);

    string login;
    getLineTeste(scan,&login,";\n");
    trim(login);

    Docente* docente = cDocente.busca(login);
    if(docente == NULL){
        throw ExcecaoRef("Referência inválida: " + login + ".");
    }

    if(!scan->eof())
        getLineTeste(scan,&trash,";\n");

    Disciplina* disciplina = new Disciplina(codigo, nome, periodo, docente);
    return disciplina;
}

void LeitorDisciplina::anexaHash(Disciplina* disciplina){
    mapa[disciplina->obterCodigo()+"-"+to_string(disciplina->obterPeriodo()->obeterAno())+"/"+
        disciplina->obterPeriodo()->obterSemestre()] = disciplina;
}

vector<Disciplina*> LeitorDisciplina::obterDisciplinas(){
    vector<Disciplina*> lista;
    for(map<string,Disciplina*>::iterator it = mapa.begin(); it != mapa.end(); ++it)
        lista.push_back(it->second);
    return lista;
}