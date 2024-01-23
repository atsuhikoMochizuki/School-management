package fr.mochizuki.entity;

import java.io.Serializable;

public class Student implements Serializable {

	private Integer studentId;
	private String name;
	private String email;
	private String university;

	public Student() {};

	public Student(Integer id, String name, String email, String university) {
		this.studentId = id;
		this.name = name;
		this.email = email;
		this.university = university;
	}

	public Student(String name, String email, String university) {
		this.name = name;
		this.email = email;
		this.university = university;
	}

	public String getName(){
		return this.name;
	}

	public String getEmail(){
		return this.email;
	}

	public String getUniversity(){
		return this.university;
	}



	public String ToString() {
		return String.format("{studentId:%d,name:'%s',email:'%s',university:'%s'}",
		              this.studentId,
		              this.name,
		              this.email,
		              this.university);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student otherStudent = (Student) obj;
			return this.studentId.equals(otherStudent.studentId) &&
			       this.name.equals(otherStudent.name) &&
			       this.email.equals(otherStudent.email) &&
			       this.university.equals(otherStudent.university);
		}
		return false;
	}
}