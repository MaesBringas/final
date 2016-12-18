package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

public class Hero extends Person {
    
    private int food = 500;
    private int perception = 1;
    private int gold = 0;
    private String name = "CoolHero27";
    
    public Hero() {
        setId(0);
        setStrength(1);
        setHealth(20);
        setMaxHealth(20);
        super.positionX = 20;
        super.positionY = 20;
        
    }
    
    public void lessFood(){
        --this.food;
    }
    
    public int getId() { return id; }
    
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    
    public void setName(String name) { this.name = name; }
    
    public int getGold() { return gold; }
    
    public void setGold(int gold) { this.gold = gold; }
    
    public int getStrength() { return strength; }
    
    public void setStrength(int power) { this.strength = power; }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }
    
    
    // Declaring methods related to Items
    
    
    // Each gold adds 1 to the gold field of the hero
    public void addGold(){
        this.gold = this.gold + 1;
    }
    
    // Each potion adds 10 to the health field of the hero
    public void addPotion(){
        if ((super.health+10) > super.maxHealth) {
            super.health = super.maxHealth;
        }
        else
            super.health = super.health + 10;
    }
    
    // Each heart adds 20 to the health field of the hero
    public void addHeart(){
        if ((super.health+20) > super.maxHealth) {
            super.health = super.maxHealth;
        }
        else
            super.health = super.health + 20;
    }
     
    // Each apple adds 50 to the food field of the hero
    public void addApple(){
        this.food = this.food + 50;
    }
    
    // Each eye adds 1 to the perception field of the hero
    public void addEye(){
        this.perception = this.perception + 1;
    }
    
    // Each sword adds 1 to the strength field of the hero
    public void addSword(){
        this.strength = this.strength + 1;
    }

}