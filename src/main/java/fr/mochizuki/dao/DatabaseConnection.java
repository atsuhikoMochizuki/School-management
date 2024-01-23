package fr.mochizuki.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Properties;
import java.util.Properties;
import java.util.Set;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class DatabaseConnection {

	private static Connection connect = null;
	private static Properties prop = null;

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

	public static Connection getInstance() {
		if (connect == null) {
			try {
				String driver = getProperty("driver");
				String url = getProperty("url");
				String user = getProperty("user");
				String password = getProperty("password");
				Class.forName(driver);
				connect = DriverManager.getConnection(url, user, password);
				connect.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return connect;
	}
}