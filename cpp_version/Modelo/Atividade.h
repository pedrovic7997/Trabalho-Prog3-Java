#ifndef ATIVIDADE_H
#define ATIVIDADE_H

// #include "../Incluidor.h"
#include <string>
#include <vector>

#include "Avaliacao.h"

using namespace std;

class Atividade {
    string nome;
    bool sincrona;
    vector<Avaliacao*> avaliacoes;

    public:
        time_t data;
        
        Atividade (string nome, bool sincrona);
        
        string obterNome() const;
        bool obterSincrona() const;
        int obterCargaHoraria() const;
        vector<Avaliacao*> obterAvaliacoes();
        time_t obterData();

        void anexaAvaliacao(Avaliacao* avaliacao);
        double calculaNotaTotal();
        
        int obterQtdAvaliacoes();

        virtual bool ehAvaliativa();

        bool compara(const Atividade* esq, const Atividade* dir);

        friend ostream& operator<<(ostream& os, Atividade &atividade); 
};

#endif