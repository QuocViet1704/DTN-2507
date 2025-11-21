package com.vti.frontend;

import com.vti.backend.StaffManagement;

public class Program {
	public static void main(String[] args) {
		StaffManagement sm = new StaffManagement();

		while (true) {
			sm.addStaff();
			sm.findByName();
		}
	}
}
