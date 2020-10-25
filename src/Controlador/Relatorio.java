package Controlador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;

import Modelo.Atividade;
import Modelo.Avaliacao;
import Modelo.Disciplina;
import Modelo.Docente;
import Modelo.Estudante;
import Modelo.Periodo;
import Modelo.Prova;
import Modelo.Trabalho;
import Leitor.LeitorPeriodo;
import Leitor.LeitorDisciplina;
import Leitor.LeitorDisciplinaEstudante;
import Leitor.LeitorDocente;
import Leitor.LeitorEstudante;
import Leitor.LeitorAvaliacao;

public class Relatorio{

    public void panoramaPeriodo(){
        LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();

        System.out.println("------------------------");
        System.out.println("Períodos cadastrados:");
        lPeriodo.listar();
        System.out.println("\nEntre com o período desejado: ");
        Scanner scanner = new Scanner(System.in);
        String codigo = scanner.nextLine();

        Periodo periodo = lPeriodo.busca(codigo);
        LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
        ArrayList<Disciplina> list = lDisciplina.busca(periodo);
        Collections.sort(list, new Comparator<Disciplina>(){
            @Override
            public int compare(Disciplina disc1, Disciplina disc2){
                return disc1.obterNome().toLowerCase().compareTo(disc2.obterNome().toLowerCase());
            }
        });

        LeitorDisciplinaEstudante lDisciplinaEstudante = LeitorDisciplinaEstudante.obterInstancia();

        System.out.println("------------------------");
        System.out.println("Disciplinas achadas: ");
        for(Disciplina d : list){
            ArrayList<Estudante> list2 = lDisciplinaEstudante.busca(d);
            System.out.println(d.obterCodigo() + " - " + d.obterNome() +
                                " - Professor(a): " + d.obterDocente().obterNome() +
                                " -> " + d.obterDocente().obterLogin() + "@ufes.br - " +
                                list2.size() + " estudantes - " +
                                d.obterAtividades().size() + " atividades");
        }

    }

    public void estatisticaDocentes(){
        LeitorDocente lDocente = LeitorDocente.obterInstancia();
        LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();

        System.out.println("------------------------");
        System.out.println("Estatística dos docentes:");
        Set<String> loginsDocentes = lDocente.obterChaves();
        String[][] estatistica = new String[loginsDocentes.size()][6];
        int count = 0;
        for(String login : loginsDocentes){
            
            ArrayList<Disciplina> disciplinas = lDisciplina.busca(lDocente.busca(login));
            ArrayList<Periodo> periodos = new ArrayList<>();
            Boolean possui = false;
            int numAtividadesTotal = 0;
            int numAvaliacoesTotal = 0;
            int numAtividadesSincronas = 0;
            double notaTotal = 0;

            estatistica[count][0] = lDocente.busca(login).obterNome();
            estatistica[count][1] = String.valueOf(disciplinas.size());

            for(int i=0; i<disciplinas.size(); i++){

                for(int j=0; j<periodos.size() && !possui; j++){
                    if(disciplinas.get(i).obterPeriodo() == periodos.get(j)){
                        possui = true;
                    }
                }
                if(!possui){
                    periodos.add(disciplinas.get(i).obterPeriodo());
                }

                ArrayList<Atividade> listaAtividades =  disciplinas.get(i).obterAtividades();
                numAtividadesTotal += listaAtividades.size();

                for(Atividade ativ : listaAtividades){
                    if(ativ.obterSincrona()){
                        numAtividadesSincronas++;
                    }
                    
                    numAvaliacoesTotal += ativ.obterAvaliacoes().size();
                    for(Avaliacao aval : ativ.obterAvaliacoes()){
                        notaTotal += aval.obterNota();
                    }

                }
            }
            estatistica[count][2] = String.valueOf(periodos.size());
            if(disciplinas.size()!=0)
                estatistica[count][3] = Double.toString(numAtividadesTotal/disciplinas.size());
            else 
                estatistica[count][3] = "0.0";
            if(numAtividadesTotal!=0)
                estatistica[count][4] = Integer.toString(Math.round(((float)numAtividadesSincronas/(float)numAtividadesTotal)*100));
            else
                estatistica[count][4] = "0";
            if(numAvaliacoesTotal!=0)
                estatistica[count][5] = Double.toString(notaTotal/numAvaliacoesTotal);
            else
                estatistica[count][5] = "0.0";
            count++;
        }

        Arrays.sort(estatistica, new Comparator<String[]>(){
            @Override
            public int compare(String[] nome1, String[] nome2){
                return nome2[0].toLowerCase().compareTo(nome1[0].toLowerCase());
            }
        });

        for(int i=0; i<count; i++){

            System.out.printf("%s - %s disciplinas - %s períodos cadastrados - %s atividades/disciplinas - %s%% síncronas x %d%% assíncronas - Média de notas: %s\n", 
                                estatistica[i][0], estatistica[i][1], estatistica[i][2], estatistica[i][3], estatistica[i][4], 100 - Integer.valueOf(estatistica[i][4]), estatistica[i][5]);

            // System.out.println(estatistica[i][0] + " - " + estatistica[i][1] + " disciplinas - " + 
            //                     estatistica[i][2] + " períodos cadastrados - " + estatistica[i][3] + " atividades/disciplina - " +
            //                     estatistica[i][4] + "% síncronas x " + Double.valueOf(estatistica[i][4]) + "% assíncronas - " + 
            //                     "Média de notas: " + estatistica[i][5]);
        }
    }
    
