public class Docente {
    private String login;
    private String nome;
    private String paginaWeb;

    public Docente(String login, String nome) {
        this.login = login;
        this.nome = nome;
        paginaWeb = null;
    }

    public Docente(String login, String nome, String paginaWeb) {
        this.login = login;
        this.nome = nome;
        this.paginaWeb = paginaWeb;
    }

    String obterLogin() {
        return login;
    }

    String obterNome() {
        return nome;
    }

    String obterPaginaWeb() {
        return paginaWeb;
    }

    @Override
    public String toString() {
        if(paginaWeb == null)
            return "Nome: " + nome + " - Login: " + login;
        else
        return "Nome: " + nome + " - Login: " + login + " - Site: "+ paginaWeb; 
    }
}