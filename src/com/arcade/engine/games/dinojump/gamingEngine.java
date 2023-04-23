package com.arcade.engine.games.dinojump;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;



class gamingEngine extends JPanel implements KeyListener, Runnable {
  
  public static int WIDTH;
  public static int HEIGHT; 
  private Thread animation;
  
  Ground ground;
  Obstacles obstacle;
  Player player;
  
  //set these to a default (false is recommended)
  private boolean running = false;
  private boolean gameOver = false; 
  
//create an integer that tracks the score
  int score = 0;
  int highscore = 0;
  
  public gamingEngine() {
  
	 //call width and height from DinoJumpGUI and set them to local variables
	WIDTH = DinoJumpGUI.WIDTH;
	HEIGHT = DinoJumpGUI.HEIGHT;
	ground = new Ground(HEIGHT);
	obstacle = new Obstacles((int)(WIDTH * 1.5));
	player = new Player();
    //initialize score to 0
	score = 0;
    setSize(WIDTH, HEIGHT);
    setVisible(true);
  }
  
  public void paint(Graphics g) {
    super.paint(g);
    //set font to other 
    g.setFont(new Font("Courier New", Font.BOLD, 20));
    g.setColor(Color.white);
    g.drawString("SCORE: " + Integer.toString(score), 10, 30);
    g.drawString("HIGH SCORE: " + Integer.toString(highscore), 10, 50);
    
    ground.create(g);
    obstacle.create(g);
    player.create(g);
  }
  
  public void run() {
    running = true;
	System.out.println("test");

    while(running) {
      updateGame();
      repaint();      
      try {
        Thread.sleep(50);
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  public void updateGame() {
   
	  //add 1 to the score  
	  ++ score;
	  ground.updateImage();
	  //spawn obstacles
	  obstacle.update();
	  //check if player touches obstacles
	  if (obstacle.hasCollided()) {
		  player.die();
		  repaint();
		  running = false;
		  gameOver = true;
	  }
  }

  public void reset() {
	
	  
    //set gameOver to false
	gameOver = false;
	
	if (score > highscore) {
		highscore = score;
	}
	
	obstacle.resume();
	//set the score variable back to 0 
	score = 0;
  }
  
  public void keyTyped(KeyEvent e) {
    
	//enter a desired character to start the game  
    if(e.getKeyChar() == ' ') {
    	
     //if game over is true, call the reset function
    	
    	if (gameOver) {
    		System.out.println("Game starts");  
    		reset();
    	}
    	else if (animation == null || !running) {
    		animation = new Thread(this);
    		animation.start();
    		player.startRunning();
    	}
    	/*
    	else if (player.state == player.JUMPING) {
    		
    	}
    	*/
    	else {
    		//character jumps
    		player.jump();
    	}
      } 
    }
 
  //add other keyboard buttons that you might like to add for 
  //extra functionalities 
  public void keyPressed(KeyEvent e) {
  
  }
  
  public void keyReleased(KeyEvent e) {
    
  }
}