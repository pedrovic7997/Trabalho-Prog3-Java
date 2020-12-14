#include "Atividade.h"

Atividade :: Atividade (string nome, bool sincrona){
    this->nome = nome;
    this->sincrona = sincrona;
}

string Atividade :: obterNome() const{
    return nome;
}

bool Atividade :: obterSincrona() const{
    return sincrona;
}

int Atividade :: obterCargaHoraria() const{
    return 2;
}

vector<Avaliacao*> Atividade :: obterAvaliacoes(){
    return avaliacoes;
}

time_t Atividade :: obterData(){
    return data;
}

void Atividade :: anexaAvaliacao(Avaliacao* avaliacao){    
    avaliacoes.push_back(avaliacao);
}

double Atividade :: calculaNotaTotal(){
    double notaTotal = 0;
    for(Avaliacao* a : avaliacoes){
        notaTotal += a->obterNota();
    }
    return notaTotal;
}

int Atividade :: obterQtdAvaliacoes(){
    return avaliacoes.size();
}

bool compara(const Atividade* esq, const Atividade* dir){
    if(esq->data > dir->data) return 1;
    if(esq->data < dir->data) return -1;
    if(esq->data == dir->data) return 0;
}

ostream& operator<< (ostream& os, Atividade &atividade){
    if(atividade.obterSincrona()){
        os << "Nome: " << atividade.nome << " - Sincrona" << endl;
        return os;
    }
    else{
        os << "Nome: " << atividade.nome << " - Assincrona" << endl;
        return os;
    }
}