package com.vti.Exercise;

import java.time.LocalDateTime;

import com.vti.entity.Account;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.Group;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;

public class Program {
	public Account[] accounts;
	public Group[] groups;
	public Department[] departments;
	public Position[] positions;
	public Exam[] exams;

	public Program() {
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
		Group grp4 = new Group(2004, "Java Beginner", acc5, null);
		Group grp5 = new Group(2005, "Java Advanced", acc5, null);

		// GroupAccount
		acc1.addGroup(grp1, grp2);
		acc2.addGroup(grp1, grp3);
		acc3.addGroup(grp1, grp2, grp3);
		acc5.addGroup(grp3);

		grp1.addAccount(acc1, acc2, acc3);
		grp2.addAccount(acc1, acc3);
		grp3.addAccount(acc2, acc3);

		// CategoryQuestion
		CategoryQuestion cques1 = new CategoryQuestion(101, "Database");
		CategoryQuestion cques2 = new CategoryQuestion(102, "Java");
		CategoryQuestion cques3 = new CategoryQuestion(103, "C++");
		CategoryQuestion cques4 = new CategoryQuestion(104, "Python");
		CategoryQuestion cques5 = new CategoryQuestion(105, "Ruby");

		// Exam
		Exam exam1 = new Exam(1, "901", "Đề thi 01", cques2, 120, acc3, LocalDateTime.parse("2019-10-01T00:00:00"));
		Exam exam2 = new Exam(2, "902", "Đề thi 02", cques2, 90, acc4, LocalDateTime.parse("2019-11-19T00:00:00"));
		Exam exam3 = new Exam(3, "903", "Đề thi 03", cques1, 60, acc4, LocalDateTime.parse("2023-10-01T00:00:00"));
		Exam exam4 = new Exam(4, "904", "Đề thi 04", cques3, 30, acc2, LocalDateTime.parse("2025-01-10T00:00:00"));
		Exam exam5 = new Exam(5, "905", "Đề thi 05", cques5, 120, acc3, LocalDateTime.parse("2020-10-01T00:00:00"));

		this.accounts = new Account[] { acc1, acc2, acc3, acc4, acc5 };
		this.groups = new Group[] { grp1, grp2, grp3 };
		this.departments = new Department[] { dep1, dep2, dep3, dep4, dep5 };
		this.positions = new Position[] { pos1, pos2, pos3, pos4 };
		this.exams = new Exam[] { exam1, exam2, exam3, exam4, exam5 };
	}

	Account[] getAccounts() {
		return this.accounts;
	}

	Group[] getGroups() {
		return this.groups;
	}

	public static void main(String[] args) {

		Department.getAllDepartments();

	}
}
