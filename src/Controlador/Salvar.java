package Controlador;

import java.io.*;

import Leitor.LeitorDisciplina;
import Leitor.LeitorDisciplinaEstudante;
import Leitor.LeitorDocente;
import Leitor.LeitorEstudante;
import Leitor.LeitorPeriodo;

public class Salvar {
    private void salvaEstudantes( ObjectOutputStream saida) throws IOException{
        saida.writeObject(LeitorEstudante.obterInstancia());
    }

    private void salvaDocente( ObjectOutputStream saida ) throws IOException{
        saida.writeObject(LeitorDocente.obterInstancia());
    }

    private void salvaDisciplina(ObjectOutputStream saida ) throws IOException{
        saida.writeObject(LeitorDisciplina.obterInstancia());
    }

    private void salvaDisciplinaEstudante( ObjectOutputStream saida ) throws IOException{
        saida.writeObject(LeitorDisciplinaEstudante.obterInstancia());
    }

    private void salvaPeriodo( ObjectOutputStream saida ) throws IOException{
        saida.writeObject(LeitorPeriodo.obterInstancia());
    }

    public void salvaDados(String caminho) {

        try {
            FileOutputStream arq = new FileOutputStream(caminho);
            ObjectOutputStream saida = new ObjectOutputStream(arq);
            salvaEstudantes(saida);
            salvaDocente(saida);
            salvaDisciplinaEstudante(saida);
            salvaPeriodo(saida);
            salvaDisciplina(saida);
            saida.close();
        } catch (Exception e) {
            System.out.println("Erro de I/O.");
        }
    }
}
