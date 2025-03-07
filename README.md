## Build del progetto

Questo comando scaricherà tutte le dipendenze specificate nel pom.xml e le copierà nella cartella target/dependency.
```mvn dependency:copy-dependencies```

Per costruire il progetto, esegui il seguente comando:
```mvn clean install```

## Esecuzione del programma principale
```mvn exec:java -Dexec.mainClass="main.java.Entry"```

## Esecuzione dei test 

1. Esecuzione di tutti i test in src/test/java
```mvn test```

2. Esecuzione di tutti i test in di una specifica classe
```mvn -Dtest=<ClassTest> test```

Ad esempio il seguente comando eseguirà tutti i test nella classe CalculatorTest. 
```mvn -Dtest=CalculatorTest test ```

3. Esecuzione di un test specifico in una classe
```mvn -Dtest=<ClassTest>#<specificTestMethod> test```

Ad esempio il seguente comando eseguirà solo il test testSubtraction nella classe CalculatorTest. 
```mvn -Dtest=CalculatorTest#testSubtraction test```