#ifndef LEITOR_AVALIACAO
#define LEITOR_AVALIACAO
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

#include "../Modelo/Avaliacao.h"

using namespace std;

class LeitorAvaliacao{
    static LeitorAvaliacao leitor;

    LeitorAvaliacao();

    public:

    static LeitorAvaliacao obterInstancia();

    vector<Avaliacao> busca(vector<Avaliacao> avaliacoes, Estudante estudante);

    Avaliacao ler(ofstream scan,Estudante aluno);  
};
#endif