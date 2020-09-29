import java.util.ArrayList;
import java.util.List;

public class Atividade {
    private String nome;
    private Boolean sincrona;
    private List<Avaliacao> avaliacoes;

    public Atividade(String nome, Boolean sincrona) {
        this.nome = nome;
        this.sincrona = sincrona;
        this.avaliacoes = new ArrayList<>();
    }

    Boolean obterSincrona() {
        return sincrona;
    }

    String obterNome() {
        return nome;
    }

    List<Avaliacao> obterAvaliacoes() {
        return avaliacoes;
    }

    public void anexaAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }

    @Override
    public String toString() {
        if (sincrona) return "Nome: " + nome + " - Sincrona";
        else return "Nome: " + nome + " - Assincrona";
    }
}