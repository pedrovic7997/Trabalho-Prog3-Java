package Modelo;

import java.beans.Transient;
import java.util.Calendar;

public class Trabalho extends Atividade{
    Calendar prazo;
    int numMaxPorGrupo;
    int cargaHoraria;

    public Trabalho(String nome, Boolean sincrona, Calendar prazo, int numMaxPorGrupo, int cargaHoraria){
        super(nome, sincrona);
        this.prazo = prazo;
        this.numMaxPorGrupo = numMaxPorGrupo;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public int obterCargaHoraria(){
        return cargaHoraria;
    }

    public boolean ehAvaliativa(){
        return true;
    }

    @Override
    public String toString(){
        return "Trabalho: " + this.obterNome() + " - Assincrona - " +
                prazo.get(Calendar.DAY_OF_MONTH) + "/" + prazo.get(Calendar.MONTH) + "/" + prazo.get(Calendar.YEAR);
    }
}