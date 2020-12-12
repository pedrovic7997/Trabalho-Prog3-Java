#ifndef LEITOR_PERIODO
#define LEITOR_PERIODO
#include <fstream>
#include <string>
#include <vector>
#include <map>

#include "../Modelo/Periodo.h"
#include "../Modelo/Docente.h"

using namespace std;

class LeitorPeriodo{
    map<string,Periodo> mapPeriodo;
    static LeitorPeriodo leitor;
    
    LeitorPeriodo();

    public:

    static LeitorPeriodo obterInstancia();

    vector<Periodo> obterPeriodos();

    Periodo ler(ofstream scanner);

    void anexaHash(Periodo periodo);

    Periodo busca(string codigo);

    vector<Periodo> busca(Docente docente);

};
#endif