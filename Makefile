# Definisci le variabili
MVN = mvn

# Regola predefinita
all: clean dependencies install

# Pulire il progetto
clean:
	$(MVN) clean

# Scaricare le dipendenze
dependencies:
	$(MVN) dependency:copy-dependencies

# Installare le dipendenze e costruire il progetto
install:
	$(MVN) install

run:
	$(MVN) exec:java -Dexec.mainClass=$(MAIN_CLASS)

# Eseguire i test
test:
	$(MVN) test

# Eseguire un test specifico
test-specific:
ifneq ($(TEST_METHOD),)
	$(MVN) -Dtest=$(TEST_CLASS)#$(TEST_METHOD) test
else
	$(MVN) -Dtest=$(TEST_CLASS) test
endif