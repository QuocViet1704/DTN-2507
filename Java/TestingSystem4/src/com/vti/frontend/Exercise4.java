package com.vti.frontend;

import com.vti.entity.Student;

public class Exercise4 {
	public static void main(String[] args) {
		Student stu1 = new Student("Việt", "Hà Nội");
		Student stu2 = new Student("Sinh", "Phú Thọ");
		Student stu3 = new Student("Mạnh", "Hải Dương");

		stu1.setPoint(9.5f);
		stu2.setPoint(5.3f);
		stu3.setPoint(1.5f);

		stu1.showInfo();
		stu2.showInfo();
		stu3.showInfo();
	}
}
