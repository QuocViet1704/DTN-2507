package com.vti.frontend;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.vti.entity.Student;

public class Exercise1_2 {
	public static void main(String[] args) {
		Stack<Student> waitingStack = new Stack<Student>();
		Queue<Student> lateStack = new LinkedList<Student>();

		Student stu1 = new Student("Nguyễn Văn Nam");
		Student stu2 = new Student("Nguyễn Văn Huyên");
		Student stu3 = new Student("Trần Văn Nam");
		Student stu4 = new Student("Nguyễn Văn A");

		waitingStack.add(stu1);
		waitingStack.add(stu2);
		waitingStack.add(stu3);
		waitingStack.add(stu4);

		lateStack.add(stu1);
		lateStack.add(stu2);
		lateStack.add(stu3);
		lateStack.add(stu4);

//		Student.InThuTuToiSom();
		Student.InThuTuToiMuon();

	}
}
