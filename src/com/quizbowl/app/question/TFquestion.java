package com.quizbowl.app.question;

import com.quizbowl.app.dataStore.TFstore;

public class TFquestion extends Question {
	
	public TFquestion(TFstore obj)
	{
		super(obj.getQuestion(),"TF");
		this.setAnswer(obj.getAnswer());
	}

	@Override
	protected void converter() { }

}
