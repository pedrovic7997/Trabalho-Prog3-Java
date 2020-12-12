#include "Docente.h"

Docente :: Docente(string login, string nome, string paginaWeb){
    this->login = login;
    this->nome = nome;
    this->paginaWeb = paginaWeb;
}


Docente :: Docente(string login, string nome){
    this->login = login;
    this->nome = nome;
    // this->paginaWeb = NULL;
    this->paginaWeb = "nulo";
}

string Docente :: obterLogin() const{
    return login;
}
string Docente :: obterNome() const{
    return nome;
}
string Docente :: obterPaginaWeb() const{
    return paginaWeb;
}