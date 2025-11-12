package JavaVTI;

import java.time.LocalDateTime;

public class Account {
	private int accountID;
	private String email;
	private String username;
	private String fullname;
	private Department department;
	private Position position;
	private LocalDateTime createDate;

	public Account(int accountID, String email, String username, String fullname, Department department,
			Position position, LocalDateTime createDate) {
		this.accountID = accountID;
		this.email = email;
		this.username = username;
		this.fullname = fullname;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
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

	@Override
	public String toString() {
		return String.format(
				"Account{ID = %d, Email = %s, Username = %s, Fullname = %s, "
						+ "\n        DepartmentID = %s, PositionID = %s, Create Date = %s}",
				accountID, email, username, fullname, department != null ? department.getDepartmentID() : "null",
				position != null ? position.getPositionID() : "null", createDate);
	}

}
