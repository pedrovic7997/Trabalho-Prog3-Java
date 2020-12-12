#include "Estudo.h"

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