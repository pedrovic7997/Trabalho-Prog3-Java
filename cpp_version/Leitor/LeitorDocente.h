#ifndef LEITOR_DOCENTE
#define LEITOR_DOCENTE

#include "../Incluidor.h"

using namespace std;

class LeitorDocente{
    map<string,Docente*> mapDocente;
    static LeitorDocente* leitor;
    
    LeitorDocente();

    public:

    static LeitorDocente* obterInstancia();

    vector<Docente*> obterDocentes();

    Docente* ler(vector<string> vec);

    void anexaHash(Docente* docente);

    Docente* busca(string login);

    vector<Periodo*> busca(Docente* docente);

};
#endif