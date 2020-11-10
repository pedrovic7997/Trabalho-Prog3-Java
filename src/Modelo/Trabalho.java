package Modelo;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Trabalho extends Atividade{
    
    private static final long serialVersionUID = 1L;
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
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/yyyy");
        return dt1.format(data.getTime());
    }
}