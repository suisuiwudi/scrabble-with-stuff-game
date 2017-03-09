package edu.cmu.cs.cs214.hw4;


import java.util.ArrayList;

public class Word {
	private int value;
	private int x;
	private int y;
	private int direction;
	private int length;
	private int wordBonus;
	private String word;
	public Word(int x, int y, int direction, String word, int value){
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.word = word;
		this.value = value;
	}
	public int getValue(){
		return value;
	}
	public void addValue(int tileValue){
		
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public String getString(){
		return word;
	}
	
}
