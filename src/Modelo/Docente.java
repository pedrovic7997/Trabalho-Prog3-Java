package Modelo;

import java.io.Serializable;
import java.text.Normalizer;

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
        String str1 = Normalizer
                        .normalize(arg0.nome, Normalizer.Form.NFD)
                        .replaceAll("[^\\p{ASCII}]", "");
        String str2 = Normalizer
                        .normalize(nome, Normalizer.Form.NFD)
                        .replaceAll("[^\\p{ASCII}]", "");
        return str1.compareTo(str2);
    }

    @Override
    public String toString() {
        if(paginaWeb == null)
            return "Nome: " + nome + " - Login: " + login;
        else
        return "Nome: " + nome + " - Login: " + login + " - Site: "+ paginaWeb; 
    }
}