package com.vti.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vti.utils.ScannerUtils;

public class Account {
	public int id;
	public String email;
	public String username;
	public String fullname;
	public Department department;
	public Position position;
	public LocalDateTime createDate;
	public Group[] groups;

	private static List<Account> accounts = new ArrayList<>();

	public Account(String email, String username, String fullname, LocalDateTime createDate) {
		super();
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.createDate = createDate;
	}

	public Account(int id, String email, String username, String fullname, Department department, Position position,
			LocalDateTime createDate) {
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public int getGroupCount() {
		return groups == null ? 0 : groups.length;
	}

	public void addGroup(Group group) {
		if (group == null) {
			return;
		}

		if (groups == null) {
			groups = new Group[] { group };
		} else {
			groups = Arrays.copyOf(groups, groups.length + 1);
			groups[groups.length - 1] = group;
		}
	}

	public void addGroup(Group... newGroups) {
		if (newGroups == null || newGroups.length == 0) {
			return;
		}

		if (groups == null) {
			groups = Arrays.copyOf(newGroups, newGroups.length);
		} else {
			int oldLength = getGroupCount();
			groups = Arrays.copyOf(groups, oldLength + newGroups.length);
			System.arraycopy(newGroups, 0, groups, oldLength, newGroups.length);
		}
	}

	public static List<Account> getAllAccounts() {
		return accounts;
	}

	public void inputAccountAge() throws InvalidAgeInputingException {
		while (true) {
			int age = ScannerUtils.inputInt("wrong inputing! Please input an int type, input again");
			if (age <= 0) {
				throw new InvalidAgeInputingException("The age must be greater than 0");
			} else {
				return;
			}
		}

	}

	@Override
	public String toString() {
		return String.format(
				"Account{id = %d, Email = %s, Username = %s, Fullname = %s, "
						+ "\n        Departmentid = %s, Positionid = %s, Create Date = %s}",
				id, email, username, fullname, department != null ? department.getDepartmentID() : "null",
				position != null ? position.getPositionID() : "null", createDate);
	}

}
