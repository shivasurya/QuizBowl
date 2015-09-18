package com.quizbowl.app.fileHandler;

import java.util.Random;

public class Randomizer {
	public static int getRandomInteger(int range)
	{
		  Random randomno = new Random();
		  return randomno.nextInt(range);
	}
}
