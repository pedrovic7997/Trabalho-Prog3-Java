#ifndef AVALIACAO_H
#define AVALIACAO_H

// #include "../Incluidor.h"
#include <iostream>

#include "Estudante.h"

class Atividade;

using namespace std;

class Avaliacao {
    Estudante *aluno;
    double nota;

    public:
        Avaliacao (Estudante* aluno, double nota);
        ~Avaliacao();

        Estudante* obterAluno();
        double obterNota();

        friend ostream& operator<<(ostream& os, Avaliacao &avaliacao); 
};

#endif