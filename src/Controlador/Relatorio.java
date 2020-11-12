package Controlador;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.SuppressWarnings;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

import Modelo.*;
import Leitor.LeitorPeriodo;
import Leitor.LeitorDisciplina;
import Leitor.LeitorDisciplinaEstudante;
import Leitor.LeitorDocente;
import Leitor.LeitorEstudante;
import Leitor.LeitorAvaliacao;

@SuppressWarnings(value = {"unchecked"})

public class Relatorio implements IControlador {

    public void escreveRelatorios() throws Exception {
        panoramaPeriodo();
        estatisticaDocentes();
        estatisticaEstudantes();
        estatisticaDisciplinasDocente();
    }

    public void panoramaPeriodo() throws IOException {
        LeitorPeriodo lPeriodo = LeitorPeriodo.obterInstancia();

        ArrayList<Periodo> periodos = new ArrayList<>();
        for (String codigo : lPeriodo.obterHash().keySet()) {
            periodos.add(lPeriodo.busca(codigo));
        }
        Collections.sort(periodos);

        LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
        LeitorDisciplinaEstudante lDisciplinaEstudante = LeitorDisciplinaEstudante.obterInstancia();

        String output;
        output = "Período;Código Disciplina;Disciplina;Docente Responsável;E-mail Docente;Qtd. Estudantes;Qtd. Atividades";

        for (Periodo periodo : periodos) {
            ArrayList<Disciplina> list = lDisciplina.busca(periodo);
            Collections.sort(list);
            for (Disciplina d : list) {
                ArrayList<Estudante> list2 = lDisciplinaEstudante.busca(d);
                output += "\n" + periodo.obterCodigo() + ";" + d.obterCodigo()
                        + ";" + d.obterNome()
                        + ";" + d.obterDocente().obterNome()
                        + ";" + d.obterDocente().obterLogin() + "@ufes.br;"
                        + list2.size() + ";"
                        + d.obterAtividades().size();
            }
        }
        output += "\n";

        FileWriter arquivo = new FileWriter("1-visao-geral.csv");
        arquivo.write(output);
        arquivo.close();

    }

    public void estatisticaDocentes() throws IOException {
        LeitorDocente lDocente = LeitorDocente.obterInstancia();
        LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();

        Set<String> loginsDocentes = lDocente.obterChaves();
        String[][] estatistica = new String[loginsDocentes.size()][7];
        int count = 0;

        for (String login : loginsDocentes) {

            ArrayList<Disciplina> disciplinas = lDisciplina.busca(lDocente.busca(login));
            ArrayList<Periodo> periodos = new ArrayList<>();
            Boolean possui = false;
            int numAtividadesTotal = 0;
            int numAvaliacoesTotal = 0;
            int numAtividadesSincronas = 0;
            double notaTotal = 0;

            estatistica[count][0] = lDocente.busca(login).obterNome();
            estatistica[count][1] = String.valueOf(disciplinas.size());

            for (int i = 0; i < disciplinas.size(); i++) {

                Disciplina disciplina = disciplinas.get(i);
                numAtividadesSincronas += disciplina.obterSincronas();
                numAtividadesTotal += disciplina.obterAtividades().size();
                notaTotal += disciplina.obterNotaTotal();
                numAvaliacoesTotal += disciplina.obterAvaliacoesTotal();

                for (int j = 0; j < periodos.size() && !possui; j++) {
                    if (disciplina.obterPeriodo() == periodos.get(j)) {
                        possui = true;
                    }
                }
                if (!possui) {
                    periodos.add(disciplina.obterPeriodo());
                }
            }
            estatistica[count][2] = String.valueOf(periodos.size());
            if (disciplinas.size() != 0) {
                float valor = (float) numAtividadesTotal / disciplinas.size();
                DecimalFormat df = new DecimalFormat("#0.0");
                estatistica[count][3] = df.format(valor);
            } else {
                estatistica[count][3] = "0,0";
            }
            if (numAtividadesTotal != 0) {
                int sincronas = Math.round(((float) numAtividadesSincronas / (float) numAtividadesTotal) * 100);
                estatistica[count][4] = Integer.toString(sincronas);
                estatistica[count][6] = Integer.toString(100 - sincronas);
            } else {
                estatistica[count][4] = "0";
                estatistica[count][6] = "0";
            }
            if (numAvaliacoesTotal != 0) {
                float valor = (float) notaTotal / numAvaliacoesTotal;
                DecimalFormat df = new DecimalFormat("#0.0");
                estatistica[count][5] = df.format(valor);
            } else {
                estatistica[count][5] = "0,0";
            }
            count++;
        }

        Arrays.sort(estatistica, new Comparator<String[]>() {
            @Override
            public int compare(String[] nome1, String[] nome2) {
                return nome2[0].toLowerCase().compareTo(nome1[0].toLowerCase());
            }
        });

        String output;
        output = "Docente;Qtd. Disciplinas;Qtd. Períodos;Média Atividades/Disciplina;% Síncronas;% Assíncronas;Média de Notas";

        for (int i = 0; i < count; i++) {
            output += "\n" + estatistica[i][0] + ";" + estatistica[i][1] + ";" + estatistica[i][2] + ";" + estatistica[i][3] + ";" + estatistica[i][4] + "%;" + estatistica[i][6] + "%;" + estatistica[i][5];
        }
        output += "\n";

        FileWriter arquivo = new FileWriter("2-docentes.csv");
        arquivo.write(output);
        arquivo.close();

    }

