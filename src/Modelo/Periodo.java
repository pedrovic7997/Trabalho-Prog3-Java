package Modelo;

import java.io.Serializable;

public class Periodo implements Serializable, Comparable<Periodo>{
    private int ano;
    private char semestre;
    private String codigo;

    public Periodo(int ano, char semestre) {
        this.ano = ano;
        this.semestre = semestre;
        this.codigo = String.valueOf(ano) + "/" + semestre;
    }

    public int obterAno() {
        return ano;
    }

    public char obterSemestre() {
        return semestre;
    }

    public String obterCodigo() {
        return codigo;
    }

    @Override
    public int compareTo(Periodo arg0) {
        return codigo.compareTo(arg0.codigo);
    }

    @Override
    public String toString() {
        return "Periodo: " + codigo;
    }
}