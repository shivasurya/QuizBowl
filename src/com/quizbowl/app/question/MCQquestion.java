package com.quizbowl.app.question;

import com.quizbowl.app.dataStore.MCQstore;

public class MCQquestion extends Question {

	private String[] answer;
	private String genAnswer;
	private String keys;
	
	public MCQquestion(MCQstore object) {
		super(object.getQuestion(),"MCQ");
		this.keys = object.getAnswer();
		this.answer = object.getChoices();
		this.converter();
		this.setAnswer(this.genAnswer);
	}

	@Override
	protected void converter() {
		int key_gen = (int)this.keys.charAt(0);
		this.genAnswer = this.answer[key_gen - 'A'];	
		return;
	}

}
