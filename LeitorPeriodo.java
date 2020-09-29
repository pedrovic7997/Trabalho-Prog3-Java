import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LeitorPeriodo {
    private Map<String, Periodo> mapa = new HashMap<>();
    private static LeitorPeriodo leitor;

    private LeitorPeriodo(){}

    public static LeitorPeriodo obterInstancia(){
        if (leitor == null){
            leitor = new LeitorPeriodo();
            return leitor;
        }
        else return leitor;
    }

    public Periodo ler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o ano do periodo: ");
        int ano = scanner.nextInt();
        System.out.println("Informe o semestre do periodo: ");
        char semestre = scanner.next().charAt(0);
        Periodo periodo = new Periodo(ano, semestre);
        return periodo;
    }

    public void anexaHash(Periodo periodo){
        mapa.put(periodo.obterCodigo(), periodo);
    }

    public void listar(){
        for (String i : mapa.keySet()){
            System.out.println(mapa.get(i));
        }
    }

    public Periodo busca(String codigo){
        if(mapa.containsKey(codigo)){
            return mapa.get(codigo);
        }
        return null;
    }
}