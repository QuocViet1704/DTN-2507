package com.vti.Exercise;

import java.time.LocalDateTime;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class DataInitializer {
	public Department[] initDepartments() {
		Department dep1 = new Department(1, "Sale");
		Department dep2 = new Department(2, "Marketing");
		Department dep3 = new Department(3, "Teacher");
		Department dep4 = new Department(4, "Boss");
		Department dep5 = new Department(5, "Cleaner");

		return new Department[] { dep1, dep2, dep3, dep4, dep5 };
	}

	public Position[] initPositions() {
		Position pos1 = new Position(001, PositionName.PM);
		Position pos2 = new Position(002, PositionName.SCRUM_MASTER);
		Position pos3 = new Position(003, PositionName.DEV);
		Position pos4 = new Position(004, PositionName.TEST);

		return new Position[] { pos1, pos2, pos3, pos4 };
	}

	public Account[] initAccounts(Department[] deps, Position[] poses) {
		Account acc1 = new Account(1001, "vietlee@gmail.com", "viet04", "Le Quoc Viet", deps[5], poses[4],
				LocalDateTime.parse("2023-10-01T00:00:00"));
		Account acc2 = new Account(1002, "trgngx@gmail.com", "truongngx04", "Nguyen Khac Truong", deps[5], poses[4],
				LocalDateTime.parse("2022-01-17T00:00:00"));
		Account acc3 = new Account(1003, "sinhng@gmail.com", "sinhnguyen0104", "Nguyen Thanh Sinh", deps[1], poses[1],
				LocalDateTime.parse("2022-10-21T00:00:00"));
		Account acc4 = new Account(1004, "chipp03@gmail.com", "chipham", "Pham Phuong Chi", deps[1], poses[2],
				LocalDateTime.parse("2021-10-15T00:00:00"));
		Account acc5 = new Account(1005, "hungmanh@gmail.com", "manh04", "Nguyen Hung Manh", deps[2], poses[3],
				LocalDateTime.parse("2024-10-01T00:00:00"));

		return new Account[] { acc1, acc2, acc3, acc4, acc5 };
	}

}
