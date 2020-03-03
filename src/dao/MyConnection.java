package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MyConnection {
	private static Connection conn = null;
	private MyConnection() {
		
	}
	
	public static Connection getConnection()  {
		Properties p = new Properties();
		try{FileReader fr = new FileReader("d:\\web\\dbinfo.properties");
	
		p.load(fr);
		if (conn == null) {
			Class.forName(p.getProperty("driver"));
			conn = DriverManager.getConnection(
								p.getProperty("url"),
								p.getProperty("user"),
								p.getProperty("password"));
			
			
		} 
		}
		catch(Exception e) {
		System.out.println(MyConnection.class.getCanonicalName() +" -> " + e.toString());
		}
		return conn;
	}
}
