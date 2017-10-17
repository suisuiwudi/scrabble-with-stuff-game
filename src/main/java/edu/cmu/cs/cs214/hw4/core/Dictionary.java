package edu.cmu.cs.cs214.hw4.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The Class Dictionary.
 */
public class Dictionary {

	/** The dict. */
	private HashSet<String> dict;

	/**
	 * Instantiates a new dictionary.
	 *
	 * @param filePath
	 *            the file path
	 */
	public Dictionary(String filePath) {
		dict = new HashSet<String>();
		try {
			Scanner sc = new Scanner(new File(filePath));
			while (sc.hasNext()) {
				dict.add(sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * In.
	 *
	 * @param string
	 *            the string
	 * @return the boolean
	 */
	public Boolean in(String string) {
		return dict.contains(string);
	}
}
