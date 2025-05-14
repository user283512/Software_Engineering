package App;

import java.io.*;
import java.net.*;
import java.sql.*;

public class DBrecorder {
	public static void fromSourceToDB(String source, String type) {
		String keys[] = new String[100];
		String values[] = new String[100];
		int cont;

		/* reading phase */

		if (type.equals("file")) {
			FileReader fin = null;
			try {
				fin = new FileReader(source);
			} catch (IOException e) {
				System.err.println("Error opening " + source);
				System.err.println(e);
				return;
			}

			try {
				String line;
				cont = 0;
				BufferedReader br = new BufferedReader(fin);
				while ((line = br.readLine()) != null) {
					keys[cont] = line.substring(0, line.indexOf(' '));
					values[cont] = line.substring(line.indexOf(' ') + 1);
					cont++;
				}
			} catch (IOException e) {
				System.err.println("Error reading " + source);
				System.err.println(e);
				return;
			}

		} else if (type.equals("net")) {
			Socket s = null;
			try {
				s = new Socket(source.substring(0, source.indexOf(':')),
						Integer.parseInt(source.substring(source.indexOf(':') + 1)));
			} catch (Exception e) {
				System.err.println("Error in socket " + source);
				e.printStackTrace();
				return;
			}

			try {
				String line;
				cont = 0;
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				while ((line = br.readLine()) != null) {
					keys[cont] = line.substring(0, line.indexOf(' '));
					values[cont] = line.substring(line.indexOf(' ') + 1);
					System.out.println("Ricevuto: " + keys[cont] + " " + values[cont]);
					cont++;
				}
				s.close();
			} catch (Exception e) {
				System.err.println("Error in socket " + source);
				e.printStackTrace();
				return;
			}

		} else {
			System.err.println("Unknown source");
			return;
		}

		/* recording phase */
		String urlDB = "jdbc:sqlite:db1.db";
		String user = "mas";
		String pwd = "mas";
		Statement stmt;
		ResultSet rs;
		String stringSql;
		int res;

		try {
			/* connect to the DBMS */
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection(urlDB, user, pwd);
			/* create the DB table if not exist */
			stringSql = "CREATE TABLE IF NOT EXISTS tab1 (key text, value text);";
			System.out.println(stringSql);
			stmt = con.createStatement();
			res = stmt.executeUpdate(stringSql);
			System.out.println("Returned: " + res);
			con.close();

			/* add the couples to the DB */
			con = DriverManager.getConnection(urlDB, user, pwd);

			for (int i = 0; i < cont; i++) {
				/* SQL command */
				stringSql = "INSERT INTO tab1 VALUES (\"" + keys[i] + "\", \"" + values[i] + "\");";
				System.out.println(stringSql);
				stmt = con.createStatement();
				res = stmt.executeUpdate(stringSql);
				System.out.println("Returned: " + res);

			}
			con.close();

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}
}
