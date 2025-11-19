package com.vti.entity;

public class Answer {
	public int id;
	public String content;
	public Question question;
	public boolean isCorrect;

	public Answer(int id, String content, Question question, boolean isCorrect) {
		this.id = id;
		this.content = content;
		this.question = question;
		this.isCorrect = isCorrect;
	}

	public int getAnswerID() {
		return id;
	}

	public void setAnswerID(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return String.format("Answer{ID = %d, Content = %s, QuestionID = %d, Is Correct = %s}", id, content,
				question != null ? question.getQuestionID() : "null", isCorrect);
	}
}
