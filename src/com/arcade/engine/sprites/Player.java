package com.arcade.engine.sprites;

import javax.imageio.ImageIO;
import com.arcade.engine.utils.SpriteImageUtils;
public class Player extends CommonPlayer {
	
	public Player() throws Exception {
		w = 320;
		h = 400;
		x = 200;
		y = GROUND;
		force=0;
		speed = 0;
		flip=false;
		playerImg = ImageIO.read(Player.class.getResource(PLAYER_IMAGE));
		loadIdleImages();
		loadWalkImages();
		loadJumpImages();
		loadCrouchImages();
		loadLAttackImages();
		loadHitImages();
		loadPowerImages();
	}
	
	private void loadHitImages(){
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(17,53,95,98)));
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(120,53,95,98)));
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(224,53,95,98)));
		hitImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(327,53,95,98)));
	}

	private void loadIdleImages() {
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		idleImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}

	private void loadWalkImages() {
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(17,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(104,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(187,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(271,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(354,207,79,103)));
		walkImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(437,207,79,103)));
	}

	private void loadJumpImages() {
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		jumpImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}

	private void loadCrouchImages() {
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(18,53,93,96)));
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(122,53,92,96)));
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(225,53,91,96)));
		crouchImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(328,53,92,96)));
	}
	private void loadLAttackImages() {
		LAttackImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(6,1707,87,92)));
		LAttackImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(92,1707,87,92)));
		LAttackImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(187,1707,87,92)));
	}
	private void loadPowerImages() {
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(17,3445,87,101)));
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(106,3445,87,101)));
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(199,3445,87,101)));
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(290,3445,87,101)));
		powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(384,3445,87,101)));
		// powerImages.add(SpriteImageUtils.removeBackground(playerImg.getSubimage(467,3400,87,146)));
	}
}
	