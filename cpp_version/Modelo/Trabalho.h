#include <iostream>
#include <string>
#include <vector>
#include "Atividade.h"

using namespace std;

class Trabalho : public Atividade {
    int numMaxPorGrupo;
    int cargaHoraria;

    public:
        Trabalho (string nome, bool sincrona, int numMaxPorGrupo, int cargaHoraria) : 
        Atividade(nome, sincrona){
            this->numMaxPorGrupo = numMaxPorGrupo;
            this->cargaHoraria = cargaHoraria;
        }

        bool ehAvaliativa();
};