package Leitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Modelo.Avaliacao;
import Modelo.Estudante;

public class LeitorAvaliacao extends ILeitor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static LeitorAvaliacao leitor;

    private LeitorAvaliacao(){}

    public static LeitorAvaliacao obterInstancia(){
        if (leitor == null){
            leitor = new LeitorAvaliacao();
            return leitor;
        }
        else return leitor;
    }

    public ArrayList<Avaliacao> busca(List<Avaliacao> avaliacoes,Estudante estudante){
        ArrayList<Avaliacao> lista = new ArrayList<>();
        for(Avaliacao a : avaliacoes){
            if(a.obterAluno() == estudante){
                lista.add(a);
            }
        }
        return lista;
    }

    public Avaliacao ler(Scanner scan, Estudante aluno) throws Exception {
        
        float nota;

        try {
            nota = scan.nextFloat();
        } catch (Exception e){
            throw new Exception("Dado inválido: " + scan.next() + ".");
        }

        return new Avaliacao(aluno, nota);
    }
}