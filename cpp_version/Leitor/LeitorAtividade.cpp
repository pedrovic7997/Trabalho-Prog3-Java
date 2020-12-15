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

vector<string> lerConteudos(string conteudos){
    string nome;
    vector<string> lista;

    Tokenizer* tok = new Tokenizer(conteudos, '.');

    return tok->remaining();
}

vector<Material> lerMateriais(vector<string> vec){
    string nome, url;
    string materialString = vec[5];
    vector<Material> lista;

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

Estudo* criaEstudo(string nome, vector<string> vec){
    vector<Material> materiais = lerMateriais(vec);

    return new Estudo(nome, false, materiais);
}


Aula* criaAula(string nome, vector<string> vec){
    string dataString, aux, trash;
    time_t data;

    dataString = vec[3] + ";" + vec[4];
    
    if(validDate(dataString, DATE_FORMAT_PT_BR))
        data = parseDate(dataString, DATE_FORMAT_PT_BR);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }

    return new Aula(nome, true, data);
}

Prova* criaProva(string nome, vector<string> vec){
    string dataString, aux, trash;
    time_t data;

    dataString = vec[3] + ";" + vec[4];
    
    if(validDate(dataString, DATE_FORMAT_PT_BR))
        data = parseDate(dataString, DATE_FORMAT_PT_BR);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }

    vector<string> conteudos = lerConteudos(vec[5]);

    return new Prova(nome, true, conteudos, data);
}


Trabalho* criaTrabalho(string nome, vector<string> vec){
    string dataString, trash;
    time_t data;

    
    dataString = vec[3];
    if(validDate(dataString, DATE_FORMAT_PT_BR_SHORT))
        data = parseDate(dataString, DATE_FORMAT_PT_BR_SHORT);
    else{
        throw ExcecaoDado("Dado inválido: " + dataString + ".");
    }
    
    int numAlunos = 0, cargaHoraria = 0;
    
    try{
        numAlunos = stoi(vec[6]);
    } 
    catch (...) {
        throw ExcecaoDado("Dado inválido: " + vec[6] + ".");
    }

    try{
        cargaHoraria = stoi(vec[7]);
    } 
    catch (...) {
        throw ExcecaoDado("Dado inválido: " + vec[7] + ".");
    }
    
    return new Trabalho(nome, false, data, numAlunos, cargaHoraria);
}

Atividade* LeitorAtividade :: ler(vector<string> vec){
    string nome, tipo;
    
    nome = vec[1];
    tipo = vec[2];

    if(tipo == "a" || tipo == "A")
        return criaAula(nome, vec);
    if(tipo == "t" || tipo == "T")
        return criaTrabalho(nome, vec);
    if(tipo == "p" || tipo == "P")
        return criaProva(nome, vec);
    if(tipo == "e" || tipo == "E")
        return criaEstudo(nome, vec);
    throw ExcecaoDado("Dado inválido: "+tipo);
    return nullptr;
}

