package Modelo;

import java.io.Serializable;

public class Docente implements Serializable, Comparable<Docente>{

    private static final long serialVersionUID = 1L;
    private String login;
    private String nome;
    private String paginaWeb;

    public Docente(String login, String nome) {
        this.login = login;
        this.nome = nome;
        paginaWeb = null;
    }

    public Docente(String login, String nome, String paginaWeb) {
        this.login = login;
        this.nome = nome;
        this.paginaWeb = paginaWeb;
    }

    public String obterLogin() {
        return login;
    }

    public String obterNome() {
        return nome;
    }

    public String obterPaginaWeb() {
        return paginaWeb;
    }

    @Override
    public int compareTo(Docente arg0) {
        return arg0.nome.compareTo(nome);
    }

    @Override
    public String toString() {
        if(paginaWeb == null)
            return "Nome: " + nome + " - Login: " + login;
        else
        return "Nome: " + nome + " - Login: " + login + " - Site: "+ paginaWeb; 
    }
}