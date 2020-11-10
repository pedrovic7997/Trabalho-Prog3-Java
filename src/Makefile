all: build

# java Controlador.Main --read-only -p periodos.csv -d docentes.csv -o disciplinas.csv -e estudantes.csv -m matriculas.csv -a atividades.csv -n avaliacoes.csv
# java Controlador.Main --write-only

build:
	javac ./Controlador/*.java ./Leitor/*.java ./Modelo/*.java
clean:
	rm ./Controlador/*.class
	rm ./Leitor/*.class
	rm ./Modelo/*.class
