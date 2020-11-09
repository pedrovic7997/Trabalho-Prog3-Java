package Leitor;

import java.util.Scanner;

import Controlador.ControladorDocente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import Modelo.Disciplina;
import Modelo.Periodo;
import Modelo.Docente;

public class LeitorDisciplina extends ILeitor implements Serializable{
    private HashMap<String, Disciplina> mapa = new HashMap<>();
    private static LeitorDisciplina leitor;

    private LeitorDisciplina(){}

    public static LeitorDisciplina obterInstancia(){
        if (leitor == null){
            leitor = new LeitorDisciplina();
            return leitor;
        }
        else return leitor;
    }

    public HashMap<String,Disciplina> obterHash(){
        return mapa;
    }

    public static void setInstancia(LeitorDisciplina novo){
        leitor = novo;
    }

    public Disciplina ler(Scanner scanner, Periodo periodo, ControladorDocente controlador){
        String codigo = scanner.next();
        
        if (busca(codigo+"-"+periodo.obterCodigo()) != null){
            throw new RuntimeException("Cadastro repetido: "+codigo+".");
        }
        scanner.nextLine();
        String nome = scanner.nextLine();

        Disciplina disciplina = new Disciplina(codigo,nome,periodo,controlador.busca(scanner.next()));
        return disciplina;
    }

    public void anexaHash(Disciplina disciplina){
        mapa.put(disciplina.obterCodigo()+"-"+disciplina.obterPeriodo().obterAno()+"/"+
            disciplina.obterPeriodo().obterSemestre(), disciplina);
    }

    public void listar(){
        System.out.println("------------------------");
		System.out.println("Disciplinas cadastradas:");
        for (String i : mapa.keySet()){
            System.out.println(mapa.get(i));
        }
    }

    public Disciplina busca(String codigo){
        if(mapa.containsKey(codigo)){
            return mapa.get(codigo);
        }
        return null;
    }

    public ArrayList<Disciplina> busca(Periodo periodo){
        ArrayList<Disciplina> lista = new ArrayList<>();
        for (String i : mapa.keySet()){
            if(mapa.get(i).obterPeriodo()==periodo)
                lista.add(mapa.get(i));
        }
        return lista;
    }

    public ArrayList<Disciplina> busca(Docente docente){
        ArrayList<Disciplina> lista = new ArrayList<>();
        for (String i : mapa.keySet()){
            if(mapa.get(i).obterDocente()==docente)
                lista.add(mapa.get(i));
        }
        return lista;
    }
}