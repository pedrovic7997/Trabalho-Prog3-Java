package Leitor;

import java.util.Scanner;
import java.util.Set;
import java.io.Serializable;
import java.util.HashMap;

import Modelo.Docente;

public class LeitorDocente extends ILeitor implements Serializable{
   
    private static final long serialVersionUID = 1L;
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

    public Docente ler(Scanner scanner){
        String login = scanner.next();
        if(leitor.busca(login) != null)
			throw new IllegalArgumentException("Cadastro repetido: "+login+".");
        String nome = scanner.next();
        Docente docente;
        String site = scanner.next();
        docente = new Docente(login,nome,site);
        
        return docente;
    }

    public void anexaHash(Docente docente){
        mapa.put(docente.obterLogin(), docente);
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