    public void estatisticaEstudantes(){
        LeitorEstudante lEstudante = LeitorEstudante.obterInstancia();
        LeitorDisciplinaEstudante lDisLeitorEstudante = LeitorDisciplinaEstudante.obterInstancia();
        LeitorAvaliacao lAvaliacao = LeitorAvaliacao.obterInstancia();
        System.out.println("------------------------");
        System.out.println("Estatística dos estudantes:");
        Set<Integer> matriculasEstudantes = lEstudante.obterChaves();
        double[][] estatistica = new double[matriculasEstudantes.size()][5];
        int count = 0;
        for(int matricula : matriculasEstudantes){
            Estudante estudante = lEstudante.busca(matricula);
            ArrayList<Disciplina> disciplinas =  lDisLeitorEstudante.busca(estudante);
            double mediaTotal = 0;
            int qtdAvaliacoes = 0;
            ArrayList<Periodo> periodos = new ArrayList<>();
            ArrayList<Integer> somatorioMateriasPeriodo = new ArrayList<>();
            Boolean possui= false;
            estatistica[count][0] = matricula;
            for(int i=0; i<disciplinas.size(); i++){

                for(int j=0; j<periodos.size() && !possui; j++){
                    if(disciplinas.get(i).obterPeriodo() == periodos.get(j)){
                        possui = true;
                    }
                }
                if(!possui){
                    periodos.add(disciplinas.get(i).obterPeriodo());
                }
                ArrayList<Atividade> atividades =disciplinas.get(i).obterAtividades();
                for(int j = 0; j< atividades.size(); j++){
                    ArrayList<Avaliacao> avaliacoes = lAvaliacao.busca(atividades.get(j).obterAvaliacoes(),estudante);
                    qtdAvaliacoes += avaliacoes.size();
                    for(Avaliacao avaliacao : avaliacoes){
                        mediaTotal+= avaliacao.obterNota();
                    }
                }
            }
            if(periodos.size() != 0)
                estatistica[count][1] = disciplinas.size()/periodos.size();
            else estatistica[count][1] = 0;
            if(disciplinas.size() != 0)
                estatistica[count][2] = qtdAvaliacoes/disciplinas.size();
            else estatistica[count][2] = 0;
            if(qtdAvaliacoes != 0)
                estatistica[count][3] = mediaTotal/qtdAvaliacoes;
            else estatistica[count][3] = 0;
            estatistica[count][4] = qtdAvaliacoes;
            count++;
        }
        Arrays.sort(estatistica, new Comparator<double[]>(){
            @Override
            public int compare(double[] aluno1, double[] aluno2){
                if(aluno1[4] == aluno2[4])
                    return lEstudante.busca((int)aluno1[0]).obterNome().toLowerCase().compareTo(
                                    lEstudante.busca((int)aluno1[0]).obterNome().toLowerCase());
                return (int) (aluno1[4]-aluno2[4]);
            }
        });
        for(int i=0; i<count; i++){
            int matricula = (int)estatistica[i][0];
            System.out.printf("%d - %s - Media de disciplinas matriculado: %.2f - Media de avaliaçoes realizadas: %.2f - Media de notas: %.2f\n"
                                    , matricula, lEstudante.busca(matricula),
                                        estatistica[i][1], estatistica[i][2], estatistica[i][3]);
        }
    }

