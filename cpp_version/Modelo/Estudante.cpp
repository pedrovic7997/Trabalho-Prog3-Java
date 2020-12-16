#include "Estudante.h"

Estudante :: Estudante (string matricula, string nome){
    this->matricula = matricula;
    this->nome = nome;
}

string Estudante :: obterMatricula() const{
    return matricula;
}

string Estudante :: obterNome() const{
    return nome;
}

int Estudante :: contaDiciplina(){
    LeitorDisciplinaEstudante* lDisciplinas = LeitorDisciplinaEstudante :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    return disciplinas.size();
}

double Estudante :: mediaDiciplinasPorPeriodo(){
    LeitorDisciplinaEstudante* lDisciplinas = LeitorDisciplinaEstudante :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    if(disciplinas.size() == 0) return 0;

    double cont=1;
    Periodo *ant = disciplinas.at(0)->obterPeriodo();
    Periodo *atu;
    for(Disciplina* d : disciplinas){
        atu = d->obterPeriodo();
        if(ant->obterCodigo().compare(atu->obterCodigo()) != 0){
            cont++;
        }
        ant = atu;
    }

    return disciplinas.size()/cont;
}

int Estudante :: contaAvaliacoes() {
    LeitorDisciplinaEstudante* lDisciplinas = LeitorDisciplinaEstudante :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    if(disciplinas.size() == 0) return 0;

    int cont=0;
    vector<Avaliacao*> avaliacoes;
    for(Disciplina* d : disciplinas){
        for(Atividade* a : d->obterAtividades()){
            for(Avaliacao* av : a->obterAvaliacoes()){
                avaliacoes.push_back(av);
            }
        }
    }

    LeitorAvaliacao* lAvaliacoes = LeitorAvaliacao :: obterInstancia();
    avaliacoes = lAvaliacoes->busca(avaliacoes, this);

    return avaliacoes.size();
}

double Estudante :: mediaAvaliacoes(){
    double cont = this->contaAvaliacoes();

    LeitorDisciplinaEstudante* lDisciplinas = LeitorDisciplinaEstudante :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    if(disciplinas.size() == 0) return 0;

    return cont/disciplinas.size();
}

double Estudante :: mediaNotas(){
    LeitorDisciplinaEstudante* lDisciplinas = LeitorDisciplinaEstudante :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    if(disciplinas.size() == 0)return 0;

    int cont=0;
    vector<Avaliacao*> avaliacoes;
    for(Disciplina* d : disciplinas){
        for(Atividade* a : d->obterAtividades()){
            for(Avaliacao* av : a->obterAvaliacoes()){
                avaliacoes.push_back(av);
            }
        }
    }

    LeitorAvaliacao* lAvaliacoes = LeitorAvaliacao :: obterInstancia();
    avaliacoes = lAvaliacoes->busca(avaliacoes, this);

    if(avaliacoes.size() == 0) return 0;

    double notas=0;
    for(Avaliacao* a : avaliacoes){
        notas += a->obterNota();
    }
    return notas/avaliacoes.size();
}

bool Estudante :: compara(Estudante* esq, Estudante* dir){
    if(esq->contaAvaliacoes() > dir->contaAvaliacoes())
        return true;
    if(esq->contaAvaliacoes() < dir->contaAvaliacoes())
        return false;

    return stringCompare(esq->obterNome(), dir->obterNome());
}

ostream& operator<<(ostream& os, Estudante &estudante){
    os << estudante.matricula << ";" << estudante.nome << endl;
    return os;
}