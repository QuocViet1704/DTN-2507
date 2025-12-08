package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Student;

public class Exercise1_1 {
	public static void main(String[] args) {
		Student stu1 = new Student("Quốc Việt");
		Student stu2 = new Student("Quốc Việt");
		Student stu3 = new Student("Hùng Mạnh");
		Student stu4 = new Student("Lê Việt");
		Student stu5 = new Student("Thành Sinh");
		Student stu6 = new Student("Hữu Trung");

		List<Student> studentList = Student.getAllStudent();
// Question 1-a
		System.out.println("Tổng số Student: " + Student.countStudent());
// Question 1-b
		System.out.println("Student thứ tư là: " + studentList.get(3));
// Question 1-c
		System.out.println("Student đầu tiên là: " + studentList.get(0));
		System.out.println("Student cuối cùng là: " + studentList.get(studentList.size() - 1));
// Question 1-d
		Student student = new Student();
		student.setName("Chi");
		studentList.addFirst(student);
		System.out.println("Student đầu tiên là: " + studentList.get(0));
		System.out.println("Tổng số Student: " + Student.countStudent());
// Question 1-e
		Student student2 = new Student();
		student2.setName("Trường");
		studentList.addLast(student2);
		System.out.println("Student cuối cùng là: " + studentList.get(studentList.size() - 1));
		System.out.println("Tổng số Student: " + Student.countStudent());
// Question 1-f
//		Collections.reverse(studentList);

		for (Student s : studentList) {
			System.out.println(s.toString());
		}
// Question 1-g,h
//		System.out.println(Student.getStudentById());
//		System.out.println(Student.getStudentByName());
// Question 1-i
//		System.out.println("Các student có trùng tên");
//		Student.getStudentHaveSameName();
// Question 1-j
//		for (Student s : studentList) {
//			if (s.getId() == 2) {
//				s.setName(null);
//				break;
//			}
//		}
//		for (Student s : studentList) {
//			System.out.println(s.toString());
//		}
// Question 1-k
		for (Student s : studentList) {
			if (s.getId() == 5) {
				studentList.remove(s);
				break;
			}
		}
		System.out.println("---------------------------");
		for (Student s : studentList) {

			System.out.println(s.toString());
		}
// Question 1-l
		List<Student> studentCopies = new ArrayList<Student>();
		for (Student s : studentList) {
			studentCopies.add(s);
		}
		for (Student s : studentCopies) {
			System.out.println(s.toString());
		}

	}
}
