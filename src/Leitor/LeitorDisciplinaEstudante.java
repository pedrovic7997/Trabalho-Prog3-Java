package Leitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Modelo.Disciplina;
import Modelo.Estudante;

public class LeitorDisciplinaEstudante extends ILeitor implements Serializable{

    HashMap<String,ArrayList<Estudante>> mapDisciplina;
    HashMap<String,ArrayList<Disciplina>> mapEstudante;
    static LeitorDisciplinaEstudante leitor;

    private LeitorDisciplinaEstudante(){
        leitor=null;
        mapDisciplina = new HashMap<>();
        mapEstudante = new HashMap<>();
    }

    public static void setInstancia(LeitorDisciplinaEstudante novo){
        leitor = novo;
    }

    public static LeitorDisciplinaEstudante obterInstancia(){
        if (leitor == null){
            leitor = new LeitorDisciplinaEstudante();
            return leitor;
        }
        else return leitor;
    }

    public void lista(Disciplina disciplina){
        if(mapDisciplina.containsKey(disciplina.obterCodigo()))
            for(Estudante e : mapDisciplina.get(disciplina.obterCodigo())){
                System.out.println(e);
            }
    }

    public void lista(Estudante estudante){
        if(mapEstudante.containsKey(estudante.obterMatricula()))
            for(Disciplina d : mapEstudante.get(estudante.obterMatricula())){
                System.out.println(d);
            }
    }

    public void adiciona(Disciplina disciplina, Estudante estudante){
        if(!mapEstudante.containsKey(estudante.obterMatricula())){
            mapEstudante.put(estudante.obterMatricula(),new ArrayList<>()); 
        }
        mapEstudante.get(estudante.obterMatricula()).add(disciplina);

        if(!mapDisciplina.containsKey(disciplina.obterCodigo())){
            mapDisciplina.put(disciplina.obterCodigo(),new ArrayList<>());
        }
        mapDisciplina.get(disciplina.obterCodigo()).add(estudante);
    }

    public Estudante busca(Disciplina disciplina,String matricula){
        if (!mapDisciplina.containsKey(disciplina.obterCodigo()))
            return null;
        for(Estudante e : mapDisciplina.get(disciplina.obterCodigo())){
            if( e.obterMatricula()==matricula)
                return e;
        }
        return null;
    }

    public ArrayList<Estudante> busca(Disciplina disciplina){
        return mapDisciplina.get(disciplina.obterCodigo());
    }
    public ArrayList<Disciplina> busca(Estudante estudante){
        return mapEstudante.get(estudante.obterMatricula());
    }
}
