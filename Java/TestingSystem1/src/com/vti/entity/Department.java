package com.vti.entity;

public class Department {
	private int id;
	private String name;

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getDepartmentID() {
		return id;
	}

	public void setDepartmentID(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return name;
	}

	public void setDepartmentName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Department{id=%d, name=%s}", id, name);
	}
}
