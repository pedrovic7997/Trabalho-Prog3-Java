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

vector<Avaliacao> Atividade :: obterAvaliacoes(){
    return avaliacoes;
}

 void Atividade :: anexaAvaliacao(Avaliacao avaliacao){
    avaliacoes.push_back(avaliacao);
 }

ostream& operator<< (ostream& os, Atividade &atividade){
    if(atividade.obterSincrona()){
        os << "Nome: " << atividade.nome << " - Sincrona";
        return os;
    }
    else{
        os << "Nome: " << atividade.nome << " - Assincrona";
        return os;
    }
}