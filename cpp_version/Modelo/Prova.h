#ifndef PROVA_H
#define PROVA_H

#include "Atividade.h"

using namespace std;

class Prova : public Atividade {
    vector<string> conteudo;

    public:
        Prova (string nome, bool sincrona, vector<string> conteudo, time_t data);

        bool ehAvaliativa() override;
};

#endif