#include "Carregar.h"

void carregaPeriodo(string nArq){
    ControladorPeriodo controlador;
    ifstream* arq = new ifstream(nArq);
    string lixo;
    getline(*arq,lixo);
    controlador.ler(arq);
    arq->close();
}

void carregaDocente(string nArq){
    ControladorDocente controlador;
    ifstream* arq = new ifstream(nArq);
    string lixo;
    getline(*arq,lixo);
    controlador.ler(arq);
    arq->close();
}
void carregaDisciplina(string nArq){
    ControladorDisciplina controlador;
    ifstream* arq = new ifstream(nArq);
    string lixo;
    getline(*arq,lixo);
    controlador.ler(arq);
    arq->close();
}
void carregaEstudante(string nArq){
    ControladorEstudante controlador;
    ifstream* arq = new ifstream(nArq);
    string lixo;
    getline(*arq,lixo);
    controlador.ler(arq);
    arq->close();
}
void carregaDisciplinaEstudante(string nArq){
    ControladorDisciplina controlador;
    ifstream* arq = new ifstream(nArq);
    string lixo;
    getline(*arq,lixo);
    controlador.lerMatricula(arq);
    arq->close();
}
void carregaAtividade(string nArq){
    ControladorAtividade controlador;
    ifstream* arq = new ifstream(nArq);
    string lixo;
    getline(*arq,lixo);
    controlador.ler(arq);
    arq->close();
}
void carregaAvaliacao(string nArq){
    ControladorAtividade controlador;
    ifstream* arq = new ifstream(nArq);
    string lixo;
    getline(*arq,lixo);
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

void executa(char* args[],int argc){
    string arqPeriodo, arqDocente, arqDisciplina, arqEstudantes, arqMatriculas, arqAtividades, arqAvaliacoes;
    vector<string> arquivos;
            
    for (int i = 1; i < argc; i++){
        
        if(strcmp (args[i],"-p")==0 && i+1 < argc + 1)
            arqPeriodo = args[++i];

        else if(strcmp (args[i],"-d")==0 && i+1 < argc + 1)
            arqDocente = args[++i];

        else if(strcmp (args[i],"-o")==0 && i+1 < argc + 1)
            arqDisciplina = args[++i];

        else if(strcmp (args[i],"-e")==0 && i+1 < argc + 1)
            arqEstudantes = args[++i];

        else if(strcmp (args[i],"-m")==0 && i+1 < argc + 1)
            arqMatriculas = args[++i];

        else if(strcmp (args[i],"-a")==0 && i+1 < argc + 1)
            arqAtividades = args[++i];

        else if(strcmp (args[i],"-n")==0 && i+1 < argc + 1)
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

void Carregar :: lansaABraba(char* argv[],int argc){
    try
    {
        executa(argv,argc);
    }
    catch(const Excecao e)
    {
         cout << e.motivo<< endl;/*
        throw e;//*/
    }
    
}