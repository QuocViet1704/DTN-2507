package com.vti.frontend;

import java.util.List;

import com.vti.entity.HinhChuNhat;
import com.vti.entity.HinhHoc;
import com.vti.entity.HinhTron;
import com.vti.entity.MyMath;
import com.vti.entity.PrimaryStudent;
import com.vti.entity.SecondaryStudent;
import com.vti.entity.Student;

public class Program1 {
	public static void main(String[] args) {
// Question 1
		Student.setCollege("Đại học Bách Khoa");
		List<Student> studentList = Student.getAllStudent();
		Student stu1 = new SecondaryStudent(1, "Nguyễn Văn A");
		Student stu2 = new SecondaryStudent(2, "Nguyễn Văn B");
		Student stu3 = new PrimaryStudent(3, "Nguyễn Văn C");

		for (Student stu : studentList) {
			System.out.println(stu.toString());
		}

		Student.setCollege("Đại học Công Nghệ");
		for (Student stu : studentList) {
			System.out.println(stu.toString());
		}

// Question 2
		System.out.println("Tiền quỹ hiện tại: " + Student.getMoneyGroup());
		stu1.studentTakeMoneyGroup(50);
		System.out.println("Student 1 lấy 50k mua bimbim, kẹo về liên hoan, quỹ còn: " + Student.getMoneyGroup());
		stu2.studentTakeMoneyGroup(20);
		System.out.println("Student 2 lấy 20k đi mua bánh mì, quỹ còn: " + Student.getMoneyGroup());
		stu3.studentTakeMoneyGroup(150);
		System.out
				.println("Student thứ 3 lấy 150k đi mua đồ dùng học tập cho nhóm, quỹ còn: " + Student.getMoneyGroup());
		stu1.studentContributeMoneyGroup(50);
		stu2.studentContributeMoneyGroup(50);
		stu3.studentContributeMoneyGroup(50);
		System.out.println("Tiền quỹ hiện tại: " + Student.getMoneyGroup());
		System.out.println(Student.countStudent());

// Question 3
		int min = MyMath.min(-21, 20);
		int sum = MyMath.sum(15, 10);
		System.out.println(min);
		System.out.println(sum);

// Question 6 & 7
		Student stu4 = new PrimaryStudent(004, "Nguyễn Văn D");
		Student stu5 = new SecondaryStudent(005, "Nguyễn Văn E");
		Student stu6 = new SecondaryStudent(006, "Nguyễn Văn F");
		Student stu7 = new PrimaryStudent(006, "Nguyễn Văn F");
		Student stu8 = new PrimaryStudent(006, "Nguyễn Văn F");
		Student stu9 = new PrimaryStudent(006, "Nguyễn Văn F");
		System.out.println("Số lượng Student: " + Student.countStudent());
		System.out.println("Số lượng Primary Student: " + PrimaryStudent.countStudent());
		System.out.println("Số lượng Secondary Student: " + SecondaryStudent.countStudent());
// Question 8
		List<HinhHoc> hinhHocList = HinhHoc.getAllHinhHoc();
		HinhHoc hinh2 = new HinhTron(10);
		HinhHoc hinh3 = new HinhTron(4);
		HinhHoc hinh4 = new HinhChuNhat(2, 4);
		HinhHoc hinh5 = new HinhChuNhat(2, 4);
		HinhHoc hinh6 = new HinhChuNhat(2, 4);
		HinhHoc hinh1 = new HinhChuNhat(2, 4);

		for (HinhHoc h : hinhHocList) {
			System.out.println(h.toString());
		}

	}
}
