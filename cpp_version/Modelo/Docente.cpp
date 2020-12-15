#include "Docente.h"

Docente :: Docente(string login, string nome, string paginaWeb){
    this->login = login;
    this->nome = nome;
    this->paginaWeb = paginaWeb;
}


Docente :: Docente(string login, string nome){
    this->login = login;
    this->nome = nome;
    // this->paginaWeb = nullptr
    this->paginaWeb = "";
}

string Docente :: obterLogin() const{
    return login;
}

string Docente :: obterNome() const{
    return nome;
}

string Docente :: obterPaginaWeb() const{
    return paginaWeb;
}

int Docente :: contaDisciplinas(){
    LeitorDisciplina* lDisciplinas = LeitorDisciplina :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    return disciplinas.size();
}

int Docente :: contaPeriodos(){
    LeitorDocente* lDocente = LeitorDocente :: obterInstancia();
    vector<Periodo*> periodo = lDocente->busca(this);

    return periodo.size();
}

double Docente :: mediaAtividadesPorDiciplina(){
    LeitorDisciplina* lDisciplinas = LeitorDisciplina :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    if(disciplinas.size() == 0) return 0;

    double cont=0;
    for(Disciplina* d : disciplinas){
        vector<Atividade*> atividades = d->obterAtividades();
        cont += atividades.size();
    }

    return cont/disciplinas.size();
}

double Docente :: percentualAtividadesSincronas(){
    LeitorDisciplina* lDisciplinas = LeitorDisciplina :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    if(disciplinas.size() == 0) return 0;

    double cont=0, cont2=0;
    for(Disciplina* d : disciplinas){
        vector<Atividade*> atividades = d->obterAtividades();
        cont += atividades.size();
        for(Atividade* a : atividades){
            if(a->obterSincrona())
                cont2++;
        }
    }

    if(cont == 0) return 0;
    
    return (cont2/cont) * 100;
}

double Docente :: percentualAtividadesAssincronas(){
    LeitorDisciplina* lDisciplinas = LeitorDisciplina :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    if(disciplinas.size() == 0) return 0;

    double cont=0, cont2=0;
    for(Disciplina* d : disciplinas){
        vector<Atividade*> atividades = d->obterAtividades();
        cont += atividades.size();
        for(Atividade* a : atividades){
            if(!a->obterSincrona())
                cont2++;
        }
    }

    if(cont == 0) return 0;
    
    return (cont2/cont) * 100;
}

double Docente :: mediaNotasRecebidas(){
    LeitorDisciplina* lDisciplinas = LeitorDisciplina :: obterInstancia();
    vector<Disciplina*> disciplinas = lDisciplinas->busca(this);

    double cont=0, notas=0;
    for(Disciplina* d : disciplinas){
        vector<Atividade*> atividades = d->obterAtividades();
        for(Atividade* a : atividades){
            cont += a->obterQtdAvaliacoes();
            notas += a->calculaNotaTotal();
        }
    }

    if(cont == 0) return 0;

    return notas/cont;
}

bool Docente :: compara(const Docente* esq, const Docente* dir){
    return !stringCompare(esq->obterNome(), dir->obterNome());
}

ostream& operator<<(ostream& os, Docente &docente){
    if(docente.paginaWeb == ""){
        os << "Nome: " << docente.nome << " - Login: " << docente.login << endl;
        return os;
    }
    else{
        os << "Nome: " << docente.nome << " - Login: " << docente.login << " - Site: " << docente.paginaWeb << endl;
        return os;
    }
}