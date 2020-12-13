#include "Prova.h"

Prova :: Prova (string nome, bool sincrona, vector<string> conteudo, time_t data) : Atividade (nome, sincrona){
    this->conteudo = conteudo;
    this->data = data;
}

bool Prova :: ehAvaliativa(){
    return true;
}