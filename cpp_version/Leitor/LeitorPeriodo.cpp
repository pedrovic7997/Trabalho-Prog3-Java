#include "LeitorPeriodo.h"

LeitorPeriodo* LeitorPeriodo::leitor = NULL;

LeitorPeriodo::LeitorPeriodo(){}

LeitorPeriodo* LeitorPeriodo::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorPeriodo();
        return leitor;
    }
    else return leitor;
}

vector<Periodo*> LeitorPeriodo::obterPeriodos(){
    vector<Periodo*> lista;
    for(map<string,Periodo*>::iterator it = mapPeriodo.begin(); it != mapPeriodo.end(); ++it){
        lista.push_back(it->second);
    }
    return lista;
}

Periodo* LeitorPeriodo::ler(vector<string> vec){
    int ano;
    try{
        ano = stoi(vec[0]);
    } catch (...){
        throw ExcecaoCad("Dado inválido: "+ vec[0] +".");
    }

    string semestre = vec[1];

    regex rgx("^[0-9A-Za-z]$");
    smatch match;
    if(!regex_search(semestre, match, rgx))
        throw ExcecaoDado("Dado inválido: "+semestre+".");

    Periodo* periodo = new Periodo(ano, semestre[0]);

    if(busca(periodo->obterCodigo()) != NULL)
        throw ExcecaoCad("Cadastro repetido: "+periodo->obterCodigo()+".");

    return periodo;
}

void LeitorPeriodo::anexaHash(Periodo* periodo){
    mapPeriodo[periodo->obterCodigo()] = periodo;
}

Periodo* LeitorPeriodo::busca(string codigo){
    bool contains = false;
    for(map<string,Periodo*>::iterator it = mapPeriodo.begin(); it != mapPeriodo.end(); ++it){
        if(it->first == codigo){
            contains = true;
        }
    }
    if(contains){
        return mapPeriodo[codigo];
    }
    return NULL;
}