#include "Avaliacao.h"

Avaliacao :: Avaliacao (Estudante aluno, double nota){
    this->aluno = new Estudante(aluno.obterMatricula(), aluno.obterNome());
    this->nota = nota;
}

Avaliacao :: ~Avaliacao(){
    delete this->aluno;
}

Estudante* Avaliacao :: obterAluno(){
    return aluno;
}

double Avaliacao :: obterNota(){
    return nota;
}