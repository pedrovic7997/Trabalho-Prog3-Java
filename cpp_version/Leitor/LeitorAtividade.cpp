#include "LeitorAtividade.h"

Atividade LeitorAtividade :: busca(int posicao, vector<Atividade> atividades){
    if(atividades.size() >= posicao && posicao >= 0){
        return atividades.at(posicao);
    }
}

Atividade LeitorAtividade :: ler(ifstream scan){
    string nome, tipo;
    
    getline(scan, nome, ';');
    trim(nome);

    getline(scan, tipo, ';');
    trim(tipo);

    if(tipo == "a" || tipo == "A")
        return criaAula(nome, scan);
    if(tipo == "t" || tipo == "T")
        return criaTrabalho(nome, scan);
    if(tipo == "p" || tipo == "P")
        return criaProva(nome, scan);
    if(tipo == "e" || tipo == "E")
        return criaEstudo(nome, scan);

}

Trabalho criaTrabalho(string nome, ifstream scan){
    string dataString;

    getline(scan, dataString, ';');
    trim(dataString);
}

Aula criaAula(string nome, ifstream scan);

Estudo criaEstudo(string nome, ifstream scan);

Prova criaProva(string nome, ifstream scan);

vector<Material> lerMateriais(ifstream scan);

vector<string> lerConteudos(ifstream scan);