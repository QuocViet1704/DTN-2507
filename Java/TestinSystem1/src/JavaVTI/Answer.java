package JavaVTI;

public class Answer {
	private int answerID;
	private String content;
	private Question question;
	private boolean isCorrect;

	public Answer(int answerID, String content, Question question, boolean isCorrect) {
		this.answerID = answerID;
		this.content = content;
		this.question = question;
		this.isCorrect = isCorrect;
	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
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
		return String.format("Answer{ID = %d, Content = %s, QuestionID = %d, Is Correct = %s}", answerID, content,
				question != null ? question.getQuestionID() : "null", isCorrect);
	}
}
