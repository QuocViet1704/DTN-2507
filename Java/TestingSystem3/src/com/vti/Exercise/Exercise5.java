package com.vti.Exercise;

import java.util.List;

import com.vti.entity.Department;

public class Exercise5 {
	Program program = new Program();
	List<Department> departments = Department.getAllDepartments();

	public void Question1() {
		System.out.println(departments.get(0).toString());
	}

	public void Question2() {
		for (Department dep : departments) {
			System.out.println(dep.toString());
		}
	}

	public void Question4() {
		if (departments.get(0).getDepartmentName() == "Phòng A") {
			System.out.println("Phòng ban thứ nhất tên là Phòng A");
		} else {
			System.out.println("Phòng ban thứ nhất không phải tên là Phòng A");
		}
	}

	public void Question5() {
		if (departments.get(0).getDepartmentName() == departments.get(1).getDepartmentName()) {
			System.out.println("Phòng ban thứ 1 và phòng ban thứ 2 bằng nhau");
		} else {
			System.out.println("Phòng ban thứ 1 và phòng ban thứ 2 không bằng nhau");
		}
	}

	public void Question6() {
		for (char a = 'A'; a <= 'Z'; ++a) {
			for (Department dep : departments) {
				if (dep.getDepartmentName().charAt(0) == a) {
					System.out.println(dep.getDepartmentName());
				}
			}
		}
	}

	public static void main(String[] args) {
		Exercise5 ex = new Exercise5();
		ex.Question1();
		ex.Question2();
		ex.Question4();
		ex.Question5();
		ex.Question6();
	}
}
