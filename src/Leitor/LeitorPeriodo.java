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

    public Periodo ler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ano do periodo: ");
        int ano = 0;
        boolean correto = false;
        while(!correto)
            try {
                ano = scanner.nextInt();
                correto = true;  
            } catch (Exception e) {
                System.out.println("\nDado invalido: "+ scanner.next()+".\n");
                System.out.println("Digite o ano novamente.\n");
                correto = false;
            }
        System.out.println("Informe o semestre do periodo: ");
        correto = false;
        String semestre = "";
        while(!correto)
            try {
                semestre = scanner.next();
                Pattern pattern = Pattern.compile("[1-3E]");
                Matcher matcher = pattern.matcher(semestre);
                correto = true;
                if(!matcher.matches())
                    throw new Exception();
            } catch (Exception e) {
                System.out.println("\nDado invalido: "+ semestre +".\n");
                System.out.println("Digite o semestre novamente.\n");
                correto = false;
            }
        
        Periodo periodo = new Periodo(ano, semestre.charAt(0));
        if(busca(periodo.obterCodigo()!= null))
            throw new Exception();
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