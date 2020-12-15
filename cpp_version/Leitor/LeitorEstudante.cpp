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

Estudante* LeitorEstudante::ler(vector<string> vec){
    string matricula = vec[0];

    regex rgx("[^0-9]");
    smatch match;
    if(regex_search(matricula, match, rgx))
        throw ExcecaoDado("Dado inválido: "+matricula+".");

    if(busca(matricula) != NULL)
        throw ExcecaoCad("Cadastro repetido: "+matricula+".");
    
    string aux = vec[1];

    regex rgx2(" +");
    string nome = regex_replace(aux, rgx2, " ");

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