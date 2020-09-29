public class Estudante {
    private int matricula;
    private String nome;

    public Estudante(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    int obterMatricula() {
        return matricula;
    }

    String obterNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " - Matricula: " + matricula;
    }
}