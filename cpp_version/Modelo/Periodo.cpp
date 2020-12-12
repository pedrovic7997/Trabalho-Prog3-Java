#include "Periodo.h"

Periodo :: Periodo(int ano, char semestre){
    this->ano = ano;
    this->semestre = semestre;
    this->codigo = ano + "/" + semestre;
}

int Periodo :: obeterAno() const{
    return ano;
}

char Periodo :: obterSemestre() const{
    return semestre;
}

string Periodo :: obterCodigo() const{
    return codigo;
}

ostream& operator<<(ostream& os, Periodo &periodo){
    os << "Periodo: " << periodo.codigo << endl;
    return os;
}

