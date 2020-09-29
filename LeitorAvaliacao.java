import java.util.List;
import java.util.Scanner;

public class LeitorAvaliacao {
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