#include "ControladorDisciplina.h"

void ControladorDisciplina :: ler(ifstream scan){
    LeitorDisciplina leitor = LeitorDisciplina::obterInstancia();
    ControladorDocente cDocente;
    ControladorPeriodo cPeriodo;
    while(!scan.eof()){
        string codigo;
        scan >>codigo;
       
        try{
            Periodo periodo = cPeriodo.busca(codigo);

        }
        catch(...){
            throw ExcecaoRef("Referência inválida: "+codigoDisc+".");
        }
        Disciplina disciplina = leitor.ler(scan, periodo);
        leitor.anexaHash(disciplina);
    }
}

Disciplina ControladorDisciplina::busca(string codigo){
    LeitorDisciplina leitor= LeitorDisciplina::obterInstancia();
    return leitor.busca(codigo);
}

Estudante ControladorDisciplina::busca(Disciplina disciplina, string matricula){
    LeitorDisciplinaEstudante leitor = LeitorDisciplinaEstudante::obterInstancia();
    return leitor.busca(disciplina,matricula);
}

bool ControladorDisciplina::verificaMatriculaEstudante(Disciplina disciplina, string matricula){
    // return busca(disciplina,matricula) != NULL;
}

vector<Disciplina> ControladorDisciplina::busca(Docente docente){

}

void ControladorDisciplina::lerMatricula(ifstream scan){

}