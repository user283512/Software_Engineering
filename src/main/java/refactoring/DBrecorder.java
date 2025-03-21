package refactoring;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

public class DBrecorder {

	private static String DB_Url = "jdbc:sqlite:db1.db";
	private static String DB_User = "mas";
	private static String DB_Password = "mas";
	private static String DB_Driver = "org.sqlite.JDBC";

	// ==================================
	// Private methods
	// ==================================

	private static int readFromFile(
			File file,
			ArrayList<String> keys,
			ArrayList<String> values) {

		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				keys.add(line.substring(0, line.indexOf(' ')));
				values.add(line.substring(line.indexOf(' ') + 1));
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

	private static int readFromSocket(
			String host, int port,
			ArrayList<String> keys,
			ArrayList<String> values) {

		try {
			Socket socket = new Socket(host, port);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String line;
			while ((line = br.readLine()) != null) {
				String key = line.substring(0, line.indexOf(' '));
				String value = line.substring(line.indexOf(' ') + 1);
				keys.add(key);
				values.add(value);
				System.out.println("Received: " + key + " " + value);
			}
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

	private static Connection connectToDB() {
		try {
			Class.forName(DB_Driver);
			return DriverManager.getConnection(
					DB_Url,
					DB_User,
					DB_Password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static int submitQueryUpdate(Connection connection, String query) throws SQLException {
		Statement stmt = connection.createStatement();
		return stmt.executeUpdate(query);
	}

	private static void insertDataIntoDB(ArrayList<String> keys, ArrayList<String> values) {
		Connection connection = connectToDB();
		if (connection == null)
			return;

		try {
			// Create the DB table if it doesn't exist
			String query = "CREATE TABLE IF NOT EXISTS tab1 (key text, value text);";
			submitQueryUpdate(connection, query);

			// Add the key-value pairs to the DB
			for (int i = 0; i < keys.size(); i++) {
				query = "INSERT INTO tab1 VALUES (\"" +
						keys.get(i) +
						"\", \"" +
						values.get(i) +
						"\");";
				int res = submitQueryUpdate(connection, query);
				System.out.println(query + "\nReturned: " + res);
			}

			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ==================================
	// Public methods
	// ==================================

	public static void fromSourceToDB(File file) {
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		if (readFromFile(file, keys, values) == -1)
			return;

		insertDataIntoDB(keys, values);
	}

	public static void fromSourceToDB(String host, int port) {
		ArrayList<String> keys = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		if (readFromSocket(host, port, keys, values) == -1)
			return;

		insertDataIntoDB(keys, values);
	}
}
