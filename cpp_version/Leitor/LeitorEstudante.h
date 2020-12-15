#ifndef LEITOR_ESTUDANTE
#define LEITOR_ESTUDANTE

#include "../Incluidor.h"

using namespace std;

class LeitorEstudante{
    map<string,Estudante*> mapEstudante;

    static LeitorEstudante* leitor;
    
    LeitorEstudante();

    public:

    static LeitorEstudante* obterInstancia();

    vector<Estudante*> obterEstudantes();

    Estudante* ler(ifstream* scanner);

    void anexaHash(Estudante* estudante);

    Estudante* busca(string matricula);

};
#endif