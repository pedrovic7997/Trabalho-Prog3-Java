package Modelo;

import java.util.Calendar;
import java.util.ArrayList;

public class Prova extends Atividade{
    Calendar data;
    ArrayList<String> conteudo;

    public Prova(String nome, Boolean sincrona, Calendar data, ArrayList<String> conteudo){
        super(nome, sincrona);
        this.data = data;
        this.conteudo = conteudo;
    }

    private String listaConteudo(){
        String conteudos="";
        for(String c:conteudo){
            conteudos+= c+" / ";
        }

        return conteudos;
    }

    public boolean ehAvaliativa(){
        return true;
    }

    @Override
    public String toString(){
        return "Prova: " + this.obterNome() + " - Sincrona - " +
                data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR) +
                " - " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + " - Conteudos: " + listaConteudo();
    }
}