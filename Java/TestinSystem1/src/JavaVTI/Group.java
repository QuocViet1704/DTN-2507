package JavaVTI;

import java.time.LocalDateTime;

public class Group {
	private int groupID;
	private String groupName;
	private int creatorID;
	private LocalDateTime createDate;
	
	public Group(int groupID, String groupName, int creatorID, LocalDateTime createDate) {
		this.groupID = groupID;
		this.groupName = groupName;
		this.creatorID = creatorID;
		this.createDate = createDate;
	}
	
	public int getGroupID() {return groupID;}
	public void setGroupID(int groupID) {this.groupID = groupID;}

	public String getGroupName() {return groupName;}
	public void setGroupName(String groupName) {this.groupName = groupName;}
	
	public int getCreatorID() {return creatorID;}
	public void setCreatorID(int creatorID) {this.creatorID = creatorID;}
	
	public LocalDateTime getCreateDate() {return createDate;}
	public void setCreateDate(LocalDateTime createDate) {this.createDate = createDate;}
	
	@Override
	public String toString() {
		return String.format("Group{ID = %d, Name = %s, Creator ID = %d, Create Date = %s}",
				groupID, groupName, creatorID, createDate
		);
	}
}
