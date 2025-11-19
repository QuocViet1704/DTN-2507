package com.vti.entity;

import java.time.LocalDateTime;

import com.vti.entity.Position.PositionName;
import com.vti.entity.TypeQuestion.TypeName;

public class Program {
	public static void main(String[] args) {
//Department 
		Department dep1 = new Department(1, "Sale");
		Department dep2 = new Department(2, "Marketing");
		Department dep3 = new Department(3, "Teacher");
		Department dep4 = new Department(4, "Boss");
		Department dep5 = new Department(5, "Cleaner");

//Position
		Position pos1 = new Position(001, PositionName.PM);
		Position pos2 = new Position(002, PositionName.SCRUM_MASTER);
		Position pos3 = new Position(003, PositionName.DEV);
		Position pos4 = new Position(004, PositionName.TEST);

//Account

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

//Group 
		Group grp1 = new Group(2001, "Junior", acc1, LocalDateTime.parse("2019-10-01T00:00:00"));
		Group grp2 = new Group(2002, "Senior", acc1, LocalDateTime.parse("2020-11-14T00:00:00"));
		Group grp3 = new Group(2003, "Master", acc1, LocalDateTime.parse("2024-07-01T00:00:00"));

//GroupAccount
		Group[] group_account1 = { grp1, grp2 };
		acc1.groups = group_account1;

		Group[] group_account2 = { grp2 };
		acc2.groups = group_account2;

		Group[] group_account3 = { grp1, grp2, grp3 };
		acc3.groups = group_account3;

//TypeQuestion
		TypeQuestion tques1 = new TypeQuestion(001, TypeName.ESSAY);
		TypeQuestion tques2 = new TypeQuestion(002, TypeName.MULTIPLE_CHOICE);

//CategoryQuestion
		CategoryQuestion cques1 = new CategoryQuestion(101, "Database");
		CategoryQuestion cques2 = new CategoryQuestion(102, "Java");
		CategoryQuestion cques3 = new CategoryQuestion(103, "C++");
		CategoryQuestion cques4 = new CategoryQuestion(104, "Python");
		CategoryQuestion cques5 = new CategoryQuestion(105, "Ruby");

//Question
		Question ques1 = new Question(0101, "Câu hỏi về Database", cques5, tques2, acc1,
				LocalDateTime.parse("2024-07-01T00:00:00"));
		Question ques2 = new Question(0201, "Câu hỏi về Java", cques4, tques1, acc2,
				LocalDateTime.parse("2023-07-21T00:00:00"));
		Question ques3 = new Question(0301, "Câu hỏi về C++", cques1, tques1, acc2,
				LocalDateTime.parse("2022-04-19T00:00:00"));
		Question ques4 = new Question(0401, "Câu hỏi về Python", cques1, tques2, acc1,
				LocalDateTime.parse("2020-07-01T00:00:00"));
		Question ques5 = new Question(0501, "Câu hỏi về Ruby", cques2, tques2, acc5,
				LocalDateTime.parse("2019-10-01T00:00:00"));

//Answer
		Answer ans1 = new Answer(01, "Câu trả lời cho Database", ques1, true);
		Answer ans2 = new Answer(02, "Câu trả lời cho Java", ques2, true);
		Answer ans3 = new Answer(03, "Câu trả lời cho C++", ques5, false);
		Answer ans4 = new Answer(04, "Câu trả lời cho Python", ques4, false);
		Answer ans5 = new Answer(05, "Câu trả lời cho Ruby", ques5, true);

//Exam 
		Exam exam1 = new Exam(1, "901", "Đề thi 01", cques2, 120, acc3, LocalDateTime.parse("2019-10-01T00:00:00"));
		Exam exam2 = new Exam(2, "902", "Đề thi 02", cques2, 90, acc4, LocalDateTime.parse("2019-11-19T00:00:00"));
		Exam exam3 = new Exam(3, "903", "Đề thi 03", cques1, 60, acc4, LocalDateTime.parse("2023-10-01T00:00:00"));
		Exam exam4 = new Exam(4, "904", "Đề thi 04", cques3, 30, acc2, LocalDateTime.parse("2025-01-10T00:00:00"));
		Exam exam5 = new Exam(5, "905", "Đề thi 05", cques5, 120, acc3, LocalDateTime.parse("2020-10-01T00:00:00"));

//ExamQuestion
		Question[] exam_question1 = { ques1, ques2 };
		exam1.questions = exam_question1;

		Question[] exam_question2 = { ques1, ques2, ques3 };
		exam2.questions = exam_question2;

		Question[] exam_question3 = { ques1 };
		exam3.questions = exam_question3;

		Question[] exam_question4 = { ques1, ques2, ques5, ques4 };
		exam4.questions = exam_question4;

		Question[] exam_question5 = { ques1, ques5, ques4 };
		exam5.questions = exam_question5;

		System.out.println(dep1);
		System.out.println(pos1);
		System.out.println(acc1);
		System.out.println(grp1);
		System.out.println(tques1);
		System.out.println(cques1);
		System.out.println(ques1);
		System.out.println(ans1);
		System.out.println(exam1);
	}
}
