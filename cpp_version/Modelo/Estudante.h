#ifndef ESTUDANTE_H
#define ESTUDANTE_H

#include <iostream>
#include <string>

using namespace std;

class Estudante {
    string matricula;
    string nome;

    public: 
        Estudante (string matricula, string nome);

        string obterMatricula();
        string obterNome();

        friend ostream& operator<<(ostream& os, Estudante &estudante);
};

#endif