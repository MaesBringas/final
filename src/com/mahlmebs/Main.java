package com.mahlmebs;

/* Cool main program
* @authors mahl && mebs
* @version 1.0
* */

import minidungeon.MiniDungeonGUI;

public class Main {
    
    static int x = 20;
    static int y = 20;
    static int max = 40;
    static MiniDungeonGUI gui = new MiniDungeonGUI(max,max);
    static Hero coolHero = new Hero(20, 20);
    
    public static void main(String[] args) throws InterruptedException{
        
        Room room = new Room ();
        Room[] rooms = room.generateRoom(max, gui);
        gui.setVisible(true);
        for(int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                if(room.getStartPointX() == i && room.getStartPointY() == u){
                    printRooms(i, u, room.getLengthX(), room.getLengthY());
                }
            }
        }
        
        // In the following lines we set the hero in the correct place
        // and print some values that should be visible for the user.
    
        // Printing our cool hero
        gui.md_addSprite(coolHero.getId(), "cool.png", true);
        gui.md_setSpriteVisible(coolHero.getId(), true);
        gui.md_moveSprite(coolHero.getId(), x, y);
        // Printing important info about the hero
        gui.md_setTextGold(coolHero.getGold());
        gui.md_setTextFood(coolHero.getFood());
        gui.md_setTextHealthCurrent(coolHero.getHealth());
        gui.md_setTextHealthMax(coolHero.getMaxHealth());
        gui.md_setTextStrength(coolHero.getStrength());
        gui.md_setTextPerception(coolHero.getPerception());
        gui.md_setTextPlayerName(coolHero.getName());
        gui.md_setPortraitPlayer("herohd.png");
        
        // Here we make our hero move when the arrow keys are pressed.
        // taking into account to reduce its food each time he moves,
        // and dividing his perception and strength by two when food = 0.
        
        while(true){
            
            String lastAction = gui.md_getLastAction().trim();
            
            if (lastAction.length() > 0){
            
                if (lastAction.equals("left")){
                    gui.md_moveSprite(coolHero.getId(), --x, y);
                }
                if (lastAction.equals("right")) {
                    gui.md_moveSprite(coolHero.getId(), ++x, y);
                }
                if (lastAction.equals("down")) {
                    gui.md_moveSprite(coolHero.getId(), x, ++y);
                }
                if (lastAction.equals("up")) {
                    gui.md_moveSprite(coolHero.getId(), x, --y);
                }
                
                // Reducing food after each movement (only if food is not already 0)
                if (coolHero.getFood() > 0) {
                    coolHero.lessFood();
                    gui.md_setTextFood(coolHero.getFood());
                }
                
                // Checking if food = 0, and reducing perception and strength if true
                if (coolHero.getFood() == 0){
                    if (coolHero.getPerception() > 1) {
                        coolHero.setPerception(coolHero.getPerception() / 2);
                        gui.md_setTextPerception(coolHero.getPerception());
                    }
                    if (coolHero.getStrength() > 1) {
                        coolHero.setStrength(coolHero.getStrength() / 2);
                        gui.md_setTextStrength(coolHero.getStrength());
                    }
                }
            }
            Thread.sleep(5);
        }
    }
    
    static void printRooms(int startX, int startY, int lengthX, int lengthY) {
        int sumA = startX+lengthX;
        int sumB = startY+lengthY;
        for (int a = startX; a < sumA; a++) {
            for (int b = startY; b < sumB; b++) {
                gui.md_setSquareColor(a, b, 178, 255, 102);
            }
        }
        
    }
    
}
