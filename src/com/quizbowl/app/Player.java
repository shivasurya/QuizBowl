package com.quizbowl.app;

public class Player {
	private String lname,fname;
	int points;
	
	protected Boolean savePlayer(String lname,String fname)
	{
		this.lname = lname;
		this.fname = fname;	
		return true;
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
