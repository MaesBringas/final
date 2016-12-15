package com.mahlmebs;

/* Cool main program
* @authors mahl && mebs
* @version 1.0
* */

import minidungeon.MiniDungeonGUI;

public class Main {

    static int max = 40;
    static MiniDungeonGUI gui = new MiniDungeonGUI(max,max);
    
    public static void main(String[] args) {
        Room room = new Room();
        room = room.generateRoom(max);
        int start = room.getStartPointX();
        gui.setVisible(true);
        for(int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                if(room.getStartPointX() == i && room.getStartPointY() == u){
                    printRooms(i, u, room.getLengthX(), room.getLengthY());
                }
            }
        }
        
        gui.md_addSprite(1, "cool.png", true);
        gui.md_setSpriteVisible(1, true);
        gui.md_moveSprite(1, 20, 20);

    }

    static void printRooms(int startX, int startY, int lengthX, int lengthY) {
        for (int a = startX; a < lengthX; a++) {
            for (int b = startY; b < lengthY; b++) {
                gui.md_setSquareColor(a, b, 178, 255, 102);
            }
        }
    }
}
