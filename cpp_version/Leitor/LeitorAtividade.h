#ifndef LEITOR_ATIVIDADE
#define LEITOR_ATIVIDADE
#include <fstream>
#include <string>
#include <vector>

#include "../Modelo/Atividade.h"
#include "../Modelo/Estudo.h"
#include "../Modelo/Trabalho.h"
#include "../Modelo/Aula.h"
#include "../Modelo/Prova.h"
#include "../Modelo/Material.h"

using namespace std;

class LeitorAtividade{
    static LeitorAtividade leitor;
    
    LeitorAtividade();

    Trabalho criaTrabalho(string nome, ofstream scan);

    Aula criaAula(string nome, ofstream scan);

    Estudo criaEstudo(string nome, ofstream scan);

    Prova criaProva(string nome, ofstream scan);

    vector<Material> lerMateriais(ofstream scan);

    vector<string> lerConteudos(ofstream scan);
    
    public:

    Atividade busca(int posicao, vector<Atividade> atividades);

    Atividade ler(ofstream scan);

    static LeitorAtividade obterInstancia();
};
#endif