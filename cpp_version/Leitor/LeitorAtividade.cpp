#include "LeitorAtividade.h"

Atividade LeitorAtividade :: busca(int posicao, vector<Atividade> atividades){
    if(atividades.size() >= posicao && posicao >= 0){
        return atividades.at(posicao);
    }
}

Atividade LeitorAtividade :: ler(ifstream* scan){
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

Trabalho LeitorAtividade :: criaTrabalho(string nome, ifstream* scan){
    string dataString, trash;
    time_t data;

    getline(scan, dataString, ';');
    trim(dataString);
    if(validDate(dataString, DATE_FORMAT_PT_BR_SHORT))
        data = parseDate(dataString, DATE_FORMAT_PT_BR_SHORT);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }
    
    getline(scan, trash, ';');
    getline(scan, trash, ';');

    int numAlunos = 0, cargaHoraria = 0;
    string aux;
    
    getline(scan, aux, ';');
    trim(aux);
    try{
        numAlunos = stoi(aux);
    } 
    catch (...) {
        throw ExcecaoDado("Dado inválido: " + aux + ".");
    }

    getline(scan, aux, ';');
    trim(aux);
    try{
        cargaHoraria = stoi(aux);
    } 
    catch (...) {
        throw ExcecaoDado("Dado inválido: " + aux + ".");
    }

    if(!scan->eof())
        getline(scan, trash, '\n');
    
    return new Trabalho(nome, false, data, numAlunos, cargaHoraria);
}

Aula LeitorAtividade :: criaAula(string nome, ifstream* scan){
    string dataString, aux, trash;
    time_t data;

    getline(scan, dataString, ';');
    trim(dataString);
    
    getline(scan, aux, ';');
    trim(aux);
    dataString += ';' + aux;

    if(validDate(dataString, DATE_FORMAT_PT_BR))
        data = parseDate(dataString, DATE_FORMAT_PT_BR);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }

    if(!scan->eof())
        getline(scan, trash, '\n');

    return new Aula(nome, true, data);
}

Estudo LeitorAtividade :: criaEstudo(string nome, ifstream* scan){
    string trash;
    
    getline(scan, trash, ';');
    getline(scan, trash, ';');

    vector<Material> materiais = 
}

Prova LeitorAtividade :: criaProva(string nome, ifstream* scan);

vector<Material> LeitorAtividade :: lerMateriais(ifstream* scan){
    string nome, url;
    string materialString;

    getline(scan, materialString);

    string 
}

vector<string> LeitorAtividade :: lerConteudos(ifstream* scan);