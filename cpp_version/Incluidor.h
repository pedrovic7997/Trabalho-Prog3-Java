#ifndef INLCUIDOR_H
#define INLCUIDOR_H

#include <iostream>
#include <cmath>
#include <fstream>
#include <string>
#include <vector>
#include <map>
#include <chrono>
#include <ctime>
#include <cstdlib>
#include <typeinfo>
#include <stdexcept>
#include <exception>
#include <regex>
#include "Excecoes/Excecoes.h"
#include "util/DateUtils.h"
#include "util/NumberUtils.h"
#include "util/NumPunctPTBR.h"
#include "util/StringUtils.h"
#include "util/Tokenizer.h"

class Atividade;
class Aula;
class Avaliacao;
class Disciplina;
class Docente;
class Estudante;
class Estudante;
class Estudo;
class Material;
class Periodo;
class Prova;
class Trabalho;
class LeitorAtividade;
class LeitorAvalicao;
class LeitorDisciplina;
class LeitorDisciplinaEstudante;
class LeitorDocente;
class LeitorEstudante;
class LeitorPeriodo;
class ControladorDisciplina;
class ControladorDocente;
class ControladorEstudante;
class ControladorPeriodo;

#include "Modelo/Atividade.h"
#include "Modelo/Avaliacao.h"
#include "Modelo/Disciplina.h"
#include "Modelo/Docente.h"
#include "Modelo/Estudante.h"
#include "Modelo/Estudante.h"
#include "Modelo/Material.h"
#include "Modelo/Periodo.h"
#include "Leitor/LeitorAtividade.h"
#include "Leitor/LeitorAvaliacao.h"
#include "Leitor/LeitorDisciplina.h"
#include "Leitor/LeitorDisciplinaEstudante.h"
#include "Leitor/LeitorDocente.h"
#include "Leitor/LeitorEstudante.h"
#include "Leitor/LeitorPeriodo.h"
#include "Controlador/ControladorAtividade.h"
#include "Controlador/ControladorDisciplina.h"
#include "Controlador/ControladorDocente.h"
#include "Controlador/ControladorEstudante.h"
#include "Controlador/ControladorPeriodo.h"
#endif