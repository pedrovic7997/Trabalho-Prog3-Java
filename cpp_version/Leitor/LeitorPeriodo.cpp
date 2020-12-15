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

Periodo* LeitorPeriodo::ler(ifstream* scan){
    string aux;
    getLineTeste(scan,&aux,";\n");
    trim(aux);

    int ano;
    try{
        ano = stoi(aux);
    } catch (...){
        throw ExcecaoCad("\nDado inválido: "+ aux +".\n");
    }

    string semestre;
    getLineTeste(scan,&semestre,";\n");
    trim(semestre);

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

    return mapPeriodo[codigo];
}