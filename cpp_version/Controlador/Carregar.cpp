#include "Carregar.h"

void carregaPeriodo(string nArq){
    ControladorPeriodo controlador;
    ifstream* arq = new ifstream(nArq);
    controlador.ler(arq);
    arq->close();
}

void carregaDocente(string nArq){
    ControladorDocente controlador;
    ifstream* arq = new ifstream(nArq);
    controlador.ler(arq);
    arq->close();
}
void carregaDisciplina(string nArq){
    ControladorDisciplina controlador;
    ifstream* arq = new ifstream(nArq);
    controlador.ler(arq);
    arq->close();
}
void carregaEstudante(string nArq){
    ControladorEstudante controlador;
    ifstream* arq = new ifstream(nArq);
    controlador.ler(arq);
    arq->close();
}
void carregaDisciplinaEstudante(string nArq){
    ControladorDisciplina controlador;
    ifstream* arq = new ifstream(nArq);
    controlador.lerMatricula(arq);
    arq->close();
}
void carregaAtividade(string nArq){
    ControladorAtividade controlador;
    ifstream* arq = new ifstream(nArq);
    controlador.ler(arq);
    arq->close();
}
void carregaAvaliacao(string nArq){
    ControladorAtividade controlador;
    ifstream* arq = new ifstream(nArq);
    controlador.lerAvaliacao(arq);
    arq->close();
}


void carregaDados(vector<string> arquivos){
    try {
        // if(arquivos.at(0) != NULL)
        carregaPeriodo(arquivos.at(0));
        // if(arquivos.at(1) != NULL)
        carregaDocente(arquivos.at(1));
        // if(arquivos.at(2) != NULL)
        carregaDisciplina(arquivos.at(2));
        // if(arquivos.at(3) != NULL)
        carregaEstudante(arquivos.at(3));
        // if(arquivos.at(4) != NULL)
        carregaDisciplinaEstudante(arquivos.at(4));
        // if(arquivos.at(5) != NULL)
        carregaAtividade(arquivos.at(5));
        // if(arquivos.at(6) != NULL)
        carregaAvaliacao(arquivos.at(6));
    } catch (ExcecaoIO ioe) {
        throw ExcecaoIO("Erro de I/O.");
    } catch (Excecao e) {
        throw Excecao(e);
    }
}

void Carregar :: executa(string args[], int argc){
    string arqPeriodo=NULL, arqDocente=NULL, arqDisciplina=NULL, arqEstudantes=NULL, arqMatriculas=NULL, arqAtividades=NULL, arqAvaliacoes=NULL;
    vector<string> arquivos;
            
    for (int i = 0; i < argc; i++){
        
        if(args[i]== "-p" && i+1 < argc)
            arqPeriodo = args[++i];

        else if(args[i]== "-d" && i+1 < argc)
            arqDocente = args[++i];

        else if(args[i]== "-o" && i+1 < argc)
            arqDisciplina = args[++i];

        else if(args[i]== "-e" && i+1 < argc)
            arqEstudantes = args[++i];

        else if(args[i]== "-m" && i+1 < argc)
            arqMatriculas = args[++i];

        else if(args[i]== "-a" && i+1 < argc)
            arqAtividades = args[++i];

        else if(args[i]== "-n" && i+1 < argc)
            arqAvaliacoes = args[++i];
    }

    arquivos.push_back(arqPeriodo);
    arquivos.push_back(arqDocente);
    arquivos.push_back(arqDisciplina);
    arquivos.push_back(arqEstudantes);
    arquivos.push_back(arqMatriculas);
    arquivos.push_back(arqAtividades);
    arquivos.push_back(arqAvaliacoes);
    carregaDados(arquivos);
}