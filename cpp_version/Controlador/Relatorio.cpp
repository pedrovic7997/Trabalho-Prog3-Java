#include <algorithm>

#include "Relatorio.h"

using namespace cpp_util;

void panoramaPeriodo(){
    ControladorPeriodo cPeriodo;
    ControladorDisciplina cDisciplina;

    vector<Periodo*> periodos = cPeriodo.lista();
    ofstream out("1-visao-geral.csv");
    out << "Período;Código Disciplina;Disciplina;Docente Responsável;E-mail Docente;Qtd. Estudantes;Qtd. Atividades"<< endl;
    sort(periodos.begin(),periodos.end(),Periodo :: compara);
    for(Periodo* periodo : periodos){
        vector<Disciplina*> disciplinas = cDisciplina.lista(periodo);
        sort(disciplinas.begin(),disciplinas.end(),Disciplina :: comparaNome);
        for(Disciplina* disciplina : disciplinas){
            int qtdEstudante = cDisciplina.lista(disciplina).size();
            out << periodo->obterCodigo() <<";" <<disciplina->obterCodigo() <<";"; 
            out << disciplina->obterNome() <<";"<<disciplina->obterDocente()->obterNome(); 
            out <<";" << disciplina->obterDocente()->obterLogin() <<"@ufes.br;" <<qtdEstudante;
            out << disciplina->obterAtividades().size()<< endl;
        }
    }
}

void estatisticaDocentes(){
    ControladorDocente cDocente;
    vector<Docente*> docentes = cDocente.lista();
    sort(docentes.begin(),docentes.end(),Docente :: compara);

    FILE* file = fopen("2-docentes.csv","w");
    fprintf(file,"Docente;Qtd. Disciplinas;Qtd. Períodos;Média Atividades/Disciplina;% Síncronas;% Assíncronas;Média de Notas");
    for(Docente* docente : docentes){
        fprintf(file,"%s;%d;%d;%.1f;%.0f%%;%.0f%%;%.1f\n",docente->obterNome().c_str(),docente->contaDisciplinas(),docente->contaPeriodos(),docente->mediaAtividadesPorDiciplina(),
                                                    docente->percentualAtividadesSincronas(),docente->percentualAtividadesAssincronas(),docente->mediaNotasRecebidas());
    }
}

void estatisticaEstudantes(){
    ControladorEstudante cEstudante;
    vector<Estudante*> estudantes = cEstudante.lista();
    sort(estudantes.begin(),estudantes.end(),Estudante::compara);

    FILE* file = fopen("3-estudantes.csv","w");
    fprintf(file,"");
    for(Estudante *estudante: estudantes){
        fprintf(file,"%s;%s;%.1f;%.1f;%.1f\n",estudante->obterMatricula(),estudante->obterNome(),estudante->mediaDiciplinasPorPeriodo(),
                                            estudante->mediaAvaliacoes(),estudante->mediaNotas());
    }
}

void estatisticaDisciplinasDocente(){
    ControladorDisciplina cDisciplina;
    vector<Disciplina*> disciplinas = cDisciplina.lista();
    sort(disciplinas.begin(),disciplinas.end(),Disciplina::compara);
    FILE* file = fopen("4-disciplinas.csv","w");
    for(Disciplina *disciplina : disciplinas){
        string datas ="";
        vector<Atividade*> atividades = disciplina->obterAtividades();
        sort(atividades.begin(),atividades.end(),Atividade :: compara);
        for(Atividade *atividade : atividades){
            datas+=formatDate(atividade->obterData(),DATE_FORMAT_PT_BR_SHORT);
            datas+=" ";
        }
        datas = trim(datas);
        fscanf(file,"%s;%s;%s;%s;%d;%.0f%%;%.0f%%;%d;%s\n",disciplina->obterDocente()->obterLogin(),disciplina->obterPeriodo()->obterCodigo(),
                                                            disciplina->obterCodigo(),disciplina->obterNome(),disciplina->obterAtividades().size(),
                                                            disciplina->percentualAtividadesSincronas(),disciplina->percentualAtividadesAssincronas(),
                                                            disciplina->obterCargaHoraria(),datas);
    }
}

void Relatorio :: escreveRelatorios(){
    panoramaPeriodo();
    estatisticaDocentes();
    estatisticaEstudantes();
    estatisticaDisciplinasDocente();
}