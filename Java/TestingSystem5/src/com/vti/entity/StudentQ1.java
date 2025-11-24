package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentQ1 implements IStudent {
	private int id;
	private String name;
	private int group;

	List<StudentQ1> studentList = new ArrayList<>();

	public StudentQ1(int id, String name, int group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;

		studentList.add(this);
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

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	@Override
	public void rollcall() {
		for (StudentQ1 stu : studentList) {
			System.out.println(stu.getName() + " điểm danh");
		}
	}

	@Override
	public void study() {
		for (StudentQ1 stu : studentList) {
			System.out.println(stu.getName() + " đang học bài");
		}
	}

	@Override
	public void cleaning() {
		for (StudentQ1 stu : studentList) {
			System.out.println(stu.getName() + " đang dọn vệ sinh");
		}
	}

}
