package com.quizbowl.app.fileHandler;

import java.util.ArrayList;

import com.quizbowl.app.dataStore.Question;

public class FileDriver {

	public ArrayList<Question> obj = new ArrayList<Question>();
	public boolean[] randoms;
	
	public FileDriver(String filename) throws Exception{
		fileLoader loader = new fileLoader(filename);
		obj = loader.fileParser();
		randoms = new boolean[obj.size()];
	}
	public int getQuestionCount()
	{
		System.out.println(this.obj.size());
		return this.obj.size();
	}
	public Question getRandomQuestion()
	{
		Question object = null;
		int flag = 0;
		do
		{
			int temp = Randomizer.getRandomInteger(obj.size());
			if(randoms[temp]==false)
			{
				object = obj.get(temp);
				randoms[temp]=true;
				break;
			}
			else
				flag = 1;
			
		}while(flag==1);
		return object;
	}
}
