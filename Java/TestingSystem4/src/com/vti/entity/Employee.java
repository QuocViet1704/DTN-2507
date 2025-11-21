package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Staff {
	private String task;

	List<Employee> employees = new ArrayList<>();

	public Employee(String name, int age, Gender gender, String address, String task) {
		super(name, age, gender, address);
		this.task = task;

		employees.add(this);
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

}
