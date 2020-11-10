package Modelo;

import java.io.Serializable;

public class Material implements Serializable{

    private static final long serialVersionUID = 1L;
    private String nome;
    private String link;

    public Material(String nome, String link){
        this.nome = nome;
        this.link = link;
    }

    public String obterNome(){
        return nome;
    }

    public String obterLink(){
        return link;
    }

    @Override
    public String toString(){
        return nome + ": " + link;
    }
}