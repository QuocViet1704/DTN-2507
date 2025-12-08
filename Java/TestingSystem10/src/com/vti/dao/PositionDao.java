package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.utils.JdbcUtils;

public class PositionDao {
	private JdbcUtils jdbcUtils;

	public PositionDao() throws FileNotFoundException, IOException {
		super();
		jdbcUtils = new JdbcUtils();
	}

	public List<Position> getAllPosition() throws SQLException, ClassNotFoundException {
		String sqlGetPosition = "SELECT * FROM position";
		ResultSet resultSet = jdbcUtils.executeQuery(sqlGetPosition);

		List<Position> positions = new ArrayList();
		while (resultSet.next()) {
			String posName = resultSet.getString("PositionName");
			Position.PositionName positionName = Position.PositionName.valueOf(posName.replace(" ", ""));

			Position position = new Position(resultSet.getInt("PositionID"), positionName);
			positions.add(position);
		}

		jdbcUtils.disConnection();
		return positions;
	}

	public Position getPositionById(int id) throws ClassNotFoundException, SQLException {
		String sqlGetPosition = "SELECT * FROM position WHERE PositionID = ?";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sqlGetPosition);
		ps.setInt(1, id);
		ResultSet resultSet = ps.executeQuery();
		String posName = resultSet.getString("PositionName");
		PositionName positionName = PositionName.valueOf(posName);
		if (resultSet.next()) {
			Position position = new Position(resultSet.getInt("PositionID"), positionName);
			jdbcUtils.disConnection();
			return position;
		}
		jdbcUtils.disConnection();
		return null;
	}

}