    public void estatisticaDisciplinasDocente(){
        Scanner scan = new Scanner(System.in);
        LeitorDocente lDocente = LeitorDocente.obterInstancia();
        LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
        System.out.println("------------------------");
        System.out.println("Docentes cadastrados:");
        lDocente.listar();
        System.out.println("\nEntre com o docente desejado: ");
        Docente docente = lDocente.busca(scan.nextLine());
        ArrayList<Disciplina> disciplinas =lDisciplina.busca(docente);
        String[][] estatistica = new String[disciplinas.size()][5];
        int count=0;
        for (Disciplina disciplina : disciplinas) {
            estatistica[count][0] = disciplina.obterCodigo()+"-"+disciplina.obterPeriodo().obterAno()+
                                            "/"+disciplina.obterPeriodo().obterSemestre();
            estatistica[count][1] = String.valueOf(disciplina.obterAtividades().size());
            if(disciplina.obterAtividades().size() != 0){
                int sincronas = Math.round(((float)disciplina.obterSincronas()/(float)disciplina.obterAtividades().size())*100);
                estatistica[count][2] = Integer.toString(sincronas);
            }
            else {
                estatistica[count][2] = "0";
            }
            estatistica[count][3] = String.valueOf(disciplina.obterCargaHoraria());
            estatistica[count][4] = String.valueOf(disciplina.obterAvalitiva());
            count++;
        }
        Arrays.sort(estatistica, new Comparator<String[]>(){
            @Override
            public int compare(String[] disc, String[] disc2){
                Periodo periodo1, periodo2;
                periodo1 = lDisciplina.busca(disc[0]).obterPeriodo();
                periodo2 = lDisciplina.busca(disc2[0]).obterPeriodo();
                if( periodo1.obterCodigo().compareTo(periodo2.obterCodigo()) == 0){
                    return disc[0].toLowerCase().compareTo(disc2[0].toLowerCase());
                }
                return periodo1.obterCodigo().compareTo(periodo2.obterCodigo());
            }
        });
        for(int x = 0; x < count; x++){
            int assinc =  100-Integer.valueOf(estatistica[x][2]);
            Disciplina d =lDisciplina.busca(estatistica[x][0]);
            System.out.println("Periodo: "+ d.obterPeriodo().obterCodigo() + " - Codigo: " + 
                                d.obterCodigo() + " - Nome: "+d.obterNome() + " Atividades: " + 
                                estatistica[x][1]+" - Sincronas " + estatistica[x][2]+ "% x "+ assinc
                                +"% Assincronas - Carga Horaria: "+ estatistica[x][3]
                                +"% - Quantidade de atividades avaliativas: "+ estatistica[x][4] +
                                "\nAtividades avaliativas:");
            for(Atividade a : d.obterAtividades()){
                if(a instanceof Trabalho || a instanceof Prova){
                    System.out.println(a);
                }
            }
            System.out.println("");
        }
    }
}
