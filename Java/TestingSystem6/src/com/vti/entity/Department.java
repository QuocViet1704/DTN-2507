package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

import com.vti.utils.ScannerUtils;

public class Department {
	private int id;
	private String name;

	private static List<Department> departments = new ArrayList<>();

	public Department() throws Exception {
		System.out.println("Nhập Department Id:");
		this.id = ScannerUtils.inputInt("wrong inputing! Please input an id as int type, input again");
		System.out.println("Nhập Department Name:");
		this.name = ScannerUtils.inputString();

		departments.add(this);
	}

	public Department(int id, String name) {
		this.id = id;
		this.name = name;

		departments.add(this);
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

	public static Department getDepartmentById(int id) {
		for (Department dep : departments) {
			if (dep.getDepartmentID() == id) {
				return dep;
			}
		}
		return null;
	}

	public static List<Department> getAllDepartments() {
		return departments;
	}

	@Override
	public String toString() {
		return String.format("Department{id=%d, name=%s}", id, name);
	}
}
