package com.vti.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Group {
	public int id;
	public String Name;
	public Account creatorID;
	public LocalDateTime createDate;
	public Account[] accounts;

	public static List<Group> groups = new ArrayList<>();

	public Group(int id, String Name, Account creatorID, LocalDateTime createDate) {
		this.id = id;
		this.Name = Name;
		this.creatorID = creatorID;
		this.createDate = createDate;

		groups.add(this);
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

	public int getAccountCount() {
		return accounts == null ? 0 : accounts.length;
	}

	public void addAccount(Account account) {
		if (account == null) {
			return;
		}

		if (accounts == null) {
			accounts = new Account[] { account };
		} else {
			accounts = Arrays.copyOf(accounts, accounts.length + 1);
			accounts[accounts.length - 1] = account;
		}
	}

	public void addAccount(Account... newAcounts) {
		if (newAcounts == null || newAcounts.length == 0) {
			return;
		}

		if (accounts == null) {
			accounts = Arrays.copyOf(newAcounts, newAcounts.length);
		} else {
			int oldLength = getAccountCount();
			accounts = Arrays.copyOf(accounts, oldLength + newAcounts.length);
			System.arraycopy(newAcounts, 0, accounts, oldLength, newAcounts.length);
		}
	}

	public static List<Group> getAllGroups() {
		return groups;
	}

	@Override
	public String toString() {
		return String.format("Group{ID = %d, Name = %s, Creator ID = %d, Create Date = %s}", id, Name, creatorID,
				createDate);
	}
}
