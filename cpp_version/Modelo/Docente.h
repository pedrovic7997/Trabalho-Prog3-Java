#ifndef DOCENTE_H
#define DOCENTE_H

// #include "../Incluidor.h"
#include <string>

#include "../util/StringUtils.h"
#include "../Leitor/LeitorDisciplina.h"
#include "../Leitor/LeitorDocente.h"
#include "Atividade.h"
#include "Disciplina.h"

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

        bool compara(const Docente* esq, const Docente* dir);

        friend ostream& operator<<(ostream& os, Docente &docente);
};

#endif