prefix=../
bindir=bin/
CC = g++
FLAGS = -lm -g
EXEC = main
SRC= main.cpp
SRCM= $(wildcard Modelo/*.cpp)
SRCL= $(wildcard Leitor/*.cpp)
SRCC= $(wildcard Controlador/*.cpp)
SRCU= $(wildcard util/*.cpp)
OBJ= $(SRC:.cpp=.o)
OBJM= $(SRCM:.cpp=.o)
OBJL= $(SRCL:.cpp=.o)
OBJC= $(SRCC:.cpp=.o)
OBJU= $(SRCU:.cpp=.o)


all: $(EXEC)

BIN:
	@mkdir -p bin
	@mkdir -p bin/util
	@mkdir -p bin/Controlador
	@mkdir -p bin/Leitor
	@mkdir -p bin/Modelo

$(EXEC): $(OBJ) $(OBJM) $(OBJU) $(OBJC)
	@$(CC) $^ -o $@ $(CFLAGS)

%.o: %.cpp
	@$(CC) -o $@ -c $< $(CFLAGS)
	

clean: 
	@rm -f util/*.o Controlador/*.o Leitor/*.o Modelo/*.o main.o
	@rm -r -f bin/Controlador
	@rm -r -f bin/Leitor
	@rm -r -f bin/Modelo
	@rm -r -f bin/util
	@rm -r -f bin
#	@rm -f $(bindir)util/*.o $(bindir)Controlador/*.o $(bindir)Leitor/*.o $(bindir)Modelo/*.o $(bindir)main.o