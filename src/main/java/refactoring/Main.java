package refactoring;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		//File file = new File("src/main/java/refactoring/prova.txt");
		//DBrecorder.fromSourceToDB(file);
		
		DBrecorder.fromSourceToDB("localhost", 2017);

		// DBrecorder.fromSourceToDB("localhost:2017", "net");
		// DBrecorder.fromSourceToDB("mars.ing.unimo.it:2017", "net");
	}

}
