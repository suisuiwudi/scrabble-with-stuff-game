package edu.cmu.cs.cs214.hw4.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.cmu.cs.cs214.hw4.core.GameSystem;
import edu.cmu.cs.cs214.hw4.core.Player;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.Boom;
import edu.cmu.cs.cs214.hw4.core.SpecialTile.SpecialTile;

public class WelcomeWindow {
//	private Scrabble scrabble;
//	private GameSystem game;
	
	private JFrame frame;
	private JPanel panel;
	private JButton startButton;
	private JLabel nameLabel;
	private JTextField nameText;
	
	public WelcomeWindow(Scrabble scrabble){
		frame = new JFrame("Welcom to Scrabble Game");
		frame.setSize(350,200);
		
		panel = new JPanel();
		frame.add(panel);
		
		startButton = new JButton(" start ");
		
		panel.setLayout(null);
		
		nameLabel = new JLabel("Name : ");
		nameLabel.setBounds(10,20,80,25);
		panel.add(nameLabel);
		
		nameText = new JTextField();
		nameText.setBounds(100,20,165,25);
		panel.add(nameText);
		
		startButton.setBounds(10, 80, 80, 25);
		startButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(scrabble.getGameSystem().getController().getPlayers().size() <4){
					Player player = new Player(nameText.getText());
					player.replenish(7);
					scrabble.getGameSystem().addPlayer(player);
					scrabble.setGameWindowTitle(nameText.getText());
					scrabble.newGameWindow();
				}
				
				else{
					scrabble.newPromptWindow("TOO MANY PLAYERS");
				}
			}
		});
		panel.add(startButton);
		
		frame.setVisible(true);
		
		
	}
	

	
	public static void main(String args[]){
		Scrabble scrabble = new Scrabble();
		WelcomeWindow ww = new WelcomeWindow(scrabble);
	}

}
