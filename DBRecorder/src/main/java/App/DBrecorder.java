package App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DBrecorder {
	private static final String DB_URL = "jdbc:sqlite:db1.db"; 
	private static final String DB_USER = "mas";
	private static final String DB_PWD = "mas";

	private static void initMap(BufferedReader bufferedReader,
															HashMap<String, String> map) throws IOException{
																
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String key = line.substring(0, line.indexOf(' '));;
			String value = line.substring(line.indexOf(' ') + 1);
			map.put(key, value);
		}
	}
	
	private static void procedureDB(HashMap<String, String> map) throws ClassNotFoundException,
																																			SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
		String sql = "CREATE TABLE IF NOT EXISTS tab1 (key text, value text);";
		System.out.println(sql);
		Statement stmt = connection.createStatement();
		int res = stmt.executeUpdate(sql);
		System.out.println("Returned: " + res);
		
		for (HashMap.Entry<String, String> en : map.entrySet()) {
			Object key = en.getKey();
			Object val = en.getValue();
			sql = "INSERT INTO tab1 VALUES (\"" + key + "\", \"" + val + "\");";
			System.out.println(sql);

			stmt = connection.createStatement();
			res = stmt.executeUpdate(sql);
			System.out.println("Returned: " + res);
		}
		connection.close();
	}


	public static void fromSourceToDB(File file) {
		HashMap<String, String> map = new HashMap<>();
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			initMap(bufferedReader, map);
		}
		catch (FileNotFoundException e) {
			System.err.println(e);
			return;
		}
		catch (IOException e){
			System.err.println(e);
			return;
		}

		try {
			procedureDB(map);
		} 
		catch (ClassNotFoundException | SQLException e){
			System.err.println(e);
		} 
	}

	public static void fromSourceToDB(String hostname, int port) {
		HashMap<String, String> map = new HashMap<>();
		try {
			Socket socket = new Socket(hostname, port);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			initMap(bufferedReader, map);
			socket.close();
		} 
		catch (IOException e) {
			System.err.println(e);
		}

		try {
			procedureDB(map);
		} 
		catch (ClassNotFoundException | SQLException e){
			System.err.println(e);
		} 
	}
}
