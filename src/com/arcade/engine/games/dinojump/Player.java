package com.arcade.engine.games.dinojump;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.arcade.engine.games.dinojump.utility.Resource;

public class Player {
	private static int dinoBaseY, dinoTopY, dinoStartX, dinoEndX;
	private static int dinoTop, dinoBottom, topPoint;
	
	private static boolean topPointReached;
	private static int jumpFactor = 10;
	
	public static final int STAND_STILL = 1,
							RUNNING = 2,
							JUMPING = 3,
							DIE = 4;
	public static int state;
	
	private int foot;
	
	static BufferedImage image;
	
	public Player () {
		image = new Resource().getResourceImage("../Images/ghost.png");
		
		dinoBaseY = Ground.GroundY + 5;
		dinoTopY = Ground.GroundY - image.getHeight() + 5;
		dinoStartX = 100;
		dinoEndX = dinoStartX + image.getWidth();
		topPoint = dinoTopY - 120;
		
		state = 1;
	}
	
	public void create(Graphics g) {
		dinoBottom = dinoTop + image.getHeight();
		
		switch (state) {
			case STAND_STILL:
				g.drawImage(image, dinoStartX, dinoTopY, null);
				break;
			case RUNNING:
				g.drawImage(image, dinoStartX, dinoTopY, null);
				break;
			case JUMPING:
				if (dinoTop > topPoint && !topPointReached) {
					g.drawImage(image, dinoStartX, dinoTop -= jumpFactor, null);
					break;
				}
				if (dinoTop >= topPoint && !topPointReached && dinoBottom < Ground.GroundY) {
					topPointReached = true;
					g.drawImage(image, dinoStartX, dinoTop += jumpFactor, null);
					break;
				}
				if (dinoTop > topPoint && topPointReached && dinoBottom < Ground.GroundY) {
					if (dinoTop == topPoint && topPointReached) {
						state = RUNNING;
						topPointReached = false;
						break;
					}
					g.drawImage(image, dinoStartX, dinoTop += jumpFactor, null);
					break;
				}
			case DIE:
				g.drawImage(image, dinoStartX, dinoTop, null);
				break;
		}
	}
	
	public void die () {
		state = DIE;
	}
	
	public static Rectangle getPlayer() {
		Rectangle player = new Rectangle();
		
		player.x = dinoStartX;
		
		if (state == JUMPING && !topPointReached) {
			player.y = dinoTop - jumpFactor;
		}
		else if (state == JUMPING && topPointReached) {
			player.y = dinoTop + jumpFactor;
		}
		else if (state != JUMPING) {
			player.y = dinoTop;
		}
		
		player.width = image.getWidth();
		player.height = image.getHeight();
		
		return player;
	}
	
	public void startRunning () {
		dinoTop = dinoTopY;
		state = RUNNING;
	}
	
	public void jump () {
		dinoTop = dinoTopY;
		topPointReached = false;
		state = JUMPING;
	}
}
