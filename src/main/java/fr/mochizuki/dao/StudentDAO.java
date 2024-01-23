package fr.mochizuki.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import fr.mochizuki.entity.Student;
import fr.mochizuki.dao.DatabaseConnection;

public class StudentDAO extends DAO<Student> {

	private static StudentDAO instance;
	private Connection conn;

	private StudentDAO() {

	};

	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}

	@Override
	public  Student find(long id) {
		return null;
	}

	@Override
	public  Student create(Student student) {
		this.conn = DatabaseConnection.getInstance();
		String sqlRequest = "INSERT INTO student(name,email,university) VALUES(?,?,?);";

		try {
			PreparedStatement statement = this.conn.prepareStatement(sqlRequest);
			
			statement.setString(1, student.getName());
			statement.setString(2, student.getEmail());
			statement.setString(3, student.getUniversity());
			
			int rowInserted = statement.executeUpdate();
			System.out.println("la requête a été exzécutée");
			if (rowInserted < 1)
				throw new SQLException("The Student could not be inserted in database");
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (this.conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	@Override
	public  Student update(Student student) {
		return null;
	}

	@Override
	public  Student delete(Student student) {
		return null;
	}


}