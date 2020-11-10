package Modelo;

import java.util.Calendar;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Prova extends Atividade{

    private static final long serialVersionUID = 1L;
    ArrayList<String> conteudo;

    public Prova(String nome, Boolean sincrona, Calendar data, ArrayList<String> conteudo){
        super(nome, sincrona);
        this.data = data;
        this.conteudo = conteudo;
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