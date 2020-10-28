package Leitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Modelo.Avaliacao;
import Modelo.Estudante;

public class LeitorAvaliacao extends ILeitor implements Serializable{
    private static LeitorAvaliacao leitor;

    private LeitorAvaliacao(){}

    public static LeitorAvaliacao obterInstancia(){
        if (leitor == null){
            leitor = new LeitorAvaliacao();
            return leitor;
        }
        else return leitor;
    }

    public void lista(List<Avaliacao> avaliacoes){
        for(Avaliacao a : avaliacoes){
            System.out.println(a);
        }
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

    public Avaliacao ler(Estudante aluno){

        // System.out.println("Digite a matricula do aluno: ");
        
        Scanner scan = new Scanner(System.in);
        // Estudante aluno = leitorE.busca(scan.nextInt());
        // if(aluno != null){
        System.out.println("Qual a nota desse aluno? ");
        return new Avaliacao(aluno, scan.nextFloat());
        // }
        // else{
        //     System.out.println("Aluno invalido");
        //     return null;
        // }
    }
}