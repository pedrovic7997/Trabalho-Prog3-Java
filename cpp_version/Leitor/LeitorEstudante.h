#ifndef LEITOR_ESTUDANTE
#define LEITOR_ESTUDANTE
#include <fstream>
#include <string>
#include <vector>
#include <map>

#include "../Modelo/Estudante.h"

using namespace std;

class LeitorEstudante{
    map<string,Estudante> mapEstudante;

    static LeitorEstudante leitor;
    
    LeitorEstudante();

    public:

    static LeitorEstudante obterInstancia();

    vector<Estudante> obterEstudantes();

    Estudante ler(ofstream scanner);

    void anexaHash(Estudante estudante);

    Estudante busca(string codigo);

};
#endif