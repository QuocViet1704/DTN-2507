package com.vti.frontend;

import java.util.Scanner;

public class Program1 {

	public static int inputAge() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				String input = sc.nextLine();
				int age = Integer.parseInt(input);
				if (age < 0) {
					System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
				} else {
					return age;
				}
			} catch (NumberFormatException e) {
				System.out.println("wrong inputing! Please input an age as int, input again.");
			}
		}
	}

	public static void main(String[] args) {
		inputAge();
	}
}
