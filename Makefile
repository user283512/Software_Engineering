# Definisci le variabili
MVN = mvn
MAIN_CLASS = Entry

# Regola predefinita
all: clean install run

# Scaricare le dipendenze
dependencies:
	$(MVN) dependency:copy-dependencies

# Pulire il progetto
clean:
	$(MVN) clean

# Installare le dipendenze e costruire il progetto
install:
	$(MVN) install

# Eseguire il programma principale
run:
	$(MVN) exec:java -Dexec.mainClass=$(MAIN_CLASS)

# Eseguire i test
test:
	$(MVN) test

# Eseguire un test specifico
test-specific:
	$(MVN) -Dtest=$(TEST_CLASS)#$(TEST_METHOD) test