package com.mahlmebs;

/* @authors mahl && mebs
	* @version 1.0
	* */

import minidungeon.MiniDungeonGUI;

import java.util.Random;



public class Sword extends Item{

    Random random = new Random();

    public Sword(){
        super.image = "sword.png";
        this.positionX = random.nextInt(40);
        this.positionY = random.nextInt(40);
    }

    Sword giveMeAnSword(Space[][]level, MiniDungeonGUI gui){
        Sword sword = new Sword();
        sword.setId(19); // id=1 to id=16 are avoided 'cause they are already in use.
        int heartStartX = random.nextInt(10 - 5 + 1) + 5;
        int heartStartY = random.nextInt(15 - 2 + 1) + 2;
        int[] valid = Main.validCoordinates(level, heartStartX, heartStartY);
        sword.setPositionX(valid[0]);
        sword.setPositionY(valid[1]);
        gui.md_addSprite(sword.getId(), sword.getImage(), true);
        gui.md_moveSprite(sword.getId(), sword.getPositionX(), sword.getPositionY());
        return sword;
    }

}
