package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

import minidungeon.MiniDungeonGUI;

import java.util.Random;



public class Potion extends Item{

	Random random = new Random();


	public Potion(){
		super.image = "potion.png";
		Random ran = new Random();
		this.positionX = random.nextInt(40);
		this.positionY = random.nextInt(40);
	}

	Potion[] giveMePotions(Space[][] level, int n, MiniDungeonGUI gui){
		Potion[] potions = new Potion[n];
		for (int i = 0; i < potions.length; i++) {
			potions[i] = new Potion();
			potions[i].setId(1 + i); // id = 0 is avoided 'cause is the hero's one

			int potionStartX = random.nextInt(10 - 5 + 1) + 5;
			int potionStartY = random.nextInt(15 - 2 + 1) + 2;
			int[] valid = Main.validCoordinates(level, potionStartX, potionStartY);
			potions[i].setPositionX(valid[0]);
			potions[i].setPositionY(valid[1]);

			gui.md_addSprite(potions[i].getId(), potions[i].getImage(), true);
			gui.md_setSpriteVisible(potions[i].getId(), false);
			gui.md_moveSprite(potions[i].getId(), potions[i].getPositionX(), potions[i].getPositionY());
		}
		return potions;
	}

}
