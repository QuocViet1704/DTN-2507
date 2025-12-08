package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.DepartentManagement;
import com.vti.utils.JdbcUtils;
import com.vti.utils.ScannerUtils;

public class Program2 {
	public static void main(String[] args)
			throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
		DepartentManagement departmentManagement = new DepartentManagement();

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
			System.out.format(leftAlignFormat, "7.Question 7: Delete by ID");
			System.out.format(leftAlignFormat, "8.Question 8: Exit");
			System.out.format("+--------------------------------------------------------------------------+%n");

			int choose = ScannerUtils.inputIntPositive();

			switch (choose) {
			case 1:
				departmentManagement.getAllDepartment();
				break;
			case 2:
				departmentManagement.getDepartmentByID_5();
				break;
			case 3:
				departmentManagement.getDepartmentByID();
				break;
			case 4:
				departmentManagement.checkIfDepartmentExist();
				break;
			case 5:
				departmentManagement.createDepartment();
				break;
			case 6:
				departmentManagement.updateDepartmentName();
				break;
			case 7:
				departmentManagement.deleteDepartment();
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
