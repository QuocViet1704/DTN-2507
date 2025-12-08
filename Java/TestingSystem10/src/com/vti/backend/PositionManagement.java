package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.PositionDao;
import com.vti.entity.Position;

public class PositionManagement {
	private PositionDao positionDao;

	public PositionManagement() throws FileNotFoundException, IOException {
		super();
		positionDao = new PositionDao();
	}

	public void getAllPosition() throws ClassNotFoundException, SQLException {
//		System.out.println("Hiển thị danh sách phòng ban trên hệ thống");
		List<Position> positionList = positionDao.getAllPosition();

		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   |   Position Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Position position : positionList) {
			System.out.format(leftAlignFormat, position.getID(), position.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}
}
