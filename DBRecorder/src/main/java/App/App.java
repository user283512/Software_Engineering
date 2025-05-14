package App;

public class App {
	public static void main(String[] args) {
		DBrecorder.fromSourceToDB(
			"/home/simone/Desktop/software_engineering/DBRecorder/src/main/resources/prova.txt", 
			"file");
		// DBrecorder.fromSourceToDB("localhost:2017", "net");
		// DBrecorder.fromSourceToDB("mars.ing.unimo.it:2017", "net");
	}
}
