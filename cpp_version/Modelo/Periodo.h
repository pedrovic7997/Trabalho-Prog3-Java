#ifndef PERIODO_H
#define PERIODO_H

#include "../Incluidor.h"

using namespace std;

class Periodo {
    int ano;
    char semestre;
    string codigo; 

    public:
        Periodo(int ano, char semestre);

        int obeterAno() const;
        char obterSemestre() const;
        string obterCodigo() const;

        friend ostream& operator<<(ostream& os, Periodo &periodo); 
};

#endif