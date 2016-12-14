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
        Room[] map = room.generateRooms(max);
        gui.setVisible(true);
        for(int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                gui.md_setSquareColor(i, u, 66, 31, 31);
            }
        }


        gui.md_setSquareImage(20,20,"heart.png");
    }
}
