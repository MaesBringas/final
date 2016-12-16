package com.mahlmebs;

import com.mahlmebs.Person;

public class Hero extends Person {
    
    private int food = 500;
    private int perception = 1;
    private int strength = 1;
    private int gold = 0;
    private String name = "CoolHero27";
    private int id = 1;
    
    public Hero(int health, int maxHealth) {
        setHealth(health);
        setMaxHealth(maxHealth);
        
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
    
    
}