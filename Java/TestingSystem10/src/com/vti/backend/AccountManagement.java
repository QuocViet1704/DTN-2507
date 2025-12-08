package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.AccountDao;
import com.vti.entity.Account;

public class AccountManagement {
	private AccountDao accountDao;

	public AccountManagement() throws FileNotFoundException, IOException {
		super();
		accountDao = new AccountDao();
	}

	public void getAllAccount() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		System.out.println("Hiển thị danh sách Account trên hệ thống");
		List<Account> accountList = accountDao.getAllAccount();

		String leftAlignFormat = "| %-2d | %-21s | %-15s | %-21s | %-14s | %-16s | %n";
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");
		System.out.format(
				"|ID  | Email                 | Username        |   FullName            | Department     | Position         |%n");
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+%n");

		for (Account acc : accountList) {
			System.out.format(leftAlignFormat, acc.getAccountid(), acc.getEmail(), acc.getUsername(),
					acc.getFullname());
		}
		System.out.format(
				"+----+-----------------------+-----------------+-----------------------+----------------+------------------+------------------+%n");

	}

}
