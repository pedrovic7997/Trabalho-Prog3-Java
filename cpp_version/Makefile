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
OBJ= $(SRC:.c=.o)
OBJM= $(SRCM:.c=.o)
OBJL= $(SRCL:.c=.o)
OBJC= $(SRCC:.c=.o)
OBJU= $(SRCU:.c=.o)

all: $(EXEC)
	@echo $(OBJC)

main: $(OBJ) $(OBJM) $(OBJL) $(OBJC) $(OBJU)
	$(CC) $^ -o $(bindin)$@

Modelo/%.o: Modelo/%.c
	@$(CC) -o $(bindir)$@ -c $< $(CFLAGS)

clean: main
	@rm $^