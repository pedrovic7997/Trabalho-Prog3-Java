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
};