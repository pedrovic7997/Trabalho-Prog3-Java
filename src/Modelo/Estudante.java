package Modelo;

import java.io.Serializable;

public class Estudante implements Serializable{

    private static final long serialVersionUID = 1L;
    private String matricula;
    private String nome;

    public Estudante(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String obterMatricula() {
        return matricula;
    }

    public String obterNome() {
        return nome;
    }

    @Override
    public String toString() {
        return matricula + ";" + nome;
    }
}