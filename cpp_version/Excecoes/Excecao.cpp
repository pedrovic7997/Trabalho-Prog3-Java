#include "Excecao.h"

Excecao :: Excecao(const string& motivo) { this->motivo=motivo; }

ostream& operator<< (ostream &out, const Excecao& excecao) {
    return out << excecao.motivo;
}