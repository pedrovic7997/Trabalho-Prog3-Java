#ifndef LEITOR_DISCIPLINAESTUDANTE
#define LEITOR_DISCIPLINAESTUDANTE

#include "../Incluidor.h"

using namespace std;

class LeitorDisciplinaEstudante{
    map<string,vector<Estudante*>> mapDisciplina;
    map<string,vector<Disciplina*>> mapEstudante;
    static LeitorDisciplinaEstudante* leitor;
    
    LeitorDisciplinaEstudante();

    public:

    static LeitorDisciplinaEstudante* obterInstancia();

    void adiciona(Disciplina* disciplina, Estudante* estdante);

    Estudante* busca(Disciplina* disciplina,string matricula);

    vector<Estudante*> busca(Disciplina* diciplina);

    vector<Disciplina*> busca(Estudante* estudante);

};
#endif