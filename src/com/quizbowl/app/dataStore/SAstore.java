package com.quizbowl.app.dataStore;

public class SAstore {
	private String question,answer;
	private int points;
	
	public SAstore(String question,String answer,int points)
	{
		this.question = question;
		this.answer = answer;
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
	public int getPoints()
	{
		return this.points;
	}
}
