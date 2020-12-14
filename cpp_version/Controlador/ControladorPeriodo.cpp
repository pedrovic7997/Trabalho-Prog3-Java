#include "ControladorPeriodo.h"

Periodo ControladorPeriodo :: busca(string codigo){
    LeitorPeriodo leitor= LeitorPeriodo :: obterInstancia();
    return leitor.busca(codigo);
}

void ler(ifstream* scan){
    LeitorPeriodo leitor = LeitorPeriodo::obterInstancia();
    while(scan->eof()){
        Periodo periodo = leitor.ler(scan);
        leitor.anexaHash(periodo);
    }
}