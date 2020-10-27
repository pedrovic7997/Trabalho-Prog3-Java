package Modelo;

import java.beans.Transient;
import java.util.Calendar;

public class Trabalho extends Atividade{
    int numMaxPorGrupo;
    int cargaHoraria;

    public Trabalho(String nome, Boolean sincrona, Calendar prazo, int numMaxPorGrupo, int cargaHoraria){
        super(nome, sincrona);
        this.data = prazo;
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
                data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);
    }
    @Override
    public int compareTo(Atividade a2){
        return this.data.compareTo(a2.data);
    }
}