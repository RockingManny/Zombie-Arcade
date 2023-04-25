package com.arcade.engine.gaming;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.arcade.engine.utils.GameConstants;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SplashScreen extends JFrame implements GameConstants{
    
    public SplashScreen(){
        setResizable(false);
        setTitle("ARCADE");
        setSize(SCREENWIDTH,SCREENHEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        panel.setOpaque(true);

        ImageIcon button_released = new ImageIcon("src//img//misc//start.png");
        Image scaledImage_released = button_released.getImage().getScaledInstance(SCREENWIDTH/4, SCREENHEIGHT/6, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon_released = new ImageIcon(scaledImage_released);

        ImageIcon button_pressed = new ImageIcon("src//img//misc//startPressed.png");
        Image scaledImage_pressed = button_pressed.getImage().getScaledInstance(SCREENWIDTH/4, SCREENHEIGHT/6, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon_pressed = new ImageIcon(scaledImage_pressed);

        JButton startButton = new JButton();
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setIcon(scaledIcon_released);
        startButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startButton.setIcon(scaledIcon_pressed);
            }
            public void mouseReleased(MouseEvent e) {
                startButton.setIcon(scaledIcon_released);
            }
        });
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                    dispose();
                    new MenuScreen();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 20, 20); // top, left, bottom, right
        panel.add(startButton, c);

        add(panel);
        setVisible(true);
    }
       
    public static void main(String[] args) {
        new SplashScreen();
    }
}
