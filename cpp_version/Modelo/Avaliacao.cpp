#include "Avaliacao.h"

Avaliacao :: Avaliacao (Estudante* aluno, double nota){
    this->aluno = new Estudante(aluno->obterMatricula(), aluno->obterNome());
    this->nota = nota;
}

Avaliacao :: ~Avaliacao(){
    delete aluno;
}

Estudante* Avaliacao :: obterAluno(){
    return aluno;
}

double Avaliacao :: obterNota(){
    return nota;
}

ostream& operator<< (ostream& os, Avaliacao &avaliacao){
    os << "Aluno: " << avaliacao.aluno->obterMatricula() << " - Nota: " << avaliacao.nota << endl;
    return os;
}