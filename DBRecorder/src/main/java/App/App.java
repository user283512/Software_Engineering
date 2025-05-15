package App;

import java.io.File;

public class App {
	public static void main(String[] args) {
		File file = new File("/home/simone/Desktop/software_engineering/DBRecorder/src/main/resources/prova.txt");
		DBrecorder.fromSourceToDB(file);

		//DBrecorder.fromSourceToDB("127.0.0.1", 2017);
	}
}
