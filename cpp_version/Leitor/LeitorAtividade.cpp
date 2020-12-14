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

Trabalho LeitorAtividade :: criaTrabalho(string nome, ifstream scan){
    string dataString, trash;
    time_t data;

    getline(scan, dataString, ';');
    trim(dataString);
    if(validDate(dataString, DATE_FORMAT_PT_BR_SHORT))
        data = parseDate(dataString, DATE_FORMAT_PT_BR_SHORT);
    else{
        throw invalid_argument("Dado inválido: " + dataString + ".");
    }
    
    getline(scan, trash, ';');
    getline(scan, trash, ';');

    int numAlunos = 0, cargaHoraria = 0;
    string aux;
    
    try{
        getline(scan, aux, ';');
        trim(aux);
        numAlunos = stoi(aux);
    } 
    // catch () {
    //     // throw exception another = exception(e.what());
    // }

    try{
        getline(scan, aux, ';');
        trim(aux);
        cargaHoraria = stoi(aux);
    } 
    // catch () {
    //     // throw exception another = exception(e.what());
    // }
    if(scan.eof)

}

Aula LeitorAtividade :: criaAula(string nome, ifstream scan){

}

Estudo LeitorAtividade :: criaEstudo(string nome, ifstream scan);

Prova LeitorAtividade :: criaProva(string nome, ifstream scan);

vector<Material> LeitorAtividade :: lerMateriais(ifstream scan);

vector<string> LeitorAtividade :: lerConteudos(ifstream scan);