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

        Room[] rooms = room.generateRoom(max, gui);

        gui.setVisible(true);
        gui.md_addSprite(1, "cool.png", true);
        gui.md_setSpriteVisible(1, true);
        gui.md_moveSprite(1, 20, 20);

    }
}
