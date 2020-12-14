#include "Estudo.h"

Estudo :: Estudo (string nome, bool sincrona, vector<Material> materiais) : Atividade(nome, sincrona){
    this->materiais = materiais;
    this->data = time(NULL);
    
}

bool Estudo :: ehAvaliativa(){
    return true;
}

vector<Material> Estudo :: getMateriais(){
    return materiais;
}

ostream& operator<<(ostream& os, Estudo &estudo){
    os << "Estudo: " << estudo.obterNome() << " - Assincrono - Materiais: " << endl;
    return os;
}