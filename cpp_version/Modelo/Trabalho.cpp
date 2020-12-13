#include "Trabalho.h"

Trabalho :: Trabalho (string nome, bool sincrona, time_t prazo, int numMaxPorGrupo, int cargaHoraria) : Atividade (nome, sincrona){
    this->data = prazo;
    this->numMaxPorGrupo = numMaxPorGrupo;
    this->cargaHoraria = cargaHoraria;
}

bool Trabalho :: ehAvaliativa(){
    return true;
}