package com.quizbowl.app.dataStore;

public class MCQstore {
	private String question,answer;
	private String[] choices;
	private int points;
	String keys;
	public MCQstore(String question,String answer,String[] choices,int points)
	{
		this.question = question;
		this.answer = answer;
		this.choices = choices;
		this.points = points;

	}
	public String getQuestion()
	{
		return this.question;
	}
	public String getAnswer()
	{
		return this.answer;
	}
	public String[] getChoices()
	{
		return this.choices;
	}
	public int getPoints()
	{
		return this.points;
	}
}
