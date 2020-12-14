#ifndef DISCIPLINA_H
#define DISCIPLINA_H

#include "../Incluidor.h"

using namespace std;
using namespace cpp_util;

class Disciplina{
    string codigo;
    string nome;
    Periodo *periodo;
    Docente *professor;
    vector<Atividade*> atividades;

    public:
        Disciplina(string codigo, string nome, Periodo *periodo, Docente *professor);
        ~Disciplina();

        string obterCodigo() const;
        string obterNome() const;
        Periodo* obterPeriodo() const;
        Docente* obterDocente() const;
        vector<Atividade*> obterAtividades();

        void anexaAtividade(Atividade* atividade);
        double obterNotaTotal();
        int obterAvaliacoesTotal();

        int obterSincronas();
        int obterAvalitiva();
        int obterCargaHoraria();

        double percentualAtividadesSincronas();
        double percentualAtividadesAssincronas();
        int calculaCargaHorariaTotal();
        int obterQtdAvaliacoesTotal();

        bool comparaDisciplinasNome(const Disciplina* esq, const Disciplina* dir);

        friend ostream& operator<<(ostream& os, Disciplina &disciplina); 
};

#endif