    public void estatisticaEstudantes() throws IOException {
        LeitorEstudante lEstudante = LeitorEstudante.obterInstancia();
        LeitorDisciplinaEstudante lDisLeitorEstudante = LeitorDisciplinaEstudante.obterInstancia();
        LeitorAvaliacao lAvaliacao = LeitorAvaliacao.obterInstancia();

        Set<String> matriculasEstudantes = lEstudante.obterChaves();
        String[][] estatistica = new String[matriculasEstudantes.size()][5];
        int count = 0;
        for (String matricula : matriculasEstudantes) {

            Estudante estudante = lEstudante.busca(matricula);
            ArrayList<Disciplina> disciplinas = lDisLeitorEstudante.busca(estudante);
            double mediaTotal = 0;
            int qtdAvaliacoes = 0;
            ArrayList<Periodo> periodos = new ArrayList<>();
            Boolean possui = false;

            estatistica[count][0] = matricula;
            if (disciplinas != null) {
                for (int i = 0; i < disciplinas.size(); i++) {

                    for (Periodo periodo : periodos) {
                        if (disciplinas.get(i).obterPeriodo() == periodo) {
                            possui = true;
                            break;
                        }
                    }
                    if (!possui) {
                        periodos.add(disciplinas.get(i).obterPeriodo());
                    }
                    ArrayList<Atividade> atividades = disciplinas.get(i).obterAtividades();
                    for (int j = 0; j < atividades.size(); j++) {
                        ArrayList<Avaliacao> avaliacoes = lAvaliacao.busca(atividades.get(j).obterAvaliacoes(), estudante);
                        qtdAvaliacoes += avaliacoes.size();
                        for (Avaliacao avaliacao : avaliacoes) {
                            mediaTotal += avaliacao.obterNota();
                        }
                    }
                }
            }

            if (periodos.size() != 0) {
                float valor = (float) disciplinas.size() / periodos.size();
                DecimalFormat df = new DecimalFormat("#0.0");
                estatistica[count][1] = df.format(valor);
            } else {
                estatistica[count][1] = "0,0";
            }
            if (disciplinas != null && disciplinas.size() != 0) {
                float valor = (float) qtdAvaliacoes / disciplinas.size();
                DecimalFormat df = new DecimalFormat("#0.0");
                estatistica[count][2] = df.format(valor);
            } else {
                estatistica[count][2] = "0,0";
            }
            if (qtdAvaliacoes != 0) {
                float valor = (float) mediaTotal / qtdAvaliacoes;
                DecimalFormat df = new DecimalFormat("#0.0");
                estatistica[count][3] = df.format(valor);
            } else {
                estatistica[count][3] = "0,0";
            }
            estatistica[count][4] = String.valueOf(qtdAvaliacoes);
            count++;
        }
        Arrays.sort(estatistica, new Comparator<String[]>() {
            @Override
            public int compare(String[] aluno1, String[] aluno2) {
                if (aluno1[4].equals(aluno2[4])) {
                    return lEstudante.busca(aluno1[0]).obterNome().compareToIgnoreCase(
                            lEstudante.busca(aluno2[0]).obterNome());
                }
                return (Integer.valueOf(aluno2[4]) - Integer.valueOf(aluno1[4]));
            }
        });

        String output = "Matrícula;Nome;Média Disciplinas/Período;Média Avaliações/Disciplina;Média Notas Avaliações";

        for (int i = 0; i < count; i++) {
            output += "\n" + lEstudante.busca(estatistica[i][0]) + ";" + estatistica[i][1] + ";" + estatistica[i][2] + ";" + estatistica[i][3];
        }
        output += "\n";

        FileWriter arquivo = new FileWriter("3-estudantes.csv");
        arquivo.write(output);
        arquivo.close();

    }

