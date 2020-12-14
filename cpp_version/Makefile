prefix=./
bindir=$(prefix)bin/
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


all: $(EXEC) BIN

BIN: 
	mkdir bin
	mkdir bin/util
	mkdir bin/Controlador
	mkdir bin/Leitor
	mkdir bin/Modelo

$(EXEC): $(OBJ) $(OBJM) $(OBJU) $(OBJC)
	@$(CC) $^ -o $(bindir)$@

%.o: %.cpp BIN
	@$(CC) -o $(bindir)$@ -c $< $(CFLAGS)

clean: 
	@rm $(bindir)util/*.o $(bindir)Controlador/*.o $(bindir)Leitor/*.o $(bindir)Modelo/*.o $(bindir)main.o