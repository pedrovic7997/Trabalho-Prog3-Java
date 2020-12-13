prefix=./
bindir=$(prefix)bin/
CC = g++
FLAGS = -lm -g
EXEC = main
SRC= main.cpp
SRCM= $(wildcard Modelo/*.cpp)
SRCL= $(wildcard Leitor/*.cpp)
SRCC= $(wildcard Controlador/*.cpp)
SRCU= $(wildcard Controlador/*.cpp)
OBJ= $(SRC:.cpp=.o)
OBJM= $(SRCM:.cpp=.o)
OBJL= $(SRCL:.cpp=.o)
OBJC= $(SRCC:.cpp=.o)
OBJU= $(SRCU:.cpp=.o)

all: $(EXEC)

main: $(OBJ) $(OBJM) $(OBJL) $(OBJC) $(OBJU)
	$(CC) $^ -o $(bindin)$@

Modelo/%.o: Modelo/%.c
	@$(CC) -o $(bindir)$@ -c $< $(CFLAGS)

clean: $(OBJ) $(OBJM) $(OBJL) $(OBJC) $(OBJU)
	@rm $^