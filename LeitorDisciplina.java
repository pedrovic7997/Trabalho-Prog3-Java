import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LeitorDisciplina{
    private Map<String, Disciplina> mapa = new HashMap<>();
    private static LeitorDisciplina leitor;

    private LeitorDisciplina(){}

    public static LeitorDisciplina obterInstancia(){
        if (leitor == null){
            leitor = new LeitorDisciplina();
            return leitor;
        }
        else return leitor;
    }

    public Disciplina ler(Periodo periodo, Docente professor){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o codigo da disciplina: ");
        String codigo = scanner.next();
        scanner.nextLine();
        System.out.println("Informe o nome da disciplina: ");
        String nome = scanner.nextLine();

        Disciplina disciplina = new Disciplina(codigo,nome,periodo,professor);
        return disciplina;
    }

    public void anexaHash(Disciplina disciplina){
        mapa.put(disciplina.obterCodigo(), disciplina);
    }

    public void listar(){
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
}