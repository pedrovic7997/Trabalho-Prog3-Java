#ifndef EXCECOES_H
#define EXCECOES_H

#include <iostream>
#include <string>

#include "Excecao.h"

using namespace std;

class ExcecaoDado : public Excecao {
public:
    ExcecaoDado(const string& motivo): Excecao(motivo) {};
};

class ExcecaoRef : public Excecao {
public:
    ExcecaoRef(const string& motivo): Excecao(motivo) {};
};

class ExcecaoCad : public Excecao {
public:
    ExcecaoCad(const string& motivo): Excecao(motivo) {};
};

class ExcecaoMat : public Excecao {
public:
    ExcecaoMat(const string& motivo): Excecao(motivo) {};
};

class ExcecaoAval : public Excecao {
public:
    ExcecaoAval(const string& motivo): Excecao(motivo) {};
};

class ExcecaoIO : public Excecao {
public:
    ExcecaoIO(const string& motivo): Excecao(motivo) {};
};

#endif