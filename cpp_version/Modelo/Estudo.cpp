#include "Estudo.h"

Estudo :: Estudo (string nome, bool sincrona, vector<Material> materiais, time_t data) : Atividade(nome, sincrona){
    this->materiais = materiais;
    this->data = data;
}

bool Atividade :: ehAvaliativa(){
    return true;
}

vector<Material> Estudo :: getMateriais(){
    return materiais;
}

ostream& operator<<(ostream& os, Estudo &estudo){
    os << "Estudo: " << estudo.obterNome() << " - Assincrono - Materiais: ";
    return os;
}