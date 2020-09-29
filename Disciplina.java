import java.util.*;

public class Disciplina {
    private String codigo;
    private String nome;
    private Periodo periodo;
    private Docente professor;
    private List<Atividade> atividades;
    private List<Estudante> alunos;

    public Disciplina(String codigo, String nome, Periodo periodo, Docente professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.periodo = periodo;
        this.professor = professor;
        atividades = new ArrayList<Atividade>();
        alunos = new ArrayList<>();
    }

    String obterCodigo() {
        return codigo;
    }

    String obterNome() {
        return nome;
    }

    Periodo obterPeriodo() {
        return periodo;
    }

    Docente obterDocente() {
        return professor;
    }

    public void anexaAtividade(Atividade atividade){
        atividades.add(atividade);
    }

    public void anexaEstudante(Estudante estudante){
        alunos.add(estudante);
    }

    public List<Atividade> obterAtividades(){
        return atividades;
    }

    public List<Estudante> obterEstudantes(){
        return alunos;
    }

    public void listaEstudante(){
        for(Estudante e : alunos){
            System.out.println(e);
        }
    }

    public Estudante buscaEstudante(int matricula){
        for(Estudante e : alunos){
            if(e.obterMatricula() == matricula){
                return e;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Codigo: "+ codigo +" - Nome: "+ nome + 
        " - Professor: "+ professor.obterNome() + " - Periodo: " + periodo.obterAno() + "/" +periodo.obterSemestre();
    }

}