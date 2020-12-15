#include "ControladorDisciplina.h"

void ControladorDisciplina :: ler(ifstream* scan){
    LeitorDisciplina* leitor = LeitorDisciplina::obterInstancia();
    ControladorDocente cDocente;
    ControladorPeriodo cPeriodo;
    while(!scan->eof()){
        string codigo;
        getLineTeste(scan,&codigo,";\n");
        codigo = trim(codigo);
        Periodo* periodo;
        periodo = cPeriodo.busca(codigo);
        if(periodo == NULL)
            throw ExcecaoRef("Referência inválida: "+codigo+".");
        Disciplina *disciplina = leitor->ler(scan, periodo);
        leitor->anexaHash(disciplina);
    }
}

Disciplina* ControladorDisciplina::busca(string codigo){
    LeitorDisciplina* leitor= LeitorDisciplina::obterInstancia();
    return leitor->busca(codigo);
}

Estudante *ControladorDisciplina :: busca(Disciplina *disciplina, string matricula){
    LeitorDisciplinaEstudante* leitor = LeitorDisciplinaEstudante::obterInstancia();
    return leitor->busca(disciplina,matricula);
}

bool ControladorDisciplina :: verificaMatriculaEstudante(Disciplina* disciplina, string matricula){
    return busca(disciplina,matricula) != NULL;
}

vector<Disciplina*> ControladorDisciplina :: busca(Docente* docente){
    LeitorDisciplina* leitor= LeitorDisciplina::obterInstancia();
    return leitor->busca(docente);
}

void ControladorDisciplina :: lerMatricula(ifstream* scan){
    ControladorEstudante cEstudante;
    LeitorDisciplinaEstudante *lDisciplinaEstudante = LeitorDisciplinaEstudante::obterInstancia();
    while(!scan->eof()){
        string codigo;
        getLineTeste(scan,&codigo,";\n");
        codigo = trim(codigo);
        Disciplina* disciplina;
        disciplina= busca(codigo);
        if(disciplina == NULL)
            throw ExcecaoRef("Referência inválida: "+codigo+".");
        string matricula;
        *scan >>matricula;
        Estudante* estudante;
        estudante = cEstudante.busca(matricula);
        if(estudante == NULL)
            throw ExcecaoRef("Referência inválida: "+matricula+".");
        if(verificaMatriculaEstudante(disciplina, estudante->obterMatricula()))
            throw ExcecaoMat("Matrícula repetida: "+estudante->obterMatricula()+
                        " em "+disciplina->obterCodigo()+"-"+disciplina->obterPeriodo()->obterCodigo()+
                        ".");
        lDisciplinaEstudante->adiciona(disciplina, estudante);
        // if(scan->haseof())
        //     scan->nextLine();
    }

}

vector<Disciplina*> ControladorDisciplina :: lista(Periodo* periodo){
    LeitorDisciplina* leitor= LeitorDisciplina::obterInstancia();
    return leitor->busca(periodo);
}

vector<Disciplina*> ControladorDisciplina :: lista(){
    LeitorDisciplina* leitor= LeitorDisciplina::obterInstancia();
    return leitor->obterDisciplinas();
}

vector<Estudante*> ControladorDisciplina :: lista(Disciplina* disciplina){
    LeitorDisciplinaEstudante *lDisciplinaEstudante = LeitorDisciplinaEstudante::obterInstancia();
    return lDisciplinaEstudante->busca(disciplina);
}