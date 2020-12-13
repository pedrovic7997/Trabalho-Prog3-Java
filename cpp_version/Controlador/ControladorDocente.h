#ifndef CONTROLADOR_DOCENTE
#define CONTROLADOR_DOCENTE

#include "../Incluidor.h"

using namespace std;

class CotroladorDocente{
    public:

    void ler(ifstream scan);

    Docente busca(string codigo);
};
#endif