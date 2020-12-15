#include "LeitorEstudante.h"

LeitorEstudante* LeitorEstudante::leitor = NULL;

LeitorEstudante::LeitorEstudante(){}

LeitorEstudante* LeitorEstudante::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorEstudante();
        return leitor;
    }
    else return leitor;
}

vector<Estudante*> LeitorEstudante::obterEstudantes(){
    vector<Estudante*> lista;
    for(map<string,Estudante*>::iterator it = mapEstudante.begin(); it != mapEstudante.end(); ++it){
        lista.push_back(it->second);
    }
    return lista;
}

Estudante* LeitorEstudante::ler(ifstream* scanner){
    string matricula;
    getline(*scanner, matricula, ';');
    trim(matricula);

    regex rgx("[^0-9]");
    smatch match;
    if(regex_search(matricula, match, rgx))
        throw ExcecaoDado("Dado inválido: "+matricula+".");

    if(busca(matricula) != NULL)
        throw ExcecaoCad("Cadastro repetido: "+matricula+".");
    
    string aux;
    getline(*scanner, aux, ';');
    trim(aux);

    regex rgx2(" +");
    string nome = regex_replace(aux, rgx2, " ");

    string trash;
    if(!scanner->eof())
        getline(*scanner, trash, '\n');

    return new Estudante(matricula, nome);
}

void LeitorEstudante::anexaHash(Estudante* estudante){
    mapEstudante[estudante->obterMatricula()] = estudante;
}

Estudante* LeitorEstudante::busca(string matricula){
    bool contains = false;
    for(map<string,Estudante*>::iterator it = mapEstudante.begin(); it != mapEstudante.end(); ++it){
        if(it->first == matricula){
            contains = true;
        }
    }
    if(contains){
        return mapEstudante[matricula];
    }
    return NULL;
}