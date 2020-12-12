#ifndef ESTUDANTE_H
#define ESTUDANTE_H

#include <iostream>
#include <string>
#include "Periodo.h"
#include "Atividade.h"
#include "Avaliacao.h"
#include "../Leitor/LeitorDisciplinaEstudante.h"
#include "../Leitor/LeitorAvaliacao.h"

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