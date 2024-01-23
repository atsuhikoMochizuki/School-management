package fr.mochizuki.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAO<T> {

	
	private String dbURL = "jdbc:mysql://localhost:3306/gestionecole";
	protected String sqlRequest;
	private String username = "root";
	private String password = "root";

	
	public Connection getConnection(String url, String username, String password){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(dbURL,username,password);
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return conn;
	}

	public abstract T find(long id);
	public abstract T create(T obj);
	public abstract T update(T obj);
	public abstract T delete(T obj);	



}
