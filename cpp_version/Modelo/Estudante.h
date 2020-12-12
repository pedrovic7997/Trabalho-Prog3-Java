#include <iostream>
#include <string>

using namespace std;

class Estudante {
    string matricula;
    string nome;

    public: 
        Estudante (string matricula, string nome);

        string obterMatricula();
        string obterNome();
};