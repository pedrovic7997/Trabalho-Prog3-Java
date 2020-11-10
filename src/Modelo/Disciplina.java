package Modelo;

import java.io.Serializable;
import java.util.*;

public class Disciplina implements Serializable, Comparable<Disciplina>{

    private static final long serialVersionUID = 1L;
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

    public double obterNotaTotal(){
        double notaTotal = 0;
        for(Atividade ativ : atividades){
            notaTotal += ativ.calculaNota();
        }
        return notaTotal;
    }

    public int obterAvaliacoesTotal(){
        int qtdAvaliacao = 0;
        for(Atividade ativ : atividades){
            qtdAvaliacao += ativ.obterAvaliacoes().size();
        }
        return qtdAvaliacao;
    }

    public static int comparePeriodo(Disciplina disc1, Disciplina disc2){
        if( disc1.periodo.obterCodigo().compareTo(disc2.periodo.obterCodigo()) == 0){
            return disc1.codigo.compareToIgnoreCase(disc2.codigo);
        }
        return disc1.periodo.obterCodigo().compareTo(disc2.periodo.obterCodigo());
    }

    @Override
    public int compareTo(Disciplina disc2){
        return nome.compareToIgnoreCase(disc2.nome);
    }

    @Override
    public String toString() {
        return "Codigo: "+ codigo+"-"+periodo.obterAno()+ "/" +periodo.obterSemestre() +" - Nome: "+ nome + 
        " - Professor: "+ professor.obterNome();
    }

    public int obterSincronas(){
        int qtdSinc = 0;
        for(Atividade a : obterAtividades()){
            if(a.obterSincrona()){
                qtdSinc++;
            }
        }
        return qtdSinc;
    }

    public int obterAvalitiva(){
        int qtdAvaliativas = 0;
        for(Atividade a : obterAtividades()){
            if(a.ehAvaliativa()) {
                qtdAvaliativas++;
            }
        }
        return qtdAvaliativas;
    }

    public int obterCargaHoraria(){
        int cargaHoraria = 0;
        for(Atividade a : obterAtividades()){
            cargaHoraria += a.obterCargaHoraria();
        }
        return cargaHoraria;
    }
}