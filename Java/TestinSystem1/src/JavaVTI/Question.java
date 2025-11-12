package JavaVTI;

import java.time.LocalDateTime;

public class Question {
	private int questionID;
	private String content;
	private CategoryQuestion categoryQuestion;
	private	TypeQuestion typeQuestion;
	private int creatorID;
	private LocalDateTime createDate;
	
	public Question(int questionID, String content, CategoryQuestion categoryQuestion, TypeQuestion typeQuestion, int creatorID, LocalDateTime createDate) {
		this.questionID = questionID;
		this.content = content;
		this.categoryQuestion = categoryQuestion;
		this.typeQuestion = typeQuestion;
		this.creatorID = creatorID;
		this.createDate = createDate;
	}
	
	public int getQuestionID() {return questionID;}
	public void setQuestionID(int questionID) {this.questionID = questionID;}
	
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	
	public CategoryQuestion getCategoryQuestion() {return categoryQuestion;}
	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {this.categoryQuestion = categoryQuestion;}
	
	public TypeQuestion getTypeQuestion() {return typeQuestion;}
	public void setTypeQuestion(TypeQuestion typeQuestion) {this.typeQuestion = typeQuestion;}
	
	public int getCreatorID() {return creatorID;}
	public void setCreatorID(int creatorID) {this.creatorID = creatorID;}
	
	public LocalDateTime getCreateDate() {return createDate;}
	public void setCreateDate(LocalDateTime createDate) {this.createDate = createDate;}
	
	@Override
	public String toString() {
		return String.format("Question{ID = %d, Content = %s, Category ID = %s, Type ID = %s, Creator ID = %d, Create Date = %s}", 
				questionID, content, 
				categoryQuestion != null ? categoryQuestion.getCategoryID() : "null",
				typeQuestion != null ? typeQuestion.getTypeID() : "null",
				creatorID, createDate
		);
	}
}
