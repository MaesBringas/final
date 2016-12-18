package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

public class Item {
	
	public int id;
	public int positionY;
	public int positionX;
	public String image;
	public boolean isTaken = false;


	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean taken) {
		isTaken = taken;
	}


	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getPositionX() { return positionX; }
	
	public void setPositionX(int positionX) { this.positionX = positionX; }
	
	public int getPositionY() { return positionY; }
	
	public void setPositionY(int positionY) { this.positionY = positionY; }
	
	public String getImage() { return image; }
	
	public void setImage(String image) { this.image = image; }
	
	
	Item(){}
	
}
