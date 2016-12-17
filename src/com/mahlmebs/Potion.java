package com.mahlmebs;

import java.util.Random;

/**
 * Created by manuhortet on 17/12/16.
 */

public class Potion extends Item{
	
	public Potion(){
		super.image = "potion.png";
		Random ran = new Random();
		this.positionX = ran.nextInt(40);
		this.positionY = ran.nextInt(40);
	}
	
}
