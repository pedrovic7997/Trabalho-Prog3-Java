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

ostream& operator<<(ostream& os, Docente &docente){
    if(docente.paginaWeb == "null"){
        os << "Nome: " << docente.nome << " - Login: " << docente.login;
    }
    else{
        os << "Nome: " << docente.nome << " - Login: " << docente.login << " - Site: " << docente.paginaWeb;
    }
}