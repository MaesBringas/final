package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

import minidungeon.MiniDungeonGUI;

import java.util.Random;



public class Apple extends Item {
	Random random = new Random();

	public Apple(){
		super.image = "apple.png";
		this.positionX = random.nextInt(40);
		this.positionY = random.nextInt(40);
	}

	Apple[] giveMeMacs(Space[][]level, int n, MiniDungeonGUI gui){
		Apple[] apples = new Apple[n];

		for (int i = 0; i < apples.length; i++) {
			apples[i] = new Apple();
			apples[i].setId(12 + i); // id=1 to id=11 are avoided 'cause they are already in use.
			int applesStartX = random.nextInt(35 - 2 + 1) + 2;
			int applesStartY = random.nextInt(35 - 2 + 1) + 2;
			int[] valid = Main.validCoordinates(level, applesStartX, applesStartY);
			apples[i].setPositionX(valid[0]);
			apples[i].setPositionY(valid[1]);
			gui.md_addSprite(apples[i].getId(), apples[i].getImage(), true);
//            gui.md_setSpriteVisible(apples[i].getId(), true);
			gui.md_moveSprite(apples[i].getId(), apples[i].getPositionX(), apples[i].getPositionY());
		}
		return apples;
	}


	
}
