package com.vti.entity;

import java.time.LocalDateTime;

public class Exam {
	public int id;
	public String code;
	public String title;
	public CategoryQuestion[] categoryQuestion;
	public int duration;
	public Account creator;
	public LocalDateTime createDate;
	public Question[] questions;

	public Exam(int id, String code, String title, CategoryQuestion category, int duration, Account creator,
			LocalDateTime createDate) {
		this.id = id;
		this.code = code;
		this.title = title;
		this.categoryQuestion = categoryQuestion;
		this.duration = duration;
		this.creator = creator;
		this.createDate = createDate;
	}

	public int getExamID() {
		return id;
	}

	public void setExamID(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryQuestion[] getCategoryQuestion() {
		return categoryQuestion;
	}

	public void setCategoryQuestion(CategoryQuestion[] categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Account getCreatorID() {
		return creator;
	}

	public void setCreatorID(Account creator) {
		this.creator = creator;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return String.format(
				"Exam{ID = %d, Code = %s, Title = %s, CategoryID = %s, Duration = %d, Creator ID = %d, Create Date = %s}",
				id, code, title, categoryQuestion != null ? categoryQuestion : "null", duration, creator, createDate);
	}
}
