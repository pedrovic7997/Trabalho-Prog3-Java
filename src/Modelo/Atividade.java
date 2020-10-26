package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Atividade implements Serializable{
    private String nome;
    private Boolean sincrona;
    private ArrayList<Avaliacao> avaliacoes;

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
        double notaTotal;
        for(Avaliacao aval : avaliacoes){
            notaTotal += aval.obterNota();
        }
    }

    public abstract boolean ehAvaliativa();
    @Override
    public String toString() {
        if (sincrona) return "Nome: " + nome + " - Sincrona";
        else return "Nome: " + nome + " - Assincrona";
    }
}