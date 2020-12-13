#ifndef CONTROLADOR_ESTUDANTE
#define CONTROLADOR_ESTUDANTE

#include "../Incluidor.h"

using namespace std;

class CotroladorEstudante{
    public:

    void ler(ifstream scan);

    Estudante busca(string codigo);
};
#endif