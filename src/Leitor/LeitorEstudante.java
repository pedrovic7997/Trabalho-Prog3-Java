package Leitor;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Serializable;
import java.util.HashMap;

import Modelo.Estudante;

public class LeitorEstudante extends ILeitor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private HashMap<String, Estudante> mapa = new HashMap<>();
    private static LeitorEstudante leitor;

    private LeitorEstudante(){}

    public static LeitorEstudante obterInstancia(){
        if (leitor == null){
            leitor = new LeitorEstudante();
            return leitor;
        }
        else return leitor;
    }

    public Set<String> obterChaves(){
        return mapa.keySet(); 
    }

    public HashMap<String,Estudante> obterHash(){
        return mapa;
    }

    public static void setInstancia(LeitorEstudante novo){
        leitor = novo;
    }
    
    public Estudante ler(Scanner scanner){
        String matricula;
        
        matricula = scanner.next().trim();
        
        String pattern = "[^0-9]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(matricula);

        if(m.find()){
            throw new RuntimeException("Dado inválido: "+matricula+".");
        }
        
        if(busca(matricula) != null)
			throw new IllegalArgumentException("Cadastro repetido: "+matricula+".");
        String nome = scanner.next().trim().replaceAll(" +", " ");
        Estudante aluno = new Estudante(matricula, nome);
        if(scanner.hasNext())
            scanner.nextLine();
        return aluno;
    }

    public void anexaHash(Estudante aluno){
        mapa.put(aluno.obterMatricula(), aluno);
    }

    public Estudante busca(String matricula){
        if(mapa.containsKey(matricula)){
            return mapa.get(matricula);
        }
        return null;
    }
}