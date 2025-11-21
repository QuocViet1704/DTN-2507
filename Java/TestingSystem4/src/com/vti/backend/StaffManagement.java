package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Staff;
import com.vti.entity.Staff.Gender;
import com.vti.entity.Worker;

public class StaffManagement {
	ArrayList<Staff> staffList = new ArrayList<>();
	private Scanner sc;

	public StaffManagement() {
		super();
		sc = new Scanner(System.in);
	}

	public void addStaff() {
		System.out.println("----------------------------------------------------");
		System.out.println("--------Lựa chọn chức năng bạn muốn sử dụng---------");
		System.out.println("---     1. Thêm Engineer                         ---");
		System.out.println("---     2. Thêm Worker                           ---");
		System.out.println("---     3. Thêm Employeee                        ---");
		System.out.println("----------------------------------------------------");
		int choose = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập tên: ");
		String name = sc.nextLine();
		System.out.println("Nhập tuổi: ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Nhập giới tính (Male, Female, Unknown): ");
		Gender gender;
		while (true) {
			try {
				String input = sc.nextLine().toUpperCase();
				gender = Gender.valueOf(input);
				break;
			} catch (Exception e) {
				System.out.println("Giới tính không hợp lệ! Vui lòng nhập lại");
			}
		}
		System.out.println("Nhập địa chỉ: ");
		String address = sc.nextLine();
		switch (choose) {
		case 1:
			System.out.println("Nhập ngành đào tạo: ");
			String training = sc.nextLine();

			Engineer engineer = new Engineer(name, age, gender, address, training);
			staffList.add(engineer);
			break;
		case 2:
			System.out.println("Nhập cấp bậc: ");
			int rank = sc.nextInt();
			sc.nextLine();

			Worker worker = new Worker(name, age, gender, address, rank);
			staffList.add(worker);
			break;
		case 3:
			System.out.println("Nhập ngành đào tạo: ");
			String task = sc.nextLine();

			Employee employee = new Employee(name, age, gender, address, task);
			staffList.add(employee);
			break;
		}
	}

	public void findByName() {
		System.out.println("Nhập tên cán bộ muốn tìm: ");
		String name = sc.nextLine();
		if (staffList.isEmpty()) {
			System.out.println("Không có cán bộ trong danh sách!!");
		} else {
			for (Staff staff : staffList) {
				if (staff.getName().equalsIgnoreCase(name)) {
					System.out.println("Tên: " + staff.getName());
					System.out.println("Tuổi: " + staff.getAge());
					System.out.println("Giới tính: " + staff.getGender());
					System.out.println("Địa chỉ: " + staff.getAddress());
				}
			}
		}
	}

	public void showInfo() {
		System.out.println("Danh sách các cán bộ");
		for (Staff staff : staffList) {
			System.out.println("Tên: " + staff.getName());
			System.out.println("Tuổi: " + staff.getAge());
			System.out.println("Giới tính: " + staff.getGender());
			System.out.println("Địa chỉ: " + staff.getAddress());

			if (staff instanceof Employee) {
				Employee employee = (Employee) staff;
				System.out.println("Công việc: " + employee.getTask());
			} else if (staff instanceof Engineer) {
				Engineer engineer = (Engineer) staff;
				System.out.println("Ngành đào tạo: " + engineer.getTraining());
			} else if (staff instanceof Worker) {
				Worker worker = (Worker) staff;
				System.out.println("Cấp bậc: " + worker.getRank());
			}
		}
	}

	public void deleteByName() {
		System.out.println("Nhập tên cán bộ muốn xóa: ");
		String deleteName = sc.nextLine();
		staffList.removeIf(s -> s.getName().equals(deleteName));
	}

}
