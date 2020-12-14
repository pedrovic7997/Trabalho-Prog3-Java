#ifndef CONTROLADOR_PERIODO
#define CONTROLADOR_PERIODO

#include "../Incluidor.h"

using namespace std;

class ControladorPeriodo{
    public:

    void ler(ifstream* scan);

    Periodo busca(string codigo);
};
#endif