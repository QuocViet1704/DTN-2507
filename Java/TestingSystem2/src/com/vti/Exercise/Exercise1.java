package com.vti.Exercise;

import java.time.LocalDateTime;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Exercise1 {
	public static void main(String[] args) {
		// Department
		Department dep1 = new Department(1, "Sale");
		Department dep2 = new Department(2, "Marketing");
		Department dep3 = new Department(3, "Teacher");
		Department dep4 = new Department(4, "Boss");
		Department dep5 = new Department(5, "Cleaner");

		// Position
		Position pos1 = new Position(001, PositionName.PM);
		Position pos2 = new Position(002, PositionName.SCRUM_MASTER);
		Position pos3 = new Position(003, PositionName.DEV);
		Position pos4 = new Position(004, PositionName.TEST);

		// Account

		Account acc1 = new Account(1001, "vietlee@gmail.com", "viet04", "Le Quoc Viet", dep5, pos4,
				LocalDateTime.parse("2023-10-01T00:00:00"));
		Account acc2 = new Account(1002, "trgngx@gmail.com", "truongngx04", "Nguyen Khac Truong", dep5, pos4,
				LocalDateTime.parse("2022-01-17T00:00:00"));
		Account acc3 = new Account(1003, "sinhng@gmail.com", "sinhnguyen0104", "Nguyen Thanh Sinh", dep1, pos1,
				LocalDateTime.parse("2022-10-21T00:00:00"));
		Account acc4 = new Account(1004, "chipp03@gmail.com", "chipham", "Pham Phuong Chi", dep1, pos2,
				LocalDateTime.parse("2021-10-15T00:00:00"));
		Account acc5 = new Account(1005, "hungmanh@gmail.com", "manh04", "Nguyen Hung Manh", dep2, pos3,
				LocalDateTime.parse("2024-10-01T00:00:00"));

		// Group
		Group grp1 = new Group(2001, "Junior", acc1, LocalDateTime.parse("2019-10-01T00:00:00"));
		Group grp2 = new Group(2002, "Senior", acc1, LocalDateTime.parse("2020-11-14T00:00:00"));
		Group grp3 = new Group(2003, "Master", acc1, LocalDateTime.parse("2024-07-01T00:00:00"));

		// GroupAccount
		Group[] group_account1 = { grp1, grp2 };
		acc1.groups = group_account1;

		Group[] group_account2 = { grp2, grp1 };
		acc2.groups = group_account2;

		Group[] group_account3 = { grp1, grp2, grp3 };
		acc3.groups = group_account3;

// Exercise 1
		// Question 1
		System.out.println("-- Question 1: Kiểm tra phòng ban account thứ 2");
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên này là " + acc2.department.getDepartmentName());
		}

		// Question 2
		System.out.println("-- Question 2: Kiểm tra group account thứ 2");
		int countGroupAccount2 = acc2.groups.length;
		if (acc2.groups == null) {
			System.out.println("Nhân viên này chưa có group");
		} else if (countGroupAccount2 == 1 || countGroupAccount2 == 2) {
			System.out.println("Group của nhân viên này là là Java Fresher, C# Fresher");
		} else if (countGroupAccount2 == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

		// Question 3
		System.out.println("-- Question 3: Dùng toán tử ternary để làm Question 1");
		System.out.println(acc2.department == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là " + acc2.department.getDepartmentName());

		// Question 4
		System.out.println("-- Question 4: Sử dụng toán tử ternary để làm yêu cầu sau");
		System.out.println("Position của Account thứ 1: " + acc1.getPosition().getPositionName());
		System.out.println(acc1.getPosition().getPositionName() == Position.PositionName.DEV ? "Đây là Developer"
				: "Người này không phải là Developer");

		// Question 5
//		System.out.println("-- Question 5: Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format");

//		switch (grp1.accounts.length) {
//		case 1:
//			System.out.println("Nhóm có một thành viên");
//			break;
//		case 2:
//			System.out.println("Nhóm có hai thành viên");
//			break;
//		case 3:
//			System.out.println("Nhóm có ba thành viên");
//			break;
//		default:
//			System.out.println("Nhóm có nhiều thành viên");
//			break;
//		}

		// Question 6
		System.out.println("-- Question 6: Sử dụng switch case để làm lại Question 2");
		int countGroup2 = acc2.groups.length;
		switch (countGroup2) {
		case 0:
			System.out.println("Nhân viên này chưa có phòng ban");
			break;
		case 1:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}

		// Question 7
		System.out.println("-- Question 7: Sử dụng switch case để làm lại Question 4");
		switch (acc1.position.getPositionName()) {
		case DEV:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}

		// Question 8
		System.out
				.println("-- Question 8: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ");
		Account[] accArray = { acc1, acc2, acc3, acc4, acc5 };
		for (Account x : accArray) {
			System.out.println("--------------------");
			System.out.println("Email: " + x.email);
			System.out.println("FullName: " + x.fullname);
			System.out.println("Department Name: " + x.department.getDepartmentName());
		}

		// Question 9
		System.out.println("-- Question 9: In ra thông tin các phòng ban bao gồm: id và name");
		Department[] depArray = { dep1, dep2, dep3, dep4, dep5 };
		for (Department x : depArray) {
			System.out.println("--------------------");
			System.out.println("Department ID: " + x.getDepartmentID());
			System.out.println("Department Name: " + x.getDepartmentName());
		}

		// Question 10
		System.out.println(
				"-- Question 10: In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng mẫu");
		for (int i = 0; i < accArray.length; ++i) {
			System.out.println("--------------------");
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Fullname: " + accArray[i].fullname);
			System.out.println("Phòng ban: " + accArray[i].department.getDepartmentName());
		}

		// Question 11
		System.out.println("-- Question 11: In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:");
		for (int i = 0; i < depArray.length; ++i) {
			System.out.println("--------------------");
			System.out.println("Thông tin department thứ " + (i + 1) + " là: ");
			System.out.println("      Id: " + depArray[i].getDepartmentID());
			System.out.println("      Name: " + depArray[i].getDepartmentName());
		}

		// Question 12
		System.out.println("-- Question 12: Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10");
		for (int i = 0; i < 2; ++i) {
			System.out.println("--------------------");
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("Id: " + depArray[i].getDepartmentID());
			System.out.println("Name: " + depArray[i].getDepartmentName());
		}

		// Question 13
		System.out.println("-- Question 13: In ra thông tin tất cả các account ngoại trừ account thứ 2");
		for (int i = 0; i < accArray.length; ++i) {
			if (i + 1 != 2) {
				System.out.println("--------------------");
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Id: " + accArray[i].id);
				System.out.println("Email: " + accArray[i].email);
				System.out.println("Fullname: " + accArray[i].fullname);
				System.out.println("Username" + accArray[i].username);
				System.out.println("Phòng ban: " + accArray[i].department.getDepartmentName());
				System.out.println("Position: " + accArray[i].position.getPositionName());
				System.out.println("Create Date: " + accArray[i].createDate);
			}
		}

		// Question 14
		System.out.println("-- Question 14: In ra thông tin tất cả các account có id < 4");
		for (int i = 0; i < accArray.length; ++i) {
			if (i + 1 < 4) {
				System.out.println("--------------------");
				System.out.println("Thông tin account thứ " + (i + 1) + " là:");
				System.out.println("Id: " + accArray[i].id);
				System.out.println("Email: " + accArray[i].email);
				System.out.println("Fullname: " + accArray[i].fullname);
				System.out.println("Username" + accArray[i].username);
				System.out.println("Phòng ban: " + accArray[i].department.getDepartmentName());
				System.out.println("Position: " + accArray[i].position.getPositionName());
				System.out.println("Create Date: " + accArray[i].createDate);

			}
		}

		// Question 15
		System.out.println("-- Question 15: In ra các số chẵn nhỏ hơn hoặc bằng 20");
		for (int i = 0; i <= 20; ++i) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

		// Question 16
		System.out.println(
				"-- Question 16: Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue");
		// ---Question 16-10 -----
		int i = 0;
		while (i < accArray.length) {
			System.out.println("--------------------");
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accArray[i].email);
			System.out.println("Fullname: " + accArray[i].fullname);
			System.out.println("Phòng ban: " + accArray[i].department.getDepartmentName());
			++i;
		}

		// ---Question 16-11 -----
		int i1 = 0;
		while (i1 < depArray.length) {
			System.out.println("--------------------");
			System.out.println("Thông tin department thứ " + (i1 + 1) + " là: ");
			System.out.println("      Id: " + depArray[i1].getDepartmentID());
			System.out.println("      Name: " + depArray[i1].getDepartmentName());
			++i1;
		}

		// ---Question 16-12 -----
		int i2 = 0;
		while (i2 < 2) {
			System.out.println("--------------------");
			System.out.println("Thông tin department thứ " + (i2 + 1) + " là:");
			System.out.println("Id: " + depArray[i2].getDepartmentID());
			System.out.println("Name: " + depArray[i2].getDepartmentName());
			++i2;
		}

		// ---Question 16-13 -----
		int i3 = 0;
		while (i3 < accArray.length) {
			if (i3 + 1 != 2) {
				System.out.println("--------------------");
				System.out.println("Thông tin account thứ " + (i3 + 1) + " là:");
				System.out.println("Id: " + accArray[i3].id);
				System.out.println("Email: " + accArray[i3].email);
				System.out.println("Fullname: " + accArray[i3].fullname);
				System.out.println("Username" + accArray[i3].username);
				System.out.println("Phòng ban: " + accArray[i3].department.getDepartmentName());
				System.out.println("Position: " + accArray[i3].position.getPositionName());
				System.out.println("Create Date: " + accArray[i3].createDate);
			}
			++i3;
		}

		// ---Question 16-14 -----
		int i4 = 0;
		while (i4 < accArray.length) {
			if (i4 + 1 < 4) {
				System.out.println("--------------------");
				System.out.println("Thông tin account thứ " + (i4 + 1) + " là:");
				System.out.println("Id: " + accArray[i4].id);
				System.out.println("Email: " + accArray[i4].email);
				System.out.println("Fullname: " + accArray[i4].fullname);
				System.out.println("Username" + accArray[i4].username);
				System.out.println("Phòng ban: " + accArray[i4].department.getDepartmentName());
				System.out.println("Position: " + accArray[i4].position.getPositionName());
				System.out.println("Create Date: " + accArray[i4].createDate);

			}
			++i4;
		}

	}
}
