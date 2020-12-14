#ifndef CONTROLADOR_DSICIPLINA
#define CONTROLADOR_DSICIPLINA

#include "../Incluidor.h"

using namespace std;

class ControladorDisciplina{
    public:

    void ler(ifstream* scan);

    Disciplina* busca(string codigo);

    Estudante* busca(Disciplina* disciplina, string matricula);

    bool verificaMatriculaEstudante(Disciplina* disciplina, string* matricula);

    vector<Disciplina*> busca(Docente* docente);

    void lerMatricula(ifstream* scan);
};
#endif