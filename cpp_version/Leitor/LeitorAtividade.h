#ifndef LEITOR_ATIVIDADE
#define LEITOR_ATIVIDADE

#include "../Incluidor.h"

using namespace std;
using namespace cpp_util;

class LeitorAtividade{
    static LeitorAtividade* leitor;
    
    LeitorAtividade();
    
    public:

    Atividade* busca(int posicao, vector<Atividade*> atividades);

    Atividade* ler(ifstream* scan);

    static LeitorAtividade* obterInstancia();
};

#endif