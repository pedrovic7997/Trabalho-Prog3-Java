package Modelo;

import java.io.Serializable;

public class Periodo implements Serializable{
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
    public String toString() {
        return "Periodo: " + codigo;
    }
}