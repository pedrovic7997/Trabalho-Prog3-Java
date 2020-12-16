#include "ControladorDisciplina.h"

void ControladorDisciplina :: ler(ifstream* scan){
    LeitorDisciplina* leitor = LeitorDisciplina::obterInstancia();
    ControladorDocente cDocente;
    ControladorPeriodo cPeriodo;

    string linha;
    getline(*scan, linha);
    while (getline(*scan, linha)) {
        Tokenizer tok(linha, ';');
        vector<string> vec = tok.remaining();
        for (int i = 0; i < vec.size(); i++){
            vec[i] = trim(vec[i]);
        }
        string codigo = vec[0];
        Periodo* periodo;
        periodo = cPeriodo.busca(codigo);
        if(periodo == NULL){
            throw ExcecaoRef("Referência inválida: "+codigo+".");
        }
        Disciplina *disciplina = leitor->ler(vec, periodo);
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

    string linha;
    getline(*scan, linha);
    while (getline(*scan, linha)) {
        Tokenizer tok(linha, ';');
        vector<string> vec = tok.remaining();
        for (int i = 0; i < vec.size(); i++){
            vec[i] = trim(vec[i]);
        }
        string codigo = vec[0];
        Disciplina* disciplina;
        disciplina = busca(codigo);
        if(disciplina == NULL){
            throw ExcecaoRef("Referência inválida: "+codigo+".");
        }
        string matricula = vec[1];
        Estudante* estudante;
        estudante = cEstudante.busca(matricula);

        if(estudante == NULL){
            throw ExcecaoRef("Referência inválida: "+matricula+".");
        }
        if(verificaMatriculaEstudante(disciplina, estudante->obterMatricula()))
            throw ExcecaoMat("Matrícula repetida: "+estudante->obterMatricula()+
                        " em "+disciplina->obterCodigo()+"-"+disciplina->obterPeriodo()->obterCodigo()+
                        ".");
        lDisciplinaEstudante->adiciona(disciplina, estudante);
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