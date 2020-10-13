package Modelo;

import java.io.Serializable;
import java.util.*;

public class Disciplina implements Serializable{
    private String codigo;
    private String nome;
    private Periodo periodo;
    private Docente professor;
    private ArrayList<Atividade> atividades;

    public Disciplina(String codigo, String nome, Periodo periodo, Docente professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.periodo = periodo;
        this.professor = professor;
        atividades = new ArrayList<>();
    }

    public String obterCodigo() {
        return codigo;
    }

    public String obterNome() {
        return nome;
    }

    public Periodo obterPeriodo() {
        return periodo;
    }

    public Docente obterDocente() {
        return professor;
    }

    public void anexaAtividade(Atividade atividade){
        atividades.add(atividade);
    }

    public ArrayList<Atividade> obterAtividades(){
        return atividades;
    }

    @Override
    public String toString() {
        return "Codigo: "+ codigo+"-"+periodo.obterAno()+ "/" +periodo.obterSemestre() +" - Nome: "+ nome + 
        " - Professor: "+ professor.obterNome();
    }

}