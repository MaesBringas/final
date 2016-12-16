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
        
        Room room = new Room();
        room = room.generateRoom(max);
        gui.setVisible(true);
        for(int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                if(room.getStartPointX() == i && room.getStartPointY() == u){
                    printRooms(i, u, room.getLengthX(), room.getLengthY());
                }
            }
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
