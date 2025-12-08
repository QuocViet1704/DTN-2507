package com.vti.backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.dao.DepartmentDao;
import com.vti.entity.Department;
import com.vti.utils.ScannerUtils;

public class DepartentManagement {

	private DepartmentDao departmentDao;

	public DepartentManagement() throws FileNotFoundException, IOException {
		super();
		departmentDao = new DepartmentDao();
	}

	public void getAllDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Hiển thị danh sách phòng ban trên hệ thống");
		List<Department> departmentList = departmentDao.getAllDepartment();

		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");

		for (Department department : departmentList) {
			System.out.format(leftAlignFormat, department.getId(), department.getName());
		}
		System.out.format("+--------+-----------------------+%n");
	}

	public void getDepartmentByID_5() throws ClassNotFoundException, SQLException {
		System.out.println("Thông tin phòng ban số 5");
		Department department = departmentDao.getDepartmentByID_5();
		String leftAlignFormat = "| %-6d | %-21s |%n";

		System.out.format("+--------+-----------------------+%n");
		System.out.format("|   ID   | Department Name       |%n");
		System.out.format("+--------+-----------------------+%n");
		System.out.format(leftAlignFormat, department.getId(), department.getName());
		System.out.format("+--------+-----------------------+%n");
	}

	public void getDepartmentByID() throws ClassNotFoundException, SQLException {

		System.out.println("Nhập vào ID của phòng ban bạn muốn tìm: ");
		int id = ScannerUtils.inputIntPositive();
		Department department = departmentDao.getDepartmentByID(id);

		if (department == null) {
			System.out.println("Cannot find department which has id = " + id);
		} else {
			System.out.println("Thông tin phòng ban người dùng yêu cầu");
			String leftAlignFormat = "| %-6d | %-21s |%n";

			System.out.format("+--------+-----------------------+%n");
			System.out.format("|   ID   | Department Name       |%n");
			System.out.format("+--------+-----------------------+%n");
			System.out.format(leftAlignFormat, department.getId(), department.getName());
			System.out.format("+--------+-----------------------+%n");
		}
	}

	public void checkIfDepartmentExist() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào tên phòng ban bạn muốn kiểm tra: ");
		String name = ScannerUtils.inputString();
		Department department = departmentDao.checkIfDepartmentExist(name);

		if (department == null) {
			System.out.println("Không có phòng ban tên " + name);
		} else {
			System.out.println("Có phòng ban tên " + name);
		}
	}

	public void createDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Thêm phòng ban");
		System.out.println("Nhập vào id: ");
		int id = ScannerUtils.inputIntPositive();
		System.out.println("Nhập vào name: ");
		String name = ScannerUtils.inputString();
		Department department = departmentDao.createDepartment(id, name);

	}

	public void updateDepartmentName() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập vào id của phòng ban bạn muốn đổi tên: ");
		int id = ScannerUtils.inputIntPositive();
		boolean b = checkIfDepartmentIDExist(id);
		if (b == true) {
			System.out.println("Nhập vào tên bạn muốn đặt: ");
			String name = ScannerUtils.inputString();

			Department department = departmentDao.updateDepartmentName(id, name);
		} else {
			System.out.println("Không tồn tại phòng ban " + id);
		}
	}

	public boolean checkIfDepartmentIDExist(int id) throws ClassNotFoundException, SQLException {
		Department department = departmentDao.checkIfDepartmentIDExist(id);

		if (department == null) {
			return false;
		} else {
			return true;
		}
	}

	public void deleteDepartment() throws ClassNotFoundException, SQLException {
		System.out.println("Nhập id của phòng ban bạn muốn xóa: ");
		int deleteID = ScannerUtils.inputIntPositive();
		boolean b = checkIfDepartmentIDExist(deleteID);

		if (b == true) {
			Department department = departmentDao.deleteDepartment(deleteID);
		} else {
			System.out.println("Không tồn tại phòng ban " + deleteID + " để có thể xóa");
		}

	}

}
