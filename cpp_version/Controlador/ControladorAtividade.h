#ifndef CONTROLADOR_ATIVIDADE
#define CONTROLADOR_ATIVIDADE

#include "../Incluidor.h"

using namespace std;

class CotroladorAtividade{
    bool verificaCadastroAvaliacao(Atividade atividade,Estudante estudante);
    public:

    void ler(ifstream scan);

    void lerAvaliacao(ifstream scan);
};
#endif