#include "Aula.h"

Aula :: Aula (string nome, bool sincrona, time_t data) : Atividade (nome, sincrona){
    this->data = data;
}

bool Aula :: ehAvaliativa(){
    return false;
}