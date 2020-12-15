#include "LeitorAtividade.h"

LeitorAtividade* LeitorAtividade::leitor = nullptr;

LeitorAtividade::LeitorAtividade(){}

LeitorAtividade* LeitorAtividade::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorAtividade();
        return leitor;
    }
    else return leitor;
}

Atividade* LeitorAtividade :: busca(int posicao, vector<Atividade*> atividades){
    if(atividades.size() >= posicao && posicao >= 0){
        return atividades.at(posicao);
    }
    return nullptr;
}

vector<string> lerConteudos(ifstream* scan){
    string nome;
    vector<string> lista;

    while(!scan->eof()){
        getline(*scan, nome, '.');
        nome = trim(nome);
        if(!nome.empty())
            lista.push_back(nome);
    }

    return lista;
}

vector<Material> lerMateriais(ifstream* scan){
    string nome, url;
    string materialString;
    vector<Material> lista;

    getline(*scan, materialString);

    regex re("\\[([^\\]]*)\\]\\(([^\\)]*)\\)");
    sregex_iterator next(materialString.begin(), materialString.end(), re);
    sregex_iterator end;
    while (next != end) {
        smatch match = *next;
        nome = match[1].str();
        url = match[2].str();
        Material material = Material(nome, url);
        lista.push_back(material);
        next++;
    }

    return lista;
}

Estudo* criaEstudo(string nome, ifstream* scan){
    string trash;
    
    getline(*scan, trash, ';');
    getline(*scan, trash, ';');

    vector<Material> materiais = lerMateriais(scan);

    if(!scan->eof())
        getline(*scan, trash, '\n');

    return new Estudo(nome, false, materiais);
}


Aula* criaAula(string nome, ifstream* scan){
    string dataString, aux, trash;
    time_t data;

    getline(*scan, dataString, ';');
    dataString = trim(dataString);
    
    getline(*scan, aux, ';');
    aux = trim(aux);
    dataString += ';' + aux;

    if(validDate(dataString, DATE_FORMAT_PT_BR))
        data = parseDate(dataString, DATE_FORMAT_PT_BR);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }

    if(!scan->eof())
        getline(*scan, trash, '\n');

    return new Aula(nome, true, data);
}

Prova* criaProva(string nome, ifstream *scan){
    string dataString, aux, trash;
    time_t data;

    getline(*scan, dataString, ';');
    dataString = trim(dataString);
    
    getline(*scan, aux, ';');
    aux = trim(aux);
    dataString += ';' + aux;

    if(validDate(dataString, DATE_FORMAT_PT_BR))
        data = parseDate(dataString, DATE_FORMAT_PT_BR);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }

    vector<string> conteudos = lerConteudos(scan);

    if(!scan->eof())
        getline(*scan, trash, '\n');

    return new Prova(nome, true, conteudos, data);
}


Trabalho* criaTrabalho(string nome, ifstream* scan){
    string dataString, trash;
    time_t data;

    getline(*scan, dataString, ';');
    dataString = trim(dataString);
    if(validDate(dataString, DATE_FORMAT_PT_BR_SHORT))
        data = parseDate(dataString, DATE_FORMAT_PT_BR_SHORT);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }
    
    getline(*scan, trash, ';');
    getline(*scan, trash, ';');

    int numAlunos = 0, cargaHoraria = 0;
    string aux;
    
    getline(*scan, aux, ';');
    aux = trim(aux);
    try{
        numAlunos = stoi(aux);
    } 
    catch (...) {
        throw ExcecaoDado("Dado inválido: " + aux + ".");
    }

    getline(*scan, aux, ';');
    aux = trim(aux);
    try{
        cargaHoraria = stoi(aux);
    } 
    catch (...) {
        throw ExcecaoDado("Dado inválido: " + aux + ".");
    }

    if(!scan->eof())
        getline(*scan, trash, '\n');
    
    return new Trabalho(nome, false, data, numAlunos, cargaHoraria);
}

Atividade* LeitorAtividade :: ler(ifstream* scan){
    string nome, tipo;
    
    getline(*scan, nome, ';');
    nome = trim(nome);

    getline(*scan, tipo, ';');
    tipo = trim(tipo);

    if(tipo == "a" || tipo == "A")
        return criaAula(nome, scan);
    if(tipo == "t" || tipo == "T")
        return criaTrabalho(nome, scan);
    if(tipo == "p" || tipo == "P")
        return criaProva(nome, scan);
    if(tipo == "e" || tipo == "E")
        return criaEstudo(nome, scan);
    throw ExcecaoDado("Dado inválido: "+tipo);
    return nullptr;
}

