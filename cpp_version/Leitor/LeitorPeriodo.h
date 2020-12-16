#ifndef LEITOR_PERIODO
#define LEITOR_PERIODO

#include "../Incluidor.h"

using namespace std;

class LeitorPeriodo{
    map<string,Periodo*> mapPeriodo;
    static LeitorPeriodo* leitor;
    
    LeitorPeriodo();

    public:

    static LeitorPeriodo* obterInstancia();

    vector<Periodo*> obterPeriodos();

    Periodo* ler(vector<string> vec);

    void anexaHash(Periodo* periodo);

    Periodo* busca(string codigo);

};
#endif