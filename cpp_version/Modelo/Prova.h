#include <iostream>
#include <string>
#include <vector>
#include "Atividade.h"

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