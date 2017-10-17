package edu.cmu.cs.cs214.hw4.gui;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class PromptWindow {
	public PromptWindow(String s){
		JFrame pw = new JFrame(s);
		pw.setSize(s.length()*10,100);
		
		JLabel lable = new JLabel(s);
		pw.add(lable);
		
		pw.setVisible(true);
	}

}
