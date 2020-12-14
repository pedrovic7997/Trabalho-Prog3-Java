#ifndef CONTROLADOR_DOCENTE
#define CONTROLADOR_DOCENTE

#include "../Incluidor.h"

using namespace std;

class ControladorDocente{
    public:

    void ler(ifstream* scan);

    Docente* busca(string codigo);
};
#endif