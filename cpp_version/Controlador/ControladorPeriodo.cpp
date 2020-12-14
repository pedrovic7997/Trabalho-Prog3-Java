#include "ControladorPeriodo.h"

Periodo* ControladorPeriodo :: busca(string codigo){
    LeitorPeriodo *leitor= LeitorPeriodo :: obterInstancia();
    return leitor->busca(codigo);
}

vector<Periodo*> ControladorPeriodo :: lista(){
    LeitorPeriodo *leitor= LeitorPeriodo :: obterInstancia();
    return leitor->obterPeriodos();
}

void ler(ifstream* scan){
    LeitorPeriodo* leitor = LeitorPeriodo::obterInstancia();
    while(scan->eof()){
        Periodo* periodo = leitor->ler(scan);
        leitor->anexaHash(periodo);
    }
}
