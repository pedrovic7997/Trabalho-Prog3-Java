import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class LeitorDocente{
    private Map<String, Docente> mapa = new HashMap<>();
    private static LeitorDocente leitor;

    private LeitorDocente(){}

    public static LeitorDocente obterInstancia(){
        if (leitor == null){
            leitor = new LeitorDocente();
            return leitor;
        }
        else return leitor;
    }

    public Docente ler(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o login do docente: ");
        String login = scanner.nextLine();
        System.out.println("Informe o nome do docente: ");
        String nome = scanner.nextLine();
        System.out.println("Deseja acrescentar um site do docente? ('s' caso queira) ");
        String opcao;
        opcao = scanner.next();
        Docente docente;
        if(opcao.toLowerCase().equals("s")){
            String site = scanner.next();
            System.out.println("Informe o site: ");
            docente = new Docente(login,nome,site);
        }
        else{
            docente = new Docente(login, nome);
        }
        
        return docente;
    }

    public void anexaHash(Docente docente){
        mapa.put(docente.obterLogin(), docente);
    }

    public void listar(){
        for (String i : mapa.keySet()){
            System.out.println(mapa.get(i));
        }
    }

    public Docente busca(String login){
        if(mapa.containsKey(login)){
            return mapa.get(login);
        }
        return null;
    }
}