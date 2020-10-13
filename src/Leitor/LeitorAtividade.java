package Leitor;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;

import Modelo.Atividade;
import Modelo.Estudo;
import Modelo.Trabalho;
import Modelo.Aula;
import Modelo.Prova;
import Modelo.Material;

public class LeitorAtividade implements Serializable{
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
            cont++;
        }
    }

    public Atividade busca(int posicao, List<Atividade> atividades){
        if(atividades.size() >= posicao){
            return atividades.get(posicao);
        }
        return null;
    }

    public Atividade ler(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o tipo da atividade?(Aula, estudo, prova ou trabalho)");
        String tipo=scan.next();
        while(true){
            if(tipo.toLowerCase().equals("aula"))
                return criaAula();
            if(tipo.toLowerCase().equals("trabalho"))
                return criaTrabalho();
            if(tipo.toLowerCase().equals("prova"))
                return criaProva();
            if(tipo.toLowerCase().equals("estudo"))
                return criaEstudo();
            System.out.println("Opção invalida. Digite novamente:");
            tipo=scan.next();
        }
    }

    private Aula criaAula(){
        Scanner scan = new Scanner(System.in);
        String nome;
        Calendar data = Calendar.getInstance();
        System.out.println("Informe o nome da aula: ");
        nome=scan.nextLine();
        System.out.println("Informe o ano, mês, dia, hora e minutos da aula respectivamente"+
        "(Separados por espaço): ");
        data.set(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
        return new Aula(nome,true,data);
    }

    private Trabalho criaTrabalho(){
        Scanner scan = new Scanner(System.in);
        String nome;
        Calendar data = Calendar.getInstance();
        System.out.println("Informe o nome do trabalho: ");
        nome=scan.nextLine();
        System.out.println("Informe o ano, mês e dia da entrega do trabalho " 
        + "respectivamente(Separados por espaço): ");
        data.set(scan.nextInt(), scan.nextInt(), scan.nextInt());
        System.out.println("Informe o num maximo de alunos: ");
        int numAlunos = scan.nextInt();
        System.out.println("Informe a carga horária do trabalho");
        int cargaHoraria = scan.nextInt();
        return new Trabalho(nome,false,data,numAlunos,cargaHoraria);
    }

    private Estudo criaEstudo(){
        Scanner scan = new Scanner(System.in);
        String nome;
        System.out.println("Informe o nome do estudo: ");
        nome=scan.nextLine();
        ArrayList<Material> materiais = lerMateriais();
        return new Estudo(nome,false,materiais);
    }

    private Prova criaProva(){
        Scanner scan = new Scanner(System.in);
        String nome;
        Calendar data = Calendar.getInstance();
        System.out.println("Informe o nome da prova: ");
        nome=scan.nextLine();
        System.out.println("Informe o ano, mês, dia, hora e minutos da aula respectivamente"+
        "(Separados por espaço): ");
        data.set(scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
        ArrayList<String> conteudos;
        conteudos = lerConteudos();
        return new Prova(nome,true,data,conteudos);
    }

    private ArrayList<Material> lerMateriais(){
        System.out.println("Deseja adicionar um material?(s caso queira)");
        Scanner scan = new Scanner(System.in);
        String opc = scan.next();
        String nome,url;
        ArrayList<Material> lista = new ArrayList<>();
        while(opc.toLowerCase().equals("s")){
            scan.nextLine();
            System.out.println("Digite o nome do material: ");
            nome = scan.nextLine();
            System.out.println("Digite o url do material: ");
            url = scan.nextLine();
            System.out.println("Deseja adicionar outro material?(s caso queira)");
            opc = scan.next();
            Material material = new Material(nome,url);
            lista.add(material);
        }
        return lista;
    }

    private ArrayList<String> lerConteudos(){
        System.out.println("Deseja adicionar um conteúdo?(s caso queira)");
        Scanner scan = new Scanner(System.in);
        String opc = scan.next();
        String nome;
        ArrayList<String> lista = new ArrayList<>();
        while(opc.toLowerCase().equals("s")){
            scan.nextLine();
            System.out.println("Digite o nome do conteúdo: ");
            nome = scan.nextLine();
            System.out.println("Deseja adicionar outro conteúdo?(s caso queira)");
            opc = scan.next();
            lista.add(nome);
        }
        return lista;
    }
}