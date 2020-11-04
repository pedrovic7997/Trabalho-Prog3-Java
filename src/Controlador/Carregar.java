package Controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Leitor.LeitorDisciplina;
import Leitor.LeitorDisciplinaEstudante;
import Leitor.LeitorDocente;
import Leitor.LeitorEstudante;
import Leitor.LeitorPeriodo;

public class Carregar{
    private boolean read;
    private boolean write;

    public Carregar(){
        read = true;
        write = true;
    }

    private void carregaEstudantes(ObjectInputStream entrada)throws Exception{
        LeitorEstudante leitor = (LeitorEstudante)entrada.readObject();
        LeitorEstudante.setInstancia(leitor);
    }

    private void carregaDocente(ObjectInputStream entrada)throws Exception{
        LeitorDocente leitor = (LeitorDocente)entrada.readObject();
        LeitorDocente.setInstancia(leitor);
    }

    private void carregaDisciplina(ObjectInputStream entrada)throws Exception{
        LeitorDisciplina leitor = (LeitorDisciplina)entrada.readObject();
        LeitorDisciplina.setInstancia(leitor);
    }

    private void carregaDisciplinaEstudante(ObjectInputStream entrada)throws Exception{
        LeitorDisciplinaEstudante leitor = (LeitorDisciplinaEstudante)entrada.readObject();
        LeitorDisciplinaEstudante.setInstancia(leitor);
    }

    private void carregaPeriodo(ObjectInputStream entrada)throws Exception{
        LeitorPeriodo leitor = (LeitorPeriodo)entrada.readObject();
        LeitorPeriodo.setInstancia(leitor);
    }

    public void carregaDados(String caminho) {
        
        try {
            FileInputStream arq = new FileInputStream(caminho);
            ObjectInputStream entrada = new ObjectInputStream(arq);
            carregaEstudantes(entrada);
            carregaDocente(entrada);
            carregaDisciplinaEstudante(entrada);
            carregaPeriodo(entrada);
            carregaDisciplina(entrada);
            entrada.close();
        } catch (Exception e) {
            System.out.println("Erro de I/O.");
        }
        
    }



    private void csvCarregaEstudantes(String entrada) throws Exception{
        FileInputStream arq = new FileInputStream(entrada);
        LeitorEstudante leitor = ;
        LeitorEstudante.setInstancia(leitor);
    }

    private void csvCarregaDocente(String entrada) throws Exception{
        LeitorDocente leitor = ;
        LeitorDocente.setInstancia(leitor);
    }

    private void csvCarregaDisciplina(String entrada) throws Exception{
        LeitorDisciplina leitor = ;
        LeitorDisciplina.setInstancia(leitor);
    }

    private void csvCarregaDisciplinaEstudante(String entrada) throws Exception{
        LeitorDisciplinaEstudante leitor = ;
        LeitorDisciplinaEstudante.setInstancia(leitor);
    }

    private void csvCarregaPeriodo(String entrada) throws Exception{
        LeitorPeriodo leitor = ;
        LeitorPeriodo.setInstancia(leitor);
    }

    private void csvCarregaAtividade(String entrada){

    }

    private void csvCarregaAvaliacao(String entrada){
        
    }

    public void csvCarregaDados(ArrayList<String> arquivos) throws Exception{
        
        try {
            if(arquivos.get(0) != null)
                csvCarregaPeriodo(arquivos.get(0));
            if(arquivos.get(1) != null)
                csvCarregaDocente(arquivos.get(1));
            if(arquivos.get(2) != null)
                csvCarregaDisciplina(arquivos.get(2));
            if(arquivos.get(3) != null)
                csvCarregaEstudantes(arquivos.get(3));
            if(arquivos.get(4) != null)
                csvCarregaDisciplinaEstudante(arquivos.get(4));
            if(arquivos.get(5) != null)
                csvCarregaAtividade(arquivos.get(5));
            if(arquivos.get(6) != null)
                csvCarregaAvaliacao(arquivos.get(6));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        
    }


    public void teste(String args[]){
        System.out.println(args.length);
        String arqPeriodo=null, arqDocente=null, arqDisciplina=null, arqEstudantes=null, arqMatriculas=null, arqAtividades=null, arqAvaliacoes=null;
        ArrayList<String> arquivos = new ArrayList<>();
                
        for (int i = 0; i < args.length; i++){
            
            switch (args[i]) {
                case "-p":
                    arqPeriodo = args[++i];
                    break;

                case "-d":
                    arqDocente = args[++i];
                    break;

                case "-o":
                    arqDisciplina = args[++i];
                    break;

                case "-e":
                    arqEstudantes = args[++i];
                    break;

                case "-m":
                    arqMatriculas = args[++i];
                    break;

                case "-a":
                    arqAtividades = args[++i];
                    break;

                case "-n":
                    arqAvaliacoes = args[++i];
                    break;

                case "--read-only":
                    // System.out.println(args[i] + " dados.dat ");
                    write = false;
                    break;

                case "--write-only":
                    // System.out.println(args[i] + " dados.dat ");
                    read = false;
                    break;
            
                default:
                    break;
            }
        }

        arquivos.add(arqPeriodo);
        arquivos.add(arqDocente);
        arquivos.add(arqDisciplina);
        arquivos.add(arqEstudantes);
        arquivos.add(arqMatriculas);
        arquivos.add(arqAtividades);
        arquivos.add(arqAvaliacoes);

        if(read){

        }
        if(write){

        }
    }
}
