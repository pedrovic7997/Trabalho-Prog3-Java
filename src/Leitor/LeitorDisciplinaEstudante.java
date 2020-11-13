package Leitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Modelo.Disciplina;
import Modelo.Estudante;

public class LeitorDisciplinaEstudante extends ILeitor implements Serializable{

    private static final long serialVersionUID = 1L;
    HashMap<String, ArrayList<Estudante>> mapDisciplina;
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

    public void adiciona(Disciplina disciplina, Estudante estudante){
        if(!mapEstudante.containsKey(estudante.obterMatricula())){
            mapEstudante.put(estudante.obterMatricula(),new ArrayList<>()); 
        }
        mapEstudante.get(estudante.obterMatricula()).add(disciplina);

        if(!mapDisciplina.containsKey(disciplina.obterCodigo() + disciplina.obterPeriodo().obterCodigo())){
            mapDisciplina.put(disciplina.obterCodigo() + disciplina.obterPeriodo().obterCodigo(),new ArrayList<>());
        }
        mapDisciplina.get(disciplina.obterCodigo() + disciplina.obterPeriodo().obterCodigo()).add(estudante);
    }

    public Estudante busca(Disciplina disciplina,String matricula){
        if (!mapDisciplina.containsKey(disciplina.obterCodigo() + disciplina.obterPeriodo().obterCodigo()))
            return null;
        for(Estudante e : mapDisciplina.get(disciplina.obterCodigo() + disciplina.obterPeriodo().obterCodigo())){
            if( e.obterMatricula()==matricula)
                return e;
        }
        return null;
    }

    public ArrayList<Estudante> busca(Disciplina disciplina){
        return mapDisciplina.get(disciplina.obterCodigo() + disciplina.obterPeriodo().obterCodigo());
    }
    public ArrayList<Disciplina> busca(Estudante estudante){
        return mapEstudante.get(estudante.obterMatricula());
    }
}
