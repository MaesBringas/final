package com.mahlmebs;

/* Cool main program
* @authors mahl && mebs
* @version 1.0
* */

import minidungeon.MiniDungeonGUI;

public class Main {
    
    static int heroId = 1;
    static int x = 20;
    static int y = 20;
    static int max = 40;
    static MiniDungeonGUI gui = new MiniDungeonGUI(max,max);
    static Hero coolHero = new Hero(20, 20);
    
    public static void main(String[] args) {
        
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
        
        gui.md_setTextGold(coolHero.getGold());
        gui.md_setTextFood(coolHero.getFood());
        gui.md_setTextHealthCurrent(coolHero.getHealth());
        gui.md_setTextHealthMax(coolHero.getMaxHealth());
        gui.md_setTextStrength(coolHero.getStrength());
        gui.md_setTextPerception(coolHero.getPerception());
        gui.md_setTextPlayerName(coolHero.getName());
        gui.md_println("Introduce your name : ");
        gui.md_addSprite(1, "cool.png", true);
        gui.md_setSpriteVisible(1, true);
        gui.md_moveSprite(heroId, x, y);
        
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
