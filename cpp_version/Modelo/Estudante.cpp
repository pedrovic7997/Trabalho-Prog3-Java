#include "Estudante.h"

Estudante :: Estudante (string matricula, string nome){
    this->matricula = matricula;
    this->nome = nome;
}

string Estudante :: obterMatricula(){
    return matricula;
}

string Estudante :: obterNome(){
    return nome;
}

ostream& operator<<(ostream& os, Estudante &estudante){
    os << estudante.matricula << ";" << estudante.nome;
    return os;
}