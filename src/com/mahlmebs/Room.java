
package com.mahlmebs;

import minidungeon.MiniDungeonGUI;
import java.util.Random;

public class Room {

    /* Room is an array of Spaces */

    public int lengthX;
    public int lengthY;
    public int startPointX;
    public int startPointY;
    public Space[][] roomSpace = new Space[lengthX][lengthY];

    Room() {}

    Space[][] getRoomSpace() {
        return roomSpace;
    }

    public void setRoomSpace(Space[][] roomSpace) {
        this.roomSpace = roomSpace;
    }

    public int getLengthX() {
        return lengthX;
    }

    public void setLengthX(int lengthX) {
        this.lengthX = lengthX;
    }

    public int getLengthY() {
        return lengthY;
    }

    public void setLengthY(int lengthY) {
        this.lengthY = lengthY;
    }

    public int getStartPointX() {
        return startPointX;
    }

    public void setStartPointX(int startPointX) {
        this.startPointX = startPointX;
    }

    public int getStartPointY() {
        return startPointY;
    }

    public void setStartPointY(int startPointY) {
        this.startPointY = startPointY;
    }

    Room[] generateRoom(int max, MiniDungeonGUI gui) {
        Space[][] level = new Space[max][max];
        Random random = new Random();
        int roomsGenerated = random.nextInt(20 -1 + 1) + 1;
        System.out.println("Rooms created " + roomsGenerated);
        Room[] rooms = new Room[roomsGenerated];

        for(Room item: rooms){
            item = new Room();
            /* At the moment we assume square rooms */
            int lengthX = random.nextInt((max/2) - 3 + 1) + 3;
            int lengthY = lengthX;
            System.out.println(" x extension > " + lengthX + " y extension > " + lengthY);
            int startPointX = random.nextInt((max / 2) + 1);
            int startPointY = random.nextInt((max / 2) + 1);
            System.out.println(" Room starts at > " + startPointX + " and " + startPointY );

            for( int i = startPointX; i < lengthX; i++){
                for(int u = startPointY; u < lengthY; u++){
                    level[i][u] = new Space();
                    level[i][u].setWall(false);
//                System.out.println(roomSpace[i][u].isWall());
                }
            }

            int sumX = lengthX + startPointX;
            int sumY = lengthY + startPointY;
            while (sumX > max && sumY > max) {
                System.out.println("Discarded " + sumX + " " + sumY);
                lengthX = random.nextInt((max/2) - 3 + 1) + 3;
                lengthY = random.nextInt((max/2) - 3 + 1) + 3;
                startPointX = random.nextInt((max / 2) + 1);
                startPointY = random.nextInt((max / 2) + 1);
                sumX = lengthX + startPointX;
                sumY = lengthY + startPointY;
            }
            sumX = lengthX + startPointX;
            sumY = lengthY + startPointY;
            System.out.println("Sum X > " + sumX + " Sum Y > " + sumY);
            item.setLengthX(lengthX);
            item.setLengthY(lengthY);
            item.setStartPointX(startPointX);
            item.setStartPointY(startPointY);

            for(int i = 0; i < max; i++){
                for(int u = 0; u < max; u++){
                    if(item.getStartPointX() == i && item.getStartPointY() == u){
                        item.printRooms(i, u, item.getLengthX(), item.getLengthY(), gui);
                    }
                }
            }
        }
        return rooms;
    }

    public void printRooms(int startX, int startY, int lengthX, int lengthY, MiniDungeonGUI gui) {
        int sumA = startX+lengthX;
        int sumB = startY+lengthY;
        for (int a = startX; a < sumA; a++) {
            for (int b = startY; b < sumB; b++) {
                gui.md_setSquareColor(a, b, 178, 255, 102);
            }
        }
    }

    public Room[] discardRooms(Room[] rawRoom){

        /* TODO: check Space[][] level position with Room extension */

        return rawRoom;

    }

    public void connectRooms(Room[] rooms){

    }

}
