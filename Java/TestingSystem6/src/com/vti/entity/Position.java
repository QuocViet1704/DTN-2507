package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

import com.vti.utils.ScannerUtils;

public class Position {
	private int id;
	private PositionName name;

	public enum PositionName {
		DEV, TEST, SCRUM_MASTER, PM
	}

	private static List<Position> positions = new ArrayList<>();

	public Position() throws Exception {
		System.out.println("Nhập Position Id:");
		this.id = ScannerUtils.inputInt("wrong inputing! Please input an id as int type, input again");
		System.out.println("Nhập Position name: ");
		String input = ScannerUtils.inputString().toUpperCase();
		this.name = PositionName.valueOf(input);

		positions.add(this);
	}

	public Position(int id, PositionName name) {
		this.id = id;
		this.name = name;

		positions.add(this);
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

	public static Position getPositionById(int id) {
		for (Position pos : positions) {
			if (pos.getPositionID() == id) {
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
