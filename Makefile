all:
	mkdir -p bin
	javac -cp lib/antlr-4.5.2-complete.jar src/*/*/*.java src/*/*.java src/Main.java -d bin
clean:
	rm -rf bin
