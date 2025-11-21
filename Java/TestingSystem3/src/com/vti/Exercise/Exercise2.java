package com.vti.Exercise;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.vti.entity.Account;

public class Exercise2 {
	Scanner sc = new Scanner(System.in);

	public void Question1() {
		List<Account> accounts = new ArrayList<Account>();
		for (int i = 0; i < 5; ++i) {

			System.out.println("Nhập vào thông tin của account thứ " + (i + 1));
			String email = sc.nextLine();
			String username = sc.nextLine();
			String fullname = sc.nextLine();
			LocalDateTime createDate = LocalDateTime.now();

			Account acc = new Account(email, username, fullname, createDate);
			accounts.add(acc);
		}
		for (Account acc : accounts) {
			System.out.println("Email: " + acc.getEmail());
			System.out.println("Username: " + acc.getUsername());
			System.out.println("Fullname: " + acc.getFullname());
			System.out.println("Create Date: " + acc.getCreateDate());
		}

	}

	public static void main(String[] args) {
		Exercise2 ex = new Exercise2();
		ex.Question1();
		List<Account> accounts = new ArrayList<Account>();
		for (Account acc : accounts) {
			System.out.println("Email: " + acc.getEmail());
			System.out.println("Username: " + acc.getUsername());
			System.out.println("Fullname: " + acc.getFullname());
			System.out.println("Create Date: " + acc.getCreateDate());
		}
	}
}
