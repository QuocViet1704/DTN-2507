package com.vti.Exercise;

import java.time.LocalDateTime;

import com.vti.entity.Account;

public class Exercise2 {
	public void Question1() {
		int a = 5;
		System.out.printf("%d%n", a);
	}

	public void Question2() {
		int a = 100000000;
		System.out.printf("%,d%n", a);
	}

	public void Question3() {
		float f = 5.567098f;
		System.out.printf("%.4f%n", f);
	}

	public void Question4() {
		String name = "Lê Quốc Việt";
		System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân%n", name);
	}

	public void Question5() {
		LocalDateTime time = LocalDateTime.now();
		System.out.printf("%1$td/%1$tm/%1$tY %1$tHh:%1$tMp:%1$tSs", time);
	}

	public void Question6(Account[] accounts) {
		System.out.println("Question 6");
		System.out.printf("|%4s|%20s|%10s|%20s|%25s|%20s|%n", "ID", "Email", "Username", "Fullname", "Department",
				"Position");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
		for (Account acc : accounts) {
			System.out.printf("|%4d|%20s|%10s|%20s|%25s|%20s|%30s|%n", acc.getAccountid(), acc.getEmail(),
					acc.getUsername(), acc.getFullname(), acc.getDepartment().getDepartmentName(),
					acc.getPosition().getPositionName());
		}
	}

	public static void main(String[] args) {
		Exercise2 ex = new Exercise2();
		Program program = new Program();
		Account[] account = program.getAccounts();
		ex.Question1();
		ex.Question2();
		ex.Question3();
		ex.Question4();
		ex.Question5();
		ex.Question6(account);
	}
}
