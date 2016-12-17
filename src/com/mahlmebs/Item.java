package com.mahlmebs;

/**
 * Created by manuhortet on 17/12/16.
 */

public class Item {
	
	public int id;
	public int positionY;
	public int positionX;
	public String image;
	
	
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
