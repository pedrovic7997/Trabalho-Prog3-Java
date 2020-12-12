#include <iostream>
#include <string>

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
};