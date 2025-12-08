package com.vti.frontend;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import com.vti.entity.Student;

public class Exercise1_3 {
	public static void main(String[] args) {
		Student stu1 = new Student("Quốc Việt");
		Student stu2 = new Student("Quốc Việt");
		Student stu3 = new Student("Hùng Mạnh");
		Student stu4 = new Student("Lê Việt");
		Student stu5 = new Student("Thành Sinh");
		Student stu6 = new Student("Hữu Trung");
		Student stu7 = new Student("Quốc Trung");

		Set<Student> students = new LinkedHashSet();
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		students.add(stu4);
		students.add(stu5);
		students.add(stu6);

// Question 3-a
//		Iterator<Student> it = students.iterator();
//		while (it.hasNext()) {
//			Student student = it.next();
//			System.out.println(student);
//		}

// Question 3-b
//		int i = 0;
//		while (it.hasNext() && i <= 3) {
//			Student student = it.next();
//			if (i == 3) {
//				System.out.println(student);
//			}
//			++i;
//		}

// Question 3-c
//		int j = 0;
//		while (it.hasNext()) {
//			Student student = it.next();
//			if (j == 0 || j == students.size() - 1) {
//				System.out.println(student);
//
//			}
//			++j;
//		}

// Question 3-d
		Set<Student> tempSet = new LinkedHashSet<Student>();

		tempSet.add(stu7);
		tempSet.addAll(students);

		students = tempSet;

		Iterator<Student> it2 = students.iterator();
		while (it2.hasNext()) {
			Student student = it2.next();
			System.out.println(student);
		}

// Question 3-e  

	}
}
