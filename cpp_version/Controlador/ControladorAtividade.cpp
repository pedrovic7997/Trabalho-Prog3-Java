#include "ControladorAtividade.h"

bool ControladorAtividade :: verificaCadastroAvaliacao(Atividade atividade,Estudante estudante){
    for(Avaliacao avaliacao : atividade.obterAvaliacoes())
        if(avaliacao.obterAluno()->obterMatricula == estudante.obterMatricula())
            return true;
    return false;
}

void ControladorAtividade :: ler(ifstream scan){
    LeitorAtividade leitor = LeitorAtividade.obterInstancia();
    ControladorDisciplina controlador = new ControladorDisciplina();
		
    while(!scan.eof()){
        string codigoDisc;
        scan >>codigoDisc;
        try{
            Disciplina disciplina = controlador.busca(codigoDisc);
        }
        catch{
            throw bad_typeid("Referência inválida: "+codigoDisc+".");
        }
        Atividade atividade = leitor.ler(scan);
        disciplina.anexaAtividade(atividade);
    }
}

void ControladorAtividade :: lerAvaliacao(ifstream scan){
    ControladorDisciplina cDisciplina = new ControladorDisciplina();
    ControladorEstudante cEstudante = new ControladorEstudante();
    LeitorAtividade lAtividade = LeitorAtividade.obterInstancia();
    LeitorAvaliacao lAvaliacao = LeitorAvaliacao.obterInstancia();

    while(scan.hasNext()){
        string codigoDisc;
        scan >>codigoDisc;
        String matricula = scan.next().trim();
        try{
            Disciplina disciplina = cDisciplina.busca(codigoDisc);

        }
        catch{
            throw bad_typeid("Referência inválida: "+codigoDisc+".");
        }
        try{
            Estudante estudante = cEstudante.busca(matricula);

        }
        catch{
            throw bad_typeid("Referência inválida: "+matricula+".");
        }
        
        int codigoAtiv = scan.nextInt();
        Atividade atividade = lAtividade.busca(codigoAtiv-1, disciplina.obterAtividades());
        Avaliacao avaliacao = lAvaliacao.ler(scan, estudante);
        if(verificaCadastroAvaliacao(atividade, estudante))
            throw exception("Avaliação repetida: estudante "+estudante.obterMatricula()+ 
                                " para atividade " +codigoAtiv +" de "+disciplina.obterCodigo()+"-"+
                                disciplina.obterPeriodo().obterCodigo()+".");
        atividade.anexaAvaliacao(avaliacao);
    }
}