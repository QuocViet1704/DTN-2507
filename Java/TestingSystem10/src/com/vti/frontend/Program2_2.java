package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.AccountManagement;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class Program2_2 {
	public static void main(String[] args)
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		AccountManagement accountManagement = new AccountManagement();

		JdbcUtils jdbcUtils = new JdbcUtils();
		jdbcUtils.connnectionTestting();
		while (true) {
			String leftAlignFormat = "| %-72s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Question 1: Read data – get list departments");
			System.out.format(leftAlignFormat, "2. Question 2: Read data – get department by id = 5");
			System.out.format(leftAlignFormat, "3. Question 3: Read data – get department by id");
			System.out.format(leftAlignFormat, "4. Question 4: check data exists – check department name exists");
			System.out.format(leftAlignFormat, "5. Question 5: create data – create department");
			System.out.format(leftAlignFormat, "6. Question 6: update data – update department");
			System.out.format(leftAlignFormat, "7. Question 7: Delete by ID");
			System.out.format(leftAlignFormat, "8. Question 8: Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");

			int choose = ScannerUtils.inputIntPositive();

			switch (choose) {
			case 1:
				accountManagement.getAllAccount();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}
}
