package com.vti.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import com.vti.utils.ScannerUtils;

public class Student {
	private static int count = 0;
	private int id;
	private String name;

	private static List<Student> students = new ArrayList<>();
	private static Stack<Student> studentsStack = new Stack<Student>();
	private static Queue<Student> studentsQueue = new LinkedList<Student>();

	public Student(String name) {
		super();
		count++;
		this.id = count;
		this.name = name;

		students.add(this);
		studentsStack.add(this);
		studentsQueue.add(this);
	}

	public Student() {
		count++;
		this.id = count;
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

	public static List<Student> getAllStudent() {
		return students;
	}

	public static int countStudent() {
		return count;
	}

	public static Student getStudentById() {
		System.out.println("Nhập vào id của Student bạn muốn tìm kiếm: ");
		int id = ScannerUtils.inputInt("wrong inputing! Please input an int type, input again");

		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

	public static List<Student> getStudentByName() {
		System.out.println("Nhập vào id của Student bạn muốn tìm kiếm: ");
		String name = ScannerUtils.inputString();

		List<Student> list = new ArrayList<Student>();

		for (Student student : students) {
			if (student.getName().toLowerCase().contains(name)) {
				list.add(student);
			}
		}
		return list;
	}

	public static void getStudentHaveSameName() {
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (Student s : students) {
			String name = s.getName().toLowerCase();
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		boolean trungTen = false;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() >= 2) {
				trungTen = true;
				System.out.println("Tên trùng: " + entry.getKey());
				for (Student student : students) {
					if (student.getName().equalsIgnoreCase(entry.getKey())) {
						System.out.println(" " + student);
					}
				}
			}
		}

		if (!trungTen) {
			System.out.println("Không có tên nào bị trùng trong danh sách!");
		}
	}

	public static void InThuTuToiSom() {
		Stack<Student> tempStack = new Stack<Student>();
		while (!studentsStack.isEmpty()) {
			tempStack.add(studentsStack.pop());
		}

		while (!tempStack.isEmpty()) {
			System.out.println(tempStack.pop().toString());
		}
	}

	public static void InThuTuToiMuon() {
		Queue<Student> tempQueue = new LinkedList<Student>();
		while (!studentsQueue.isEmpty()) {
			tempQueue.add(studentsQueue.poll());
		}
		
		while (!tempQueue.isEmpty()) {
			System.out.println(tempQueue.poll().toString());
		}
	}

	@Override
	public String toString() {
		return String.format("Student [id= %d, name= %s]", id, name);
	}
}
