package com.quizbowl.app.question;

import com.quizbowl.app.dataStore.SAstore;

public class SAquestion extends Question {

	
	public SAquestion(SAstore object) {
		super(object.getQuestion(),"SA");
		this.setAnswer(object.getAnswer());
	}

	@Override
	protected void converter() {}

}
