import java.util.List;
import java.util.Scanner;

public class LeitorAtividade {
    private static LeitorAtividade leitor;

    private LeitorAtividade(){}

    public static LeitorAtividade obterInstancia(){
        if (leitor == null){
            leitor = new LeitorAtividade();
            return leitor;
        }
        else return leitor;
    }

    public void lista(List<Atividade> atividades){
        int cont=1;
        for(Atividade a : atividades){
            System.out.println(cont+"-"+a);
        }
    }

    public Atividade busca(int posicao, List<Atividade> atividades){
        if(atividades.size() >= posicao){
            return atividades.get(posicao);
        }
        return null;
    }

    public Atividade ler(){

        System.out.println("A atividade é assincrona ou sincrona? ('A' para assincrona, 'S' para sincrona)");
        
        Scanner scan = new Scanner(System.in);
        if(scan.next().toLowerCase().equals("s")){
            System.out.println("Informe o nome da atividade: ");
            scan.nextLine();
            return new Atividade(scan.nextLine(),true);
        }
        System.out.println("Informe o nome da atividade: ");
        scan.nextLine();
        return new Atividade(scan.nextLine(),false);
    }
}