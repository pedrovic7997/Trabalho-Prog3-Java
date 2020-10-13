package Modelo;

import java.util.ArrayList;

public class Estudo extends Atividade{
    private ArrayList<Material> materiais;

    public Estudo(String nome, Boolean sincrona, ArrayList<Material> materiais){
        super(nome, sincrona);
        this.materiais = materiais;
    }

    private String listaMateriais(){
        String lista = "";

        for(Material m:materiais){
            lista += m.obterNome() + ": " + m.obterLink() + " / ";
        }

        return lista;
    }
    
    public boolean ehAvaliativa(){
        return false;
    }

    @Override
    public String toString(){
        return "Estudo: " + this.obterNome() + " - Assincrono - Materiais: " + listaMateriais();
    }
}
