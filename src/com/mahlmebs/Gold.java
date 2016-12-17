package com.mahlmebs;

/**
 * Created by manuhortet on 17/12/16.
 */

import java.util.Random;

public class Gold extends Item {
	
	public Gold(){
		this.image = "gold.png";
		Random ran = new Random();
		this.positionX = ran.nextInt(40);
		this.positionY = ran.nextInt(40);
	}
	
	public void addGold(Hero coolHero) {
		int gold = coolHero.getGold();
		coolHero.setGold(gold + 1);
	}
	
	
}
