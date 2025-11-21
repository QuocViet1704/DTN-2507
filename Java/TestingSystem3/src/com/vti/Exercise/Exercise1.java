package com.vti.Exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
	Scanner sc = new Scanner(System.in);

	public void Question1() {
		float luongAccount1 = 5240.5f;
		float luongAccount2 = 10970.055f;
		int luongAcc1 = (int) luongAccount1;
		int luongAcc2 = (int) luongAccount2;
		System.out.println("Lương của Account 1: " + luongAcc1);
		System.out.println("Lương của Account 2: " + luongAcc2);
	}

	public void Question2() {
		Random rd = new Random();
		int number = rd.nextInt(100000);

		System.out.printf("Số 5 chữ số: %05d%n", number);
	}

	public void Question3() {
		Random rd = new Random();
		int a = rd.nextInt(100000);
		int b = a % 100;
		System.out.printf("Số dư của %d là: %d%n", a, b);
	}

	public void Question4() {
		System.out.println("Nhập vào hai số nguyên:");
		int a = sc.nextInt();
		int b = sc.nextInt();

		float thuong = (float) a / b;
		System.out.printf("Thương của 2 số nguyên %d và %d là: %.2f", a, b, thuong);
	}

	public static void main(String[] args) {
		Exercise1 ex = new Exercise1();
		ex.Question1();
		ex.Question2();
		ex.Question3();
		ex.Question4();
	}
}
