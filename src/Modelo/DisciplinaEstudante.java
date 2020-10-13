package Modelo;

import java.io.Serializable;

public class DisciplinaEstudante implements Serializable{
    private Estudante estudante;
    private Disciplina disciplina;

    public DisciplinaEstudante(Estudante estudante, Disciplina disciplina){
        this.estudante= estudante;
        this.disciplina= disciplina;
    }

    public Estudante obterEstudante(){
        return estudante;
    }

    public Disciplina obterDisciplina(){
        return disciplina;
    }

}