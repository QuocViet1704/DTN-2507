package com.vti.entity;

public class Position {
	private int id;
	private PositionName name;

	public enum PositionName {
		DEV, TEST, SCRUM_MASTER, PM
	}

	public Position(int id, PositionName name) {
		this.id = id;
		this.name = name;
	}

	public int getPositionID() {
		return id;
	}

	public void setPositionID(int id) {
		this.id = id;
	}

	public PositionName getPositionName() {
		return name;
	}

	public void setPositionName(PositionName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Position{ID = %d, Name = %s}", id, name);
	}
}
