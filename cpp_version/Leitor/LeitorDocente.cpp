#include "LeitorDocente.h"

LeitorDocente* LeitorDocente::leitor = NULL;

LeitorDocente* LeitorDocente::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorDocente();
        return leitor;
    }
    else return leitor;
}

vector<Docente*> LeitorDocente::obterDocentes(){
    vector<Docente*> lista;
    for(map<string,Docente*>::iterator it = mapDocente.begin(); it != mapDocente.end(); ++it){
        lista.push_back(it->second);
    }
    return lista;
}

Docente* LeitorDocente::ler(ifstream* scanner){
    string login;
    getline(*scanner, login, ';');
    trim(login);
    
    if(leitor->busca(login) != NULL)
        throw ExcecaoCad("Cadastro repetido: " + login + ".");

    string nome;
    getline(*scanner, nome, ';');
    trim(nome);

    string site;
    getline(*scanner, site, ';');
    trim(site);

    return new Docente(login, nome, site);
}

void LeitorDocente::anexaHash(Docente* docente){
    mapDocente[docente->obterLogin()] = docente;
}

Docente* LeitorDocente::busca(string login){
    bool contains = false;
    for(map<string,Docente*>::iterator it = mapDocente.begin(); it != mapDocente.end(); ++it){
        if(it->first == login){
            contains = true;
        }
    }
    if(contains){
        return mapDocente[login];
    }
    return NULL;
}

vector<Periodo*> busca(Docente* docente){
    ControladorDisciplina cDisciplina;

    vector<Disciplina*> disciplinas = cDisciplina.busca(docente);
    vector<Periodo*> periodos;

    bool possui = false;
    for(Disciplina* disciplina : disciplinas){
        possui = false;
        for(Periodo* periodo: periodos){
            if(disciplina->obterPeriodo() == periodo){
                possui=true;
            }
        }
        if(!possui){
            periodos.push_back(disciplina->obterPeriodo());
        }
    }
    return periodos;
}