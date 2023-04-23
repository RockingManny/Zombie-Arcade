package com.arcade.engine.games.dinojump;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import com.arcade.engine.games.dinojump.utility.Resource;

public class Ground {
	
	private class groundImages {
 		BufferedImage groundImage;
 		int x;
	}
	
	public static int GroundY;
	private BufferedImage groundPhoto;
	private ArrayList<groundImages> imageSet;
	
	public Ground (int panelHeight) {
		GroundY = (int) (panelHeight - 0.14 * panelHeight);
		
		try {
			groundPhoto = new Resource().getResourceImage("../Images/ground.png");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		imageSet = new ArrayList<groundImages>();
		
		for (int i = 0; i < 4; i++) {
			groundImages obj = new groundImages();
			obj.groundImage = groundPhoto;
			obj.x = 0;
			imageSet.add(obj);
		}
		
		
	}
	
	public void updateImage () {
		Iterator<groundImages> loop = imageSet.iterator();
		
		groundImages first = loop.next();
		
		first.x -= 10;
		
		int previousX = first.x;
		
		while(loop.hasNext()) {
			groundImages second = loop.next();
			
			second.x = previousX + groundPhoto.getWidth();
			
			previousX = second.x;
		}
		
		if (first.x < -groundPhoto.getWidth()) {
			imageSet.remove(first);
			first.x = previousX + groundPhoto.getWidth();
			imageSet.add(first);
		}
	}
	
	public void create (Graphics g) {
		for (groundImages ground : imageSet) {
			g.drawImage(ground.groundImage, (int)ground.x, GroundY, null);
		}
	}
	
}
