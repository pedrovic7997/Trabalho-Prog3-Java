package Leitor;

import java.util.Scanner;
import java.util.Set;
import java.beans.Transient;
import java.io.Serializable;
import java.util.HashMap;

import Modelo.Estudante;

public class LeitorEstudante extends ILeitor implements Serializable{
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
        try {
            matricula = scanner.next();
        } catch (Exception e) {
            throw new RuntimeException("Dado inválido: "+scanner.next());
        }
        if(busca(matricula) != null)
			throw new IllegalArgumentException("Cadastro repetido: "+matricula+".");
        String nome = scanner.next();
        Estudante aluno = new Estudante(matricula, nome);
        return aluno;
    }

    public void anexaHash(Estudante aluno){
        mapa.put(aluno.obterMatricula(), aluno);
    }

    public void listar(){
        for (String i : mapa.keySet()){
            System.out.println(mapa.get(i));
        }
    }

    public Estudante busca(String matricula){
        if(mapa.containsKey(matricula)){
            return mapa.get(matricula);
        }
        return null;
    }
}