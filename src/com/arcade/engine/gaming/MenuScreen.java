package com.arcade.engine.gaming;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.arcade.engine.utils.GameConstants;

public class MenuScreen extends JFrame implements GameConstants{
    private JLabel titleLabel;
    private JPanel buttonPanel;
    public MenuScreen(){
        setResizable(false);
        setTitle("ARCADE");
        setSize(SCREENWIDTH,SCREENHEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);

        // Create title label
        titleLabel = new JLabel("ARCADE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Create button panel
        buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(buttonPanel);

        // Create button icons and labels
        ArrayList<ImageIcon> buttonIcons = new ArrayList<>();
        buttonIcons.add(new ImageIcon(new ImageIcon("src//img//icons//dino.png").getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        buttonIcons.add(new ImageIcon(new ImageIcon("src//img//icons//gundam.png").getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));
        
        ArrayList<String> buttonLabels = new ArrayList<>();
        buttonLabels.add("Dino Game");
        buttonLabels.add("Gundam Game");

        // Add buttons to panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.5;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        for (int index = 0; index < buttonIcons.size(); index++) {
            final int i = index;
            JButton button = new JButton(buttonIcons.get(i));
            button.setPreferredSize(new Dimension(buttonIcons.get(i).getImage().getWidth(null), buttonIcons.get(i).getImage().getHeight(null)));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            button.setOpaque(false);
            button.setBorderPainted(false);
            button.setIcon(buttonIcons.get(i));
            button.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    button.setIcon(buttonIcons.get(i));
                }
                public void mouseReleased(MouseEvent e) {
                    button.setIcon(buttonIcons.get(i));
                }
            });
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        setVisible(false);
                        dispose();
                        new GameScreen(i);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            
            // Create and add label for the button
            JLabel label = new JLabel(buttonLabels.get(i));
            label.setFont(new Font("Arial", Font.PLAIN, 18));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setVerticalAlignment(SwingConstants.TOP);
            label.setForeground(Color.WHITE);
            buttonPanel.add(button, c);
            c.gridy++;
            buttonPanel.add(label, c);
        
            c.gridx++;
            c.gridy = 0;

        }
        


        add(buttonPanel);
        setVisible(true);
    }
}
