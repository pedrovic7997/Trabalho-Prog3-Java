#ifndef PERIODO_H
#define PERIODO_H

#include "../Incluidor.h"

using namespace std;
using namespace cpp_util;

class Periodo {
    int ano;
    char semestre;
    string codigo; 

    public:
        Periodo(int ano, char semestre);

        int obeterAno() const;
        char obterSemestre() const;
        string obterCodigo() const;

        bool comparaPeriodo(const Periodo* esq, const Periodo* dir);

        friend ostream& operator<<(ostream& os, Periodo &periodo); 
};

#endif