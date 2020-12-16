prefix=../
bindir=bin/
CC = g++
FLAGS = -lm -g
EXEC = main
SRC= main.cpp
SRCM= $(wildcard cpp_version/Modelo/*.cpp)
SRCL= $(wildcard cpp_version/Leitor/*.cpp)
SRCC= $(wildcard cpp_version/Controlador/*.cpp)
SRCE= $(wildcard cpp_version/Excecoes/*.cpp)
SRCU= $(wildcard cpp_version/util/*.cpp)
OBJ= $(SRC:.cpp=.o)
OBJM= $(SRCM:.cpp=.o)
OBJL= $(SRCL:.cpp=.o)
OBJC= $(SRCC:.cpp=.o)
OBJU= $(SRCU:.cpp=.o)
OBJE= $(SRCE:.cpp=.o)


all: $(EXEC) run

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
	@rm -f cpp_version/util/*.o cpp_version/Controlador/*.o cpp_version/Leitor/*.o cpp_version/Modelo/*.o cpp_version/Excecoes/*.o cpp_version/main.o 