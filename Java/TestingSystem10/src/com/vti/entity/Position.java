package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class Position {
	private int id;
	private PositionName name;

	public static enum PositionName {
		Dev, Test, Scrum_Master, PM
	}

	private static List<Position> positions = new ArrayList<>();

	public Position(int id, PositionName name) {
		this.id = id;
		this.name = name;

		positions.add(this);
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

	public static Position getPositionById(int id) {
		for (Position pos : positions) {
			if (pos.getID() == id) {
				return pos;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return String.format("Position{ID = %d, Name = %s}", id, name);
	}
}
