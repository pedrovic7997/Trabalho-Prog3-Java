#include "ControladorPeriodo.h"

Periodo* ControladorPeriodo :: busca(string codigo){
    LeitorPeriodo *leitor= LeitorPeriodo :: obterInstancia();
    return leitor->busca(codigo);
}

vector<Periodo*> ControladorPeriodo :: lista(){
    LeitorPeriodo *leitor= LeitorPeriodo :: obterInstancia();
    return leitor->obterPeriodos();
}

void ControladorPeriodo ::ler(ifstream* scan){
    
    LeitorPeriodo* leitor = LeitorPeriodo::obterInstancia();

    string linha;
    getline(*scan, linha);
    while (getline(*scan, linha)) {
        Tokenizer tok(linha, ';');
        vector<string> vec = tok.remaining();
        for (int i = 0; i < vec.size(); i++){
            vec[i] = trim(vec[i]);
        }
        Periodo* periodo = leitor->ler(vec);
        leitor->anexaHash(periodo);
    }
}
