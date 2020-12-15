#ifndef TRABALHO_H
#define TRABALHO_H

#include "Atividade.h"

using namespace std;

class Trabalho : public Atividade {
    int numMaxPorGrupo;
    int cargaHoraria;

    public:
        Trabalho (string nome, bool sincrona, time_t prazo, int numMaxPorGrupo, int cargaHoraria);

        bool ehAvaliativa() override;
};

#endif