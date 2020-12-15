#ifndef ESTUDANTE_H
#define ESTUDANTE_H

// #include "../Incluidor.h"
#include "Avaliacao.h"

using namespace std;
using namespace cpp_util;

class Estudante {
    string matricula;
    string nome;

    public: 
        Estudante (string matricula, string nome);

        string obterMatricula() const;
        string obterNome() const;

        int contaDiciplina();
        double mediaDiciplinasPorPeriodo();
        int contaAvaliacoes();
        double mediaAvaliacoes();
        double mediaNotas();

        bool compara(Estudante* esq, Estudante* dir);

        friend ostream& operator<<(ostream& os, Estudante &estudante);
};

#endif