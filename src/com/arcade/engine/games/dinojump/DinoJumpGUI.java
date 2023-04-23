package com.arcade.engine.games.dinojump;


import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DinoJumpGUI {
	
	//Create a JFrame that displays a name on the frame
	//For example, give it the name "Dino Jump" by filling in the parenthesis in JFrame()
	JFrame mainWindow = new JFrame("Dino Jump");

	//For ease of use, create variables to store the width and height of the window
	//Set these equal to your desired dimensions
	public static int WIDTH = 600;
	public static int HEIGHT = 400;
	

	//Method to set up the dino GUI
	public void createGUI() {
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon sky = new ImageIcon("/Users/totallyfarhan/Desktop/Programming/Projects/Java/DinoJump/src/sky.png");
		JLabel bg = new JLabel();
		bg.setIcon(sky);
        //Create a variable of type "Container"
		//Set the variable equal to your JFrame.getContentPane();
		//This will allow us to display the pane
		
		Container container = mainWindow.getContentPane();

		//Create a new "GamePanel" object
		gamingEngine engine = new gamingEngine();
		
		//Add the listener to get the next key pressed "[game panel object].addKeyListener([game panel object]);"
		engine.addKeyListener(engine);
		
		//Set the game panel "focusable" to true
		engine.setFocusable(true);
		engine.add(bg);
		//Set the container layout to "BorderLayout()";
		container.setLayout(new BorderLayout());
		//Add the game panel to the container
		container.add(engine, BorderLayout.CENTER);
		//Set JFrame size
		mainWindow.setSize(WIDTH, HEIGHT);
		//Set JFrame resizable to false
		mainWindow.setResizable(false);
		//Set JFrame window visibility to true
		mainWindow.setVisible(true);
	}

	// //Main method that calls the run method
	// public static void main(String[] args) {
	// 	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	// 		public void run() {
	// 			new DinoJumpGUI().createGUI();
				
	// 		}
			
	// 	});

	// }
}