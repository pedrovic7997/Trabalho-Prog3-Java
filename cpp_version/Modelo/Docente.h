#ifndef DOCENTE_H
#define DOCENTE_H

#include <iostream>
#include <string>

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