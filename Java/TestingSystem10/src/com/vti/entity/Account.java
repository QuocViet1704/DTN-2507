package com.vti.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Account {
	public int id;
	public String email;
	public String username;
	public String fullname;
	public Department department;
	public Position position;
	public LocalDate createDate;

	public Account(int id, String email, String username, String fullname, Department department, Position position) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
	}

	public Account(int id, String email, String username, String fullname) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
	}

	private static List<Account> accounts = new ArrayList<>();

	public Account(String email, String username, String fullname, LocalDate createDate) {
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.createDate = createDate;
	}

	public Account(int id, String email, String username, String fullname, Department department, Position position,
			LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
		this.createDate = createDate;

		accounts.add(this);
	}

	public int getAccountid() {
		return id;
	}

	public void setAccountid(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public static List<Account> getAllAccounts() {
		return accounts;
	}

	@Override
	public String toString() {
		return String.format(
				"Account{id = %d, Email = %s, Username = %s, Fullname = %s, "
						+ "\n        Departmentid = %s, Positionid = %s, Create Date = %s}",
				id, email, username, fullname, department != null ? department.getId() : "null",
				position != null ? position.getID() : "null", createDate);
	}

}
