package JavaVTI;

import java.time.LocalDateTime;

public class GroupAccount {
	private Group group;
	private	Account account;
	private LocalDateTime joinDate;
	
	public GroupAccount(Group group, Account account, LocalDateTime joinDate) {
		this.account = account;
		this.group = group;
		this.joinDate = joinDate;
	}
	
	public Group getGroup() {return group;}
	public void setGroup(Group group) {this.group = group;}
	
	public Account getAccount() {return account;}
	public void setAccount(Account account) {this.account = account;}
	
	public LocalDateTime getJoinDate() {return joinDate;}
	public void setJoinDate(LocalDateTime joinDate) {this.joinDate = joinDate;}
	
	@Override
	public String toString() {
		return String.format("GroupAccount{Group ID = %s, Account ID = %s, Join Date = %s}",
				group != null ? group.getGroupID() : "null",
				account != null ? account.getAccountID() : "null",
				joinDate
		);
	}
}
