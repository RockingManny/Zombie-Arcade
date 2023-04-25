package com.arcade.engine.games.dinojumpgame;

import javax.swing.*;
import java.awt.*;

public class UserInterface {
  JFrame mainWindow = new JFrame("Dino Jump");
  
  public static int WIDTH = 800;
  public static int HEIGHT = 500;
  
  public void createAndShowGUI() {
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Container container = mainWindow.getContentPane();
    
    GamePanel gamePanel = new GamePanel();
    gamePanel.addKeyListener(gamePanel);
    gamePanel.setFocusable(true);
    
    container.setLayout(new BorderLayout());
    
    container.add(gamePanel, BorderLayout.CENTER);
    
    mainWindow.setSize(WIDTH, HEIGHT);
    mainWindow.setResizable(true);
    mainWindow.setVisible(true);
  }
}