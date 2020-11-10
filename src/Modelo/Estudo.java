package Modelo;

import java.util.ArrayList;
import java.util.Calendar;

public class Estudo extends Atividade{

    private static final long serialVersionUID = 1L;
    private ArrayList<Material> materiais;

    public Estudo(String nome, Boolean sincrona, ArrayList<Material> materiais){
        super(nome, sincrona);
        this.materiais = materiais;
        data = Calendar.getInstance();
    }

    public ArrayList<Material> getMateriais(){
        return materiais;
    }

    public boolean ehAvaliativa(){
        return false;
    }

    @Override
    public String toString(){
        return "Estudo: " + this.obterNome() + " - Assincrono - Materiais: ";
    }
}
