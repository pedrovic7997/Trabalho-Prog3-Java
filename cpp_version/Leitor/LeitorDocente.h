#ifndef LEITOR_DOCENTE
#define LEITOR_DOCENTE
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>

#include "../Modelo/Docente.h"

using namespace std;

class LeitorDocente{
    map<string,Docente> mapEstudante;
    static LeitorDocente leitor;
    
    LeitorDocente();

    public:

    static LeitorDocente obterInstancia();

    vector<Docente> obterDocentes();

    Docente busca(string nome);

    Docente ler(ofstream scanner);

    void anexaHash(Docente docente);

    Docente busca(string codigo);

};
#endif