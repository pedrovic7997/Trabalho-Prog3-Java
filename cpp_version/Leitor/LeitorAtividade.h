#ifndef LEITOR_ATIVIDADE
#define LEITOR_ATIVIDADE

#include "../Incluidor.h"

using namespace std;
using namespace cpp_util;

class LeitorAtividade{
    static LeitorAtividade* leitor;
    
    LeitorAtividade();

    Trabalho* criaTrabalho(string nome, ifstream* scan);

    Aula* criaAula(string nome, ifstream* scan);

    Estudo* criaEstudo(string nome, ifstream* scan);

    Prova* criaProva(string nome, ifstream* scan);

    vector<Material*> lerMateriais(ifstream* scan);

    vector<string> lerConteudos(ifstream* scan);
    
    public:

    Atividade* busca(int posicao, vector<Atividade*> atividades);

    Atividade* ler(ifstream* scan);

    static LeitorAtividade* obterInstancia();
};

LeitorAtividade :: leitor = NULL;
#endif