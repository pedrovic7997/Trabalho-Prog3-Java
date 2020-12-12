#ifndef PROVA_H
#define PROVA_H

#include "../Incluidor.h"

using namespace std;

class Prova : public Atividade {
    vector<string> conteudo;

    public:
        Prova (string nome, bool sincrona, vector<string> conteudo) : 
        Atividade(nome, sincrona){
            this->conteudo = conteudo;
        }

        bool ehAvaliativa();
};

#endif