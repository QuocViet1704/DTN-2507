package com.vti.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.vti.utils.ScannerUtils;

public class Group {
	public int id;
	public String Name;
	public Account creatorID;
	public LocalDateTime createDate;
	public Account[] accounts;

	public static List<Group> groups = new ArrayList<>();

	public Group() throws Exception {
		System.out.println("Nhập Group Id: ");
		this.id = ScannerUtils.inputInt("wrong inputing! Please input an id as int type, input again");
		System.out.println("Nhập Group name:");
		this.Name = ScannerUtils.inputString();
		System.out.println("Nhập creator Id: ");
		int input = ScannerUtils.inputInt("wrong inputing! Please input an id as int type, input again");

		for (Account acc : Account.getAllAccounts()) {
			if (acc.getAccountid() == input) {
				this.creatorID = acc;
				break;
			}
		}

		if (this.creatorID == null) {
			System.out.println("Không tìm thấy Account này!");
		}

		System.out.println("Bạn có muốn nhập ");
	}

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
