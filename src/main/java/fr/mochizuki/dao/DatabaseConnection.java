package fr.mochizuki.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.IOException;


public class DatabaseConnection {

	private static Connection connect = null;
	private static Properties prop = null;

	/**
	 * returns a property of the given database configuration file, if available.
	 * Otherwise, an IOException is generated
	 * @param key a key in database configuration properties file
	 * @return a property in database configuration file if exists
	 */
	public static String getProperty(String key) {
		String returnStr = null;

		if (prop != null) {
			return prop.getProperty(key);

		} else {

			String filePath = "./src/main/resources/database.properties";
			
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(filePath);
				prop.load(ip);
				returnStr = prop.getProperty(key);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			} 
		}
		return prop.getProperty(key);
	}

	/**
	 * Singleton of databaseConnection 
	 * @return
	 */
	public static Connection getInstance() {
		if (connect == null) {
			try {
				
				String driver = getProperty("driver");
				String url = getProperty("url");
				String user = getProperty("user");
				String password = getProperty("password");
				// Class.forName(driver);
				connect = DriverManager.getConnection(url, user, password);
				connect.setAutoCommit(false);
			} catch (SQLException ex) {
				ex.printStackTrace();
			} 
			// catch(ClassNotFoundException e){
			// 	e.printStackTrace();
			// }
		}
		return connect;
	}
}