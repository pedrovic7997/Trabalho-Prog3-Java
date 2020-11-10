package Modelo;

import java.io.Serializable;

public class Avaliacao implements Serializable{

    private static final long serialVersionUID = 1L;
    private Estudante aluno;
    private double nota;

    public Avaliacao(Estudante aluno, float nota) {
        this.aluno = aluno;
        this.nota = nota;
    }

    public Estudante obterAluno() {
        return aluno;
    }

    public double obterNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno.obterMatricula() + " - Nota: " + nota;
    }
}