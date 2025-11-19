package com.vti.Exercise;

import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
	Random random = new Random();

	public void Question1() {
		int a = random.nextInt();
		System.out.println("Số nguyên ngẫu nhiên " + a);
	}

	public void Question2() {
		float f = random.nextFloat();
		System.out.println("Số thực ngẫu nhiên " + f);
	}

	public void Question3() {
		String[] listName = { "Việt", "Trường", "Sinh", "Chi", "Mạnh", "Kiên", " Quyết" };
		int randIndex = random.nextInt(listName.length);
		System.out.println("In tên một bạn " + listName[randIndex]);
	}

	public void Question4() {
		int minDay = (int) LocalDate.of(1995, 7, 24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();

		long randomInt = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);

		System.out.println(randomDay);
	}

	public void Question5() {
		int maxDay = (int) LocalDate.now().toEpochDay();
		int minDay = (int) LocalDate.now().minusYears(1).toEpochDay();

		long randomInt = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);

		System.out.println(randomDay);
	}

	public void Question6() {
		int maxDay = (int) LocalDate.now().toEpochDay();
		int minDay = 0;

		long randomInt = minDay + random.nextInt(maxDay - minDay);

		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);

		System.out.println(randomDay);
	}

	public void Question7() {
		int a = random.nextInt(999 - 100 + 1) + 100;
		System.out.println(a);
	}

	public static void main(String[] args) {
		Random random = new Random();
		Exercise4 ex = new Exercise4();
		ex.Question1();
//		ex.Question3();
		ex.Question4();
		ex.Question5();
		ex.Question6();
		ex.Question7();
	}
}
