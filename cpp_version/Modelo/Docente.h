#ifndef DOCENTE_H
#define DOCENTE_H

#include <iostream>
#include <string>
#include "Disciplina.h"
#include "Periodo.h"
#include "Atividade.h"
#include "../Leitor/LeitorDisciplina.h"
#include "../Leitor/LeitorPeriodo.h"

using namespace std;

class Docente {
    string login;
    string nome;
    string paginaWeb;

    public:
        Docente(string login, string nome, string paginaWeb);
        Docente(string login, string nome);

        string obterLogin() const;
        string obterNome() const;
        string obterPaginaWeb() const;

        int contaDisciplinas();
        int contaPeriodos();
        double mediaAtividadesPorDiciplina();
        double percentualAtividadesSincronas();
        double percentualAtividadesAssincronas();
        double mediaNotasRecebidas();

        friend ostream& operator<<(ostream& os, Docente &docente);
};

#endif