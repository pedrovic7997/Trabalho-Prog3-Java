#include "Disciplina.h"

Disciplina :: Disciplina(string codigo, string nome, Periodo *periodo, Docente *professor) {
    this->codigo = codigo;
    this->nome = nome;
    this->periodo = periodo;
    this->professor = professor;
}

Disciplina :: ~Disciplina(){
    delete periodo;
    delete professor;
}

string Disciplina :: obterCodigo() const{
    return codigo;
}

string Disciplina :: obterNome() const{
    return nome;
}

Periodo* Disciplina :: obterPeriodo() const{
    return periodo;
}

Docente* Disciplina :: obterDocente() const{
    return professor;
}

vector<Atividade> Disciplina :: obterAtividades(){
    return atividades;
}

void Disciplina :: anexaAtividade(Atividade atividade){
    atividades.push_back(atividade);
}

double Disciplina :: obterNotaTotal(){
    double notaTotal = 0;
    for(Atividade ativ : atividades){
        notaTotal += ativ.obterAvaliacoes().size();
    }
    return notaTotal;
}

int Disciplina :: obterAvaliacoesTotal(){
    int qtdAvaliacao = 0;
    for(Atividade ativ : atividades){
        qtdAvaliacao += ativ.obterAvaliacoes().size();
    }
    return qtdAvaliacao;
}

int Disciplina :: obterSincronas(){
    int qtdSinc = 0;
    for(Atividade a : obterAtividades()){
        if(a.obterSincrona()){
            qtdSinc++;
        }
    }
    return qtdSinc;
}

int Disciplina :: obterAvalitiva(){
    int qtdAvaliativas = 0;
    for(Atividade a : obterAtividades()){
        if(a.ehAvaliativa()) {
            qtdAvaliativas++;
        }
    }
    return qtdAvaliativas;
}

int Disciplina :: obterCargaHoraria(){
    int cargaHoraria = 0;
    for(Atividade a : obterAtividades()){
        cargaHoraria += a.obterCargaHoraria();
    }
    return cargaHoraria;
}
