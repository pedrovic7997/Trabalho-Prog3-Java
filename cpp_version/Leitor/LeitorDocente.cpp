#include "LeitorDocente.h"

LeitorDocente* LeitorDocente::leitor = NULL;

LeitorDocente* LeitorDocente::obterInstancia(){
    if (leitor == NULL){
        leitor = new LeitorDocente();
        return leitor;
    }
    else return leitor;
}