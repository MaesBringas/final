package com.mahlmebs;

import minidungeon.MiniDungeonGUI;

import java.util.Random;

public class Eye extends Item {

	Random random = new Random();

	public Eye(){
		super.image = "eye.png";
		this.positionX = random.nextInt(40);
		this.positionY = random.nextInt(40);
	}

	Eye giveMeAnEye(Space[][]level, MiniDungeonGUI gui){
		Eye eye = new Eye();
		eye.setId(18); // id=1 to id=16 are avoided 'cause they are already in use.
		int heartStartX = random.nextInt(10 - 5 + 1) + 5;
		int heartStartY = random.nextInt(15 - 2 + 1) + 2;
		int[] valid = Main.validCoordinates(level, heartStartX, heartStartY);
		eye.setPositionX(valid[0]);
		eye.setPositionY(valid[1]);
		gui.md_addSprite(eye.getId(), eye.getImage(), true);
		gui.md_moveSprite(eye.getId(), eye.getPositionX(), eye.getPositionY());
		return eye;
	}
	
}
