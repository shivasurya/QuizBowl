package com.quizbowl.app.question;

public abstract class Question {

	private String question,questionType,answer;
	private int points=0;

	public Question(String question,String questionType)
	{
		this.question = question;
		this.questionType = questionType;
	}
	abstract protected void converter();
	public final Boolean checkAnswer(String answer,int points)
	{
		if(answer.equals(this.answer)){
			this.points = points;
			return true;
		}
		this.points = -points;
		return false;
	}
	
	public final String getQuestion()
	{
		return this.question;
	}
	public final int getPoints(){

		return this.points;
	}
	protected final void setAnswer(String answer)
	{
		this.answer = answer;
	}
	public final String getAnswer()
	{
		return this.answer;
	}
	
}
