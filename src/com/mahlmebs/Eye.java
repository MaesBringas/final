package com.mahlmebs;

import java.util.Random;

/**
 * Created by manuhortet on 17/12/16.
 */
public class Eye extends Item {
	
	public Eye(){
		super.image = "eye.png";
		Random ran = new Random();
		this.positionX = ran.nextInt(40);
		this.positionY = ran.nextInt(40);
	}
	
}
