package fr.mochizuki.entity;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import fr.mochizuki.entity.Student;


public class StudentTest{

	private Student studentRef = null;

	@Before
	public void initStudent(){
		studentRef = new Student(1,"Doe","johnDoe24@gmail.com","Stanford");
	}
	

	@Test
	public void ToString_shouldReturnGoodString(){
		String expectedStr = String.format(
			"""
			{
				"studentId": %d,
				"name":"%s",
				"email":"%s",
				"university":"%s"
			}""",
			1,
			"Doe",
			"johnDoe24@gmail.com",
			"Stanford");

		String returnStr = studentRef.ToString();
		assertThat(returnStr).isEqualTo(expectedStr);
	}
}