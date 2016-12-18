package com.mahlmebs;

/* Gold class
* @authors mahl && mebs
* @version 1.0
* */

import minidungeon.MiniDungeonGUI;

import java.util.Random;

public class Gold extends Item {

	Random random = new Random();

	public Gold(){
		this.image = "gold.png";
		this.positionX = random.nextInt(40);
		this.positionY = random.nextInt(40);
	}

	Gold[] giveMeGold(Space[][] level, int n, MiniDungeonGUI gui){
		Gold[] goldCoins = new Gold[n];
		for (int i = 0; i < goldCoins.length; i++) {
			goldCoins[i] = new Gold();
			goldCoins[i].setId(1 + i); // id = 0 is avoided 'cause is the hero's one

			int goldStartX = random.nextInt(10 - 5 + 1) + 5;
			int goldStartY = random.nextInt(15 - 2 + 1) + 2;
			int[] valid = Main.validCoordinates(level, goldStartX, goldStartY);
			goldCoins[i].setPositionX(valid[0]);
			goldCoins[i].setPositionY(valid[1]);

			gui.md_addSprite(goldCoins[i].getId(), goldCoins[i].getImage(), true);
			gui.md_setSpriteVisible(goldCoins[i].getId(), false);
			gui.md_moveSprite(goldCoins[i].getId(), goldCoins[i].getPositionX(), goldCoins[i].getPositionY());
		}
		return goldCoins;
	}
	
}
