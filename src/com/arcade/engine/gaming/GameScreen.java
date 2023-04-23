package com.arcade.engine.gaming;

import javax.swing.JFrame;

import com.arcade.engine.games.dinojump.DinoJumpGUI;
import com.arcade.engine.utils.GameConstants;

public class GameScreen extends JFrame implements GameConstants {
	
	public GameScreen(int i) throws Exception {
		// setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setExtendedState(MAXIMIZED_BOTH);
		// setLocationRelativeTo(null);
		// setTitle(TITLE);
		// GameBoard board = new GameBoard();
		// add(board);
		// setVisible(true);
		System.out.println(i);
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DinoJumpGUI().createGUI();
				
			}
			
		});
	}
	

}
