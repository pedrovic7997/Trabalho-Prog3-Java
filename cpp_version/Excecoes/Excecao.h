#ifndef EXCECAO_H
#define EXCECAO_H

#include <iostream>
#include <string>

using namespace std;

class Excecao {
    
public:
    string motivo;
    Excecao(const string& motivo);

    friend ostream& operator<< (ostream &out, const Excecao& excecao);
};


#endif