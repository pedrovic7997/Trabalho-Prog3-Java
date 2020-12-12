#ifndef AULA_H
#define AULA_H

#include "../Incluidor.h"

using namespace std;

class Aula : public Atividade {

    public:
        Aula (string nome, bool sincrona, time_t data);

        bool ehAvaliativa();
};

#endif