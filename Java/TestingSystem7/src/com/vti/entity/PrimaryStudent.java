package com.vti.entity;

public final class PrimaryStudent extends Student {
	private static int count = 0;

	public PrimaryStudent(int id, String name) {
		super(id, name);
		if (super.countStudent() <= 7 && this.countStudent() + SecondaryStudent.countStudent() < 7) {
			System.out.println(super.countStudent());
			count++;
		} else {
		}
	}

	public static int countStudent() {
		return count;
	}

}
