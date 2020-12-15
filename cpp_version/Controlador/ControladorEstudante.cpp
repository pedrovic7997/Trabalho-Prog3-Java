#include "ControladorEstudante.h"

Estudante* ControladorEstudante :: busca(string codigo){
    LeitorEstudante* leitor= LeitorEstudante :: obterInstancia();
    return leitor->busca(codigo);
}

void ControladorEstudante :: ler(ifstream* scan){
    LeitorEstudante* leitor = LeitorEstudante::obterInstancia();
    while(!scan->eof()){
        Estudante* estudante = leitor->ler(scan);
        leitor->anexaHash(estudante);
    }
}

vector<Estudante*> ControladorEstudante :: lista(){
    LeitorEstudante* leitor = LeitorEstudante::obterInstancia();
    return leitor->obterEstudantes();
}