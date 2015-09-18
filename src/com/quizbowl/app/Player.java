package com.quizbowl.app;

public class Player {
	private String lname,fname;
	private int points;
	
	public Player(String lname,String fname)
	{
		this.lname = lname;
		this.fname = fname;
		this.points = 0;
	}
	
	protected String getFullName()
	{
		return fname+" "+lname;
	}
	protected int getPointStatus()
	{
		return this.points;
	}
	protected void setPointStatus(int points)
	{
		this.points = this.points+points;
	}
}
