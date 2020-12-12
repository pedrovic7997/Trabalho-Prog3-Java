prefix=./
bindir=$(prefix)/bin/
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
OBJU= $(SRCC:.c=.o)

all: $(EXEC)

main: $(OBJ) $(OBJM) $(OBJL) $(OBJC) $(OBJU)
	$(CC) $(bindir)$^ -o $@

%.o: %.c
	@$(CC) -o $(bindir)$@ -c $< $(CFLAGS)

clean: main
	@rm $^