public class Periodo {
    private int ano;
    private char semestre;
    private String codigo;

    public Periodo(int ano, char semestre) {
        this.ano = ano;
        this.semestre = semestre;
        this.codigo = String.valueOf(ano) + "/" + semestre;
    }

    int obterAno() {
        return ano;
    }

    char obterSemestre() {
        return semestre;
    }

    String obterCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Periodo: " + codigo;
    }
}