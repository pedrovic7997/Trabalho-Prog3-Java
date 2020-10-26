package Leitor;

import java.util.Scanner;
import java.io.Serializable;
import java.util.HashMap;

import Modelo.Periodo;

public class LeitorPeriodo extends ILeitor implements Serializable{
    private HashMap<String, Periodo> mapa = new HashMap<>();
    private static LeitorPeriodo leitor;

    private LeitorPeriodo(){}

    public static LeitorPeriodo obterInstancia(){
        if (leitor == null){
            leitor = new LeitorPeriodo();
            return leitor;
        }
        else return leitor;
    }

    public HashMap<String,Periodo> obterHash(){
        return mapa;
    }

    public static void setInstancia(LeitorPeriodo novo){
        leitor = novo;
    }

    public Periodo ler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ano do periodo: ");
        int ano = scanner.nextInt();
        System.out.println("Informe o semestre do periodo: ");
        char semestre = scanner.next().charAt(0);
        Periodo periodo = new Periodo(ano, semestre);
        return periodo;
    }

    public void anexaHash(Periodo periodo){
        mapa.put(periodo.obterCodigo(), periodo);
    }

    public void listar(){
        for (String i : mapa.keySet()){
            System.out.println(mapa.get(i));
        }
    }

    public Periodo busca(String codigo){
        if(mapa.containsKey(codigo)){
            return mapa.get(codigo);
        }
        return null;
    }
}