package com.mahlmebs;

import com.mahlmebs.Person;

import java.util.Random;

public class Enemy extends Person {
    
    String secretMessage;
    
    public Enemy(String piece){
        
        Random ran = new Random();
        
        if (piece.equals("bishop")) {
            this.image = "black-bishop.png";
            this.positionX = ran.nextInt(40);
            this.positionY = ran.nextInt(40);
            this.maxHealth = 7;
            this.health = 7;
            this.strength = 2;
        }
        else if (piece.equals("king")) {
            this.image = "black-king.png";
            this.positionX = ran.nextInt(40);
            this.positionY = ran.nextInt(40);
            this.maxHealth = 1;
            this.health = 1;
            this.strength = 1;
        }
        else if (piece.equals("knight")) {
            this.image = "black-knight.png";
            this.positionX = ran.nextInt(40);
            this.positionY = ran.nextInt(40);
            this.maxHealth = 7;
            this.health = 7;
            this.strength = 2;
        }
        else if (piece.equals("pawn")) {
            this.image = "black-pawn.png";
            this.positionX = ran.nextInt(40);
            this.positionY = ran.nextInt(40);
            this.maxHealth = 2;
            this.health = 2;
            this.strength = 1;
        }
        else if (piece.equals("queen")) {
            this.image = "black-queen.png";
            this.positionX = ran.nextInt(40);
            this.positionY = ran.nextInt(40);
            this.maxHealth = 10;
            this.health = 10;
            this.strength = 3;
        }
        else if (piece.equals("rook")) {
            this.image = "black-rook.png";
            this.positionX = ran.nextInt(40);
            this.positionY = ran.nextInt(40);
            this.maxHealth = 8;
            this.health = 8;
            this.strength = 2;
        }
        else if (piece.equals("secretenemy")){
            this.image = "demon.png";
            this.positionX = ran.nextInt(40);
            this.positionY = ran.nextInt(40);
            this.maxHealth = 50;
            this.health = 50;
            this.strength = 7;
            String newline = System.getProperty("line.separator");
            secretMessage = "You killed the big one! Hey, he was holding a paper..." +newline
                            + " ''To enter PARKOUR mode, just type parkour''";
        }
    }
    
        
    public void moveRight() {
        Random ran = new Random();
        int ran2 = ran.nextInt(300);
        if (ran2 == 50) {
            if (this.positionX > 1 && this.positionX < 39)
                this.positionX = this.positionX + 1;
        }
    }
    
    public void moveLeft() {
        Random ran = new Random();
        int ran2 = ran.nextInt(300);
        if (ran2 == 50) {
            if (this.positionX > 1 && this.positionX < 39)
                this.positionX = this.positionX - 1;
        }
    }
    
    public void moveDown() {
        Random ran = new Random();
        int ran2 = ran.nextInt(300);
        if (ran2 == 50) {
            if (this.positionY > 1 && this.positionY < 39)
                this.positionY = this.positionY + 1;
        }
    }
    
    public void moveUp() {
        Random ran = new Random();
        int ran2 = ran.nextInt(300);
        if (ran2 == 50) {
            if (this.positionY > 1 && this.positionY < 39)
                this.positionY = this.positionY - 1;
        }
    }
    
    public String getSecretMessage() {
        return secretMessage;
    }
    
    public void setSecretMessage(String secretMessage) {
        this.secretMessage = secretMessage;
    }
    
    public void attack(Hero coolHero){
        Random ran = new Random();
        int ran2 = ran.nextInt(100);
        if (ran2 == 50) {
            int heroHealth = coolHero.getHealth();
            coolHero.setHealth(heroHealth - this.strength);
        }
    }
    
    
    }
    

