package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

import java.util.Random;



public class Potion extends Item{
	
	public Potion(){
		super.image = "potion.png";
		Random ran = new Random();
		this.positionX = ran.nextInt(40);
		this.positionY = ran.nextInt(40);
	}
	
}