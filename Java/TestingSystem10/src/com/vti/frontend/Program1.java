package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.PositionManagement;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class Program1 {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		PositionManagement positionManagement = new PositionManagement();

		JdbcUtils jdbcUtils = new JdbcUtils();

		while (true) {
			String leftAlignFormat = "| %-75s |%n";
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format("|                        Choose please                                     |%n");
			System.out.format("+--------------------------------------------------------------------------+%n");
			System.out.format(leftAlignFormat, "1. Question 1: Check connection");
			System.out.format(leftAlignFormat, "2. Question 2: Read data – get list positions");
			System.out.format(leftAlignFormat, "3. Question 3: create data – create position");
			System.out.format(leftAlignFormat,
					"4. Question 4: update data – update departmentName = Dev where departmentID = 5");
			System.out.format(leftAlignFormat, "5. Question 5: Delete by ID");
			System.out.format(leftAlignFormat, "6. Question 6: Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");

			int choose = ScannerUtils.inputIntPositive();

			switch (choose) {
			case 1:
				jdbcUtils.connnectionTestting();
				break;
			case 2:
				positionManagement.getAllPosition();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				return;
			default:
				System.out.println("Nhập lại:");
				break;
			}
		}
	}
}
