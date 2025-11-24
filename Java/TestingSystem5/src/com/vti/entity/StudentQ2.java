package com.vti.entity;

import java.util.Scanner;

public class StudentQ2 extends Person {
	Scanner sc = new Scanner(System.in);
	private int id;
	private int avgPoint;
	private String email;

	@Override
	public void inputInfo() {
		super.inputInfo();
		System.out.print("Nhập mã sinh viên: ");
		this.id = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhập điểm trung bình: ");
		this.avgPoint = sc.nextInt();
		sc.nextLine();
		System.out.print("Nhập email: ");
		this.email = sc.nextLine();
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("Mã sinh viên: " + this.id);
		System.out.println("Điểm trung bình: " + this.avgPoint);
		System.out.println("Email: " + this.email);
	}

	public void getScholarship() {
		if (this.avgPoint > 8) {
			System.out.println("Học sinh này dành được học bổng!");
		} else {
			System.out.println("Học sinh này không dành được học bổng!");
		}
	}

	public static void main(String[] args) {
		StudentQ2 stu = new StudentQ2();
		stu.inputInfo();
		stu.showInfo();
		stu.getScholarship();
	}
}
