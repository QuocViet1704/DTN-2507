package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private static int count = 0;
	private int id;
	private String name;
	private static String college;
	private static double moneyGroup;

	private static List<Student> students = new ArrayList<>();

	public Student(int id, String name) {
		if (count < 7) {
			count++;
			this.id = id;
			this.name = name;
			moneyGroup += 100;
			students.add(this);
		} else {
			System.out.println("Chỉ được phép tạo tối đa 7 Student!");
		}
	}

	public static double getMoneyGroup() {
		return moneyGroup;
	}

	public static void studentTakeMoneyGroup(double moneyGroup) {
		Student.moneyGroup -= moneyGroup;
	}

	public static void studentContributeMoneyGroup(double moneyGroup) {
		Student.moneyGroup += moneyGroup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}

	public static List<Student> getAllStudent() {
		return students;
	}

	public static int countStudent() {
		return count;
	}

	public static final void study() {
		System.out.println("Đang học bài...");
	}

	@Override
	public String toString() {
		return String.format("Student [id= %d, name= %s, college= %s]", id, name, college);
	}

}
