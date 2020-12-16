#include "Material.h"

Material :: Material (string nome, string link){
    this->nome = nome;
    this->link = link;
}

string Material :: obterNome(){
    return nome;
}

string Material :: obterLink(){
    return link;
}

ostream& operator<<(ostream& os, Material &material){
    os << material.nome << ": " << material.link << endl;
    return os;
}