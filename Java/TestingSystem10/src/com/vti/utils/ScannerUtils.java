package com.vti.utils;

import java.util.Scanner;

public class ScannerUtils {
	private static Scanner sc = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				String input = sc.nextLine();
				int a = Integer.parseInt(input);
				return 0;
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				String input = sc.nextLine();
				float f = Float.parseFloat(input);
				return 0;
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				String input = sc.nextLine();
				double d = Double.parseDouble(input);
				return 0;
			} catch (NumberFormatException e) {
				System.out.println(errorMessage);
			}
		}
	}

	public static String inputString() {
		String input = sc.nextLine();
		return input;
	}

	public static int inputIntPositive() {
		while (true) {
			try {
				String input = sc.nextLine();
				int a = Integer.parseInt(input);
				if (a < 0) {
					System.out.println("Nhập liệu sai! Vui lòng nhập vào số nguyên dương");
					continue;
				}
				return a;
			} catch (NumberFormatException e) {
				System.err.println("Nhập liệu sai! Vui lòng nhập vào một số nguyên");
			}
		}
	}

	public static int inputPhoneNumber(String errorMessage) {
		while (true) {
			try {
				String input = sc.nextLine();
				if (input.length() >= 11) {
					System.out.println("Nhập liệu sai! Vui lòng nhập vào số nguyên dương");
					continue;
				}
				int a = Integer.parseInt(input);

				return 0;
			} catch (NumberFormatException e) {
				System.err.println(errorMessage);
			}
		}
	}
}
