#include "ControladorEstudante.h"

Estudante* ControladorEstudante :: busca(string codigo){
    LeitorEstudante* leitor= LeitorEstudante :: obterInstancia();
    return leitor->busca(codigo);
}

void ControladorEstudante :: ler(ifstream* scan){
    LeitorEstudante* leitor = LeitorEstudante::obterInstancia();
    
    string linha;
    getline(*scan, linha);
    while (getline(*scan, linha)) {
        Tokenizer tok(linha, ';');
        vector<string> vec = tok.remaining();
        for (int i = 0; i < vec.size(); i++){
            vec[i] = trim(vec[i]);
        }
        Estudante* estudante = leitor->ler(vec);
        leitor->anexaHash(estudante);
    }
}

vector<Estudante*> ControladorEstudante :: lista(){
    LeitorEstudante* leitor = LeitorEstudante::obterInstancia();
    return leitor->obterEstudantes();
}