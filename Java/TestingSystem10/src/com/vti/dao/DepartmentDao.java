package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Department;
import com.vti.utils.JdbcUtils;

public class DepartmentDao {
	private JdbcUtils jdbcUtils;

	public DepartmentDao() throws FileNotFoundException, IOException {
		super();
		jdbcUtils = new JdbcUtils();
	}

	public List<Department> getAllDepartment() throws ClassNotFoundException, SQLException {
		String sqlGetDepartment = "SELECT * FROM department";
		ResultSet resultSet = jdbcUtils.executeQuery(sqlGetDepartment);

		List<Department> departments = new ArrayList();
		while (resultSet.next()) {
			Department department = new Department(resultSet.getInt("DepartmentID"),
					resultSet.getString("DepartmentName"));
			departments.add(department);
		}

		jdbcUtils.disConnection();
		return departments;
	}

	public Department getDepartmentByID_5() throws ClassNotFoundException, SQLException {
		String sqlGetDepartment = "SELECT * FROM department WHERE departmentID = 5";
		ResultSet resultSet = jdbcUtils.executeQuery(sqlGetDepartment);

		if (resultSet.next()) {
			Department department = new Department(resultSet.getInt("DepartmentID"),
					resultSet.getString("DepartmentName"));
			jdbcUtils.disConnection();
			return department;
		}
		jdbcUtils.disConnection();
		return null;
	}

	public Department getDepartmentByID(int id) throws ClassNotFoundException, SQLException {
		String sqlGetDepartment = "SELECT * FROM department WHERE departmentID = ?";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sqlGetDepartment);

		ps.setInt(1, id);

		ResultSet resultSet = ps.executeQuery();
		if (resultSet.next()) {
			Department department = new Department(resultSet.getInt("DepartmentID"),
					resultSet.getString("DepartmentName"));
			jdbcUtils.disConnection();
			return department;
		}
		jdbcUtils.disConnection();
		return null;
	}

	public Department checkIfDepartmentExist(String name) throws ClassNotFoundException, SQLException {
		String sqlCheckDepartment = "SELECT * FROM department WHERE departmentName = ?";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sqlCheckDepartment);
		ps.setString(1, name);

		ResultSet resultSet = ps.executeQuery();
		if (resultSet.next()) {
			Department department = new Department(resultSet.getInt("DepartmentID"),
					resultSet.getString("DepartmentName"));
			jdbcUtils.disConnection();
			return department;
		}
		jdbcUtils.disConnection();
		return null;
	}

	public Department createDepartment(int id, String name) throws ClassNotFoundException, SQLException {
		String sqlGetDepartment = "INSERT INTO department (departmentID, departmentName) VALUE (?,?)";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sqlGetDepartment);
		ps.setInt(1, id);
		ps.setString(2, name);

		int resultSet = ps.executeUpdate();
		return null;
	}

	public Department checkIfDepartmentIDExist(int id) throws ClassNotFoundException, SQLException {
		String sqlCheckDepartment = "SELECT * FROM department WHERE departmentID = ?";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sqlCheckDepartment);
		ps.setInt(1, id);

		ResultSet resultSet = ps.executeQuery();
		if (resultSet.next()) {
			Department department = new Department(resultSet.getInt("DepartmentID"),
					resultSet.getString("DepartmentName"));
			jdbcUtils.disConnection();
			return department;
		}
		jdbcUtils.disConnection();
		return null;
	}

	public Department updateDepartmentName(int id, String name) throws ClassNotFoundException, SQLException {
		String sqlGetDepartment = "UPDATE department SET departmentName = ? WHERE departmentID = ?";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sqlGetDepartment);
		ps.setString(1, name);
		ps.setInt(2, id);

		int rs = ps.executeUpdate();
		return null;
	}

	public Department deleteDepartment(int deleteID) throws ClassNotFoundException, SQLException {
		String sqlGetDepartment = "DELETE FROM department WHERE departmentID = ?";
		PreparedStatement ps = jdbcUtils.createPrepareStatement(sqlGetDepartment);
		ps.setInt(1, deleteID);

		int rs = ps.executeUpdate();
		return null;
	}

}
