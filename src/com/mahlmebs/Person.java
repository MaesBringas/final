package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

public abstract class Person {
    
    protected int positionX;
    protected int positionY;
    protected int health;
    protected int maxHealth;
    protected int strength;
    protected String image;
    protected int id;
    protected String getImage() { return image; }
    protected void setImage(String image) { this.image = image; }
    
    public int getStrength() {
        return strength;
    }
    
    public void setStrength(int strength) {
        this.strength = strength;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    Person(){}
    
    public int getPositionX() {
        return positionX;
    }
    
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    
    public int getPositionY() {
        return positionY;
    }
    
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
   
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }



}


