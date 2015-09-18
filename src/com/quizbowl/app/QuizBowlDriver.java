package com.quizbowl.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.quizbowl.app.dataStore.MCQstore;
import com.quizbowl.app.dataStore.SAstore;
import com.quizbowl.app.dataStore.TFstore;
import com.quizbowl.app.fileHandler.FileDriver;
import com.quizbowl.app.question.MCQquestion;
import com.quizbowl.app.question.SAquestion;
import com.quizbowl.app.question.TFquestion;

public class QuizBowlDriver  {
	BufferedReader br; 
	int questionnumbers;
	FileDriver filedriver;
	Player player = new Player();
	public final static String SA ="SA";
	public final static String MC ="MC";
	public final static String TF ="TF";
	
	public QuizBowlDriver() throws Exception {
		// TODO Auto-generated constructor stub
		this.initializer();
		if(this.interactiveShell())
		{
			this.startGame();
		}
	}
	void initializer() throws Exception
	{
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Your first Name");
		String fname = br.readLine();
		System.out.println("Your last Name");
		String lname = br.readLine();
		System.out.println("Enter Filename to save session:");
		String filename = br.readLine();
		player.savePlayer(lname,fname);
		filedriver = new FileDriver(filename);
	}
	boolean interactiveShell()  throws Exception
	{
		boolean flag=false;
		do{
			System.out.println("How Many Questions would you like to have ?");
			int number = Integer.parseInt(br.readLine());
			if(filedriver.getQuestionCount() >= number && number > 0 ){
				System.out.println("ss"+filedriver.getQuestionCount());
				questionnumbers = number;	
				flag = false;
				System.out.println("Starting your Quiz! Good Luck "+player.getFullName());
			}
			else{
				flag = true;
				System.out.println("Thats not a Right Chocie! choose once gain out of "+filedriver.getQuestionCount());				
			}
		}while(flag);
		return true;
	}
	void startGame() throws Exception
	{
		com.quizbowl.app.dataStore.Question object=null;
		String answer=null;
		while(questionnumbers-- > 0)
		{
			answer=null;
			object = filedriver.getRandomQuestion();
			System.out.println(object.getType());
			switch(object.getType())
			{
				case TF : 
					TFstore tfstore = (TFstore) object.getQuestion();
					TFquestion objs = new TFquestion(tfstore);
					this.printQuestion(objs.getQuestion());
					answer = readAnswer();
					if(answer.equals("skip"))
						break;
					if(objs.checkAnswer(answer,tfstore.getPoints()))
					{
						player.setPointStatus(objs.getPoints());
						System.out.println("Correct Answer!  point Status is : "+player.getPointStatus());	
					}
					else
					{
						player.setPointStatus(objs.getPoints());
						System.out.println("Oops!Wrong Answer!  point Status is : "+player.getPointStatus());	
				
					}
					object = null;
					break;
				case MC : 
					MCQstore mcqstore = (MCQstore) object.getQuestion();
					MCQquestion mcqobj = new MCQquestion(mcqstore);
					printQuestion(mcqobj.getQuestion());
					String[] choices = mcqstore.getChoices();
					System.out.println("your choices Goes Below");
					for(String val:choices)
						System.out.println(val);
					answer = readAnswer();
					if(answer.equals("skip"))
						break;
					if(mcqobj.checkAnswer(answer,mcqstore.getPoints()))
					{
						player.setPointStatus(mcqobj.getPoints());
						System.out.println("Correct Answer!  point Status is : "+player.getPointStatus());	
					}
					else
					{
						player.setPointStatus(mcqobj.getPoints());
						System.out.println("Oops!Wrong Answer!  point Status is : "+player.getPointStatus());	
						System.out.println("The correct Answer is : "+mcqobj.getAnswer());
					}
					object = null;
					break;
				case SA :
					SAstore sastore = (SAstore) object.getQuestion();
					SAquestion saobj = new SAquestion(sastore);
					this.printQuestion(saobj.getQuestion());
					answer = readAnswer();
					if(answer.equals("skip"))
						break;
					if(saobj.checkAnswer(answer,sastore.getPoints()))
					{
						player.setPointStatus(saobj.getPoints());
						System.out.println("Correct Answer!  point Status is : "+player.getPointStatus());	
					}
					else
					{
						player.setPointStatus(saobj.getPoints());
						System.out.println("Oops!Wrong Answer!  point Status is : "+player.getPointStatus());	
				
					}
					object = null;
					
					break;
				
			}
		}
		System.out.println("Thank you "+player.getFullName()+" your score is "+player.getPointStatus());
	}
	public void printQuestion(String question)
	{
		System.out.println("---------");
		System.out.println(question);
		System.out.println("---------");
	}
	public String readAnswer() throws Exception
	{
		String val = br.readLine();
		return val;
	}
	public static void main(String[] args) throws Exception {
		QuizBowlDriver obj = new QuizBowlDriver();
	}
}
