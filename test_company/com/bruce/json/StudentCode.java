package com.bruce.json;

public class StudentCode {
	private String name;
	private int value;
    public static StudentCode FAIL = new StudentCode("FAIL", 1);
    public StudentCode() {}
	public StudentCode(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
