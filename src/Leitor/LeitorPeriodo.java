package Leitor;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    public Periodo ler(Scanner scanner) throws Exception {
        System.out.println("Informe o ano do periodo: ");
        int ano = 0;
        
        try {
            ano = scanner.nextInt();
        } catch (Exception e) {
            throw new Exception("\nDado invalido: "+ scanner.next()+".\n");
        }
        
        String semestre = "";
        semestre = scanner.next();
        Pattern pattern = Pattern.compile("[0-9A-Za-z]");
        Matcher matcher = pattern.matcher(semestre);
        if(!matcher.matches())
            throw new Exception("Dado invalido: "+ semestre +".");
                
        Periodo periodo = new Periodo(ano, semestre.charAt(0));
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