package com.revature.iopractice;

public class Student {
	private String name;
	private String email;
	private String studentNumber;
	private double grade;
	public Student() {}
	public Student(String name, String email, String studentNumber, double grade) {
		super();
		this.name = name;
		this.email = email;
		this.studentNumber = studentNumber;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return name + ";" + email + ";" + studentNumber + ";" + grade + "\n";
	}
	
}
