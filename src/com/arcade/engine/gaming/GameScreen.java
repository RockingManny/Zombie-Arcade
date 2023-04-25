package com.arcade.engine.gaming;
import javax.swing.JFrame;

import com.arcade.engine.games.dinojumpgame.UserInterface;
import com.arcade.engine.utils.GameConstants;
public class GameScreen extends JFrame implements GameConstants {
	
	public GameScreen(int game_choice) throws Exception {
		
		switch(game_choice)
		{
			case 0:
				// Game 1 : Dino
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
					  new UserInterface().createAndShowGUI();
					}
				  });
				break;
			case 1:
				// Game 2
				setResizable(false);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				setExtendedState(MAXIMIZED_BOTH);
				setLocationRelativeTo(null);
				setTitle(TITLE);
				GameBoard board = new GameBoard();
				add(board);
				setVisible(true);
				break;
		}
	}
	

}
