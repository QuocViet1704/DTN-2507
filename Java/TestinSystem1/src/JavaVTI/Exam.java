package JavaVTI;

import java.awt.geom.IllegalPathStateException;
import java.time.LocalDateTime;
import java.util.EmptyStackException;

public class Exam {
	private int examID;
	private String code;
	private String title;
	private CategoryQuestion categoryQuestion;
	private int duration;
	private int creatorID;
	private LocalDateTime createDate;
	
	public Exam(int examID, String code, String title, CategoryQuestion category, int duration, int creatorID, LocalDateTime createDate) {
		this.examID = examID;
		this.code = code;
		this.title = title;
		this.categoryQuestion = categoryQuestion;
		this.duration = duration;
		this.creatorID = creatorID;
		this.createDate = createDate;
	}
	
	public int getExamID() {return examID;}
	public void setExamID(int examID) {this.examID = examID;}
	
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	 
	public CategoryQuestion getCategoryQuestion() {return categoryQuestion;}
	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {this.categoryQuestion = categoryQuestion;}

	public int getDuration() {return duration;}
	public void setDuration(int duration) {this.duration = duration;}
	
	public int getCreatorID() {return creatorID;}
	public void setCreatorID(int creatorID) {this.creatorID = creatorID;}
	
	public LocalDateTime getCreateDate() {return createDate;}
	public void setCreateDate(LocalDateTime createDate) {this.createDate = createDate;}
	
	@Override 
	public String toString() {
		return String.format("Exam{ID = %d, Code = %s, Title = %s, CategoryID = %s, Duration = %d, Creator ID = %d, Create Date = %s}",
				examID, code, title, 
				categoryQuestion != null ? categoryQuestion.getCategoryID() : "null", 
				duration, creatorID, createDate
		);
	}
}
