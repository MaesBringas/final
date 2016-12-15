package com.mahlmebs;

/* Cool main program
* @authors mahl && mebs
* @version 1.0
* */

import minidungeon.MiniDungeonGUI;

public class Main {
    
    public static void main(String[] args) {
        
        int max = 40;
        MiniDungeonGUI gui = new MiniDungeonGUI(max,max);
        Room room = new Room();

        room = room.generateRoom(max);
        int start = room.getStartPoint();
//        printRooms(room);
        gui.setVisible(true);
        for(int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                gui.md_setSquareColor(start, i, 178, 255, 102);
            }
        }
        
        gui.md_addSprite(1, "cool.png", true);
        gui.md_setSpriteVisible(1, true);
        gui.md_moveSprite(1, 20, 20);
    
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            
        }
        
    }

    static void printRooms(Room room){
        
    }
}
