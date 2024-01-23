package fr.mochizuki.dao;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import java.sql.Connection;

import fr.mochizuki.dao.DatabaseConnection;
import fr.mochizuki.entity.Student;

public class StudentDAOTest {

	@Test
	public void create_should_returnAttemptedStudent(){
		Student sangoku = new Student("Sayien","sangoku.sayien@gmail.com","kame-house");
		StudentDAO studentDao = null;
		studentDao = StudentDAO.getInstance();
		assertThat(studentDao).isNotNull();
		Student returnValue = studentDao.create(sangoku);
		assertThat(returnValue.getName()).isEqualTo(sangoku.getName());

	}	
}