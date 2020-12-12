#ifndef LEITOR_DISCIPLINAESTUDANTE
#define LEITOR_DISCIPLINAESTUDANTE
#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>

#include "../Modelo/Docente.h"
#include "../Modelo/Estudante.h"

using namespace std;

class LeitorDisciplinaEstudante{
    map<string,vector<Estudante>> mapDisciplina;
    map<string,vector<Disciplina>> mapEstudante;
    static LeitorDisciplinaEstudante leitor;
    
    LeitorDisciplinaEstudante();

    public:

    static LeitorDisciplinaEstudante obterInstancia();

    void adiciona(Disciplina disciplina, Esudante estdante);

    Estudante busca(Disciplina disciplina,string matricula);

    vector<Estudante> busca(Diciplina diciplina);

    vector<Disciplina> busca(string codigo);

};
#endif