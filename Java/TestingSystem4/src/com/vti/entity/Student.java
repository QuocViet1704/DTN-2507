package com.vti.entity;

public class Student {
	private int id;
	private String name;
	private String hometown;
	private float point;

	public Student(String name, String hometown) {
		this.name = name;
		this.hometown = hometown;
		this.point = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public float getPoint() {
		return point;
	}

	public void setPoint(float point) {
		this.point = point;
	}

	public void showInfo() {
		System.out.println("Thông tin sinh viên");
		System.out.println("Tên: " + this.getName());
		if (this.getPoint() < 4) {
			System.out.println("Điểm học lực: Yếu");
		} else if (this.getPoint() > 4 && this.getPoint() < 6) {
			System.out.println("Điểm học lực: Trung Bình");
		} else if (this.getPoint() > 6 && this.getPoint() < 8) {
			System.out.println("Điểm học lực: Khá");
		} else if (this.getPoint() > 8) {
			System.out.println("Điểm học lực: Giỏi");
		}

	}

}
