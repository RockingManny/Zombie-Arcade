package com.arcade.engine.gaming;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.arcade.engine.utils.GameConstants;

import java.awt.Insets;


//         // Add buttons to panel
//         GridBagConstraints c = new GridBagConstraints();
//         c.gridx = 0;
//         c.gridy = 0;
//         c.weightx = 1.0;
//         c.weighty = 1.0;
//         c.fill = GridBagConstraints.BOTH;
//         c.insets = new Insets(10, 10, 10, 10);
//         for (ImageIcon icon : buttonIcons) {
//             JButton button = new JButton(icon);
//             button.setPreferredSize(new Dimension(150, 150));
//             button.setBorder(BorderFactory.createEmptyBorder());
//             button.setContentAreaFilled(false);
//             buttonPanel.add(button, c);
//             c.gridx++;
//         }

//         pack();
//         setLocationRelativeTo(null);
//         setVisible(true);
//     }
// }


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuScreen extends JFrame implements GameConstants{
    private JLabel titleLabel;
    private JPanel buttonPanel;
    public MenuScreen(){
        setResizable(false);
        setTitle("ARCADE");
        setSize(SCREENWIDTH,SCREENHEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Create button icons
        ArrayList<ImageIcon> buttonIcons = new ArrayList<>();
        buttonIcons.add(new ImageIcon("src//img//icons//dino.png"));
        buttonIcons.add(new ImageIcon("src//img//icons//dino.png"));

        // Add buttons to panel
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        for (int index = 0; index < buttonIcons.size(); index++) {
            final int i = index;
            JButton button = new JButton(buttonIcons.get(i));
            button.setPreferredSize(new Dimension(150, 150));
            button.setBorder(BorderFactory.createEmptyBorder());
            button.setContentAreaFilled(false);
            buttonPanel.add(button, c);
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
            c.gridx++;
        }

        add(buttonPanel);
        setVisible(true);
    }
       
    public static void main(String[] args) {
        new SplashScreen();
    }
}
