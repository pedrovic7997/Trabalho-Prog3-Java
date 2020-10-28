package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class Atividade implements Cloneable, Serializable, Comparable<Atividade> {
    private String nome;
    private Boolean sincrona;
    private ArrayList<Avaliacao> avaliacoes;
    protected Calendar data;

    public Atividade(String nome, Boolean sincrona) {
        this.nome = nome;
        this.sincrona = sincrona;
        this.avaliacoes = new ArrayList<>();
    }

    public Boolean obterSincrona() {
        return sincrona;
    }

    public String obterNome() {
        return nome;
    }

    public ArrayList<Avaliacao> obterAvaliacoes() {
        return avaliacoes;
    }

    public void anexaAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    public int obterCargaHoraria(){
        return 2;
    }

    public double calculaNota(){
        double notaTotal = 0;
        for(Avaliacao aval : avaliacoes){
            notaTotal += aval.obterNota();
        }
        return notaTotal;
    }

    public Calendar obterData(){
        return data;
    }

    public abstract boolean ehAvaliativa();
    
    @Override
    public String toString() {
        if (sincrona) return "Nome: " + nome + " - Sincrona";
        else return "Nome: " + nome + " - Assincrona";
    }

    public int compareTo(Atividade a2){
        return this.data.compareTo(a2.data);
    }
}