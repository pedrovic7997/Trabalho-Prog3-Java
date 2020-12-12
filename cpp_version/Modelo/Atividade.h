#ifndef ATIVIDADE_H
#define ATIVIDADE_H

#include <iostream>
#include <string>
#include <vector>
#include "Avaliacao.h"

using namespace std;

class Atividade {
    string nome;
    bool sincrona;
    vector<Avaliacao> avaliacoes;
    // protected Calendar data;

    public:
        Atividade (string nome, bool sincrona);
        ~Atividade();
        
        string obterNome() const;
        bool obterSincrona() const;
        int obterCargaHoraria() const;
        // Calendar obterData();

        void anexaAvaliacao(Avaliacao avaliacao);

        vector<Avaliacao> obterAvaliacoes();
        // double calculaNota();

        virtual bool ehAvaliativa();

        friend ostream& operator<<(ostream& os, Atividade &atividade); 
};

#endif