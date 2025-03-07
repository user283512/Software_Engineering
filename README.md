## Build del progetto

Questo comando scaricherà tutte le dipendenze specificate nel pom.xml e le copierà nella cartella target/dependency.
```sh mvn dependency:copy-dependencies```

Per costruire il progetto, esegui il seguente comando:
```sh mvn clean install```

## Esecuzione del programma principale
```sh mvn exec:java -Dexec.mainClass="main.java.Entry"```

## Esecuzione dei test 

1. Esecuzione di tutti i test in src/test/java
```sh mvn test```

2. Esecuzione di tutti i test in di una specifica classe
```sh mvn -Dtest=<ClassTest> test```

Ad esempio il seguente comando eseguirà tutti i test nella classe CalculatorTest. 
```sh mvn -Dtest=CalculatorTest test ```

3. Esecuzione di un test specifico in una classe
```sh mvn -Dtest=<ClassTest>#<specificTestMethod> test```

Ad esempio il seguente comando eseguirà solo il test testSubtraction nella classe CalculatorTest. 
```sh mvn -Dtest=CalculatorTest#testSubtraction test```