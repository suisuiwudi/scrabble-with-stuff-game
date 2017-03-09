package edu.cmu.cs.cs214.hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
	private HashSet<String> dict;
	public Dictionary(String filePath){
		dict = new HashSet<String>();
		try{
			Scanner sc = new Scanner(new File(filePath));
			while (sc.hasNext()){
				dict.add(sc.next());
			}
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public Boolean in(String string){
		return dict.contains(string);
	}
}
