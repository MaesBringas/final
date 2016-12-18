package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

import minidungeon.MiniDungeonGUI;

import java.util.Random;



public class Heart extends Item {

	Random random = new Random();

	public Heart(){
		super.image = "heart.png";
		this.positionX = random.nextInt(40);
		this.positionY = random.nextInt(40);
	}

	Heart giveMeAHeart(Space[][]level, MiniDungeonGUI gui){
		Heart heart = new Heart();
		heart.setId(17); // id=1 to id=16 are avoided 'cause they are already in use.
		int heartStartX = random.nextInt(10 - 5 + 1) + 5;
		int heartStartY = random.nextInt(15 - 2 + 1) + 2;
		int[] valid = Main.validCoordinates(level, heartStartX, heartStartY);
		heart.setPositionX(valid[0]);
		heart.setPositionY(valid[1]);
		gui.md_addSprite(heart.getId(), heart.getImage(), true);
		gui.md_moveSprite(heart.getId(), heart.getPositionX(), heart.getPositionY());
		return heart;
	}
	
}
