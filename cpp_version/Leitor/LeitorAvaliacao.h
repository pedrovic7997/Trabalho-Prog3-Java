#ifndef LEITOR_AVALIACAO
#define LEITOR_AVALIACAO

#include "../Incluidor.h"

using namespace std;

class LeitorAvaliacao{
    static LeitorAvaliacao* leitor;

    LeitorAvaliacao(){};

    public:

    static LeitorAvaliacao* obterInstancia();

    vector<Avaliacao*> busca(vector<Avaliacao*> avaliacoes, Estudante* estudante);

    Avaliacao* ler(ifstream* scan,Estudante aluno);  
};
#endif