    public void estatisticaDisciplinasDocente() throws Exception {

        ControladorDisciplina cDisciplina = new ControladorDisciplina();
        LeitorDisciplina lDisciplina = LeitorDisciplina.obterInstancia();
        String output = "Docente;Período;Código;Nome;Qtd. Atividades;% Síncronas;% Assíncronas;CH;Datas Avaliações";

        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        for (String codigo : lDisciplina.obterHash().keySet()) {
            disciplinas.add(lDisciplina.busca(codigo));
        }
        Collections.sort(disciplinas);

        disciplinas.sort(new Comparator<Disciplina>() {
            @Override
            public int compare(Disciplina disc, Disciplina disc2) {
                Periodo periodo1, periodo2;
                periodo1 = disc.obterPeriodo();
                periodo2 = disc2.obterPeriodo();
                if (periodo1.obterCodigo().compareTo(periodo2.obterCodigo()) == 0) {
                    return disc.obterCodigo().compareToIgnoreCase(disc2.obterCodigo());
                }
                return periodo1.obterCodigo().compareTo(periodo2.obterCodigo());
            }
        });

        String[][] estatistica = new String[disciplinas.size()][6];

        int count = 0;
        for (Disciplina disciplina : disciplinas) {
            estatistica[count][0] = disciplina.obterCodigo() + "-" + disciplina.obterPeriodo().obterAno()
                    + "/" + disciplina.obterPeriodo().obterSemestre();
            estatistica[count][1] = String.valueOf(disciplina.obterAtividades().size());
            if (disciplina.obterAtividades().size() != 0) {
                int sincronas = Math.round(((float) disciplina.obterSincronas() / (float) disciplina.obterAtividades().size()) * 100);
                estatistica[count][2] = Integer.toString(sincronas);
                estatistica[count][5] = Integer.toString(100 - sincronas);
            } else {
                estatistica[count][2] = "0";
                estatistica[count][5] = "0";
            }
            estatistica[count][3] = String.valueOf(disciplina.obterCargaHoraria());
            estatistica[count][4] = String.valueOf(disciplina.obterAvalitiva());
            count++;
        }

        for (int x = 0; x < count; x++) {
            Disciplina d = cDisciplina.busca(estatistica[x][0]);
            output += "\n" + d.obterDocente().obterLogin() + ";" + d.obterPeriodo().obterCodigo() + ";"
                    + d.obterCodigo() + ";" + d.obterNome() + ";"
                    + estatistica[x][1] + ";" + estatistica[x][2] + "%;" + estatistica[x][5]
                    + "%;" + estatistica[x][3]
                    + ";";

            ArrayList<Atividade> lista = (ArrayList<Atividade>) d.obterAtividades().clone();
            Collections.sort(lista);

            int idx = 0;
            while (lista.size() > idx && !(lista.get(idx).ehAvaliativa())) {
                idx++;
            }
            if (lista.size() > idx) {
                Atividade aux = lista.remove(idx);
                output += aux.toString();
                for (Atividade a : lista) {
                    if (a.ehAvaliativa()) {
                        output += " " + a.toString();
                    }
                }
            }
        }

        output += "\n";

        FileWriter arquivo = new FileWriter("4-disciplinas.csv");
        arquivo.write(output);
        arquivo.close();

    }
}
