import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LeitorEstudante {
    private Map<Integer, Estudante> mapa = new HashMap<>();
    private static LeitorEstudante leitor;

    private LeitorEstudante(){}

    public static LeitorEstudante obterInstancia(){
        if (leitor == null){
            leitor = new LeitorEstudante();
            return leitor;
        }
        else return leitor;
    }

    public Estudante ler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a matricula do estudante: ");
        int matricula = scanner.nextInt();
        System.out.println("Informe o nome do estudante:  ");
        scanner.nextLine();
        String nome = scanner.nextLine();
        Estudante aluno = new Estudante(matricula, nome);
        return aluno;
    }

    public void anexaHash(Estudante aluno){
        mapa.put(aluno.obterMatricula(), aluno);
    }

    public void listar(){
        for (Integer i : mapa.keySet()){
            System.out.println(mapa.get(i));
        }
    }

    public Estudante busca(int matricula){
        if(mapa.containsKey(matricula)){
            return mapa.get(matricula);
        }
        return null;
    }
}