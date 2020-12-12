#include <iostream>
#include <string>
#include "Estudante.h"

using namespace std;

class Avaliacao {
    Estudante *aluno;
    double nota;

    public:
        Avaliacao (Estudante aluno, double nota);
        ~Avaliacao();

        Estudante* obterAluno();
        double obterNota();
};