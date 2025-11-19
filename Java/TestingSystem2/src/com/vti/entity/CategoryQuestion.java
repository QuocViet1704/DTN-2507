package com.vti.entity;

public class CategoryQuestion {
	private int id;
	private String name;

	public CategoryQuestion(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getCategoryID() {
		return id;
	}

	public void setCategoryID(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return name;
	}

	public void setCategoryName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("CategoryQuestion{ID = %d, Name = %s}", id, name);
	}
}
