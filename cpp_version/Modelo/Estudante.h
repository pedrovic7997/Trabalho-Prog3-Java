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

        int contaDiciplina();
        double mediaDiciplinasPorPeriodo();
        int contaAvaliacoes();
        double mediaAvaliacoes();
        double mediaNotas();

        friend ostream& operator<<(ostream& os, Estudante &estudante);
};

#endif