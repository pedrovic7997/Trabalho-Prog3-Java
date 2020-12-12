#ifndef LEITOR_ATIVIDADE
#define LEITOR_ATIVIDADE
#include <fstream>
#include <string>
#include <vector>

#include "../Modelo/Atividade.h"

using namespace std;

class LeitorAtividade{
    static LeitorAtividade leitor;
    
    LeitorAtividade();

    Trabalho criaTrabalho(String nome, ofstream scan);

    Aula criaAula(String nome, ofstream scan);

    Estudo criaEstudo(String nome, ofstream scan);

    Prova criaProva(String nome, ofstream scan);

    vector<Material> lerMateriais(ofstream scan);

    vector<String> lerConteudos(ofstream scan);
    
    public:

    Atividade busca(int posicao, List<Atividade> atividades);

    Atividade ler(ofstream scan);

    static LeitorAtividade obterInstancia();
};
#endif