package com.vti.Exercise;

public class Exercise3 {
	public void Question1() {
		Integer input = 5000;
		Float luong = input.floatValue();

		System.out.printf("Lương: %.2f", luong);
	}

	public void Question2() {
		String input = "1234567";
		int a = Integer.parseInt(input);

		System.out.printf("Số nguyên sau khi convert ra int: %d", a);
	}

	public void Question3() {
		Integer input = 1234567;
		int a = input.intValue();

		System.out.printf("Số nguyên sau khi convert ra int: %d", a);
	}

	public static void main(String[] args) {
		Exercise3 ex = new Exercise3();
//		ex.Question1();
		ex.Question2();
	}
}
