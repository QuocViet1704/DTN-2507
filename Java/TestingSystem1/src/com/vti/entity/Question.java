package com.vti.entity;

import java.time.LocalDateTime;

public class Question {
	public int id;
	public String content;
	public CategoryQuestion categoryQuestion;
	public TypeQuestion type;
	public Account creator;
	public LocalDateTime createDate;

	public Question(int id, String content, CategoryQuestion categoryQuestion, TypeQuestion typeQuestion,
			Account creatorID, LocalDateTime createDate) {
		this.id = id;
		this.content = content;
		this.categoryQuestion = categoryQuestion;
		this.type = typeQuestion;
		this.creator = creator;
		this.createDate = createDate;
	}

	public int getQuestionID() {
		return id;
	}

	public void setQuestionID(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}

	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}

	public TypeQuestion getTypeQuestion() {
		return type;
	}

	public void setTypeQuestion(TypeQuestion type) {
		this.type = type;
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
				"Question{ID = %d, Content = %s, Category ID = %s, Type ID = %s, Creator ID = %d, Create Date = %s}",
				id, content, categoryQuestion != null ? categoryQuestion.getCategoryID() : "null",
				type != null ? type.getTypeID() : "null", creator, createDate);
	}
}
