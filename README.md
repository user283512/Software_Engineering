# Build
1. Pulire il progetto: ```make clean```
2. Scaricare le dipendenze:  ```make dependencies```
3. Installare le dipendenze e costruire il progetto: ```make install```
4. Eseguire il programma principale specificato, ad esempio il seguente comando eseguira il main all'interno del package exercise1.shoppingcart: ```make run MAIN_CLASS=exercise1.shoppingcart.Main```
5. Eseguire tutti i test: ```make test```
6. Esecuzione di tutti i test in una specifica classe, ad esempio il seguente comando eseguirà tutti i test nella classe ShoppingCartTest: ```make test-specific TEST_CLASS=exercise1.shoppingcart.ShoppingCartTest```
7. Esecuzione di un test specifico in una classe, ad esempio, il seguente comando eseguirà solo il test testAddItem nella classe ShoppingCartTest: ```make test-specific TEST_CLASS=exercise1.shoppingcart.ShoppingCartTest TEST_METHOD=testAddItem```