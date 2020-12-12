#include <iostream>
#include <string>
#include <vector>
#include "Atividade.h"
#include "Periodo.h"
#include "Docente.h"

using namespace std;

class Disciplina{
    string codigo;
    string nome;
    Periodo *periodo;
    Docente *professor;
    vector<Atividade> atividades;

    public:
        Disciplina(string codigo, string nome, Periodo *periodo, Docente *professor);
        ~Disciplina();

        string obterCodigo() const;
        string obterNome() const;
        Periodo* obterPeriodo() const;
        Docente* obterDocente() const;
        vector<Atividade> obterAtividades();

        void anexaAtividade(Atividade atividade);
        double obterNotaTotal();
        int obterAvaliacoesTotal();

        int obterSincronas();
        int obterAvalitiva();
        int obterCargaHoraria();
};