package com.vti.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.StudentQ1;

public class StudentManagement {
	Scanner sc = new Scanner(System.in);
	List<StudentQ1> studentList = new ArrayList<>();

	public void addStudent() {
		for (int i = 0; i < 3; ++i) {
			System.out.println("Nhập thông tin của học sinh thứ " + (i + 1) + ":");
			System.out.println("Nhập id: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Nhập tên: ");
			String name = sc.nextLine();
			System.out.println("Nhập group(1,2,3): ");
			int group = sc.nextInt();
			sc.nextLine();

			StudentQ1 stu = new StudentQ1(id, name, group);
			studentList.add(stu);
		}
	}

	public void rollCall() {
		System.out.println("Cả lớp điểm danh!!");
		for (StudentQ1 student : studentList) {
			student.rollcall();
		}
	}

	public void groupOneStudy() {
		System.out.println("Nhóm 1 đi học bài:");
		for (StudentQ1 student : studentList) {
			if (student.getGroup() == 1) {
				student.study();
			}
		}
	}

	public void groupTwoCleanning() {
		System.out.println("Nhóm 2 đi dọn vệ sinh:");
		for (StudentQ1 student : studentList) {
			if (student.getGroup() == 2) {
				student.cleaning();
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentManagement sm = new StudentManagement();
		while (true) {
			System.out.println("╔══════════════════════════════════╗");
			System.out.println("║            MENU CHÍNH            ║");
			System.out.println("╠══════════════════════════════════╣");
			System.out.println("║  1. Tạo 10 học sinh, chia 3 nhóm ║");
			System.out.println("║  2. Kêu gọi cả lớp điểm danh     ║");
			System.out.println("║  3. Gọi nhóm 1 học bài           ║");
			System.out.println("║  4. Gọi nhóm 2 dọn vệ sinh       ║");
			System.out.println("║  5. Thoát chương trình           ║");
			System.out.println("╚══════════════════════════════════╝");
			System.out.print("→ Nhập lựa chọn (1–5): ");

			int choose = sc.nextInt();
			sc.nextLine();

			switch (choose) {
			case 1: {
				sm.addStudent();
				break;
			}
			case 2: {
				sm.rollCall();
				break;
			}
			case 3: {
				sm.groupOneStudy();
				break;
			}
			case 4: {
				sm.groupTwoCleanning();
				break;
			}
			case 5: {
				return;
			}
			}
		}
	}
}
