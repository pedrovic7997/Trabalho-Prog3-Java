prefix=../
bindir=bin/
CC = g++
FLAGS = -lm -g
EXEC = main
SRC= main.cpp
SRCM= $(wildcard Modelo/*.cpp)
SRCL= $(wildcard Leitor/*.cpp)
SRCC= $(wildcard Controlador/*.cpp)
SRCE= $(wildcard Excecoes/*.cpp)
SRCU= $(wildcard util/*.cpp)
OBJ= $(SRC:.cpp=.o)
OBJM= $(SRCM:.cpp=.o)
OBJL= $(SRCL:.cpp=.o)
OBJC= $(SRCC:.cpp=.o)
OBJU= $(SRCU:.cpp=.o)
OBJE= $(SRCE:.cpp=.o)


all: $(EXEC) run

BIN:
	@mkdir -p bin
	@mkdir -p bin/util
	@mkdir -p bin/Controlador
	@mkdir -p bin/Leitor
	@mkdir -p bin/Modelo
	@mkdir -p bin/Excecoes

$(EXEC): $(OBJ) $(OBJC) $(OBJU) $(OBJE) $(OBJL) $(OBJM)
	@$(CC) $^ -o $@ $(FLAGS)

teste: 
	@cd bin

run:
	@./$(EXEC) -p periodos.csv -d docentes.csv -o disciplinas.csv -e estudantes.csv -m matriculas.csv -a atividades.csv -n avaliacoes.csv


%.o: %.cpp
	@$(CC) -o $@ -c $< $(FLAGS)
	
clean: rmproper
	@rm -f $(EXEC)

rmproper: 
	@rm -f util/*.o Controlador/*.o Leitor/*.o Modelo/*.o Excecoes/*.o main.o 
	@rm -r -f bin/Controlador
	@rm -r -f bin/Leitor
	@rm -r -f bin/Modelo
	@rm -r -f bin/util
	@rm -r -f bin
	@rm -f $(bindir)util/*.o $(bindir)Controlador/*.o $(bindir)Leitor/*.o $(bindir)Modelo/*.o $(bindir)main.o