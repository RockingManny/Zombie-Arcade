package com.arcade.engine.games.dinojump;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.arcade.engine.games.dinojump.utility.Resource;


public class Obstacles {
	private class Obstacle {
		BufferedImage image;
		int x;
		int y;
		
		Rectangle getObstacle () {
			Rectangle obstacle = new Rectangle();
			obstacle.x = x;
			obstacle.y = y;
			obstacle.width = image.getWidth();
			obstacle.height = image.getHeight();
			
			return obstacle;
		}
	}
	
	
	public class RandomNum {
		Random rand = new Random(); 
		
		int lowerLimit = 135;
		 
		int upperLimit = 500;
		
		int randomInt = rand.nextInt(upperLimit) + lowerLimit;
	}
	
	private int firstx, obstacleInterval, speed;
	private ArrayList<BufferedImage> imageList;
	private ArrayList<Obstacle> obstacleList;
	
	private Obstacle block;
	
	public Obstacles(int firstPos) {
		obstacleList = new ArrayList<Obstacle>();
		imageList = new ArrayList<BufferedImage>();
		
		firstx = firstPos;
		
		RandomNum randInterval = new RandomNum();
	    obstacleInterval = randInterval.randomInt;
		speed = 10;
		
		imageList.add(new Resource().getResourceImage("../Images/graveyard.png"));
		imageList.add(new Resource().getResourceImage("../Images/mushroom.png"));
		imageList.add(new Resource().getResourceImage("../Images/cactus.png"));
		
		int x = firstx;
		
		for (BufferedImage image : imageList) {
			Obstacle obs = new Obstacle();
			
			obs.x = x;
			obs.image = image;
			obs.y = Ground.GroundY - image.getHeight() + 5;
			RandomNum randInterval2 = new RandomNum();
		    obstacleInterval = randInterval2.randomInt;
			x += obstacleInterval;
			
			obstacleList.add(obs);
		}
		
	}
	
	public void update () {
		Iterator<Obstacle> loop = obstacleList.iterator();
		Obstacle firstOb = loop.next();
		firstOb.x -= speed;
		
		while (loop.hasNext()) {
			Obstacle ob = loop.next();
			ob.x -= speed;
		}
		
		Obstacle finalOb = obstacleList.get(obstacleList.size() - 1);
		
		if (firstOb.x < -firstOb.image.getWidth()) {
			obstacleList.remove(firstOb);
			RandomNum randInterval3 = new RandomNum();
		    obstacleInterval = randInterval3.randomInt;
			firstOb.x = obstacleList.get(obstacleList.size() -1).x + obstacleInterval;
			obstacleList.add(firstOb);
		}
	}
	
	public void create (Graphics g) {
		for (Obstacle ob : obstacleList) {
			g.setColor(Color.black);
			g.drawImage(ob.image, ob.x, ob.y, null);
		}
	}
	
	public boolean hasCollided() {
		for (Obstacle ob : obstacleList) {
			if (Player.getPlayer().intersects(ob.getObstacle())) {
				block = ob;
				return true;
			}
		}
		return false;
	}
	
	public void resume () {
		int x = firstx/2;
		
		obstacleList = new ArrayList<Obstacle>();
		
		for (BufferedImage bi : imageList) {
			Obstacle ob = new Obstacle();
			
			ob.image = bi;
			ob.x = x;
			ob.y = Ground.GroundY - bi.getHeight() + 5;
			
			RandomNum randInterval = new RandomNum();
		    obstacleInterval = randInterval.randomInt;
			x += obstacleInterval;
			
			obstacleList.add(ob);
		}
		
		
	}
}
