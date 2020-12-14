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

    Periodo* ler(ifstream* scanner);

    void anexaHash(Periodo periodo);

    Periodo* busca(string codigo);

    vector<Periodo*> busca(Docente* docente);

};
#endif