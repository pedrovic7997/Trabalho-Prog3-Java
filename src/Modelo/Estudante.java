package Modelo;

import java.io.Serializable;

public class Estudante implements Serializable{
    private int matricula;
    private String nome;

    public Estudante(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public int obterMatricula() {
        return matricula;
    }

    public String obterNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Matricula: " + matricula;
    }
}