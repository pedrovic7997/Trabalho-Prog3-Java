public class Avaliacao {
    private Estudante aluno;
    private float nota;

    public Avaliacao(Estudante aluno, float nota) {
        this.aluno = aluno;
        this.nota = nota;
    }

    Estudante obterAluno() {
        return aluno;
    }

    float obterNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Aluno: " + aluno.obterMatricula() + " - Nota: " + nota;
    }
}