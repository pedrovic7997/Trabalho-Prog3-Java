package Controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import Leitor.LeitorDisciplina;
import Leitor.LeitorDisciplinaEstudante;
import Leitor.LeitorDocente;
import Leitor.LeitorEstudante;
import Leitor.LeitorPeriodo;

public class Carregar{
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
}
