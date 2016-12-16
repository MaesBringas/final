
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

        Random random = new Random();
        int roomsGenerated = random.nextInt(30 - 7 + 1) + 7;
        System.out.println("Rooms created " + roomsGenerated);
        Room[] rooms = new Room[roomsGenerated];

        // Before set the rooms, we generate values randomly inside the max length
        // Initializes all the space
        Space[][] level = new Space[max][max];
        for( int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                level[i][u] = new Space();
            }
        }

        // With this array, we filter and choose 5 of them with no conflicts
        // acts on each room individually
        for(int r  = 0; r < rooms.length; r++){
            rooms[r] = new Room();
            int lengthX = random.nextInt((max/3) - 3 + 1) + 3;
            int lengthY = lengthX;
            int startPointX = random.nextInt((max- 1 + 1) + 1);
            int startPointY = random.nextInt((max - 1 + 1) + 1);
            int sumX = lengthX + startPointX;
            int sumY = lengthY + startPointY;
            while (sumX > max || sumY > max) {
                System.out.println("Discarded " + sumX + " " + sumY);
                lengthX = random.nextInt((max/4) - 3 + 1) + 3;
                lengthY = lengthX;
                startPointX = random.nextInt((max- 1 + 1) + 1);
                startPointY = random.nextInt((max- 1 + 1) + 1);
                sumX = lengthX + startPointX;
                sumY = lengthY + startPointY;
            }
            System.out.println("Accepted " + sumX + " " + sumY);
            rooms[r].setLengthX(lengthX);
            rooms[r].setLengthY(lengthY);
            rooms[r].setStartPointX(startPointX);
            rooms[r].setStartPointY(startPointY);


            // We modify the space to be available to walk
            for( int i = rooms[r].startPointX; i < sumX; i++){
                for(int u = rooms[r].startPointY; u < sumY; u++){
                    level[i][u].setWall(false);
                }
            }
        }

        for(int i = 0; i < max; i++){
            for(int u = 0; u < max; u++){
                if(level[i][u].isWall()){
                    gui.md_setSquareColor(i, u, 96, 96, 96);
                } else{
                    gui.md_setSquareColor(i, u, 178, 255, 102);
                }

            }
        }
        return rooms;
    }

    public Room[] discardRooms(Room[] rawRoom){

        /* TODO: check Space[][] level position with Room extension */

        return rawRoom;

    }

    public void connectRooms(Room[] rooms){

    }

}
