package com.mahlmebs;

import com.mahlmebs.Person;

public class Hero extends Person {

    private int food;
    private int perception;
    private int power;
    
    public int getPower() { return power; }
    
    public void setPower(int power) { this.power = power; }

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

    Hero(){}
}
