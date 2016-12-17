package com.mahlmebs;

import com.mahlmebs.Person;

public class Hero extends Person {
    
    private int food = 500;
    private int perception = 1;
    private int strength = 1;
    private int gold = 0;
    private String name = "CoolHero27";
    private int id = 1;
    
    public Hero() {
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
    
    
    // Methods related to Items
    
    public void addGold(){
        this.gold = this.gold + 1;
    }
    
    public void addHealth(Hero coolHero){
        int health = coolHero.getHealth();
        if ((coolHero.getHealth()+10) > coolHero.getMaxHealth()) {
            int newHealth = coolHero.getMaxHealth();
            coolHero.setHealth(newHealth);
        }
        else
            coolHero.setMaxHealth(health+10);
    }
    
    
}