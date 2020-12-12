#ifndef LEITOR_DISCIPLINA
#define LEITOR_DISCIPLINA
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>

#include "../Modelo/Disciplina.h"
#include "../Modelo/Docente.h"
#include "../Modelo/Periodo.h"

using namespace std;

class LeitorDisciplina{
    map<string,Disciplina> mapa;
    static LeitorDisciplina leitor;

    LeitorDisciplina();

    public:

    static LeitorDisciplina obterInstancia();

    vector<Disciplina> busca(Periodo periodo);

    vector<Disciplina> busca(Docente docente);

    Disciplina busca(string codigo);

    Disciplina ler(ofstream scan,Periodo periodo);

    void anexaHash(Disciplina disciplina);

    vector<Disciplina> retornaDisciplinas();

};
#endif