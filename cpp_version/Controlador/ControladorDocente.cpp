#include "ControladorDocente.h"

Docente* ControladorDocente :: busca(string codigo){
    LeitorDocente* leitor= LeitorDocente :: obterInstancia();
    return leitor->busca(codigo);
}

void ControladorDocente :: ler(ifstream* scan){
    LeitorDocente *leitor = LeitorDocente::obterInstancia();
    string linha;
    getline(*scan, linha);
    while (getline(*scan, linha)) {
        Tokenizer tok(linha, ';');
        vector<string> vec = tok.remaining();
        for (int i = 0; i < vec.size(); i++){
            vec[i] = trim(vec[i]);
        }
        Docente* docente = leitor->ler(vec);
        leitor->anexaHash(docente);
    }
}

vector<Docente*> ControladorDocente :: lista(){
    LeitorDocente *leitor = LeitorDocente::obterInstancia();
    return leitor->obterDocentes();
}