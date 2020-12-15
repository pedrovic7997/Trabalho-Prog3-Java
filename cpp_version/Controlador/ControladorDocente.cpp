#include "ControladorDocente.h"

Docente* ControladorDocente :: busca(string codigo){
    LeitorDocente* leitor= LeitorDocente :: obterInstancia();
    return leitor->busca(codigo);
}

void ControladorDocente :: ler(ifstream* scan){
    LeitorDocente *leitor = LeitorDocente::obterInstancia();
    while(scan->eof()){
        Docente* docente = leitor->ler(scan);
        leitor->anexaHash(docente);
    }
}

vector<Docente*> ControladorDocente :: lista(){
    LeitorDocente *leitor = LeitorDocente::obterInstancia();
    return leitor->obterDocentes();
}