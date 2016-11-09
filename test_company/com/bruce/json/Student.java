package com.bruce.json;

import java.util.Date;

public class Student {
	// private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int age;
	private String city;
	private Date date;
	private StudentCode studentCode;
	private StudentCode ss;

	public Student() {
		//super();
	}

	public Student(String id, String name, int age, String city) {
		//super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StudentCode getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(StudentCode studentCode) {
		this.studentCode = studentCode;
	}

	public StudentCode getSs() {
		return ss;
	}

	public void setSs(StudentCode ss) {
		this.ss = ss;
	}

}
