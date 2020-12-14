#ifndef LEITOR_DISCIPLINA
#define LEITOR_DISCIPLINA

#include "../Incluidor.h"

using namespace std;

class LeitorDisciplina{
    map<string,Disciplina*> mapa;
    static LeitorDisciplina* leitor;

    LeitorDisciplina();

    public:

    static LeitorDisciplina* obterInstancia();

    vector<Disciplina*> busca(Periodo* periodo);

    vector<Disciplina*> busca(Docente* docente);

    Disciplina* busca(string codigo);

    Disciplina* ler(ifstream* scan,Periodo periodo);

    void anexaHash(Disciplina* disciplina);

    vector<Disciplina*> obterDisciplinas();

};
#endif