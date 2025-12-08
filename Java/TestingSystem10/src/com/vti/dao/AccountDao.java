package com.vti.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;
import com.vti.utils.JdbcUtils;

public class AccountDao {
	private JdbcUtils jdbcUtils;
	DepartmentDao departmentDao = new DepartmentDao();
	PositionDao positionDao = new PositionDao();

	public AccountDao() throws FileNotFoundException, IOException {
		super();
		jdbcUtils = new JdbcUtils();
	}

	public List<Account> getAllAccount()
			throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
		String sqlGetAccount = "SELECT * FROM account";
		ResultSet resultSet = jdbcUtils.executeQuery(sqlGetAccount);

		List<Account> accountList = new ArrayList<Account>();

		while (resultSet.next()) {
			int depID = resultSet.getInt("DepartmentID");
			Department department = departmentDao.getDepartmentByID(depID);
			int posID = resultSet.getInt("PositionID");
			Position position = positionDao.getPositionById(posID);
			LocalDate lcd = resultSet.getDate("CreateDate").toLocalDate();

			Account account = new Account(resultSet.getInt("AccountID"), resultSet.getString("Email"),
					resultSet.getString("Username"), resultSet.getString("Fullname"), department, position, lcd);

			accountList.add(account);
		}

		jdbcUtils.disConnection();
		return accountList;
	}

}
