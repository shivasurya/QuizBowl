package com.quizbowl.app.fileHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.quizbowl.app.dataStore.MCQstore;
import com.quizbowl.app.dataStore.Question;
import com.quizbowl.app.dataStore.SAstore;
import com.quizbowl.app.dataStore.TFstore;

public class fileLoader {

	private BufferedReader br;
	private static final String TF = "TF";
	private static final String MCQ = "MC";
	private static final String SA = "SA";
	private ArrayList<Question> data = new ArrayList<Question>();
	
	public fileLoader(String fileName) throws Exception {
		File file = new File("C:\\Users\\S.Shivasurya\\workspace2\\QuizBowl\\src\\com\\quizbowl\\app\\fileHandler\\"+fileName);
		FileReader fr = new FileReader(file);
		br = new BufferedReader(fr);
	
	}
	public ArrayList<Question> fileParser() throws Exception
	{
		int number = Integer.parseInt(br.readLine());
		while(number-- > 0)
		{
			String[] choice = br.readLine().split(" ");
			int points = Integer.parseInt(choice[1]);
			String question = br.readLine();
			Question obj;
			switch(choice[0])
			{
				case TF : 
					String answer = br.readLine();
					TFstore tfstore = new TFstore(question,answer,points);
					obj = new Question(tfstore, TF);
					data.add(obj);
					break;
				case MCQ :
					int ChoiceNumber = Integer.parseInt(br.readLine());
					String[] choices = new String[ChoiceNumber];
					int i=0;
					while(ChoiceNumber-- > 0)
					{
						choices[i] = br.readLine();
						i++;
					}
					String answers = br.readLine();
					MCQstore mcq = new MCQstore(question, answers, choices, points);
					obj = new Question(mcq, MCQ);
					data.add(obj);
					break;
				case SA : 
					String answerw = br.readLine();
					SAstore sastore = new SAstore(question,answerw,points);
					obj = new Question(sastore, SA);
					data.add(obj);
					break;
				default : System.out.println("No Such Question error");
			}
		}
		return data;
	}
	
	
}
