package com.vti.Exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

public class Exercise5 {
	public void Question1() {
		int a = MyScanner.sc.nextInt();
		int b = MyScanner.sc.nextInt();
		int c = MyScanner.sc.nextInt();
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}

	public void Question2() {
		float f1 = MyScanner.sc.nextFloat();
		float f2 = MyScanner.sc.nextFloat();
		System.out.println("f1 = " + f1);
		System.out.println("f2 = " + f2);
	}

	public void Question3() {
		String name = MyScanner.sc.nextLine();
		System.out.println("Họ và tên: " + name);
	}

	public void Question4() {
		System.out.println("Nhập ngày sinh (dd/MM/yyyy)");

		String input = MyScanner.sc.nextLine();
		LocalDate dOb = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		System.out.println("Ngày sinh: " + dOb);
	}

//	public void Question5() {
//		int id = MyScanner.sc.nextInt();
//		MyScanner.sc.nextLine();
//		String email = MyScanner.sc.nextLine();
//		String fullname = MyScanner.sc.nextLine();
//		String username = MyScanner.sc.nextLine();
//		int positionID = MyScanner.sc.nextInt();
//		int departmentID = MyScanner.sc.nextInt();
//		String input = MyScanner.sc.nextLine();
////		LocalDateTime createDate = LocalDateTime.parse(input);
//		
//		Department dep = Department.getDepartmentById(departmentID);
//		Position pos = Position.getPositionById(positionID);
//		
//		Account account = new Account(id, email, username, fullname, dep, pos, createDate);
//	}

	public void Question6() {
		int depId = MyScanner.sc.nextInt();
		MyScanner.sc.nextLine();
		String depName = MyScanner.sc.nextLine();

		Department department = new Department(depId, depName);

		System.out.printf("Department: %d, %s%n", depId, depName);
	}

	public void Question7() {
		System.out.println("Nhập vào một số chẵn: ");
		int a = MyScanner.sc.nextInt();
		if (a % 2 == 0) {
			System.out.println(a + " là số chẵn");
		} else {
			System.out.println(a + " không phải là số chẵn");
		}
	}

	public void Question8() {
		System.out.println("Mời bạn nhập chức năng muốn sử dụng (1 hoặc 2): ");
		int a;

		while (true) {

			String input = MyScanner.sc.nextLine();

			try {
				a = Integer.parseInt(input);

				if (a != 1 && a != 2) {
					System.out.println("Mời bạn nhập lại!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.println("Sai định dạng! Nhập lại.\n");
				continue;
			}
		}

		if (a == 1) {
			System.out.println(
					"Nhập vào lần lượt các thông tin để tạo account(id, email, username, fullname, department Id, position Id): \n");
			int id = MyScanner.sc.nextInt();
			MyScanner.sc.nextLine();
			String email = MyScanner.sc.nextLine();
			String username = MyScanner.sc.nextLine();
			String fullname = MyScanner.sc.nextLine();
			int depId = MyScanner.sc.nextInt();
			int posId = MyScanner.sc.nextInt();
			Department department = Department.getDepartmentById(depId);
			Position position = Position.getPositionById(posId);
			LocalDateTime createDate = LocalDateTime.now();

			Account account = new Account(id, email, username, fullname, department, position, createDate);
		} else if (a == 2) {
			System.out.println("Nhập vào lần lượt các thông tin để tạo Department(id, name): \n");

			int depId = MyScanner.sc.nextInt();
			MyScanner.sc.nextLine();
			String depName = MyScanner.sc.nextLine();

			Department department = new Department(depId, depName);

		}
	}

	public static void main(String[] args) {
		Exercise5 ex = new Exercise5();
		Program program = new Program();
//		ex.Question1();
//		ex.Question2();
//		ex.Question3();
//		ex.Question4();
//		ex.Question6();
//		ex.Question7();
		ex.Question8();
		List<Account> list = Account.getAllAccounts();
		for (Account acc : list) {
			System.out.println(acc.getAccountid() + " - " + acc.getUsername() + " - " + acc.getFullname() + " - "
					+ acc.department.getDepartmentName() + " - " + acc.position.getPositionName());
		}
		List<Department> list2 = Department.getAllDepartments();

		for (Department dep : list2) {
			System.out.println(dep.getDepartmentID() + " - " + dep.getDepartmentName());
		}

	}
}
