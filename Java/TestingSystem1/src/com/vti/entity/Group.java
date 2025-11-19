package com.vti.entity;

import java.time.LocalDateTime;

public class Group {
	public int id;
	public String Name;
	public Account creatorID;
	public LocalDateTime createDate;
	public Account[] accounts;

	public Group(int id, String Name, Account creatorID, LocalDateTime createDate) {
		this.id = id;
		this.Name = Name;
		this.creatorID = creatorID;
		this.createDate = createDate;
	}

	public int getGroupID() {
		return id;
	}

	public void setGroupID(int ID) {
		this.id = id;
	}

	public String getGroupName() {
		return Name;
	}

	public void setGroupName(String Name) {
		this.Name = Name;
	}

	public Account getCreatorID() {
		return creatorID;
	}

	public void setCreatorID(Account creatorID) {
		this.creatorID = creatorID;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return String.format("Group{ID = %d, Name = %s, Creator ID = %d, Create Date = %s}", id, Name, creatorID,
				createDate);
	}
}
