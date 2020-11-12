package Leitor;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.Serializable;

import Modelo.Atividade;
import Modelo.Estudo;
import Modelo.Trabalho;
import Modelo.Aula;
import Modelo.Prova;
import Modelo.Material;

public class LeitorAtividade extends ILeitor implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private static LeitorAtividade leitor;

    private LeitorAtividade(){}

    public static LeitorAtividade obterInstancia(){
        if (leitor == null){
            leitor = new LeitorAtividade();
            return leitor;
        }
        else return leitor;
    }

    public Atividade busca(int posicao, List<Atividade> atividades){
        if(atividades.size() >= posicao && posicao >= 0 ){
            return atividades.get(posicao);
        }
        return null;
    }

    public Atividade ler(Scanner scan) throws Exception{
        String nome=scan.next();
        String tipo=scan.next();

        if(tipo.equalsIgnoreCase("a"))
            return criaAula(nome, scan);
        if(tipo.equalsIgnoreCase("t"))
            return criaTrabalho(nome, scan);
        if(tipo.equalsIgnoreCase("p"))
            return criaProva(nome, scan);
        if(tipo.equalsIgnoreCase("e"))
            return criaEstudo(nome, scan);

        throw new Exception("Dado inválido: " + tipo + ".");
    }

    private Aula criaAula(String nome, Scanner scan) throws Exception{
        String dataString = scan.next();
        dataString += " " + scan.next();
        Scanner dataScanner = new Scanner(dataString);
        
        Calendar data = Calendar.getInstance();
        int dia[] = new int[5];
        
        dataScanner.useDelimiter("[/ :]");
        for(int idx = 0; idx<5; idx++){
            String elemento = dataScanner.next();
            try {
                dia[idx] = Integer.valueOf(elemento);
            } catch (Exception e) {
                dataScanner.close();
                throw new Exception("Dado inválido: " + elemento + ".");
            }
        }
        dataScanner.close();
        data.set(dia[2],dia[1]-1,dia[0],dia[3],dia[4]);
        scan.nextLine();
        return new Aula(nome,true,data);
    }

    private Trabalho criaTrabalho(String nome, Scanner scan) throws Exception {
        String dataString = scan.next();
        Scanner dataScanner = new Scanner(dataString);
        dataScanner.useDelimiter("/");
        Calendar data = Calendar.getInstance();
        
        int dia[] = new int[3];
        for(int idx = 0; idx<3; idx++){
            String elemento = dataScanner.next();
            try {
                dia[idx] = Integer.valueOf(elemento);
            } catch (Exception e) {
                dataScanner.close();
                throw new Exception("Dado inválido: " + elemento + ".");
            }
        }
        dataScanner.close();
        data.set(dia[2],dia[1]-1,dia[0]);
        
        scan.next();
        scan.next();
        int numAlunos = 0, cargaHoraria = 0;
        String aux;
        try{
            aux = scan.next();
            numAlunos = Integer.valueOf(aux);
        } catch (Exception e){
            throw new Exception("Dado inválido: " + scan.next() + ".");
        }
        try{
            aux = scan.next();
            cargaHoraria = Integer.valueOf(aux);
        } catch (Exception e){
            throw new Exception("Dado inválido: " + scan.next() + ".");
        }
        scan.nextLine();
        return new Trabalho(nome,false,data,numAlunos,cargaHoraria);
    }

    private Estudo criaEstudo(String nome, Scanner scan){
        scan.next();
        scan.next();
        ArrayList<Material> materiais = lerMateriais(new Scanner(scan.next()));
        scan.nextLine();
        return new Estudo(nome,false,materiais);
    }

    private Prova criaProva(String nome, Scanner scan) throws Exception {
        String dataString = scan.next();
        dataString += " ";
        dataString += scan.next();
        Scanner dataScanner = new Scanner(dataString);
        
        Calendar data = Calendar.getInstance();
                
        int dia[] = new int[5];
        
        dataScanner.useDelimiter("[/ :]");
        for(int idx = 0; idx<5; idx++){
            String elemento = dataScanner.next();
            try {
                dia[idx] = Integer.valueOf(elemento);
            } catch (Exception e) {
                dataScanner.close();
                throw new Exception("Dado inválido: " + elemento + ".");
            }
        }
        dataScanner.close();
        data.set(dia[2],dia[1]-1,dia[0],dia[3],dia[4]);
        ArrayList<String> conteudos;
        conteudos = lerConteudos(new Scanner(scan.next()));
        scan.nextLine();
        return new Prova(nome,true,data,conteudos);
    }

    private ArrayList<Material> lerMateriais(Scanner scan){
        String nome,url;
        String materialString = scan.nextLine();
        ArrayList<Material> lista = new ArrayList<>();

        String pattern = "\\[([^\\]]*)\\]\\(([^\\)]*)\\)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(materialString);

        while(m.find()){
            nome = m.group(1);
            url = m.group(2);
            Material material = new Material(nome,url);
            lista.add(material);
        }
        
        return lista;
    }

    private ArrayList<String> lerConteudos(Scanner scan){
        String nome;
        ArrayList<String> lista = new ArrayList<>();

        scan.useDelimiter(".");
        while(scan.hasNext()){
            nome = scan.next();
            if (!nome.isEmpty()){
                lista.add(nome);
            }
        }
        return lista;
    }
}