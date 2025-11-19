package com.vti.Exercise;

import java.util.List;

import com.vti.entity.Account;

public class Exercise6 {
	public void Question1() {
		for (int i = 0; i < 10; ++i) {
			if (i % 2 == 0) {
				System.out.println(i + " ");
			}
		}
	}

	public void Question2() {
		Program program = new Program();
		List<Account> accounts = Account.getAllAccounts();

		System.out.println("Thông tin toàn bộ Account: ");
		for (Account acc : accounts) {
			System.out.println("--------------------------------");
			System.out.printf(
					"Account Id: % d %nEmail: %s %nUsername: %s %nFullname: %s %nDepartment: %s %nPosition: %s %n",
					acc.getAccountid(), acc.getEmail(), acc.getUsername(), acc.getFullname(),
					acc.department.getDepartmentName(), acc.position.getPositionName());
		}
	}

	public void Question3() {
		for (int i = 0; i < 10; ++i) {
			System.out.println(i + " ");
		}
	}

	public static void main(String[] args) {
		Exercise6 ex = new Exercise6();
		ex.Question1();
		ex.Question2();
		ex.Question3();
	}
}
