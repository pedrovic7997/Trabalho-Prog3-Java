package Leitor;

import java.util.Scanner;
import java.util.Set;
import java.io.Serializable;
import java.util.HashMap;

import Modelo.Docente;

public class LeitorDocente extends ILeitor implements Serializable{
    private HashMap<String, Docente> mapa = new HashMap<>();
    private static LeitorDocente leitor;

    private LeitorDocente(){}

    public static LeitorDocente obterInstancia(){
        if (leitor == null){
            leitor = new LeitorDocente();
            return leitor;
        }
        else return leitor;
    }

    public HashMap<String,Docente> obterHash(){
        return mapa;
    }

    public static void setInstancia(LeitorDocente novo){
        leitor = novo;
    }

    public Docente ler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o login do docente: ");
        String login = scanner.nextLine();
        System.out.println("Informe o nome do docente: ");
        String nome = scanner.nextLine();
        System.out.println("Deseja acrescentar um site do docente? ('s' caso queira) ");
        String opcao;
        opcao = scanner.next();
        Docente docente;
        if(opcao.toLowerCase().equals("s")){
            String site = scanner.next();
            System.out.println("Informe o site: ");
            docente = new Docente(login,nome,site);
        }
        else{
            docente = new Docente(login, nome);
        }
        
        return docente;
    }

    public void anexaHash(Docente docente){
        mapa.put(docente.obterLogin(), docente);
    }

    public void listar(){
        for (String i : mapa.keySet()){
            System.out.println(mapa.get(i));
        }
    }

    public Docente busca(String login){
        if(mapa.containsKey(login)){
            return mapa.get(login);
        }
        return null;
    }

    public Set<String> obterChaves(){
        return mapa.keySet();
    }
}