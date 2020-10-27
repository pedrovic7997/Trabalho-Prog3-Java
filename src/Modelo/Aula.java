package Modelo;

import java.util.Calendar;

public class Aula extends Atividade{

    public Aula (String nome,Boolean sincrona, Calendar data){
        super(nome, sincrona);
        this.data = data;
    }

    public boolean ehAvaliativa(){
        return false;
    }

    @Override
    public String toString(){
        return "Aula: " + this.obterNome() + " - Sincrona - " +
                data.get(Calendar.DAY_OF_MONTH) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR) +
                " - " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE);
    }

    @Override
    public int compareTo(Atividade a2){
        return this.data.compareTo(a2.data);
    }
}
